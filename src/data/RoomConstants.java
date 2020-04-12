package data;

public interface RoomConstants {
	String FILENAME_TEXT = "room.txt";
	String FILENAME_BIN = "room.data";
	String FILENAME_BIN_FIXED = "roomFixed.dat";
	String FIELD_SEP = "\t";
	int ROOM_TYPE_SIZE = 25;
	int ROOM_NUMBERE_SIZE = 8;
	int ROOM_STATUS_SIZE = 25;
	int RECORD_SIZE = ROOM_NUMBERE_SIZE *2 +ROOM_TYPE_SIZE*2+ROOM_STATUS_SIZE *2;
}
