package business;

public class Book {
	private String fname;
	private String lname;
	private String roomnum;
	
	public String getFirstName() {
		return fname;
	}
	public void setFirstName(String fname) {
		this.fname = fname;
	}
	
	public String getLastName() {
		return lname;
	}
	public void setLastName(String lname) {
		this.lname = lname;
	}
	public String getRoomNum() {
		return roomnum;
	}
	public void setRoomNum(String roomnum) {
		this.roomnum = roomnum;
	}
	
	public Book(String fname, String lname,String roomnum) {
		this.fname = fname;
		this.lname = lname;
		this.roomnum=roomnum;
	}
}