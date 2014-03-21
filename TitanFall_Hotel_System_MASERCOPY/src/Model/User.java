package Model;

public class User {

	private String userType,fName,lName,homeaddress,email,phoneNum,userID,password;

	public User(String userID,String userType,String fName, String lName,String homeaddress,
			String phoneNum,String email, String password) {
		this.userID = userID;
		this.userType = userType;
		this.fName = fName;
		this.lName = lName;
		this.homeaddress = homeaddress;
		this.email = email;
		this.phoneNum = phoneNum;
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
