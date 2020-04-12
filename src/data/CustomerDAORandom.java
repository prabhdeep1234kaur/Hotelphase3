package data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import business.CustomerInfo;

public class CustomerDAORandom implements CustomerDAO {
	private int count;
	private File personFile=null;
	private RandomAccessFile dataFile=null;

	public CustomerDAORandom() {
		personFile=new File(CustomerConstants.FILENAME_BIN_FIXED);	
	}
	
	@Override
	public CustomerInfo getCustomer(String firstName) {
		// TODO Auto-generated method stub
		//int i=Integer.parseInt(firstName);
		String i=firstName;
		
		try {
			dataFile=new RandomAccessFile(personFile,"rw");
			count=(int) (dataFile.length()/CustomerConstants.RECORD_SIZE);
			//if(i<=count) {
				//dataFile.seek((i-1)*CustomerConstants.RECORD_SIZE);
				dataFile.seek((count-1)*CustomerConstants.RECORD_SIZE);
				String firstName1 = readString(dataFile,CustomerConstants.FIRST_NAME_SIZE);
				String lastName1  = readString(dataFile,CustomerConstants.LAST_NAME_SIZE);
				String address    = readString(dataFile,CustomerConstants.ADDRESS_SIZE);
				String phoneno    = readString(dataFile,CustomerConstants.PHONE_NUM_SIZE);
				String city       = readString(dataFile,CustomerConstants.CITY_SIZE);
				String province   = readString(dataFile,CustomerConstants.PROVINCE_SIZE);
				String country    = readString(dataFile,CustomerConstants.COUNTRY_SIZE);
				String zip        = readString(dataFile,CustomerConstants.ZIP_SIZE);
				CustomerInfo customer = new CustomerInfo(firstName1,lastName1,address,phoneno,city,province,country,zip);
				return customer;
			//}
		}catch(FileNotFoundException e) {
			System.out.println("error");
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println("error");
			e.printStackTrace();
		}finally {
			try {
				dataFile.close();
			}catch (IOException e1) {
				System.out.println("error");
				e1.printStackTrace();
			}
		}
		return null;		
	}



	@Override
	public ArrayList<CustomerInfo> getCustomers() {
		// TODO Auto-generated method stub
		ArrayList<CustomerInfo> customers=new ArrayList<CustomerInfo>();
		try {
			dataFile=new RandomAccessFile(personFile,"rw");
			count=(int) (dataFile.length()/CustomerConstants.RECORD_SIZE);
			for(int i=0;i<count;i++) {
				dataFile.seek(i*CustomerConstants.RECORD_SIZE);
				String firstName1 = readString(dataFile,CustomerConstants.FIRST_NAME_SIZE);
				String lastName1  = readString(dataFile,CustomerConstants.LAST_NAME_SIZE);
				String address    = readString(dataFile,CustomerConstants.ADDRESS_SIZE);
				String phoneno    = readString(dataFile,CustomerConstants.PHONE_NUM_SIZE);
				String city       = readString(dataFile,CustomerConstants.CITY_SIZE);
				String province   = readString(dataFile,CustomerConstants.PROVINCE_SIZE);
				String country    = readString(dataFile,CustomerConstants.COUNTRY_SIZE);
				String zip        = readString(dataFile,CustomerConstants.ZIP_SIZE);
				CustomerInfo customer = new CustomerInfo(firstName1,lastName1,address,phoneno,city,province,country,zip);
				customers.add(customer);
				// tests.add(test);
			}
			}catch(FileNotFoundException ex) {
				System.out.println("error");
				ex.printStackTrace();
			}catch(IOException e3) {
				System.out.println("error");
				e3.printStackTrace();	
			}
		finally {
				try {
					dataFile.close();
				}catch (IOException e4) {
					System.out.println("error");
					e4.printStackTrace();
				}
			}
		return customers;
	}

	@Override
	public boolean addCustomer(CustomerInfo customer) {
		// TODO Auto-generated method stub
		boolean success=false;
		try {
			dataFile=new RandomAccessFile(personFile,"rw");
			count=(int)dataFile.length()/CustomerConstants.RECORD_SIZE;
			dataFile.seek(count*CustomerConstants.RECORD_SIZE);
			
			writeString(dataFile,CustomerConstants.FIRST_NAME_SIZE,customer.getfirstName());
			writeString(dataFile,CustomerConstants.LAST_NAME_SIZE,customer.getlastName());
			writeString(dataFile,CustomerConstants.ADDRESS_SIZE,customer.getAddress());
			writeString(dataFile,CustomerConstants.PHONE_NUM_SIZE,customer.getPhoneNumber());
			writeString(dataFile,CustomerConstants.CITY_SIZE,customer.getCity());
			writeString(dataFile,CustomerConstants.PROVINCE_SIZE,customer.getProvince());
			writeString(dataFile,CustomerConstants.COUNTRY_SIZE,customer.getCountry());
			writeString(dataFile,CustomerConstants.ZIP_SIZE,customer.getZip());
			
			success=true;
		}catch(FileNotFoundException e) {
			System.out.println("error");
			e.printStackTrace();
		}catch(IOException e3) {
			System.out.println("error");
			e3.printStackTrace();
		}
		finally {
			try {
				dataFile.close();
			}catch(IOException e4) {
				System.out.println("error");
				e4.printStackTrace();
			}
		}
		return success;
	}
	
	
	private static void writeString(DataOutput out,int length,String s) throws IOException{
		
		for(int i=0;i<length;i++) {
			
			if(i<s.length())
				out.writeChar(s.charAt(i));
			else 
				out.writeChar(0);
		}	
	}
		

	private static String readString(DataInput In,int length) throws IOException{
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<length;i++) {
			char c =In.readChar();
			if(c!=0)
			sb.append(c);			
		}
		return sb.toString();
	}

	
}
