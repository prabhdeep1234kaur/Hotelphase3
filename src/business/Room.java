package business;

public class Room {
	private String roomNum;
	private String roomType;
	private String roomStatus;
	
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	
	
	public Room(String roomNum,String roomType, String roomStatus) {
		this.roomNum = roomNum;
		this.roomType = roomType;
		this.roomStatus = roomStatus;
	}
}
