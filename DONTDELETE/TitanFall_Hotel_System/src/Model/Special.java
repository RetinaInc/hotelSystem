package Model;

public class Special {
	
	// Instance variables
	private String speicalID,specialName;
	private double specialsCost;
	
	// Special constructor
	public Special(String specialID, String specialName, double specialCost){
		this.speicalID = specialID;
		this.specialName = specialName;
		this.specialsCost = specialCost;
	}

	// Getters and Setters
	public String getSpeicalID() {
		return speicalID;
	}

	public void setSpeicalID(String speicalID) {
		this.speicalID = speicalID;
	}

	public String getSpecialName() {
		return specialName;
	}

	public void setSpecialName(String specialName) {
		this.specialName = specialName;
	}

	public double getSpecialsCost() {
		return specialsCost;
	}

	public void setSpecialsCost(double specialsCost) {
		this.specialsCost = specialsCost;
	}
	
	
}
