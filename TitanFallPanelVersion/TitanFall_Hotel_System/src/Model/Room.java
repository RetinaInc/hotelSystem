package Model;

public class Room {
	private int roomNumber,typeID;
	private String roomAvailability;
	private String roomType;
	private double price;
	
	public Room(int roomNumber, String roomAvailability,int typeID){
		this.roomNumber = roomNumber;
		this.roomAvailability = roomAvailability;
		this.typeID = typeID;
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

	public String isRoomAvailability() {
		return roomAvailability;
	}

	public void setRoomAvailability(String roomAvailability) {
		this.roomAvailability = roomAvailability;
	}
	
	
}
