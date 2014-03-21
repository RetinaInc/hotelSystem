package Model;

import java.util.ArrayList;

public class Hotel {

	private String hotelID, hotelName, hotelPhoneNumber, hotelAddress;
	private int totalNumberRooms, hotelRating;
	private ArrayList<User> users = new ArrayList();
	
	public Hotel(String id, String name, String phoneNumber, String address, int totalNumberRooms, int hoteRating){
		this.hotelID = id;
		this.hotelName = name;
		this.hotelPhoneNumber = phoneNumber;
		this.hotelAddress = address;
		this.totalNumberRooms = totalNumberRooms;
		this.hotelRating = hoteRating;
	}
	

	
	public void addUsers(User u){
		users.add(u);
	}
	
	public void removeUsers(User u){
		users.remove(u);
	}

	public ArrayList<User> getUsers() {
		return users;
	}
	
	public int getNumUsers()
	{
		return users.size();
	}
	
	public User getUser(int index){
		return users.get(index);
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelPhoneNumber() {
		return hotelPhoneNumber;
	}

	public void setHotelPhoneNumber(String hotelPhoneNumber) {
		this.hotelPhoneNumber = hotelPhoneNumber;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public int getTotalNumberRooms() {
		return totalNumberRooms;
	}

	public void setTotalNumberRooms(int totalNumberRooms) {
		this.totalNumberRooms = totalNumberRooms;
	}

	public int getHotelRating() {
		return hotelRating;
	}

	public void setHotelRating(int hotelRating) {
		this.hotelRating = hotelRating;
	}
	
	
}
