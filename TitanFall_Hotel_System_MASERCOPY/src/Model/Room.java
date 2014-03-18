package Model;

public class Room {
	private int roomNumber;
	private boolean roomAvailability;
	
	public Room(int roomNumber, boolean roomAvailability){
		this.roomNumber = roomNumber;
		this.roomAvailability = roomAvailability;
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
