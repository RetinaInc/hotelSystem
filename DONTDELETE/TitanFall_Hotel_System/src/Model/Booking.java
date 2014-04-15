package Model;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JList;

import Database.Queries;
import GUI.AvailabilityGUI;

public class Booking {

	private int bookingID,hotelID;
	private int numGuests, numNights, numRooms, day, months, year;
	private double totalCost;
	private String arrivalDate,departureDate,userID;
	private Queries q;
	
	public Booking(){
		
	}
	public Booking(int bookingID, int numGuests, int day, int months,
			int year, int numNights, int numRooms, double totalCost) {
		this.bookingID = bookingID;
		this.numGuests = numGuests;
		this.numNights = numNights;
		this.numRooms = numRooms;
		this.totalCost = totalCost;
		this.day = day;
		this.months = months;
		this.year = year;
		q = new Queries();
	}

	public Booking(int day, int month, int year, int selectedIndex) {
		this.day = day;
		this.months = month;
		this.year = year;
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
	public Booking(int bookingID , int numGuests, int numNights, int numRooms, double total,
			String arrivalDate, String departureDate, String userID) {
		this.bookingID = bookingID;
		this.numGuests = numGuests;
		this.numNights = numNights;
		this.numRooms = numRooms;
		this.totalCost = total;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.userID = userID;
	}

	public Booking(int bookingID, int numGuests, int numRooms, double totalCost ,Date arrival,
			Date departure) {
		this.bookingID = bookingID;
		this.numGuests = numGuests;
		this.numRooms = numRooms;
		this.totalCost = totalCost;
		this.arrivalDate = arrival.toString();
		this.departureDate = departure.toString();
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

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public ArrayList<Room> availability() {

		ArrayList<Room> roomList = new ArrayList<Room>(q.availabilityQuery(
				getDay(), getMonths(), getYear(), getNumNights()));

		return roomList;
	}
}
