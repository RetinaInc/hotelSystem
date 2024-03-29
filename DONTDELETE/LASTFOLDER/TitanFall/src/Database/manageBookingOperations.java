package Database;
/**
 * Robert Kenny 
 * Mark Lordan
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class manageBookingOperations {
	private Connection conn;
	private Statement stmt;
	private ResultSet rset;
	private PreparedStatement pstmt;
	private Queries q = new Queries();
	private Calendar today;
	private SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
	private String dayString,monthString,yearString;
	private int day,month,year;
	
	//this method takes in the month as an integer and returns the sting representation of it so it can
	//be used to compare departure dates to todays date
	public String getMonth(int month){
		String m = "";
		ArrayList<String> months = new ArrayList<String>();
		months.add("JAN");
		months.add("FEB");
		months.add("MAR");
		months.add("APR");
		months.add("MAY");
		months.add("JUN");
		months.add("JUL");
		months.add("AUG");
		months.add("SEP");
		months.add("OCT");
		months.add("NOV");
		months.add("DEC");
		
		for(int i = 0; i < months.size(); i++){
			m = months.get(month);
		}
		return m;
	}
	
	//this gets a particular users bookings where the arrival date has not passed
	public ArrayList<Object[]> getBookings(String userID){
		System.out.println(userID);
		today = Calendar.getInstance();
		String todaysDate = s.format(today.getTime());
		dayString = todaysDate.substring(0, 2);
		monthString = todaysDate.substring(3, 5);
		yearString =  todaysDate.substring(8, 10);
		
		day = Integer.parseInt(dayString);
		month = Integer.parseInt(monthString);
		month = month -1;			//subtract 1 to get precise month i.e 01 should be 00 to represent Jan
		year = Integer.parseInt(yearString);
		ArrayList<Object[]> resultList = new ArrayList<Object[]>();
		String query = "SELECT booking_id, number_of_guests, number_of_rooms,number_of_nights, total_cost, arrivaldate,"
				+ " departuredate FROM bookings WHERE USER_ID = '"+ userID + "' and BOOKINGS.DEPARTUREDATE >= '"
				+ day + "-" + getMonth(month) + "-" + year + "'";
		try{
			q.open();
			stmt = q.getConn().createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()){
				Object[] b = {rset.getInt("booking_id"),
						rset.getInt("number_of_guests"),
						rset.getInt("number_of_rooms"),
						rset.getInt("number_of_nights"),
						rset.getDouble("total_cost"),
						rset.getDate("arrivaldate"),
						rset.getDate("departuredate")};
				resultList.add(b);
			}
		}
		catch(SQLException se){
			System.out.println("Get bookings error");
			se.printStackTrace();
		}
		return resultList;
	}

	//this method gets all of the bookings in the system where the departure date has not yet passed
	//the admin can then select from this result set and delete them for what ever reason
	public ArrayList<Object[]> getBookingsAdmin(){
		ArrayList<Object[]> resultList = new ArrayList<Object[]>();
		
		today = Calendar.getInstance();
		String todaysDate = s.format(today.getTime());
		dayString = todaysDate.substring(0, 2);
		monthString = todaysDate.substring(3, 5);
		yearString =  todaysDate.substring(8, 10);
		
		day = Integer.parseInt(dayString);
		month = Integer.parseInt(monthString);
		month = month -1;			//subtract 1 to get precise month i.e 01 should be 00 to represent Jan
		year = Integer.parseInt(yearString);
		
		String query = "SELECT booking_ID,FIRST_NAME,LAST_NAME,NUMBER_OF_GUESTS,"
				+ "NUMBER_OF_NIGHTS,ARRIVALDATE "
				+ " from BOOKINGS,users WHERE users.USER_ID = BOOKINGS.USER_ID"
				+ " and BOOKINGS.DEPARTUREDATE >= '" + day + "-" + getMonth(month) + "-" + year + "'";
		try{
			q.open();
			stmt = q.getConn().createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()){
				Object[] b = {rset.getInt("booking_ID"),
						rset.getString("FIRST_NAME"),
						rset.getString("LAST_NAME"),
						rset.getInt("NUMBER_OF_GUESTS"),
						rset.getInt("NUMBER_OF_NIGHTS"),
						rset.getDate("ARRIVALDATE")};
				resultList.add(b);
			}
		}
		catch(SQLException se){
			System.out.println("Get bookings admin error");
			se.printStackTrace();
		}
		return resultList;
	}
	
	//removes a users booking based on the booking id
	//data is removed from bookings.roombookings and specialbookings if they have any
	public void removeBooking(int id){
		try
		{
			q.open();
			String sql = "Delete from roombookings where booking_ID = " + id;
			pstmt = q.getConn().prepareStatement(sql);
			pstmt.executeUpdate();
			
			sql = "Delete from specialbookings where booking_ID = " + id;
			pstmt = q.getConn().prepareStatement(sql);
			pstmt.executeUpdate();
			
			sql = "Delete from bookings where booking_ID = " + id;
			pstmt = q.getConn().prepareStatement(sql);
			pstmt.executeUpdate();
			
			System.out.println("booking " + id + " removed");
		}
		catch(Exception e){
			System.out.println("error removing booking " + e);
		}
	}
	public double getSpecialCost(int bookingID){
		double specialDiff =0;
		try{
		q.open();
		stmt = q.getConn().createStatement();
		String sql = "SELECT SUM(specials.special_cost) "
				+ "FROM specials INNER JOIN specialbookings ON specials.special_id = specialbookings.special_id "
				+ "WHERE specialbookings.booking_id = " + bookingID;
		rset = stmt.executeQuery(sql);
		while(rset.next()){
			specialDiff = rset.getInt(1);
		}
		}
		catch(SQLException se){
			System.out.println("Get bookings admin error");
			se.printStackTrace();
		}
		
		return specialDiff;
	}
}
