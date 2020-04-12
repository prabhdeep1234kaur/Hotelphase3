package data;

import java.util.ArrayList;

public interface RoomReader {
	business.Room getRoom(String testName);
	ArrayList<business.Room> getRoom();
}
