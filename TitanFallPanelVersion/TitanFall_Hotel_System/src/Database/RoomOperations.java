package Database;
import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;
import Model.Room;
import Database.Queries;
public class RoomOperations {
	
	private Connection connection;
	private ResultSet rset;
	private Statement stmt;
	private PreparedStatement pstmt;
	
	public RoomOperations(){
		Queries q = new Queries();
		q.open();
		 connection = q.getConn();	 
	}
	
	
	/* 
	 * This method takes a reference variable of type Room as a parameter and uses a prepared statement
	 * to add the room to the Rooms table in the database
	 */
	public void addRoom(Room r){
		try{
			System.out.println(r.getRoomNumber() + " " + r.isRoomAvailability() + " " + r.getRoomTypeID());
			String addRoomSQL = "INSERT INTO Rooms (Room_Number, Room_Availability, Type_ID) VALUES (?,?,?)";
			pstmt = connection.prepareStatement(addRoomSQL);
			pstmt.setInt(1,r.getRoomNumber());
			pstmt.setString(2,Character.toString(r.isRoomAvailability()));
			pstmt.setInt(3, 900);
			pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("ERROR!");
			ex.printStackTrace();
		}
	}
	
	/* 
	 * This method returns a ResultSet which holds all the data from the Rooms table 
	 * ordered by the room number
	 */
	public ResultSet getRooms(){
		try{
			String queryString = "SELECT * FROM Rooms ORDER BY Room_Number";
			
			stmt = connection.createStatement();
			rset = stmt.executeQuery(queryString);
		}catch(Exception e){
			System.out.println(e);
		}
		return rset;
	}
	
	public ResultSet getLastRow(){
		System.out.println("hi");
		String addRoomSQL = "SELECT * FROM Rooms ORDER By Room_Number";
		try{
			pstmt = connection.prepareStatement(addRoomSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rset = pstmt.executeQuery();
			rset.last();
			System.out.println(rset.getInt(1) + "," + rset.getString(2) + "," + rset.getInt(3));
		}catch(Exception exc){
			System.out.println("ERROR:  " + exc.getMessage());
		}
		return rset;
	}
	
	/*
	 * This method is for testing purposes and prints out the contents of the room table
	 */
	public void queryRooms(){
		try{
			String roomQuery = "SELECT * FROM rooms ORDER BY Room_Number";
			
			stmt = connection.createStatement();
			rset = stmt.executeQuery(roomQuery);
			
			while(rset.next()){
				System.out.println("Database" + rset.getInt(1) + "," + rset.getString(2) + "," + rset.getInt(3));
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void closeDB(){
		try{
			connection.close();
			System.out.println("Connection closed");
		}catch(SQLException e){
			System.out.println("Could not close connection ");
		}
	}
}
