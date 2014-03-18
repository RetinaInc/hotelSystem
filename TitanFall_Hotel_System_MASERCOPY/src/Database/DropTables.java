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
		} catch (SQLException ex) {
			System.out.println("ERROR: herpderp " + ex.getMessage());
			ex.printStackTrace();
			
		}
		q.close();
	}
	public static void main(String args[]){
		DropTables dt = new DropTables();
		dt.dropTables();
	}
}
