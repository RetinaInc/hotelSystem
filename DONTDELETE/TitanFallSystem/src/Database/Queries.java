package Database;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import Model.*;
import oracle.jdbc.pool.OracleDataSource;

public class Queries {
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rset;
	private PreparedStatement pstmt;
	private int numSpecials = 0;

	public void open() {
			try {
				// open local DB
				OracleDataSource ods = new OracleDataSource();
				//ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
				//ods.setUser("X00106072");
				//ods.setPassword("db29Mar93");
				ods.setURL("jdbc:oracle:thin:HR/@localhost:1521:XE");
				ods.setUser("root");
				ods.setPassword("root");
				conn = ods.getConnection();
			}
			 catch (Exception ex) {
					System.out.println("Open Database Error, check Queries class");
				}
			}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.print("Could not close connection ");
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}
	

	public ArrayList<Object[]> getUserBookingInfo(int bookingID){
		ArrayList<Object[]> resultList = new ArrayList<Object[]>();
		
		String query = "SELECT rb.room_number, rt.type_name, rt.roomtype_price FROM ROOMBOOKINGS rb, ROOMTYPES rt, ROOMS r WHERE rt.TYPE_ID = r.TYPE_ID "
						+ "AND rb.ROOM_NUMBER = r.ROOM_NUMBER AND rb.BOOKING_ID = '" + bookingID+"'";
		try{
			open();
			stmt = getConn().createStatement(); 
			rset = stmt.executeQuery(query);
			while(rset.next()){
				Object[] b = {rset.getInt("room_number"),
						rset.getString("type_name"),
						rset.getDouble("roomtype_price")};
				resultList.add(b);
			}
			for (int j = 0; j < resultList.size(); j++) {
				System.out.println(resultList.get(j)[0]);
			}
		}
		
		catch(SQLException se){
			System.out.println("Get userBooking error");
			se.printStackTrace();
		}
		return resultList;
	}
	public ArrayList<Object[]> editBookings(Calendar arrival, int numNights, String userID){
		ArrayList<Object[]> resultList = new ArrayList<Object[]>();
		Calendar departureQ = arrival;
		System.out.println(departureQ.getTime());
		departureQ.add(Calendar.DAY_OF_MONTH, numNights);
		String firstRoomQuery = "SELECT r.room_number, rt.type_name, rt.roomtype_price FROM rooms r, roomtypes rt WHERE r.type_id = rt.type_id ORDER BY r.room_number";
		
		String secondRoomQuery = "SELECT r.ROOM_NUMBER FROM BOOKINGS b, roombookings rb, rooms r WHERE rb.BOOKING_ID = b.BOOKING_ID AND rb.room_number = r.room_number AND"
			+ "((TO_DATE('" + arrival.get(Calendar.YEAR) + "/" + (arrival.get(Calendar.MONTH)+1) + "/" + arrival.get(Calendar.DAY_OF_MONTH) + "','YYYY/MM/DD') >= ARRIVALDATE "
			+ "AND TO_DATE('" + arrival.get(Calendar.YEAR) + "/" + (arrival.get(Calendar.MONTH)+1) + "/" + arrival.get(Calendar.DAY_OF_MONTH) + "','YYYY/MM/DD') <= DEPARTUREDATE) "
			+ "OR (TO_DATE('" + departureQ.get(Calendar.YEAR) + "/" + (departureQ.get(Calendar.MONTH)+1) + "/" + departureQ.get(Calendar.DAY_OF_MONTH) + "','YYYY/MM/DD') >= ARRIVALDATE "
			+ "AND TO_DATE('" + departureQ.get(Calendar.YEAR) + "/" + (departureQ.get(Calendar.MONTH)+1) + "/" + departureQ.get(Calendar.DAY_OF_MONTH) + "','YYYY/MM/DD') <= DEPARTUREDATE) "
			+ "OR (TO_DATE('" + arrival.get(Calendar.YEAR) + "/" + (arrival.get(Calendar.MONTH)+1) + "/" + arrival.get(Calendar.DAY_OF_MONTH) + "','YYYY/MM/DD') <= ARRIVALDATE "
			+ "AND TO_DATE('" + departureQ.get(Calendar.YEAR) + "/" + (departureQ.get(Calendar.MONTH)+1) + "/" + departureQ.get(Calendar.DAY_OF_MONTH) + "','YYYY/MM/DD') >= DEPARTUREDATE))"
			+ "ORDER BY r.ROOM_NUMBER";
		int[] bookedRooms;
		try {
			open();
			stmt = getConn().createStatement();
			rset = stmt.executeQuery(firstRoomQuery); // first query, selects
														// all rooms
			while (rset.next()) {
				Object [] o= {rset.getInt("ROOM_NUMBER"),
						rset.getString("TYPE_NAME"),
						rset.getDouble("ROOMTYPE_PRICE")};
				resultList.add(o); // add object to arraylist
			}
			
			rset = stmt.executeQuery(secondRoomQuery);
			int counter = 0;
			bookedRooms = new int[resultList.size()];
			while (rset.next()) {
				bookedRooms[counter] = rset.getInt("ROOM_NUMBER");
				counter++;
			}
			System.out.println(bookedRooms.length);
			for (int h = 0; h < bookedRooms.length; h++) {
				for (int j = 0; j < resultList.size(); j++) {
					if((int) resultList.get(j)[0] == bookedRooms[h]){
						resultList.remove(j);
						System.out.println("Removed - " + bookedRooms[h]);
					}
				}
			}
			for (int j = 0; j < resultList.size(); j++) {
				System.out.println(resultList.get(j)[0]);
			}
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		close();
		return resultList;
	}

	/* 	
	 * Availability query selects all rooms for DB, stores in arrayList of rooms
	 * then selects all room numbers that have a booking for the date entered
	 * (from start screen)
	 * iterator is used to move through the array-list, if the room number is
	 * present , remove that room from the list
	*/

	public ArrayList<Room> availabilityQuery(Calendar cal, int numNights) {
		Calendar departureQ = cal;
		System.out.println(departureQ.getTime());
		departureQ.add(Calendar.DAY_OF_MONTH, numNights);
		System.out.println(departureQ.getTime());
		Calendar arrivalQ = Calendar.getInstance();
		arrivalQ.setTime(cal.getTime());
		arrivalQ.add(Calendar.DATE, - numNights);

		
//		System.out.println(day + " " +  month + " " +year);
		String firstRoomQuery = "SELECT r.room_number, rt.type_name, rt.roomtype_price FROM rooms r, roomtypes rt WHERE r.type_id = rt.type_id ORDER BY r.room_number";
		
		String secondRoomQuery = "SELECT r.ROOM_NUMBER FROM BOOKINGS b, roombookings rb, rooms r WHERE rb.BOOKING_ID = b.BOOKING_ID AND rb.room_number = r.room_number AND"
			+ "((TO_DATE('" + arrivalQ.get(Calendar.YEAR) + "/" + (arrivalQ.get(Calendar.MONTH)+1) + "/" + arrivalQ.get(Calendar.DAY_OF_MONTH) + "','YYYY/MM/DD') >= ARRIVALDATE "
			+ "AND TO_DATE('" + arrivalQ.get(Calendar.YEAR) + "/" + (arrivalQ.get(Calendar.MONTH)+1) + "/" + arrivalQ.get(Calendar.DAY_OF_MONTH) + "','YYYY/MM/DD') <= DEPARTUREDATE) "
			+ "OR (TO_DATE('" + departureQ.get(Calendar.YEAR) + "/" + (departureQ.get(Calendar.MONTH)+1) + "/" + departureQ.get(Calendar.DAY_OF_MONTH) + "','YYYY/MM/DD') >= ARRIVALDATE "
			+ "AND TO_DATE('" + departureQ.get(Calendar.YEAR) + "/" + (departureQ.get(Calendar.MONTH)+1) + "/" + departureQ.get(Calendar.DAY_OF_MONTH) + "','YYYY/MM/DD') <= DEPARTUREDATE) "
			+ "OR (TO_DATE('" + arrivalQ.get(Calendar.YEAR) + "/" + (arrivalQ.get(Calendar.MONTH)+1) + "/" + arrivalQ.get(Calendar.DAY_OF_MONTH) + "','YYYY/MM/DD') <= ARRIVALDATE "
			+ "AND TO_DATE('" + departureQ.get(Calendar.YEAR) + "/" + (departureQ.get(Calendar.MONTH)+1) + "/" + departureQ.get(Calendar.DAY_OF_MONTH) + "','YYYY/MM/DD') >= DEPARTUREDATE))"
					+ "ORDER BY r.ROOM_NUMBER";
		ArrayList<Room> roomList = new ArrayList<Room>();
		int[] bookedRooms;
		try {
			open();
			System.out.println(arrivalQ.get(Calendar.MONTH)+1);
			System.out.println(departureQ.getTime());
			stmt = getConn().createStatement();
			rset = stmt.executeQuery(firstRoomQuery); // first query, selects
														// all rooms
			while (rset.next()) {
				Room r = new Room(rset.getInt("ROOM_NUMBER"),
						rset.getString("TYPE_NAME"),
						rset.getDouble("ROOMTYPE_PRICE"));
				roomList.add(r); // add room object to arraylist
			}
			for (int i = 0; i < roomList.size(); i++) {
				System.out.println(roomList.get(i).getRoomNumber());
			}
			rset = stmt.executeQuery(secondRoomQuery);
			int counter = 0;
			bookedRooms = new int[roomList.size()];
			while (rset.next()) {
				bookedRooms[counter] = rset.getInt("ROOM_NUMBER");
				counter++;
			}
			for (int i = 0; i < bookedRooms.length; i++) {
				System.out.println(bookedRooms[i]);
			}
			// We use the Iterator to move through the array-list, the loop checks every iteration of room
			// numbers against each value of bookedRooms
			Iterator<Room> it = roomList.iterator(); 
			int loop = 0 ;
				while (it.hasNext()) {	
					if (it.next().getRoomNumber() == bookedRooms[loop]) {
						it.remove();
						System.out.println("Room removed" + bookedRooms[loop]);
						loop++;
				}
			}	
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		for (int i = 0; i < roomList.size(); i++) {
			System.out.println(roomList.get(i).getRoomNumber());
		}
		close();
		return roomList;  //passed back to model as an arrayList of Room objects
		
	}
}

