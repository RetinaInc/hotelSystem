package Database;

import java.sql.*; 
import java.util.*;

import Model.*;
import oracle.jdbc.pool.OracleDataSource;

public class CreateTables {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rset;
	private Queries q = new Queries();
	private Hotel h;
	private int bookingID = 505;
	private int hotelID = 2222;
	
	public java.sql.Date convertDate(int day, int month, int year){
		GregorianCalendar cal = (GregorianCalendar)Calendar.getInstance();
		cal.clear();
		cal.set(year, month, day);
		java.sql.Date releaseDate = new java.sql.Date(cal.getTime().getTime());
		return releaseDate;
	}
	


	public void buildTitanFallTables() 
	{
		try {
//			q.open("college");
			q.open("local");
			
			stmt = q.getConn().createStatement();
			
// USERS TABLE
			stmt.executeUpdate("CREATE TABLE Users "
					+ "(User_ID	varchar2(50) NOT NULL PRIMARY KEY, UserType varchar2(1) CHECK (UserType IN ('G','A')), First_Name varchar2(50), Last_Name varchar2(50), HomeAddress varchar2(50), Phone_Number varchar2(50), Email_Address varchar2(50), UserPassword varchar2(50) NOT NULL)");
			
			String sqlInsert = "INSERT INTO users VALUES (?,?,?,?,?,?,?,?)";
			pstmt = q.getConn().prepareStatement(sqlInsert);
			
			// USERS Insert row #1.
			pstmt.setString(1,"01");
			pstmt.setString(2,"G");
			pstmt.setString(3,"Derek");
			pstmt.setString(4,"Mulhern");
			pstmt.setString(5,"Celbridge");
			pstmt.setString(6,"088123456");
			pstmt.setString(7,"delpeter@gmail.com");
			pstmt.setString(8,"P1");
			pstmt.executeUpdate();
			
			// USERS Insert row #2.
			pstmt.setString(1,"02");
			pstmt.setString(2,"G");
			pstmt.setString(3,"Robert");
			pstmt.setString(4,"Kenny");
			pstmt.setString(5,"101 The Jacks");
			pstmt.setString(6,"088123457");
			pstmt.setString(7,"robertkenny@gmail.com");
			pstmt.setString(8,"P2");
			pstmt.executeUpdate();
			
			// USERS Insert row #3.
			pstmt.setString(1,"03");
			pstmt.setString(2,"G");
			pstmt.setString(3,"Mark");
			pstmt.setString(4,"Lordan");
			pstmt.setString(5,"121 The Whatever");
			pstmt.setString(6,"088123458");
			pstmt.setString(7,"marklordan@gmail.com");
			pstmt.setString(8,"P3");
			pstmt.executeUpdate();
			
			// USERS Insert row #4.
			pstmt.setString(1,"04");
			pstmt.setString(2,"G");
			pstmt.setString(3,"Thomas");
			pstmt.setString(4,"Murphy");
			pstmt.setString(5,"7 The Pub");
			pstmt.setString(6,"088123459");
			pstmt.setString(7,"thomasmurphy@gmail.com");
			pstmt.setString(8,"P4");
			pstmt.executeUpdate();
			
			// USERS Insert row #4.
			pstmt.setString(1,"05");
			pstmt.setString(2,"A");
			pstmt.setString(3,"Eileen");
			pstmt.setString(4,"Costello");
			pstmt.setString(5,"88 The Titanfall");
			pstmt.setString(6,"088123460");
			pstmt.setString(7,"eileencostello@gmail.com");
			pstmt.setString(8,"A1");
			pstmt.executeUpdate();
			
// HOTELS TABLE
			stmt.executeUpdate("CREATE TABLE Hotels "
					+ "(Hotel_ID number NOT NULL PRIMARY KEY, Hotel_Name varchar2(50), Hotel_PhoneNumber varchar2(50), Hotel_Address varchar2(50), NumOfRooms number, HotelRating number)");
			
			stmt.executeUpdate("CREATE SEQUENCE hotel_seq start with 2222 increment by 2222");
			
			String hotelInsert = "INSERT INTO hotels VALUES(hotel_seq.nextval,?,?,?,?,?)";
			pstmt = q.getConn().prepareStatement(hotelInsert);
			
			// HOTELS Insert row #1.
			pstmt.setString(1, "TitanFall Tower Hotel");
			pstmt.setString(2,"087998877");
			pstmt.setString(3, "100 Star Living Street");
			pstmt.setInt(4, 10);
			pstmt.setInt(5,5);
			pstmt.executeUpdate();

// BOOKINGS TABLE
			stmt.executeUpdate("CREATE TABLE Bookings "
					+ "(Booking_ID number NOT NULL PRIMARY KEY, Number_Of_Guests number NOT NULL, Number_Of_Nights number NOT NULL, Number_Of_Rooms number NOT NULL, Total_Cost number(6,2), "
					+ "ArrivalDate Date, DepartureDate Date, Hotel_ID number, User_ID varchar2(50), FOREIGN KEY (Hotel_ID) REFERENCES hotels (Hotel_ID) ON DELETE CASCADE, FOREIGN KEY (User_ID) REFERENCES users (User_ID) ON DELETE CASCADE)");
			
			stmt.executeUpdate("CREATE SEQUENCE booking_seq start with 500 increment by 1");
			
			String bookingInsert = "INSERT INTO bookings VALUES(booking_seq.nextval,?,?,?,?,?,?,hotel_seq.currval,?)";
			pstmt = q.getConn().prepareStatement(bookingInsert);
			
			// BOOKINGS Insert row #1.
			pstmt.setInt(1, 2);
			pstmt.setInt(2, 1);
			pstmt.setInt(3, 1);
			pstmt.setDouble(4, 199);
			pstmt.setDate(5, convertDate(1,0,2015)); 				// 0 is representing January, 1 is February etc.	
			pstmt.setDate(6, convertDate(2,0,2015));
			pstmt.setString(7, "01");
			pstmt.executeUpdate();
			
//			pstmt.setDate(6, Date.valueOf("2015-01-02")); Keeping this comment as reference
//			pstmt.setDate(5, Date.valueOf("2015-01-01")); Keeping this comment as reference

			// ROOMTYPE TABLE
			stmt.executeUpdate("CREATE TABLE Roomtypes "
						+ "(Type_ID number NOT NULL PRIMARY KEY, Type_Name varchar2(50), RoomType_Price number(5,2))");
			
			stmt.executeUpdate("CREATE SEQUENCE roomType_seq start with 900 increment by 1");

			String roomTypeInsert = "INSERT INTO roomtypes values(roomType_seq.nextval,?,?)"; 
			pstmt = q.getConn().prepareStatement(roomTypeInsert);

			//ROOMTYPE Insert row #1
			pstmt.setString(1, "Single");
			pstmt.setDouble(2, 59);
			pstmt.executeUpdate();
			
// ROOMS TABLE
			stmt.executeUpdate("CREATE TABLE Rooms "
					+ "(Room_Number number NOT NULL PRIMARY KEY, Room_Availability char(1) CHECK (Room_Availability IN('T','F')), Type_ID number, FOREIGN KEY (Type_ID) REFERENCES roomtypes (Type_ID) ON DELETE CASCADE)");
			
			stmt.executeUpdate("CREATE SEQUENCE room_seq start with 1101 increment by 1");
			
			String roomInsert = "INSERT INTO rooms values(room_seq.nextval,?,roomType_seq.currval)";
			pstmt = q.getConn().prepareStatement(roomInsert);
			
			// ROOMS Insert row #1.
			pstmt.setString(1, "T");
			pstmt.executeUpdate();
		
			
// ROOMBOOKINGS TABLE
			stmt.executeUpdate("CREATE TABLE RoomBookings "
					+ "(Room_Number number NOT NULL, Booking_ID number NOT NULL, DateOfBooking varchar2(50), PRIMARY KEY(Room_Number, Booking_ID), FOREIGN KEY (Room_Number) REFERENCES rooms (Room_Number) ON DELETE CASCADE, FOREIGN KEY (Booking_ID) REFERENCES bookings (Booking_ID) ON DELETE CASCADE)");
			
			String roomBookingsInsert = "INSERT INTO roombookings VALUES(room_seq.currval, booking_seq.currval, ?)";
			pstmt = q.getConn().prepareStatement(roomBookingsInsert);
			
			// ROOMBOOKINGS Insert row #1.
			pstmt.setString(1,"26.12.14");
			pstmt.executeUpdate();
			
// SPECIALS TABLE
			stmt.executeUpdate("CREATE TABLE Specials "
					+ "(Special_ID varchar2(50) NOT NULL PRIMARY KEY, Special_Name varchar2(50), Special_Cost number(5,2), Booking_ID number, FOREIGN KEY(Booking_ID) REFERENCES bookings (Booking_ID) ON DELETE CASCADE)");
			
			stmt.executeUpdate("CREATE SEQUENCE special_seq start with 11 increment by 11");
			
			
			String specialInsert = "INSERT INTO specials VALUES(special_seq.nextval,?,?,booking_seq.currval)";
			pstmt = q.getConn().prepareStatement(specialInsert);
			
			// SPECIALS Insert row #1.
			pstmt.setString(1,"Golf");
			pstmt.setDouble(2,100);
			pstmt.executeUpdate();
			
			String roomInsert2 = "INSERT INTO rooms values(room_seq.nextval,?,roomType_seq.currval)";
			pstmt = q.getConn().prepareStatement(roomInsert2);
			
			// ROOMS Insert row #2.
			pstmt.setString(1, "T");
			pstmt.executeUpdate();
			// ROOMS Insert row #3.
			pstmt.setString(1, "T");
			pstmt.executeUpdate();
			// ROOMS Insert row #4.
			pstmt.setString(1, "T");
			pstmt.executeUpdate();
			
			String bookingInsert2 = "INSERT INTO bookings VALUES(booking_seq.nextval,?,?,?,?,?,?,hotel_seq.currval,?)";
			pstmt = q.getConn().prepareStatement(bookingInsert2);
			
			// BOOKINGS Insert row #2.
			pstmt.setInt(1, 1);
			pstmt.setInt(2, 2);
			pstmt.setInt(3, 1);
			pstmt.setDouble(4, 118);
			pstmt.setDate(5, convertDate(2, 0, 2016)); // 0 represents January
			pstmt.setDate(6, convertDate(3, 0, 2016)); // 0 represents January
			pstmt.setString(7, "01");
			pstmt.executeUpdate();

			
			String roomInsert3 = "INSERT INTO rooms values(room_seq.nextval,?,roomType_seq.currval)";
			pstmt = q.getConn().prepareStatement(roomInsert3);
			
			// ROOMS Insert row #5.
			pstmt.setString(1, "T");
			pstmt.executeUpdate();
			
			
			String roomTypeInsert3 = "INSERT INTO roomtypes values(roomType_seq.nextval,?,?)"; 
			pstmt = q.getConn().prepareStatement(roomTypeInsert3);

			// ROOMTYPES Insert row 2
			pstmt.setString(1, "Double");
			pstmt.setDouble(2, 99);
			pstmt.executeUpdate();
			
			String roomBookingsInsert2 = "INSERT INTO roombookings VALUES(room_seq.currval,booking_seq.currval,?)";
			pstmt = q.getConn().prepareStatement(roomBookingsInsert2);
			
			// ROOMBOOKINGS Insert row #2.
			pstmt.setString(1,"1.1.16");
			pstmt.executeUpdate();
			
			String specialInsert2 = "INSERT INTO specials VALUES(special_seq.nextval,?,?,booking_seq.currval)";
			pstmt = q.getConn().prepareStatement(specialInsert2);
			
			// SPECIALS Insert row #2.
			pstmt.setString(1, "Spa");
			pstmt.setDouble(2,150);
			pstmt.executeUpdate();
			
			String roomInsert4 = "INSERT INTO rooms values(room_seq.nextval,?,roomType_seq.currval)";
			pstmt = q.getConn().prepareStatement(roomInsert4);
			
			// ROOMS Insert row #6.
			pstmt.setString(1, "T");
			pstmt.executeUpdate();
			// ROOMS Insert row #7.
			pstmt.setString(1, "T");
			pstmt.executeUpdate();
			
			String bookingInsert3 = "INSERT INTO bookings VALUES(booking_seq.nextval,?,?,?,?,?,?,hotel_seq.currval,?)";
			pstmt = q.getConn().prepareStatement(bookingInsert3);
			
			// BOOKINGS Insert row #3.
			pstmt.setInt(1, 4);
			pstmt.setInt(2, 5);
			pstmt.setInt(3, 1);
			pstmt.setDouble(4, 495);
			pstmt.setDate(5, convertDate(02,7,2014)); // 7 represents August
			pstmt.setDate(6, convertDate(7,7,2014)); // 7 represents August
			pstmt.setString(7, "01");
			pstmt.executeUpdate();
			
			
			String roomInsert5 = "INSERT INTO rooms values(room_seq.nextval,?,roomType_seq.currval)";
			pstmt = q.getConn().prepareStatement(roomInsert5);
			// ROOMS Insert row #8.
			pstmt.setString(1, "T");
			pstmt.executeUpdate();
			
			
			String roomBookingsInsert3 = "INSERT INTO roombookings VALUES(room_seq.currval,booking_seq.currval,?)";
			pstmt = q.getConn().prepareStatement(roomBookingsInsert3);
			
			// ROOMBOOKINGS Insert row #3.
			pstmt.setString(1,"25.7.16");
			pstmt.executeUpdate();
			
			String specialInsert3 = "INSERT INTO specials VALUES(special_seq.nextval,?,?,booking_seq.currval)";
			pstmt = q.getConn().prepareStatement(specialInsert3);
			
			// SPECIALS Insert row #3.
			pstmt.setString(1, "Breakfast");
			pstmt.setDouble(2,19.99); 
			pstmt.executeUpdate();
			
			String roomInsert6 = "INSERT INTO rooms values(room_seq.nextval,?,roomType_seq.currval)";
			pstmt = q.getConn().prepareStatement(roomInsert6);
			
			// ROOMS Insert row #9.
			pstmt.setString(1, "T");
			pstmt.executeUpdate();
			// ROOMS Insert row #10.
			pstmt.setString(1, "T");
			pstmt.executeUpdate();
			
			String bookingInsert4 = "INSERT INTO bookings VALUES(booking_seq.nextval,?,?,?,?,?,?,hotel_seq.currval,?)";
			pstmt = q.getConn().prepareStatement(bookingInsert4);
			
			// BOOKINGS Insert row #4.
			pstmt.setInt(1, 2);
			pstmt.setInt(2, 2);
			pstmt.setInt(3, 1);
			pstmt.setDouble(4, 99);
			pstmt.setDate(5, convertDate(20, 1, 2015)); // 1 represents February
			pstmt.setDate(6, convertDate(22, 1, 2015)); // 1 represents February
			pstmt.setString(7, "02");
			pstmt.executeUpdate();
			
			String roomBookingsInsert4 = "INSERT INTO roombookings VALUES(room_seq.currval,booking_seq.currval,?)";
			pstmt = q.getConn().prepareStatement(roomBookingsInsert4);
			
			// ROOMBOOKINGS Insert row #4.
			pstmt.setString(1,"31.1.15");
			pstmt.executeUpdate();
			
			String specialInsert4 = "INSERT INTO specials VALUES(special_seq.nextval,?,?,booking_seq.currval)";
			pstmt = q.getConn().prepareStatement(specialInsert4);
			
			// SPECIALS Insert row #4.
			pstmt.setString(1, "Valentines Day");
			pstmt.setDouble(2,50);
			pstmt.executeUpdate();
			
			String roomTypeInsert4 = "INSERT INTO roomtypes values(roomType_seq.nextval,?,?)"; 
			pstmt = q.getConn().prepareStatement(roomTypeInsert4);

			// ROOMTYPES Insert row 3
			pstmt.setString(1, "Twin");
			pstmt.setDouble(2, 199);
			pstmt.executeUpdate();
			
			String roomInsert7 = "INSERT INTO rooms values(room_seq.nextval,?,roomType_seq.currval)";
			pstmt = q.getConn().prepareStatement(roomInsert7);
			
			// ROOMS Insert row #11.
			pstmt.setString(1, "T");
			pstmt.executeUpdate();
			// ROOMS Insert row #12.
			pstmt.setString(1, "T");
			pstmt.executeUpdate();
			// ROOMS Insert row #13.
			pstmt.setString(1, "T");
			pstmt.executeUpdate();


			String bookingInsert5 = "INSERT INTO bookings VALUES(booking_seq.nextval,?,?,?,?,?,?,hotel_seq.currval,?)";
			pstmt = q.getConn().prepareStatement(bookingInsert5);
			
			// BOOKINGS Insert row #5.
			pstmt.setInt(1, 2);
			pstmt.setInt(2, 7);
			pstmt.setInt(3, 1);
			pstmt.setDouble(4, 1393);
			pstmt.setDate(5, convertDate(29, 10, 2014)); // 10 represents November
			pstmt.setDate(6, convertDate(6, 11, 2914)); // 11 represents December
			pstmt.setString(7, "03");
			pstmt.executeUpdate();
			
			String roomBookingsInsert5 = "INSERT INTO roombookings VALUES(room_seq.currval,booking_seq.currval,?)";
			pstmt = q.getConn().prepareStatement(roomBookingsInsert5);
			
			// ROOMBOOKINGS Insert row #5.
			pstmt.setString(1,"2.11.14");
			pstmt.executeUpdate();
			
			String roomInsert8 = "INSERT INTO rooms values(room_seq.nextval,?,roomType_seq.currval)";
			pstmt = q.getConn().prepareStatement(roomInsert8);
			
			// ROOMS Insert row #14.
			pstmt.setString(1, "T");
			pstmt.executeUpdate();
			
			
			String bookingInsert6 = "INSERT INTO bookings VALUES(booking_seq.nextval,?,?,?,?,?,?,hotel_seq.currval,?)";
			pstmt = q.getConn().prepareStatement(bookingInsert6);
			
			// BOOKINGS Insert row #6.
			pstmt.setInt(1, 2);
			pstmt.setInt(2, 1);
			pstmt.setInt(3, 1);
			pstmt.setDouble(4, 199);
//			pstmt.setDate(5, Date.valueOf("2016-02-15"));
			pstmt.setDate(5, convertDate(15, 1, 2016));
//			pstmt.setDate(6, Date.valueOf("2016-02-16"));
			pstmt.setDate(6, convertDate(16, 1, 2016));
			pstmt.setString(7, "04");
			pstmt.executeUpdate();
			
			String roomBookingsInsert6 = "INSERT INTO roombookings VALUES(room_seq.currval,booking_seq.currval,?)";
			pstmt = q.getConn().prepareStatement(roomBookingsInsert6);
			
			// ROOMBOOKINGS Insert row #6.
			pstmt.setString(1,"2.2.16");
			pstmt.executeUpdate();
			
			String roomInsert9 = "INSERT INTO rooms values(room_seq.nextval,?,roomType_seq.currval)";
			pstmt = q.getConn().prepareStatement(roomInsert9);
			
			// ROOMS Insert row #15.
			pstmt.setString(1, "T");
			pstmt.executeUpdate();
			
			// CREDITCARD TABLE
			stmt.executeUpdate("CREATE TABLE CreditCards " + "(Credit_CardNumber number NOT NULL PRIMARY KEY, CreditCard_Type varchar2(50) NOT NULL, NameOnCard varchar2(50) NOT NULL, ExpiryDate varchar2(50) NOT NULL, CCVNumber varchar2(50) NOT NULL, User_ID varchar2(50), FOREIGN KEY (User_ID) REFERENCES users (User_ID) ON DELETE CASCADE)");
			
			String creditcardsInsert = "INSERT INTO creditcards VALUES (?,?,?,?,?,?)";
			pstmt = q.getConn().prepareStatement(creditcardsInsert);
			
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
			
			System.out.println("Hotels table created.");
			System.out.println("Bookings table created.");	
			System.out.println("Users table created.");			
			System.out.println("Rooms table created.");
			System.out.println("Roomtypes table created.");
			System.out.println("RoomBookings table created.");
			System.out.println("Credit Card table created.");
			System.out.println("Specials table created.\n");
			
		} 
		catch (SQLException ex) {
			System.out.println("ERROR:  buildTitanFallTables " + ex.getMessage());
			ex.printStackTrace();
		}
		q.close();
	}
	
