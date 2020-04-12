package data;

public interface BookConstants {
	String FILENAME_TEXT = "book.txt";
	String FILENAME_BIN = "book.data";
	String FILENAME_BIN_FIXED = "bookFixed.dat";
	String FIELD_SEP = "\t";
	int NAME_SIZE = 20;
	int ROOM_NUMBER_SIZE = 3;
	int ROOM_TYPE_SIZE = 15;
	int RECORD_SIZE = ROOM_NUMBER_SIZE *2 + NAME_SIZE*2 + ROOM_TYPE_SIZE*2;
}