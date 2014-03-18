package Model;

public class Booking {
	
	private String bookingID;
	private int numGuests,numNights,numRooms;
	private double totalCost;
	
	public Booking(String bookingID, int numGuests, int numNights, int numRooms, double totalCost){
		this.bookingID = bookingID;
		this.numGuests = numGuests;
		this.numNights = numNights;
		this.numRooms = numRooms;
		this.totalCost = totalCost;
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

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	
}
