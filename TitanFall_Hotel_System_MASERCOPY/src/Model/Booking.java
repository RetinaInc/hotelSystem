package Model;

import Database.Queries;

public class Booking {
	
	private String bookingID;
	private int numGuests,numNights,numRooms, day, months, year;
	private double totalCost;
	private Queries q;
	
	public Booking(String bookingID, int numGuests, int day, int months, int year, int numNights, int numRooms, double totalCost){
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

	public String getBookingID() {
		return bookingID;
	}

	public void setBookingID(String bookingID) {
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
	public void availability(){
		
		q.availabilityQuery(getDay(),getMonths(), getYear(), getNumNights());
		
	}
	
	
}
