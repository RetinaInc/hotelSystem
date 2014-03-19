package Database;

import java.sql.*;

import Model.User;
import oracle.jdbc.pool.OracleDataSource;

public class Queries {
	private Connection conn;
	private Statement stmt;
	private ResultSet rset;
	
	public void open(String location){
		if(location.equals("local")){
			try{
				//open local DB
				OracleDataSource ods = new OracleDataSource();
				
				ods.setURL("jdbc:oracle:thin:HR/@localhost:1521:XE");
				ods.setUser("Delboy");
				ods.setPassword("7777");
				conn = ods.getConnection();
//				System.out.println("Local DB opened");
				}
			catch(Exception e){
					System.out.println("Open Database Error, check Queries class");
				}
		}
		else if(location.equals("college")){
			try{
				//open  college DB
				OracleDataSource ods = new OracleDataSource();

				ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
				ods.setUser("X00106072");
				ods.setPassword("db29Mar78");
				conn = ods.getConnection();
//				System.out.println("Tallaght DB opened");
		}
			catch(Exception e){
			System.out.println("Open Database Error, check Queries class");
			}
		}
	}
	public void close() {
		try {
			conn.close();
//			System.out.println("Connection closed (Query)");
		} catch (SQLException e) {
			System.out.print("Could not close connection ");
			e.printStackTrace();
		}
	}
	
	public Connection getConn() {
		return conn;
	}
}
