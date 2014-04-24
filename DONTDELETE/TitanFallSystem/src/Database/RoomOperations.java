package Database;

import java.sql.*;

import javax.swing.JOptionPane;

import Model.*;
import Database.*;
import oracle.jdbc.pool.OracleDataSource;

public class RoomOperations {

	private Connection connection;
	private ResultSet rset;
	private Statement stmt;
	private PreparedStatement pstmt;

	public RoomOperations() {
		Queries q = new Queries();
		q.open();
		connection = q.getConn();
	}

	/*
	 * This method takes a reference variable of type Room as a parameter and
	 * uses a prepared statement to add the room to the Rooms table in the
	 * database
	 */
	
	//Instead of try catching i added throws exception here 
	//so when you try add the room in the manage rooms it trys to do the below if its succesful itl show the dialog inside here 
	//if it fails it doesnt add the room but shows an error dialog 
	public void addRoom(Room r) throws SQLException {
	
			String addRoomSQL = "INSERT INTO Rooms (Room_Number, Room_Availability, Type_ID) VALUES (?,?,?)";
			pstmt = connection.prepareStatement(addRoomSQL);
			pstmt.setInt(1, r.getRoomNumber());
			pstmt.setString(2, Character.toString(r.isRoomAvailability()));
			pstmt.setInt(3, r.getRoomTypeID());
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Room Added to the database");
	}

	/*
	 * This method updates a particular room in the hotel
	 */
	public void updateRoom(int roomNumber, int roomTypeID) {
		try {
			String updateRoomQuery = "UPDATE Rooms SET Type_ID =" + "'"
					+ roomTypeID + "'" + "WHERE Room_Number =" + "'"
					+ roomNumber + "'";
			stmt = connection.createStatement();
			stmt.executeUpdate(updateRoomQuery);
		} catch (Exception e) {
			System.out.println("Problem, roomNumber has not been updated " + e);
		}
	}

	// This method takes a room number parameter which is the room number to be
	// deleted. The SQL statement deletes this roomnumber.
	public int deleteRoom(int roomNumber)throws SQLException {
		
		String findQuery ="SELECT room_number ,booking_id FROM RoomBookings WHERE ROOM_NUMBER= '"+roomNumber+"'";
		pstmt = connection.prepareStatement(findQuery,
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet = pstmt.executeQuery();
		if (!resultSet.isBeforeFirst() ) {    
			 System.out.println("No Bookings on Record For this room");
			 int no = 0;
				try {
					String deleteQuery = "DELETE FROM Rooms WHERE Room_Number =" + "'"
							+ roomNumber + "'";
					stmt = connection.createStatement();
					no = stmt.executeUpdate(deleteQuery);
					System.out.println("Room no "+roomNumber+" deleted");
				} catch (SQLException e) {
					System.out.println("Room was not deleted");
				}
				return no;
			}
		else{
			JOptionPane.showMessageDialog(null, "Room not deleted as a booking already exists");
		}
		return -1;
		
		
	}

	/*
	 * This method returns a ResultSet which holds all the data from the Rooms
	 * table ordered by the room number
	 */
	public ResultSet getRooms() {
		try {
			String queryString = "SELECT * FROM Rooms ORDER BY Room_Number";

			stmt = connection.createStatement();
			rset = stmt.executeQuery(queryString);
		} catch (Exception e) {
			System.out.println(e);
		}
		return rset;
	}

	public ResultSet getLastRow() {
		String addRoomSQL = "SELECT * FROM Rooms ORDER By Room_Number";
		try {
			pstmt = connection.prepareStatement(addRoomSQL,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rset = pstmt.executeQuery();
			rset.last();
			System.out.println(rset.getInt(1) + "," + rset.getString(2) + ","
					+ rset.getInt(3));
		} catch (Exception exc) {
			System.out.println("ERROR:  " + exc.getMessage());
		}
		return rset;
	}

	/*
	 * This method is for testing purposes and prints out the contents of the
	 * room table
	 */
	public void queryRooms() {
		try {
			String roomQuery = "SELECT count(Room_Number) FROM rooms";

			stmt = connection.createStatement();
			rset = stmt.executeQuery(roomQuery);

			while (rset.next()) {
				System.out.println("Database" + rset.getInt(1) + ","
						+ rset.getString(2) + "," + rset.getInt(3));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void closeDB() {
		try {
			connection.close();
			System.out.println("Connection closed");
		} catch (SQLException e) {
			System.out.println("Could not close connection ");
		}
	}
}
