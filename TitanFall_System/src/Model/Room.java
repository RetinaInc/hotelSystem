package Model;

public class Room {
	private int roomNumber;
	private boolean roomAvailability;
	private String roomType;
	private double price;
	
	public Room(int roomNumber, boolean roomAvailability){
		this.roomNumber = roomNumber;
		this.roomAvailability = roomAvailability;
	}
	public Room(int roomNumber, String roomType , double price){
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.price = price;
	}

	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public boolean isRoomAvailability() {
		return roomAvailability;
	}

	public void setRoomAvailability(boolean roomAvailability) {
		this.roomAvailability = roomAvailability;
	}
	
	
}
