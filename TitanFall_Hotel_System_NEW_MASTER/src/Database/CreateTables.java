package Database;

import java.sql.*; // Needed for JDBC classes
import java.util.ArrayList;

import Model.Hotel;
import Model.User;
import oracle.jdbc.pool.OracleDataSource;

public class CreateTables {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rset;
	private Queries q = new Queries();
	private Hotel h;
	
	public void buildUserTable() {
		try {
			q.open("local");
			stmt = q.getConn().createStatement();

			stmt.executeUpdate("CREATE TABLE Users "
					+ "(User_ID	varchar2(50) NOT NULL PRIMARY KEY, UserType varchar2(5), First_Name varchar2(50), Last_Name varchar2(50), HomeAddress varchar2(50), Phone_Number varchar2(50), Email_Address varchar2(50), UserPassword varchar2(50))");

			String sqlInsert = "INSERT INTO users VALUES (?,?,?,?,?,?,?,?)";
			pstmt = q.getConn().prepareStatement(sqlInsert);
			
			// Insert row #1.
			pstmt.setString(1,"01");
			pstmt.setString(2,"G");
			pstmt.setString(3,"Derek");
			pstmt.setString(4,"Mulhern");
			pstmt.setString(5,"Celbridge");
			pstmt.setString(6,"088123456");
			pstmt.setString(7,"delpeter@gmail.com");
			pstmt.setString(8,"P1");
			pstmt.executeUpdate();
			
			// Insert row #2.
			pstmt.setString(1,"02");
			pstmt.setString(2,"G");
			pstmt.setString(3,"Robert");
			pstmt.setString(4,"Kenny");
			pstmt.setString(5,"101 The Jacks");
			pstmt.setString(6,"088123457");
			pstmt.setString(7,"robertkenny@gmail.com");
			pstmt.setString(8,"P2");
			pstmt.executeUpdate();
			
			// Insert row #3.
			pstmt.setString(1,"03");
			pstmt.setString(2,"G");
			pstmt.setString(3,"Mark");
			pstmt.setString(4,"Lordan");
			pstmt.setString(5,"121 The Whatever");
			pstmt.setString(6,"088123458");
			pstmt.setString(7,"marklordan@gmail.com");
			pstmt.setString(8,"P3");
			pstmt.executeUpdate();
			
			// Insert row #4.
			pstmt.setString(1,"04");
			pstmt.setString(2,"G");
			pstmt.setString(3,"Thomas");
			pstmt.setString(4,"Murphy");
			pstmt.setString(5,"7 The Pub");
			pstmt.setString(6,"088123459");
			pstmt.setString(7,"thomasmurphy@gmail.com");
			pstmt.setString(8,"P4");
			pstmt.executeUpdate();
			
			// Insert row #4.
			pstmt.setString(1,"05");
			pstmt.setString(2,"A");
			pstmt.setString(3,"Eileen");
			pstmt.setString(4,"Costello");
			pstmt.setString(5,"88 The Titanfall");
			pstmt.setString(6,"088123460");
			pstmt.setString(7,"eileencostello@gmail.com");
			pstmt.setString(8,"A1");
			pstmt.executeUpdate();
			
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
					+ "(Hotel_ID number NOT NULL PRIMARY KEY, Hotel_Name varchar2(50), Hotel_PhoneNumber varchar2(50), Hotel_Address varchar2(50), NumOfRoom number, HotelRating number )");
			
			String sqlInsert= "INSERT INTO hotels VALUES(?,?,?,?,?,?)";
			pstmt = q.getConn().prepareStatement(sqlInsert);
			
			// Insert row #1.
			pstmt.setInt(1,1001 );
			pstmt.setString(2, "TitanFall Tower Hotel");
			pstmt.setString(3,"087998877");
			pstmt.setString(4, "100 Star Living Street");
			pstmt.setInt(5, 10);
			pstmt.setInt(6,5);
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
			stmt = q.getConn().createStatement();
			
			stmt.executeUpdate("CREATE TABLE Bookings "
					+ "(Booking_ID number NOT NULL PRIMARY KEY, Number_Of_Guests number, Number_Of_Nights number, Number_Of_Rooms number, Total_Cost number, ArrivalDate Date,DepartureDate Date, Hotel_ID number, User_ID varchar2(50), FOREIGN KEY (Hotel_ID) REFERENCES hotels, FOREIGN KEY (User_ID) REFERENCES users)");
			
			stmt = q.getConn().createStatement();

			// Insert row #1.
			stmt.execute("INSERT INTO bookings VALUES(000,2,1,1,199,TO_DATE('2015/01/01','yyyy/mm/dd'),TO_DATE('2015/01/02','yyyy/mm/dd'),1001,'01')");
			stmt.execute("INSERT INTO bookings VALUES(001,1,2,1,118,TO_DATE('2016/01/02','yyyy/mm/dd'),TO_DATE('2016/01/03','yyyy/mm/dd'),1001,'02')");
			stmt.execute("INSERT INTO bookings VALUES(002,4,5,1,495,TO_DATE('2014/08/02','yyyy/mm/dd'),TO_DATE('2014/08/07','yyyy/mm/dd'),1001,'02')");
			stmt.execute("INSERT INTO bookings VALUES(003,2,2,1,99,TO_DATE('2015/02/20','yyyy/mm/dd'),TO_DATE('2015/02/22','yyyy/mm/dd'),1001,'04')");
			stmt.execute("INSERT INTO bookings VALUES(004,2,7,1,1393,TO_DATE('2014/11/29','yyyy/mm/dd'),TO_DATE('2014/12/06','yyyy/mm/dd'),1001,'03')");
			stmt.execute("INSERT INTO bookings VALUES(005,2,1,1,199,TO_DATE('2016/02/15','yyyy/mm/dd'),TO_DATE('2016/02/16','yyyy/mm/dd'),1001,'05')");
			
			System.out.println("Bookings table created.");		
		} 
		catch (SQLException ex) {
			System.out.println("ERROR:  buildBookingTable" + ex.getMessage());
			ex.printStackTrace();
		}
		q.close();
	}
	public void buildRoomTypesTable(){
		try {
			q.open("local");
			stmt = q.getConn().createStatement();
			
			stmt.executeUpdate("CREATE TABLE Roomtypes "
						+ "(Type_ID number NOT NULL PRIMARY KEY, Type_Name varchar2(50), RoomType_Price number)");

			String sql = "INSERT INTO roomtypes values(?,?,?)"; 
			pstmt = q.getConn().prepareStatement(sql);

			//Insert row 1
			pstmt.setInt(1, 1000);
			pstmt.setString(2, "Single");
			pstmt.setDouble(3, 59);
			pstmt.executeUpdate();
			
			//Insert row 2
			pstmt.setInt(1, 1001);
			pstmt.setString(2, "Double");
			pstmt.setDouble(3, 99);
			pstmt.executeUpdate();
			
			//Insert row 3
			pstmt.setInt(1, 1002);
			pstmt.setString(2, "Twin");
			pstmt.setDouble(3, 199);
			pstmt.executeUpdate();
			
			System.out.println("Roomtypes table created.");
		} 
		catch (SQLException ex) {
			System.out.println("ERROR:  buildRoomTypesTable" + ex.getMessage());
		}
		q.close();
	}
	
	public void bulidRoomsTable(){
		try {
			q.open("local");
			stmt = q.getConn().createStatement();
			
			stmt.executeUpdate("CREATE TABLE Rooms "
						+ "(Room_Number number NOT NULL PRIMARY KEY, Room_Availability char, Type_ID number, FOREIGN KEY (Type_ID) REFERENCES roomtypes )");

			
			String sql = "INSERT INTO rooms values(?,?,?)";
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
			
			System.out.println("Rooms table created.");
			
		} 
		catch (SQLException ex) {
			System.out.println("ERROR:  buildRoomsTable" + ex.getMessage());
		}
		q.close();
	}
	
	public void buildRoomBookingsTable() {
		try {
			q.open("local");
			stmt = q.getConn().createStatement();
			
			stmt.executeUpdate("CREATE TABLE RoomBookings "
					+ "(Room_Number number NOT NULL, Booking_ID number NOT NULL, DateOfBooking varchar2(50), PRIMARY KEY(Room_Number, Booking_ID), FOREIGN KEY (Room_Number) REFERENCES rooms, FOREIGN KEY (Booking_ID) REFERENCES bookings)");
			
			String sqlInsert= "INSERT INTO roombookings VALUES(?,?,?)";
			pstmt = q.getConn().prepareStatement(sqlInsert);
			
			// Insert row #1.
			pstmt.setInt(1,301);
			pstmt.setInt(2,000);
			pstmt.setString(3,"4.9.14");
			pstmt.executeUpdate();
			
			// Insert row #2.
			pstmt.setInt(1,105);
			pstmt.setInt(2,001);
			pstmt.setString(3,"4.9.14");
			pstmt.executeUpdate();
			
			// Insert row #3.
			pstmt.setInt(1,203);
			pstmt.setInt(2,002);
			pstmt.setString(3,"5.7.14");
			pstmt.executeUpdate();
			
			// Insert row #4.
			pstmt.setInt(1,205);
			pstmt.setInt(2,003);
			pstmt.setString(3,"6.6.14");
			pstmt.executeUpdate();
			
			// Insert row #5.
			pstmt.setInt(1,305);
			pstmt.setInt(2,004);
			pstmt.setString(3,"7.3.14");
			pstmt.executeUpdate();
			
			//Insert row 6
			pstmt.setInt(1,305);
			pstmt.setInt(2,005);
			pstmt.setString(3,"7.3.14");
			pstmt.executeUpdate();
			
			
			System.out.println("RoomBookings table created.");
			
		} 
		catch (SQLException ex) {
			System.out.println("ERROR:  buildRoomBookingsTable" + ex.getMessage());
			ex.printStackTrace();
		}
		q.close();
	}
	
	public void buildCreditCardsTable(){
		try{
			q.open("local");
			stmt = q.getConn().createStatement();
			
			stmt.executeUpdate("CREATE TABLE CreditCards " + "(Credit_CardNumber number NOT NULL PRIMARY KEY, CreditCard_Type varchar2(50), NameOnCard varchar2(50), ExpiryDate varchar2(50), CCVNumber varchar2(50), User_ID varchar2(50), FOREIGN KEY (User_ID) REFERENCES users)");
			
			String sqlInsert = "INSERT INTO creditcards VALUES (?,?,?,?,?,?)";
			pstmt = q.getConn().prepareStatement(sqlInsert);
			
			//Insert row #1.
			pstmt.setInt(1,1234);
			pstmt.setString(2, "Visa");
			pstmt.setString(3, "Derek Mulhern");
			pstmt.setString(4, "01-01-2014");
			pstmt.setString(5,"CCV123");
			pstmt.setString(6,"01");
			pstmt.executeUpdate();
			
			//Insert row #2.
			pstmt.setInt(1,12345);
			pstmt.setString(2, "Mastercard");
			pstmt.setString(3, "Robert Kenny");
			pstmt.setString(4, "02-02-2014");
			pstmt.setString(5,"CCV456");
			pstmt.setString(6,"02");
			pstmt.executeUpdate();
			
			//Insert row #3.
			pstmt.setInt(1,123456);
			pstmt.setString(2, "Visa");
			pstmt.setString(3, "Mark Lordan");
			pstmt.setString(4, "03-03-2014");
			pstmt.setString(5,"CCV789");
			pstmt.setString(6,"03");
			pstmt.executeUpdate();
			
			//Insert row #4.
			pstmt.setInt(1,1234567);
			pstmt.setString(2, "Visa");
			pstmt.setString(3, "Thomas Murphy");
			pstmt.setString(4, "04-04-2014");
			pstmt.setString(5,"CCV001");
			pstmt.setString(6,"04");
			pstmt.executeUpdate();
			
			System.out.println("Credit Card table created.");
		}
		catch(SQLException ex){
			System.out.println("ERROR:  buildCreditCardTable" + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public void buildSpecialsTable() {
		try {
			q.open("local");
			stmt = q.getConn().createStatement();
			
			stmt.executeUpdate("CREATE TABLE Specials "
					+ "(Special_ID varchar2(50) NOT NULL PRIMARY KEY, Special_Name varchar2(50), Special_Cost number, Booking_ID number, FOREIGN KEY(Booking_ID) REFERENCES bookings )");
			
			String sqlInsert= "INSERT INTO specials VALUES(?,?,?,?)";
			pstmt = q.getConn().prepareStatement(sqlInsert);
			
			// Insert row #1.
			pstmt.setInt(1,22);
			pstmt.setString(2, "Golf");
			pstmt.setInt(3,100);
			pstmt.setInt(4, 000);
			pstmt.executeUpdate();
			
			// Insert row #2.
			pstmt.setInt(1,33);
			pstmt.setString(2, "Spa");
			pstmt.setInt(3,150);
			pstmt.setInt(4, 001);
			pstmt.executeUpdate();
			
			// Insert row #3.
			pstmt.setInt(1,44);
			pstmt.setString(2, "Breakfast");
			pstmt.setDouble(3,19.99); // This needs to be a double?!!!!
			pstmt.setInt(4, 002);
			pstmt.executeUpdate();
			
			// Insert row #4.
			pstmt.setInt(1,55);
			pstmt.setString(2, "Valentines Day");
			pstmt.setDouble(3,50);
			pstmt.setInt(4, 003);
			pstmt.executeUpdate();
			
			System.out.println("Specials table created.\n");
			
		} 
		catch (SQLException ex) {
			System.out.println("ERROR:  buildSpecialTable" + ex.getMessage());
			ex.printStackTrace();
		}
		q.close();
	}
	
	public Hotel getHotel(){
		String sqlStatement = "SELECT * FROM Hotels";
		try {
			q.open("local");
			Statement stmt = q.getConn().createStatement();
			// Send the statement to the DBMS.
			rset = stmt.executeQuery(sqlStatement);

			// Display the contents of the result set.
			// The result set will have three columns.  
			
			while (rset.next()) {
				System.out.printf("%10s %10s %10s  %10s %10d %10d\n",
						rset.getString("Hotel_ID"),
						rset.getString("Hotel_Name"),
						rset.getString("Hotel_PhoneNumber"),
						rset.getString("Hotel_Address"),
						rset.getInt("NumOfRoom"),
						rset.getInt("HotelRating"));
				
				h = new Hotel(rset.getString("Hotel_ID"),
						rset.getString("Hotel_Name"),
						rset.getString("Hotel_PhoneNumber"),
						rset.getString("Hotel_Address"),
						rset.getInt("NumOfRoom"),
						rset.getInt("HotelRating"));
				
				
			}
			
		} catch (Exception ex) {
			System.out.println("ERROR: queryDB " + ex.getMessage());
		}
		q.close();
		return h;
	}
	
	public ArrayList<User> getUsers() {
		String sqlStatement = "SELECT * FROM Users";
		try {
			q.open("local");
			Statement stmt = q.getConn().createStatement();
			// Send the statement to the DBMS.
			rset = stmt.executeQuery(sqlStatement);

			// Display the contents of the result set.
			// The result set will have three columns.
			while (rset.next()) {
				System.out.printf("%5s %5s %8s %15s %20s %15s %25s %10s\n",
						rset.getString("User_ID"),
						rset.getString("UserType"),
						rset.getString("First_Name"),
						rset.getString("Last_Name"),
						rset.getString("HomeAddress"),
						rset.getString("Phone_Number"),
						rset.getString("Email_Address"),
						rset.getString("UserPassword"));
				
				User u = new User(rset.getString("User_ID"),
						rset.getString("UserType"),
						rset.getString("First_Name"),
						rset.getString("Last_Name"),
						rset.getString("HomeAddress"),
						rset.getString("Phone_Number"),
						rset.getString("Email_Address"),
						rset.getString("UserPassword"));
				
				h.addUsers(u);
			}
			
		} catch (Exception ex) {
			System.out.println("ERROR: queryDB " + ex.getMessage());
		}
		q.close();
		return h.getUsers();
		
		
	}
	
	// This method updates a particular users details in the users table
		// based on the id of the user 
		public void updateDeatils(String id,String fname,String lname,String add,String email,String phone) {
			try {
				q.open("local");
				String sql = "UPDATE Users SET First_Name = '" + fname + "', Last_Name = '" + lname + "', HomeAddress = '"
						+ add + "',Email_Address = '" + email + "',Phone_Number = " + phone + "WHERE User_ID = '" + id + "'";
	
				stmt = q.getConn().createStatement();
				stmt.executeUpdate(sql);
				
				System.out.println("Users deatils have been updated");
			} catch (Exception e) {
				System.out.println("Problem" + e);
			}
			q.close();
		}
		
		public void updatePassword(String id,String password) {
			try {
				q.open("local");
				String sql = "UPDATE Users SET UserPassword = '" + password + "' WHERE User_ID = '" + id + "'";
	
				stmt = q.getConn().createStatement();
				stmt.executeUpdate(sql);
				
				System.out.println("Users password have been updated");
			} catch (Exception e) {
				System.out.println("Problem" + e);
			}
			q.close();
		}
	
	public void queryDB() {
		String sqlStatement = "SELECT * FROM Users";
		try {
			q.open("local");
			Statement stmt = q.getConn().createStatement();

			rset = stmt.executeQuery(sqlStatement);

			while (rset.next()) {
				System.out.printf("%5s %5s %8s %15s %20s %15s %25s %10s\n",
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
}
