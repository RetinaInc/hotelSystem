package database;

import java.sql.*;

import oracle.jdbc.pool.OracleDataSource;
import oracle.net.aso.r;
import oracle.net.aso.s;

public class MovieDB {
	private Connection connection;
	private Statement stmt;
	private ResultSet rSet;
	
	public void openDB(){
		try{
			OracleDataSource ods = new OracleDataSource();
			
			ods.setURL("jdbc:oracle:thin:HR/@localhost:1521:XE");
			ods.setUser("Delboy");
			ods.setPassword("7777");
			
//			 ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
//			 ods.setUser("x00106072");
//			 ods.setPassword("db29Mar78");
			
			connection = ods.getConnection();
			System.out.println("You are now connected to Delboy's database.");
			
		}catch(Exception e){
			System.out.println("Unable to load the database" + e);
			System.exit(1);
		}
	}
	
	public void dropTable(){
		System.out.println("Checking for existing tables.");
		
		try{
			
			stmt = connection.createStatement();
			
			try{
				stmt.execute("DROP TABLE Movie");
				System.out.println("Movie table has been dropped from the database");
			}catch(SQLException sqe){
				// No need to report an error, the table simply does not exit
			}
		}catch(Exception e){
			System.out.println("ERROR: " + e.getMessage());
		}
	}
	
	public void buildMovieTable() {
		try {
			
			stmt = connection.createStatement();

			// Create the table.
			stmt.executeUpdate("CREATE TABLE Movie (MovieID number NOT NULL PRIMARY KEY,Title VARCHAR(50),Actor VARCHAR(50),Genre VARCHAR(50))");

			// Insert rows
			stmt.execute("INSERT INTO Movie VALUES (1,'The Kinds Speech','Colin Firth','Drama')");
			stmt.execute("INSERT INTO Movie VALUES (2,'The Black Swan','Natalie Portman','Psychological Thriller')");
			stmt.execute("INSERT INTO Movie VALUES (3,'Harry Potter and the Deadly Hollows','Emma Watson','Fantasy')");
			stmt.execute("INSERT INTO Movie VALUES (4,'Gravity','Sandra Bullock','Sci fi')");
			stmt.execute("INSERT INTO Movie VALUES (5,'Inception','Leonardo di Caprio','Fantasy')");
			stmt.execute("INSERT INTO Movie VALUES (6,'The Social Network','Jesse Eisenberg','Drama')");
			stmt.execute("INSERT INTO Movie VALUES (7,'The Kids are alright','Julianne Moore','Comedy')");
			stmt.execute("INSERT INTO Movie VALUES (8,'All about Steve','Sandra Bullock','Comedy')");
			
			System.out.println("Movie table created.");
			
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
	
	public void showDB() {
		try {
//			String query = "SELECT * FROM Movie";
			stmt = connection.createStatement();
			rSet = stmt.executeQuery("SELECT * FROM Movie");
			while(rSet.next()){
				System.out.printf("%5d %50s %30s %30s\n", rSet.getInt("MovieID"),rSet.getString("Title"),rSet.getString("Actor"),rSet.getString("Genre"));
			}
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void queryDB(){
		try {

			stmt = connection.createStatement();
			rSet = stmt.executeQuery("SELECT COUNT(MovieID) as MovieID FROM Movie");
			while(rSet.next()){
				System.out.printf("%d\n", rSet.getInt("MovieID"));
				
			}
			rSet = stmt.executeQuery("SELECT Title, Actor FROM Movie WHERE Actor like '%S%'");
			while(rSet.next()){
				System.out.printf("%5s %10s\n", rSet.getString("Title"), rSet.getString("Actor"));
			}	
			rSet = stmt.executeQuery("SELECT COUNT(Genre) as Comedy FROM Movie WHERE Genre = 'Comedy'");
			while(rSet.next()){
				System.out.printf("Number of Comedy Movies in Database: %s\n", rSet.getString("Comedy"));
			}
		}catch(Exception e){
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void closeDB(){
		try{
			stmt.close();
			// rSet.close();
			// connection.close();
		}catch(SQLException s){
			System.out.println("Could not close connetction ");
			s.printStackTrace();
		}
	}
	
	//Revision 1 - 20.29pm 18.3.2014
}
	

