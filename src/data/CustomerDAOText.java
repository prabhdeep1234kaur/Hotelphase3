package data;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


import business.CustomerInfo;

public class CustomerDAOText implements CustomerDAO {
	
private File customerFile = null;
	
	//Constructor 
	public CustomerDAOText() {
		customerFile = new File(CustomerConstants.FILENAME_TEXT);
	}
	// check if the file is exist
	private void checkFile() throws IOException{
		if (!customerFile.exists()) {
			customerFile.createNewFile();
		}
	}
	
	//
	//@SuppressWarnings("resource")
	private boolean saveCustomers(ArrayList<CustomerInfo> customers) {
		PrintWriter out = null;
		try {
			this.checkFile();
			// Print Tests
			out = new PrintWriter(new BufferedWriter(new FileWriter(customerFile)),true);
		
			for (CustomerInfo c : customers) {
				out.print(c.getfirstName() + FIELD_SEP);
				out.print(c.getlastName() + FIELD_SEP);
				out.print(c.getPhoneNumber() + FIELD_SEP);
				out.print(c.getAddress() + FIELD_SEP);
				out.print(c.getCity() + FIELD_SEP);
				out.print(c.getProvince() + FIELD_SEP);
				out.print(c.getCountry() + FIELD_SEP);
				out.println(c.getZip());	
			}
		} catch (IOException ioe) { 
			ioe.printStackTrace();
			return false;
		} finally {
			this.close(out);
		}
		return true;
	}
	// method to close the file
	private void close(Closeable stream) {
		try {
			if (stream != null) {
				stream.close();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	
	
	@Override
	public CustomerInfo getCustomer(String firstName) {
		// TODO Auto-generated method stub
		ArrayList<CustomerInfo> customers = this.getCustomers();
		for (CustomerInfo t : customers) {
			if (t.getfirstName().equalsIgnoreCase(firstName)) {
				return t;
			}
		}
		return null;
	}
	@Override
	public ArrayList<CustomerInfo> getCustomers() {
		// TODO Auto-generated method stub
		BufferedReader in = null;
		
		try {
			this.checkFile();
			in = new BufferedReader(new FileReader(customerFile));
			ArrayList<CustomerInfo> customers = new ArrayList<CustomerInfo>();
			String line = in.readLine();
			while (line != null) {
				String[] columns = line.split(FIELD_SEP);
				String firstName = columns[0];
				String lastName = columns[1];
				String phoneNumber =columns[2];
				String address=  columns[3];
				String city =  columns[4];				
				String province = columns[5];
				String country =  columns[6];
				String zip =  columns[7];
				//create customer Object
				CustomerInfo c = new CustomerInfo(firstName,lastName,phoneNumber,country,province,city,zip,address);
				customers.add(c);
				line = in.readLine();
			}
			return customers;
		} catch (Exception e) {
			System.err.println("There is an error during reading data of customers");
			return null;
		} finally {
			this.close(in);
		}
	}

	@Override
	public boolean addCustomer(CustomerInfo customer) {
		// TODO Auto-generated method stub
		
		ArrayList<CustomerInfo> customers = this.getCustomers();
		customers.add(customer);
		return this.saveCustomers(customers);
	}
}


