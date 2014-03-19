package Database;


import java.sql.*;

import oracle.jdbc.pool.OracleDataSource;

public class DropTables {

	private Statement stmt;
	private Queries q = new Queries();
	
	
	public void dropTables() {
		q.open("local");
		System.out.println("Checking for existing tables.");

		try {
			// Get a Statement object.
			stmt = q.getConn().createStatement();

			try{
				//Drop the creditcards table.
				stmt.execute("DROP TABLE creditcards");
				System.out.println("CreditCards table dropped.");
			}
			catch (SQLException ex) {
				// No need to report an error.
				// The table simply did not exist.
			}
			try{
				//Drop the specials table.
				stmt.execute("DROP TABLE specials");
				System.out.println("Specials table dropped.");
			}
			catch (SQLException ex) {
				// No need to report an error.
				// The table simply did not exist.
			}
			try{
				//Drop the roombookings table.
				stmt.execute("DROP TABLE roombookings");
				System.out.println("RoomBookings table dropped.");
			}
			catch (SQLException ex) {
				// No need to report an error.
				// The table simply did not exist.
			}
			try{
				//Drop the bookings table.
				stmt.execute("DROP TABLE bookings");
				System.out.println("Bookings table dropped.");
			}
			catch (SQLException ex) {
				// No need to report an error.
				// The table simply did not exist.
			}
			try {
				// Drop the users table.
				stmt.execute("DROP TABLE users");
				System.out.println("Users table dropped.");
			} 
			catch (SQLException ex) {
				// No need to report an error.
				// The table simply did not exist.
			}
			try{
				//Drop the hotel table.
				stmt.execute("DROP TABLE hotels");
				System.out.println("Hotels table dropped.");
			}
			catch (SQLException ex) {
				// No need to report an error.
				// The table simply did not exist.
			}
			try{
				//Drop the rooms table.
				stmt.execute("DROP TABLE rooms");
				System.out.println("Rooms table dropped.");
			}
			catch (SQLException ex) {
				// No need to report an error.
				// The table simply did not exist.
			}
			try{
				//Drop the roomtypes table.
				stmt.execute("DROP TABLE roomtypes");
				System.out.println("RoomTypes table dropped.");
			}
			catch (SQLException ex) {
				// No need to report an error.
				// The table simply did not exist.
			}
			
		} catch (SQLException ex) {
			System.out.println("ERROR: AHHH ERROR!!!!! " + ex.getMessage());
			ex.printStackTrace();
			
		}
		q.close();
	}
	public static void main(String args[]){
		DropTables dt = new DropTables();
		dt.dropTables();
	}
}
