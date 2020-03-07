package data;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import business.CustomerInfo;

public class CustomerDAOBinary implements CustomerDAO {
	private File customerFile = null;

	public CustomerDAOBinary() {
		customerFile = new File(CustomerConstants.FILENAME_BIN);
	}
	private void checkFile() throws IOException{
		if (!customerFile.exists()) {
			customerFile.createNewFile();
		}
	}
//	@SuppressWarnings("resource")
	private boolean saveCustomer(ArrayList<CustomerInfo> customers) {
		DataOutputStream out = null;
		try {
			this.checkFile();
			out = new DataOutputStream(new FileOutputStream(customerFile,true));
			for (CustomerInfo c : customers) {
				out.writeUTF(c.getfirstName());
				out.writeUTF(c.getlastName());
				out.writeUTF(c.getPhoneNumber());
				out.writeUTF(c.getCountry());
				out.writeUTF(c.getProvince());
				out.writeUTF(c.getCity());
				out.writeUTF(c.getZip());
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return false;
		}finally {
			this.close(out);
		}
		return true;
	}
	
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
		for (CustomerInfo c : customers) {
			if (c.getfirstName().equalsIgnoreCase(firstName)) {
				return c;
			}
		}
		return null;
	}

	@Override
	public ArrayList<CustomerInfo> getCustomers() {
		// TODO Auto-generated method stub

		DataInputStream in = null;
		ArrayList<CustomerInfo> customers = new ArrayList<CustomerInfo>();
		try {
			this.checkFile();
			in = new DataInputStream(new FileInputStream(customerFile));
			while (in.available() > 0) {
				String firstName = in.readUTF();
				String lastName=in.readUTF();
				String country=in.readUTF();
				String province=in.readUTF();
				String city=in.readUTF();			
				String zip=in.readUTF();			
				String address=in.readUTF();		
				String phoneno=in.readUTF();
				CustomerInfo c = new CustomerInfo(firstName,lastName,phoneno,country,province,city,zip,address);
				customers.add(c);
			}
		} catch (EOFException eofe) {
			this.close(in);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return customers;
	}
	@Override
	public boolean addCustomer(CustomerInfo customer) {
		// TODO Auto-generated method stub

		ArrayList<CustomerInfo> customers = this.getCustomers();
		customers.add(customer);
		return this.saveCustomer(customers);
	}
}