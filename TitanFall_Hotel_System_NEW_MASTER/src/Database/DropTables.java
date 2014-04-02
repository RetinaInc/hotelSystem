package Database;


import java.sql.*;

import oracle.jdbc.pool.OracleDataSource;

public class DropTables {

	private Statement stmt;
	private Queries q = new Queries();
	
	//The tables are dropped in sequence so there is no conflict between Primary Key and Foreign Key
	public void dropTables() {
//		q.open("local");
		q.open("college");
//		System.out.println("Checking for existing tables.\n");

		try {
			stmt = q.getConn().createStatement();

			try{
				//Drop the Credit Card table.
				stmt.execute("DROP TABLE creditcards");
				System.out.println("CreditCards table dropped.");
			}
			catch (SQLException ex) {
				// No need to report an error.
				// The table simply did not exist.
			}
			try{
				//Drop the Special table & Special Sequence
				stmt.execute("DROP TABLE specials");
				stmt.execute("DROP SEQUENCE special_seq");
				System.out.println("Specials table dropped.");
			}
			catch (SQLException ex) {

			}
			try{
				//Drop the Room Booking table.
				stmt.execute("DROP TABLE roombookings");
				System.out.println("RoomBookings table dropped.");
			}
			catch (SQLException ex) {

			}
			try{
				//Drop the Booking table & Booking Sequence
				stmt.execute("DROP TABLE bookings");
				stmt.execute("DROP SEQUENCE booking_seq");
				System.out.println("Bookings table dropped.");
			}
			catch (SQLException ex) {

			}
			try {
				// Drop the User table.
				stmt.execute("DROP TABLE users");
				System.out.println("Users table dropped.");
			} 
			catch (SQLException ex) {

			}
			try{
				//Drop the Hotel table & Hotel Sequence
				stmt.execute("DROP TABLE hotels");
				stmt.execute("DROP SEQUENCE hotel_seq");
				System.out.println("Hotels table dropped.");
			}
			catch (SQLException ex) {

			}
			try{
				//Drop the Room table & Room Sequence
				stmt.execute("DROP TABLE rooms");
				stmt.execute("DROP SEQUENCE room_seq");
				System.out.println("Rooms table dropped.");
			}
			catch (SQLException ex) {

			}
			try{
				//Drop the Room Type table & RoomType Sequence
				stmt.execute("DROP TABLE roomtypes");
				stmt.execute("DROP SEQUENCE roomType_seq");
				System.out.println("RoomTypes table dropped.\n");
			}
			catch (SQLException ex) {

			}
			
		} catch (SQLException ex) {
			System.out.println("ERROR: AHHH ERROR!!!!! " + ex.getMessage());
			ex.printStackTrace();
			
		}
		q.close();
	}
}
