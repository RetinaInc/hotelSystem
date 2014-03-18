package Database;

import java.sql.*; // Needed for JDBC classes

import oracle.jdbc.pool.OracleDataSource;

public class CreateTables {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rset;
	private Queries q = new Queries();
	
	public void buildUserTable() {
		try {
			q.open("local");
			Statement stmt = q.getConn().createStatement();


			stmt.executeUpdate("CREATE TABLE Users "
					+ "(User_ID	varchar2(50) NOT NULL PRIMARY KEY,UserType varchar2(5),First_Name varchar2(50),Last_Name varchar2(50),HomeAddress varchar2(50), Phone_Number varchar2(50),Email_Address varchar2(50),UserPassword	varchar2(50))");

			stmt.execute("INSERT INTO users VALUES ('01','G','Derek','Mulhern','Celbridge','088123456','delpeter@gmail.com','P1')");
			stmt.execute("INSERT INTO users VALUES ('02','G','Robert','Kenny','101 The Jacks','088123457','robertkenny@gmail.com','P2')");
			stmt.execute("INSERT INTO users VALUES ('03','G','Mark','Lordan','121 The Whatever','088123458','marklordan@gmail.com','P3')");
			stmt.execute("INSERT INTO users VALUES ('04','G','Thomas','Murphy','7 The Pub','088123459','thomasmurphy@gmail.com','P4')");
			stmt.execute("INSERT INTO users VALUES ('05','A','Eileen','Costello','88 The Titanfall','088123460','eileencostello@gmail.com','A1')");
			
			System.out.println("Users table created.");
			
		} catch (SQLException ex) {
			System.out.println("ERROR: buildUserTable" + ex.getMessage());
		}
		q.close();
	}
	
