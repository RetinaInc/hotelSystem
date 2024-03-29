package Model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JList;

import Database.Queries;
import GUI.AvailabilityGUI;

public class Booking {

	private int bookingID,hotelID;
	private int numGuests, numNights, numRooms;
	private Calendar cal;
	private double totalCost;
	private String arrivalDate,departureDate,userID;
	private Queries q;
	
	public Booking(int bookingID, double totalCost){
		this.bookingID = bookingID;
		this.totalCost = totalCost;	
	}

	public Booking(Calendar call, int selectedIndex) {
		cal = Calendar.getInstance();
		this.cal.setTime(call.getTime());
		this.numNights = selectedIndex;
		q = new Queries();
	}
	public Booking(int bookingID, int numGuests, int numNights, int numRooms, double total,
			String arrivalDate, String departureDate, int hotelID, String userID) {
		this.bookingID = bookingID;
		this.numGuests = numGuests;
		this.numNights = numNights;
		this.numRooms = numRooms;
		this.totalCost = total;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.hotelID = hotelID;
		this.userID = userID;
	}
	
	//used to pass a booking object to the database where a full booking object is created from this
	public Booking(int bookingID , int numNights,int numRooms, double total,
			String arrivalDate, String departureDate, String userID) {
		this.bookingID = bookingID;
		this.numNights = numNights;
		this.numRooms = numRooms;
		this.totalCost = total;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.userID = userID;
	}
	//sql arrival and departure dates
	public Booking(int bookingID, int numGuests, int numRooms, double totalCost ,Date arrival,
			Date departure) {
		this.bookingID = bookingID;
		this.numGuests = numGuests;
		this.numRooms = numRooms;
		this.totalCost = totalCost;
		this.arrivalDate = arrival.toString();
		this.departureDate = departure.toString();
	}

	public Booking() {
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public int getNumGuests() {
		return numGuests;
	}

	public void setNumGuests(int numGuests) {
		this.numGuests = numGuests;
	}

	public int getNumNights() {
		return numNights;
	}

	public void setNumNights(int numNights) {
		this.numNights = numNights;
	}

	public int getNumRooms() {
		return numRooms;
	}

	public void setNumRooms(int numRooms) {
		this.numRooms = numRooms;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public Calendar getCal() {
		return cal;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public ArrayList<Room> availability() {
		System.out.println(getCal().getTime());
		System.out.println(getNumNights());
		ArrayList<Room> roomList;
		roomList = new ArrayList<Room>(q.availabilityQuery(getCal(),getNumNights()));

		return roomList;
	}
	public String dateConverter(Date d){
		String stringd ="";
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		stringd = df.format(d);
		System.out.println(stringd);
		return stringd;
	}
}
