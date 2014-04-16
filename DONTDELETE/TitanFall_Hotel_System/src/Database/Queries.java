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
	
	public ArrayList<Object[]> getBookings(String userID){
		System.out.println(userID);
		ArrayList<Object[]> resultList = new ArrayList<Object[]>();
		String query = "SELECT booking_id, number_of_guests, number_of_rooms,number_of_nights, total_cost, arrivaldate, departuredate FROM bookings WHERE USER_ID = '"+ userID + "'";
		try{
			open();
			stmt = getConn().createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()){
				Object[] b = {rset.getInt("booking_id"),
						rset.getInt("number_of_guests"),
						rset.getInt("number_of_rooms"),
						rset.getInt("number_of_nights"),
						rset.getDouble("total_cost"),
						rset.getDate("arrivaldate"),
						rset.getDate("departuredate")};
				resultList.add(b);
			}
		}
		catch(SQLException se){
			System.out.println("Get bookings error");
			se.printStackTrace();
		}
		return resultList;
	}

	/* 	
	 * Availability query selects all rooms for DB, stores in arrayList of rooms
	 * then selects all room numbers that have a booking for the date entered
	 * (from start screen)
	 * iterator is used to move through the array-list, if the room number is
	 * present , remove that room from the list
	*/

	public ArrayList availabilityQuery(int day, int month, int year, int numNights) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		cal.add(Calendar.DAY_OF_MONTH, numNights);
		Calendar arrivalQ = Calendar.getInstance();
		arrivalQ.set(year, month, day);
		
//		System.out.println(day + " " +  month + " " +year);
		String firstRoomQuery = "SELECT r.room_number, rt.type_name, rt.roomtype_price FROM rooms r, roomtypes rt WHERE r.type_id = rt.type_id ORDER BY r.room_number";
		
		String secondRoomQuery = "SELECT r.ROOM_NUMBER FROM BOOKINGS b, roombookings rb, rooms r WHERE rb.BOOKING_ID = b.BOOKING_ID AND rb.room_number = r.room_number AND"
			+ "((TO_DATE('" + arrivalQ.get(Calendar.YEAR) + "/" + (arrivalQ.get(Calendar.MONTH)+1) + "/" + arrivalQ.get(Calendar.DAY_OF_MONTH) + "','YYYY/MM/DD') >= ARRIVALDATE "
			+ "AND TO_DATE('" + arrivalQ.get(Calendar.YEAR) + "/" + (arrivalQ.get(Calendar.MONTH)+1) + "/" + arrivalQ.get(Calendar.DAY_OF_MONTH) + "','YYYY/MM/DD') <= DEPARTUREDATE) "
			+ "OR (TO_DATE('" + cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.DAY_OF_MONTH) + "','YYYY/MM/DD') >= ARRIVALDATE "
			+ "AND TO_DATE('" + cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.DAY_OF_MONTH) + "','YYYY/MM/DD') <= DEPARTUREDATE) "
			+ "OR (TO_DATE('" + arrivalQ.get(Calendar.YEAR) + "/" + (arrivalQ.get(Calendar.MONTH)+1) + "/" + arrivalQ.get(Calendar.DAY_OF_MONTH) + "','YYYY/MM/DD') <= ARRIVALDATE "
			+ "AND TO_DATE('" + cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.DAY_OF_MONTH) + "','YYYY/MM/DD') >= DEPARTUREDATE))";
		ArrayList<Room> roomList = new ArrayList<Room>();
		int[] bookedRooms;
		try {
			open();
//			System.out.println(arrivalQ.get(Calendar.MONTH)+1);
//			System.out.println(cal.getTime());
			stmt = getConn().createStatement();
			rset = stmt.executeQuery(firstRoomQuery); // first query, selects
														// all rooms
			while (rset.next()) {
				Room r = new Room(rset.getInt("ROOM_NUMBER"),
						rset.getString("TYPE_NAME"),
						rset.getDouble("ROOMTYPE_PRICE"));
				roomList.add(r); // add room object to arraylist
			}
//			for (int i = 0; i < roomList.size(); i++) {
//				System.out.println(roomList.get(i).getRoomNumber());
//			}
			rset = stmt.executeQuery(secondRoomQuery);
			int counter = 0;
			bookedRooms = new int[roomList.size()];
			while (rset.next()) {
				bookedRooms[counter] = rset.getInt("ROOM_NUMBER");
				counter++;
			}
//			for (int i = 0; i < bookedRooms.length; i++) {
//				System.out.println(bookedRooms[i]);
//			}
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
//		for (int i = 0; i < roomList.size(); i++) {
//			System.out.println(roomList.get(i).getRoomNumber());
//		}
		close();
		return roomList;  //passed back to model as an arrayList of Room objects
		
	}
	
	// This method is used to add a users special price to the total price in the bookings table
	public void addSpecials(int golf,int spa,int breakfast,int karting,int bookingid,double price){
		try
		{
			open();
			
			String sql = "Update Bookings set Total_Cost = Total_Cost + " + price + " where Booking_ID = " + bookingid;
			
			pstmt = getConn().prepareStatement(sql);
			pstmt.executeUpdate();
			
			if(golf > 0){
				sql = "Insert into SpecialBookings values(?,?,?)";
				pstmt = getConn().prepareStatement(sql);
				numSpecials++;
				pstmt.setInt(1, numSpecials);
				pstmt.setInt(2, 11);
				pstmt.setInt(3,bookingid );
				pstmt.executeUpdate();
			}
			if(spa > 0){
				sql = "Insert into SpecialBookings values(?,?,?)";
				pstmt = getConn().prepareStatement(sql);
				
				numSpecials++;
				pstmt.setInt(1, numSpecials);
				pstmt.setInt(2, 22);
				pstmt.setInt(3,bookingid );
				pstmt.executeUpdate();
			}

			if(breakfast > 0){
				sql = "Insert into SpecialBookings values(?,?,?)";
				pstmt = getConn().prepareStatement(sql);
				
				numSpecials++;
				pstmt.setInt(1, numSpecials);
				pstmt.setInt(2, 33);
				pstmt.setInt(3,bookingid );
				pstmt.executeUpdate();
			}

			if(karting > 0){
				sql = "Insert into SpecialBookings values(?,?,?)";
				pstmt = getConn().prepareStatement(sql);
				
				numSpecials++;
				pstmt.setInt(1, numSpecials);
				pstmt.setInt(2, 44);
				pstmt.setInt(3,bookingid );
				pstmt.executeUpdate();
			}
			System.out.println("Special cost added to booking ");
		}
		catch(Exception e){
			System.out.println("could not add special " + e);
		}
		close();
	}

}


