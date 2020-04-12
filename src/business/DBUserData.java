package business;

public class DBUserData {

	private String userName, passWord;
	private int userType;
	public DBUserData() {};
	public DBUserData(int userType, String userName, String passWord) {
		this.userType = userType;
		this.userName = userName;
		this.passWord = passWord;
	};
	
	public 	int getUserType() {
		return userType;
	}
	
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPassword() {
		return passWord;
	}
	
	public void setUserPassword(String passWord) {
		this.passWord = passWord;
	}
	
}
