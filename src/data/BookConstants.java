package data;

public interface BookConstants {
	String FILENAME_TEXT = "book.txt";
	String FILENAME_BIN = "book.data";
	String FILENAME_BIN_FIXED = "bookFixed.dat";
	String FIELD_SEP = "\t";
	int FIRST_NAME_SIZE = 10;
	int LAST_NAME_SIZE = 10;
	int ROOM_NUMBER_SIZE = 3;
	int RECORD_SIZE = ROOM_NUMBER_SIZE *2 + FIRST_NAME_SIZE*2 + LAST_NAME_SIZE*2;
}