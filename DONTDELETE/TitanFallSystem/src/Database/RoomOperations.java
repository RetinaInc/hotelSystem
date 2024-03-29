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
	Queries q = new Queries();
	public RoomOperations() {
	
		q.open();
		connection = q.getConn();
	}

	/*
	 * This method takes a reference variable of type Room as a parameter and
	 * uses a prepared statement to add the room to the Rooms table in the
	 * database
	 */
	
	//Instead of try catching i added throws exception here 
	//so when you try add the room in the manage rooms it trys to do the below if its succesfull 
	//the method returns true
	//if it fails it doesnt add the room but shows an error dialog 
	public boolean addRoom(Room r) throws SQLException {
		boolean added = false;
			try
			{

			String addRoomSQL = "INSERT INTO Rooms (Room_Number, Room_Availability, Type_ID) VALUES (?,?,?)";
			pstmt = connection.prepareStatement(addRoomSQL);
			pstmt.setInt(1, r.getRoomNumber());
			pstmt.setString(2, Character.toString(r.isRoomAvailability()));
			pstmt.setInt(3, r.getRoomTypeID());
			pstmt.executeUpdate();
			System.out.println("room added");
			added = true;
			}
			catch(Exception ae){
				JOptionPane.showMessageDialog(null, "Room already exists","Error adding room",JOptionPane.WARNING_MESSAGE);
				System.out.println("room already exists ");
				ae.printStackTrace();
			}
			return added;
	}

	/*
	 * This method updates a particular room in the hotel
	 */
	public void updateRoom(int roomNumber, int roomTypeID) {
		try {
				
			String sql = "select Room_Number from ROOMBOOKINGS where ROOM_NUMBER = " + roomNumber;
			
			pstmt = q.getConn().prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			//check to see if room  has a booking on it
			if(rset.next() == true){
				JOptionPane.showMessageDialog(null, "Room " + roomNumber + " has a booking on it and cannot be updated",
					"Error deleting room",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				//check to see if the room exists because it doesn't have a booking on it when it gets to here
				sql = "select * from ROOMS where ROOM_NUMBER = " + roomNumber;
				
				pstmt = q.getConn().prepareStatement(sql);
				
				rset = pstmt.executeQuery();
				if(rset.next() == true){ //means it does exist
					String updateRoomQuery = "UPDATE Rooms SET Type_ID = " + 
							+ roomTypeID + "WHERE Room_Number = " 
							+ roomNumber;
					stmt = connection.createStatement();
					stmt.executeUpdate(updateRoomQuery);
					JOptionPane.showMessageDialog(null, "Room " + roomNumber + " has been updated","Room updated"
							 ,JOptionPane.INFORMATION_MESSAGE);
					 System.out.println("room updated ");
				}
				else //doesnt exist
				{
					JOptionPane.showMessageDialog(null, "Room " + roomNumber + " does not exist",
							"Error deleting room",JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (Exception e) {
			System.out.println("Problem, roomNumber has not been updated " + e);
			e.printStackTrace();
		}
	}

	// This method takes a room number parameter which is the room number to be
	// deleted. The SQL statement deletes this roomnumber.
	public void deleteRoom(int roomNumber)throws SQLException {
		try
		{
		String sql = "select Room_Number from ROOMBOOKINGS where ROOM_NUMBER = " + roomNumber;
		
		pstmt = q.getConn().prepareStatement(sql);
		
		rset = pstmt.executeQuery();
		//check to see if room  has a booking on it
		if(rset.next() == true){
			JOptionPane.showMessageDialog(null, "Room " + roomNumber + " has a booking on it and cannot be removed",
				"Error deleting room",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			//check to see if the room exists because it doesn't have a booking on it when it gets to here
			sql = "select * from ROOMS where ROOM_NUMBER = " + roomNumber;
			
			pstmt = q.getConn().prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next() == true){
				sql = "Delete from rooms where Room_Number = " + roomNumber;
				
				pstmt = q.getConn().prepareStatement(sql);
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Room " + roomNumber + " has been removed",
						"Room removed",JOptionPane.INFORMATION_MESSAGE);
				System.out.println("room " + roomNumber + " removed");
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Room " + roomNumber + " does not exist",
						"Error deleting room",JOptionPane.ERROR_MESSAGE);
			}
		}
		}catch(Exception e){
			System.out.println("could not remove room " + e);
		}
		
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
