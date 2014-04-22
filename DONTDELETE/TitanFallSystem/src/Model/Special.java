package Model;

public class Special {

	private String specialName;
	private double specialsCost;
	private int speicalID;
	
	public Special(int specialID, String specialName, double specialCost){
		this.speicalID = specialID;
		this.specialName = specialName;
		this.specialsCost = specialCost;
	}

	public int getSpeicalID() {
		return speicalID;
	}

	public void setSpeicalID(int speicalID) {
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
