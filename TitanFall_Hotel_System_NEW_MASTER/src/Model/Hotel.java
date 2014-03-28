package Model;

import java.util.ArrayList;

import Database.CreateTables;

public class Hotel {

	private String hotelName, hotelPhoneNumber, hotelAddress;
	private int hotelID, totalNumberRooms, hotelRating; // Need to change hotelID to an integer to correspond with the ERD and class diagram
	private ArrayList<User> users = new ArrayList();
	
	public Hotel(int id, String name, String phoneNumber, String address, int totalNumberRooms, int hoteRating){
		this.hotelID = id;
		this.hotelName = name;
		this.hotelPhoneNumber = phoneNumber;
		this.hotelAddress = address;
		this.totalNumberRooms = totalNumberRooms;
		this.hotelRating = hoteRating;
	}
	
	public void updateUsersDetails(String id,String fname,String lname,String address,String email,String phone){
		
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserID().equals(id))
			{
				users.get(i).setfName(fname);
				users.get(i).setlName(lname);
				users.get(i).setHomeAddress(address);
				users.get(i).setEmail(email);
				users.get(i).setPhoneNum(phone);
			}
				
		}
		CreateTables c = new CreateTables();
		c.updateDeatils(id, fname, lname, address, email, phone);
	}
	
	public void updateUsersPassword(String id,String password){
		
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserID().equals(id))
			{
				users.get(i).setPassword(password);
			}
				
		}
		CreateTables c = new CreateTables();
		c.updatePassword(id, password);
		
	}
	
	public User getUser(String userid)
	{
		User u = null;
		
		for(int i = 0; i < users.size(); i++){
			if(users.get(i).getUserID().equals(userid)){
				u = users.get(i);
			}
		}
		
		return u;
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

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
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
