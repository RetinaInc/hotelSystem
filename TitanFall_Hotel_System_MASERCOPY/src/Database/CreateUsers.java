package Database;

import java.sql.*; // Needed for JDBC classes

import Model.User;
import oracle.jdbc.pool.OracleDataSource;

public class CreateUsers {

	private Connection conn;
	private Statement stmt;
	private ResultSet rset;
	private User theUser;
	private Queries q = new Queries();

	public void openDB() {
		try {
			q.open("local");
		} catch (Exception e) {
			System.out.print("Unable to load driver " + e);
			System.exit(1);
		}
		q.close();
	}

	public boolean buildUser(User u) {
		boolean existing = false;
		q.open("local");
		theUser = u;
		try {
			stmt = q.getConn().createStatement();
			// Insert
			stmt.execute("INSERT INTO users VALUES ('" + theUser.getUserID()
					+ "','G', '" + theUser.getfName() + "','"
					+ theUser.getlName() + "','" + theUser.getHomeaddress()
					+ "','" + theUser.getPhoneNum() + "','"
					+ theUser.getEmail() + "','" + theUser.getPassword() + "')");

			System.out.println("Users table populated.");

		} catch (SQLIntegrityConstraintViolationException ex) {
			System.out.println("Username unavailable, please try again BITCH");
			existing = true;
		} catch (SQLException ex) {
			System.out.println("ERROR: in buildUser " + ex.getMessage());
			ex.printStackTrace();
		}
		q.close();
		return existing;
	}

	

	public void closeDB() {
		try {
			stmt.close();
			rset.close();
			conn.close();
			System.out.print("Connection closed");
		} catch (SQLException e) {
			System.out.print("Could not close connection ");
			e.printStackTrace();
		}
	}

}
