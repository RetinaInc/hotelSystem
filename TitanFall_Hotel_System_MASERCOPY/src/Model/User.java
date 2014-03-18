package Model;

public class User {

	private String userType,fName,lName,homeaddress,email,phoneNum,userID,password;

	public User(String fName, String lName,String homeaddress,
			String email, String phoneNum, String userID, String password) {
		
		this.fName = fName;
		this.lName = lName;
		this.homeaddress = homeaddress;
		this.phoneNum = phoneNum;
		this.email = email;
		this.userID = userID;
		this.password = password;
	}

	public String getHomeaddress() {
		return homeaddress;
	}


	public String getUserID() {
		return userID;
	}

	public String getUserType() {
		return userType;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	
}
