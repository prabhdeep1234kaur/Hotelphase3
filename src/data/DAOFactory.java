package data;

public class DAOFactory {
	public static RoomDAO getRoomDAO() {
		RoomDAO roomDAO = new RoomDAORandom();
		return roomDAO;
	}
}
