package Model;

public class Special {

	private String speicalID,specialName;
	private double specialsCost;
	
	public Special(String specialID, String specialName, double specialCost){
		this.speicalID = specialID;
		this.specialName = specialName;
		this.specialsCost = specialCost;
	}

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