	public void buildHotelTable() {
		try {
			q.open("local");
			// Get a Statement object.
			stmt = q.getConn().createStatement();
			stmt.executeUpdate("CREATE TABLE Hotels "
					+ "(Hotel_ID number NOT NULL PRIMARY KEY,Hotel_Name varchar2(50),Hotel_PhoneNumber varchar2(50),Hotel_Address varchar2(50),NumOfRoom number, HotelRating number )");
			
			String sqlInsert= "INSERT INTO hotels VALUES(?,?,?,?,?,?)";
			pstmt = q.getConn().prepareStatement(sqlInsert);
			
			pstmt.setInt(1,1001 );
			pstmt.setString(2, "TitanFall Tower Hotel");
			pstmt.setString(3,"087998877");
			pstmt.setString(4, "100 Star Living Street");
			pstmt.setInt(5, 10);
			pstmt.setInt(6,5);
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 1002);
			pstmt.setString(2, "Fawlty Towers");
			pstmt.setString(3, "0851435213");
			pstmt.setString(4, "Beverly Hills");
			pstmt.setInt(5, 2000);
			pstmt.setInt(6, 5);
			pstmt.executeUpdate();
			
			System.out.println("Hotels table created.");
			
		} 
		catch (SQLException ex) {
			System.out.println("ERROR:  buildHotelTable" + ex.getMessage());
			ex.printStackTrace();
		}
		q.close();
	}
	
	public void buildBookingsTable() {
		try {
			q.open("local");
			// Get a Statement object.
			stmt = q.getConn().createStatement();
			stmt.executeUpdate("CREATE TABLE Bookings "
					+ "(Booking_ID number NOT NULL PRIMARY KEY, Number_Of_Guests number, Number_Of_Nights number, "
					+ "Number_Of_Rooms number, Total_Cost number, ArrivalDate varchar2(50), FOREIGN KEY (User_ID) REFERENCES users,"
					+ "FOREIGN KEY (Hotel_ID) REFERENCES hotels)");
			
			String sqlInsert= "INSERT INTO bookings VALUES(?,?,?,?,?,?)";
			pstmt = q.getConn().prepareStatement(sqlInsert);
			
			// Insert row #1.
			pstmt.setInt(1, 000);
			pstmt.setInt(2, 2);
			pstmt.setInt(3, 1);
			pstmt.setInt(4, 1);
			pstmt.setInt(5, 199);
			pstmt.setString(6, "1-1-14");
			pstmt.setInt(7, 1001);
			pstmt.setString(8, "01");
			pstmt.executeUpdate();
			
			// Insert row #2.
			pstmt.setInt(1, 001);
			pstmt.setInt(2, 1);
			pstmt.setInt(3, 2);
			pstmt.setInt(4, 1);
			pstmt.setInt(5, 118);
			pstmt.setString(6, "2-1-14");
			pstmt.setInt(7, 1001);
			pstmt.setString(8, "01");
			pstmt.executeUpdate();
			
			// Insert row #3.
			pstmt.setInt(1, 002);
			pstmt.setInt(2, 4);
			pstmt.setInt(3, 5);
			pstmt.setInt(4, 1);
			pstmt.setInt(5, 472);
			pstmt.setString(6, "3-1-14");
			pstmt.setInt(7, 1001);
			pstmt.setString(8, "01");
			pstmt.executeUpdate();
			
			// Insert row #4.
			pstmt.setInt(1, 003);
			pstmt.setInt(2, 2);
			pstmt.setInt(3, 1);
			pstmt.setInt(4, 1);
			pstmt.setInt(5, 99);
			pstmt.setString(6, "4-1-14");
			pstmt.setInt(7, 1001);
			pstmt.setString(8, "02");
			pstmt.executeUpdate();
			
			// Insert row #5.
			pstmt.setInt(1, 004);
			pstmt.setInt(2, 1);
			pstmt.setInt(3, 7);
			pstmt.setInt(4, 1);
			pstmt.setInt(5, 99);
			pstmt.setString(6, "5-1-14");
			pstmt.setInt(7, 1001);
			pstmt.setString(8, "03");
			pstmt.executeUpdate();
			
			// Insert row #6.
			pstmt.setInt(1, 005);
			pstmt.setInt(2, 2);
			pstmt.setInt(3, 1);
			pstmt.setInt(4, 1);
			pstmt.setInt(5, 199);
			pstmt.setString(6, "6-1-14");
			pstmt.setInt(7, 1001);
			pstmt.setString(8, "04");
			pstmt.executeUpdate();
			
			System.out.println("Bookingss table created.");
			
		} 
		catch (SQLException ex) {
			System.out.println("ERROR:  buildBookingTable" + ex.getMessage());
			ex.printStackTrace();
		}
		q.close();
	}
	
	public void buildRoomTypesTable(){
		String sql = "INSERT INTO roomtypes values(?,?,?)"; 
		try {
			q.open("local");
			// Get a Statement object.
			 pstmt = q.getConn().prepareStatement("CREATE TABLE roomtypes "
						+ "(Type_ID number NOT NULL PRIMARY KEY,Type_Name varchar2(50),RoomType_Price number)");

			// Create the table.
			pstmt.executeUpdate();

			System.out.println("roomtypes table created.");
			
			pstmt = q.getConn().prepareStatement(sql);
			
			//insert row 1
			pstmt.setInt(1, 1000);
			pstmt.setString(2, "Single");
			pstmt.setDouble(3, 59);
			pstmt.executeUpdate();
			
			//insert row 2
			pstmt.setInt(1, 1001);
			pstmt.setString(2, "Double");
			pstmt.setDouble(3, 99);
			pstmt.executeUpdate();
			
			//insert row 3
			pstmt.setInt(1, 1002);
			pstmt.setString(2, "Twin");
			pstmt.setDouble(3, 199);
			pstmt.executeUpdate();
			
		} 
		catch (SQLException ex) {
			System.out.println("ERROR:  buildRoomTypesTable" + ex.getMessage());
		}
		q.close();
	}
	
	public void bulidRoomsTable(){
		String sql = "INSERT INTO rooms values(?,?,?)";
		try {
			q.open("local");
			// Get a Statement object.
			 pstmt = q.getConn().prepareStatement("CREATE TABLE Rooms "
						+ "(Room_Number number NOT NULL PRIMARY KEY, Room_Availability char, Type_ID number, FOREIGN KEY (Type_ID) REFERENCES roomtypes )");

			// Create the table.
			pstmt.executeUpdate();
			
			System.out.println("Rooms table created.");
			
			pstmt = q.getConn().prepareStatement(sql);
			
			// Insert row #1.
			pstmt.setInt(1, 101);
			pstmt.setString(2, "T");
			pstmt.setInt(3, 1000);
			pstmt.executeUpdate();
			
			// Insert row #2.
			pstmt.setInt(1, 102);
			pstmt.setString(2, "T");
			pstmt.setInt(3, 1000);
			pstmt.executeUpdate();
			
			// Insert row #3.
			pstmt.setInt(1, 103);
			pstmt.setString(2, "T");
			pstmt.setInt(3, 1000);
			pstmt.executeUpdate();
			
			// Insert row #4.
			pstmt.setInt(1, 104);
			pstmt.setString(2, "T");
			pstmt.setInt(3, 1000);
			pstmt.executeUpdate();
			
			// Insert row #5.
			pstmt.setInt(1, 105);
			pstmt.setString(2, "T");
			pstmt.setInt(3, 1000);
			pstmt.executeUpdate();
			
			// Insert row #6.
			pstmt.setInt(1, 201);
			pstmt.setString(2, "T");
			pstmt.setInt(3, 1001);
			pstmt.executeUpdate();
			
			// Insert row #7.
			pstmt.setInt(1, 202);
			pstmt.setString(2, "T");
			pstmt.setInt(3, 1001);
			pstmt.executeUpdate();
			
			// Insert row #8.
			pstmt.setInt(1, 203);
			pstmt.setString(2, "T");
			pstmt.setInt(3, 1001);
			pstmt.executeUpdate();
			
			// Insert row #9.
			pstmt.setInt(1, 204);
			pstmt.setString(2, "T");
			pstmt.setInt(3, 1001);
			pstmt.executeUpdate();
			
			// Insert row #10.
			pstmt.setInt(1, 205);
			pstmt.setString(2, "T");
			pstmt.setInt(3, 1001);
			pstmt.executeUpdate();
			
			// Insert row #11.
			pstmt.setInt(1, 301);
			pstmt.setString(2, "T");
			pstmt.setInt(3, 1002);
			pstmt.executeUpdate();
			
			// Insert row #12.
			pstmt.setInt(1, 302);
			pstmt.setString(2, "T");
			pstmt.setInt(3, 1002);
			pstmt.executeUpdate();
			
			// Insert row #13.
			pstmt.setInt(1, 303);
			pstmt.setString(2, "T");
			pstmt.setInt(3, 1002);
			pstmt.executeUpdate();
			
			// Insert row #14.
			pstmt.setInt(1, 304);
			pstmt.setString(2, "T");
			pstmt.setInt(3, 1002);
			pstmt.executeUpdate();
			
			// Insert row #15.
			pstmt.setInt(1, 305);
			pstmt.setString(2, "T");
			pstmt.setInt(3, 1002);
			pstmt.executeUpdate();
			
		} 
		catch (SQLException ex) {
			System.out.println("ERROR:  buildRooms" + ex.getMessage());
		}
		q.close();
	}
	
	public void queryDB() {
		String sqlStatement = "SELECT * FROM Users";
		try {
			q.open("local");
			Statement stmt = q.getConn().createStatement();
			// Send the statement to the DBMS.
			rset = stmt.executeQuery(sqlStatement);

			// Display the contents of the result set.
			// The result set will have three columns.
			while (rset.next()) {
				System.out.printf("%10s %10s %10s  %10s %10s %10s %10s %10s\n",
						rset.getString("User_ID"),
						rset.getString("UserType"),
						rset.getString("First_Name"),
						rset.getString("Last_Name"),
						rset.getString("HomeAddress"),
						rset.getString("Phone_Number"),
						rset.getString("Email_Address"),
						rset.getString("UserPassword"));
			}
			
		} catch (Exception ex) {
			System.out.println("ERROR: queryDB " + ex.getMessage());
		}
		q.close();
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
