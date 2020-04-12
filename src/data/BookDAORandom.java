package data;

import java.io.*;
import java.util.ArrayList;

import business.Book;

public class BookDAORandom implements BookDAO{
	private int count;
	private File testFile = null;
	private RandomAccessFile dataFile = null;
	
	public BookDAORandom() {
		testFile = new File(BookConstants.FILENAME_BIN_FIXED);
	}
	
	public Book getBook(String firstName) {
		int i = Integer.parseInt(firstName);
		try {
			dataFile = new RandomAccessFile(testFile,"rw");
			// Find Number of Records in a File
			count = (int)dataFile.length()/BookConstants.RECORD_SIZE;
			if(i<=count){
				dataFile.seek((i-1) * BookConstants.RECORD_SIZE);
				
				String roomtype = (readString(dataFile,BookConstants.ROOM_NUMBER_SIZE));
				String roomnum = (readString(dataFile,BookConstants.ROOM_TYPE_SIZE));
				String fName = (readString(dataFile,BookConstants.NAME_SIZE));
				
				Book t = new Book(roomtype,roomnum,fName); 
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
	
	public ArrayList<Book> getBooks() {
		ArrayList<Book> books = new ArrayList<Book>();
		try {
			dataFile = new RandomAccessFile(testFile,"rw");
			
			// Find Number of Records in a File
			count = (int)(dataFile.length()/BookConstants.RECORD_SIZE);
			for(int i = 0; i <count; i++){
				dataFile.seek(i * BookConstants.RECORD_SIZE);
				String roomtype = (readString(dataFile,BookConstants.ROOM_NUMBER_SIZE));
				String roomnum = (readString(dataFile,BookConstants.ROOM_TYPE_SIZE));
				String fName = (readString(dataFile,BookConstants.NAME_SIZE));
				Book t = new Book(roomtype,roomnum,fName);
				books.add(t);
			}
		}catch (FileNotFoundException e) {
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

	return books;

	}
	public boolean addBook(Book book) {
		boolean success = false;
		try {
			dataFile = new RandomAccessFile(testFile, "rw");
			count = (int) dataFile.length() / BookConstants.RECORD_SIZE;
			dataFile.seek(count * BookConstants.RECORD_SIZE);
			writeString(dataFile, BookConstants.ROOM_NUMBER_SIZE, book.getRoomNum());
			writeString(dataFile, BookConstants.ROOM_TYPE_SIZE, book.getRoomType());
			writeString(dataFile, BookConstants.NAME_SIZE, book.getName());
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
}