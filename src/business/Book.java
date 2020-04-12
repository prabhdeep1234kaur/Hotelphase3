package business;

public class Book {
	private String fname;
	private String lname;
	private String roomtype;
	
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
	public String getRoomType() {
		return roomtype;
	}
	public void setRoomType(String roomtype) {
		this.roomtype = roomtype;
	}
	
	public Book(String fname, String lname,String roomtype) {
		this.fname = fname;
		this.lname = lname;
		this.roomtype=roomtype;
	}
}
