package business;

public class Book {
	private String name;
	private String roomnum;
	private String roomtype;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoomNum() {
		return roomnum;
	}
	public void setRoomNum(String roomnum) {
		this.roomnum = roomnum;
	}
	public String getRoomType() {
		return roomtype;
	}
	public void setRoomType(String roomtype) {
		this.roomtype = roomtype;
	}
	
	public Book(String name,String roomnum,String roomtype) {
		this.name = name;
		this.roomnum=roomnum;
		this.roomtype=roomtype;
	}
}