	public ResultSet getLastRow() {
		String sqlStatement = "SELECT * FROM bookings ORDER BY Booking_ID";
		try {
			pstmt = q.getConn().prepareStatement(sqlStatement,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rset = pstmt.executeQuery();
			rset.last();
			System.out.println(rset.getInt("Booking_ID"));
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		
		q.close();
		return rset;
	}
	
	// This method takes a reference variable of type Booking as a parameter and 
	// uses a prepared statement to add the booking to the Bookings table
	//also arrival date is split into 3 integers to convert it into a date format suitable
	//for sql

	
	
	public Hotel getHotel(){
		String hotelsqlS = "SELECT * FROM Hotels";
		try {
			//q.open("college");
			q.open("local");
			Statement stmt = q.getConn().createStatement();
			
			rset = stmt.executeQuery(hotelsqlS);
			while (rset.next()) {
				System.out.printf("%10d %10s %10s  %10s %10d %10d\n",
						rset.getInt(1),
						rset.getString(2),
						rset.getString(3),
						rset.getString(4),
						rset.getInt(5),
						rset.getInt(6));
				
				h = new Hotel(
						rset.getInt(1),
						rset.getString(2),
						rset.getString(3),
						rset.getString(4),
						rset.getInt(5),
						rset.getInt(6));
			}
			
		} catch (Exception ex) {
			System.out.println("ERROR: getHotel " + ex.getMessage());
		}
		q.close();
		return h;
	}
	
	
	public ArrayList<User> getUsers() {
		String sqlStatement = "SELECT * FROM Users";
		try {
			//q.open("college");
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
			System.out.println("ERROR: getUsers " + ex.getMessage());
		}
		q.close();
		return h.getUsers();
	}
	
	private String dayString,monthString,yearString,dayString2,monthString2,yearString2;
	private int day,month,year,day2,month2,year2;
	public void addBooking(Booking b) {
		dayString = b.getArrivalDate().substring(0, 2);
		monthString =  b.getArrivalDate().substring(3, 5);		
		yearString =  b.getArrivalDate().substring(6, 10);
		
		day = Integer.parseInt(dayString);
		month = Integer.parseInt(monthString);
		month = month -1;						//subtract 1 to get precise month i.e 01 should be 00 to represent Jan
		year = Integer.parseInt(yearString);
		
		dayString2 = b.getDepartureDate().substring(0, 2);
		monthString2 = b.getDepartureDate().substring(3, 5);
		yearString2 =  b.getDepartureDate().substring(6, 10);
		
		day2 = Integer.parseInt(dayString2);
		month2 = Integer.parseInt(monthString2);
		month2 = month2 -1;							//subtract 1 to get precise month i.e 01 should be 00 to represent Jan
		year2 = Integer.parseInt(yearString2);
		
		try {
			q.open("local");
			bookingID++;
			String sql = "INSERT INTO Bookings VALUES (booking_seq.nextval,?,?,?,?,?,?,hotel_seq.currval,?) ";

			pstmt = q.getConn().prepareStatement(sql);
			
			pstmt.setInt(1, b.getNumGuests());
			pstmt.setInt(2, b.getNumNights());
			pstmt.setInt(3, b.getNumRooms());
			pstmt.setDouble(4, b.getTotalCost());
			pstmt.setDate(5, convertDate(day,month,year)); //arrival Date
			pstmt.setDate(6, convertDate(day2,month2,year2)); //departure Date
			pstmt.setString(7, b.getUserID());
//			pstmt.setInt(1, bookingID);
//			pstmt.setInt(2, b.getNumGuests());
//			pstmt.setInt(3, b.getNumNights());
//			pstmt.setInt(4, b.getNumRooms());
//			pstmt.setDouble(5, b.getTotalCost());
//			pstmt.setDate(6, convertDate(day,month,year)); //arrival Date
//			pstmt.setDate(7, convertDate(day2,month2,year2)); //departure Date
//			pstmt.setInt(8, hotelID);
//			pstmt.setString(9, b.getUserID());

			pstmt.executeUpdate();
			
			System.out.println("booking created for " + b.getUserID());
		} catch (Exception se) {
			System.out.println("Error creating a booking " + se);
		}
		q.close();
	}
	
		/* 	
		 * This method updates a particular users details in the users table
		 * based on the id of the user 
		*/
		public void updateDeatils(String id,String fname,String lname,String add,String email,String phone) {
			try {
//				q.open("college");
				q.open("local");
				String sql = "UPDATE Users SET First_Name = '" + fname + "', Last_Name = '" + lname + "', HomeAddress = '"
						+ add + "',Email_Address = '" + email + "',Phone_Number = " + phone + "WHERE User_ID = '" + id + "'";
	
				stmt = q.getConn().createStatement();
				stmt.executeUpdate(sql);
				
				System.out.println("Users deatils have been updated");
			} catch (Exception e) {
				System.out.println("Update details error" + e);
			}
			q.close();
		}
		
		/* 	
		 * This method updates a particular users password in the database
		*/
		public void updatePassword(String id,String password) {
			try {
//				q.open("college");
				q.open("local");
				String sql = "UPDATE Users SET UserPassword = '" + password + "' WHERE User_ID = '" + id + "'";
	
				stmt = q.getConn().createStatement();
				stmt.executeUpdate(sql);
				
				System.out.println("Users password have been updated");
			} catch (Exception e) {
				System.out.println("Update password error" + e);
			}
			q.close();
		}	
}
