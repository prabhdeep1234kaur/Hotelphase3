package data;

import java.io.*;
import java.util.ArrayList;

import business.Room;
public class RoomDAORandom implements RoomDAO {
	private int count;
	private File testFile = null;
	private RandomAccessFile dataFile = null;
	
	public RoomDAORandom() {
		testFile = new File(RoomConstants.FILENAME_BIN_FIXED);
	}
	
	public Room getRoom(String roomType) {
		int i = Integer.parseInt(roomType);
		try {
			dataFile = new RandomAccessFile(testFile,"rw");
			// Find Number of Records in a File
			count = (int)dataFile.length()/RoomConstants.RECORD_SIZE;
			if(i<=count){
				dataFile.seek((i-1) * RoomConstants.RECORD_SIZE);
				
				String roomnum = (readString(dataFile,RoomConstants.ROOM_NUMBERE_SIZE));
				String roomtype = (readString(dataFile,RoomConstants.ROOM_TYPE_SIZE));
				String roomstatus = (readString(dataFile,RoomConstants.ROOM_STATUS_SIZE));
				Room t = new Room(roomnum,roomtype,roomstatus);
				return t;
			}
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				
				dataFile.close();
				}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
			}
			return null;
	}
	
	public ArrayList<Room> getRooms() {
		ArrayList<Room> rooms = new ArrayList<Room>();
		try {
			dataFile = new RandomAccessFile(testFile,"rw");
			
			// Find Number of Records in a File
			count = (int)dataFile.length()/RoomConstants.RECORD_SIZE;
			for(int i = 0; i <count; i++)
				{
				dataFile.seek(i * RoomConstants.RECORD_SIZE);
				dataFile.seek((i-1) * RoomConstants.RECORD_SIZE);
				
				String roomnum = (readString(dataFile,RoomConstants.ROOM_NUMBERE_SIZE));
				String roomtype = (readString(dataFile,RoomConstants.ROOM_TYPE_SIZE));
				String roomstatus = (readString(dataFile,RoomConstants.ROOM_STATUS_SIZE));
				Room t = new Room(roomnum,roomtype,roomstatus);
				rooms.add(t);
			}
		} catch (FileNotFoundException e) {
			System.err.println("ROOM NOT FOUND ------");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		finally{
		try {
		
			dataFile.close();
			}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		}

	return rooms;

	}
	
	public boolean addRoom(Room room) {
		boolean success = false;
		try {
			dataFile = new RandomAccessFile(testFile, "rw");
			count = (int) dataFile.length() / RoomConstants.RECORD_SIZE;
			dataFile.seek(count * RoomConstants.RECORD_SIZE);
			writeString(dataFile, RoomConstants.ROOM_NUMBERE_SIZE, room.getRoomNum());
			writeString(dataFile, RoomConstants.ROOM_TYPE_SIZE, room.getRoomType());
			writeString(dataFile, RoomConstants.ROOM_STATUS_SIZE, room.getRoomStatus());
			//dataFile.writeString(room.getRoomNum());
			success = true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dataFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return success;
	}
	
	private static void writeString(DataOutput out, int length, String s) throws IOException {
		for (int i = 0; i < length; i++) {
			if (i < s.length())
				out.writeChar(s.charAt(i));
			else
				out.writeChar(0);// write unicode 0
		}
	}
	
	private static String readString(DataInput in, int length) throws IOException {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			char c = in.readChar();
			// If char is not unicode zero add to String
			if (c != 0)
				sb.append(c);
		}
		return sb.toString();

	}

	@Override
	public ArrayList<Room> getRoom() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
