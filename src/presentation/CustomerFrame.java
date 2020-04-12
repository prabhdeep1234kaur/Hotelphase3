package presentation;
	

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import business.CustomerInfo;


import javax.swing.*;


import data.DAOFactoryC;
import data.DBCustomer;
import data.DBMain;
//import presentation.Customers.DisplayButtonHandler;
//import presentation.Customers.FindButtonHandler;
import data.CustomerDAO;

public class CustomerFrame extends JFrame{

	private JLabel cidname,fname,lname,address,phone,membership,lcity,lpro,lpincode,lc;
	private JTextField tCidname,tFname,tLname,tAddress,tPhone,tcity,tPro,tpincode,tc;
	private JButton add,del;
	private JComboBox membershipSatus;
	//private JPanel CustomerPanel;
	private JTable table;
	private JPanel guestPanel;
	private JPanel displayPanel;
	private JTable testTable;
	JLabel background;
	private CustomerDAO cDao = DAOFactoryC.getCutstomerDAO();

	private static JTable customerTable;
	private DBCustomer db=null;
	ResultSet result;
	private JButton btnDisplayDB;
	public CustomerFrame() {
		
		/*background*/
		ImageIcon bg_img = new ImageIcon("images/images.jpg");
		//image resize
		Image img = bg_img.getImage();
		Image temp_img = img.getScaledInstance(1200, 1200, Image.SCALE_SMOOTH);
		bg_img = new ImageIcon(temp_img);
		 background = new JLabel("",bg_img,JLabel.CENTER);
		background.setBackground(new Color(0, 128, 0));
		background.setBounds(0,10,974,705);
		
		//declare panel
		guestPanel = new JPanel();
		guestPanel.setSize(1000,1500);
		guestPanel.setBackground(new Color(0,0,0,60));
		//guestPanel.setBounds(566,50,400,350);
	
		//form info
		//customer id
		cidname = new JLabel("Customer ID");
		cidname.setBounds(20,10,100,20);
		cidname.setOpaque(true);
		cidname.setBackground(Color.white);
		background.add(cidname);
		
		tCidname = new JTextField();
		tCidname.setBounds(130,10,190,25);
		tCidname.setEditable(false);
		background.add(tCidname);
		//first
		fname = new JLabel("FIRST NAME");
		fname.setBounds(20,50,100,20);
		fname.setOpaque(true);
		fname.setBackground(Color.white);
		background.add(fname);
		
		tFname = new JTextField();
		tFname.setBounds(130,50,190,25);
		background.add(tFname);

		//last
		lname = new JLabel("LAST NAME");
		lname.setBounds(20,100,100,20);
		lname.setOpaque(true);
		lname.setBackground(Color.white);
		background.add(lname);

		tLname = new JTextField();
		tLname.setBounds(130,100,190,25);
		background.add(tLname);

		
		//phone
		phone = new JLabel("PHONE NUMBER");
		phone.setBounds(20,150,100,20);
		phone.setOpaque(true);
		phone.setBackground(Color.white);
		background.add(phone);

		tPhone = new JTextField();
		tPhone.setBounds(130,150,190,25);
		background.add(tPhone);

		
		//address
		address = new JLabel("ADDRESS");
		address.setBounds(20,200,100,20);
		address.setOpaque(true);
		address.setBackground(Color.white);
		background.add(address);

		tAddress = new JTextField();
		tAddress.setBounds(130,200,190,40);
		background.add(tAddress);
		
		//city
		lcity = new JLabel("CITY");
		lcity.setBounds(20,250,100,20);
		lcity.setOpaque(true);
		lcity.setBackground(Color.white);
		background.add(lcity);

		tcity = new JTextField();
		tcity.setBounds(130,250,190,25);
		background.add(tcity);
		
		//country
		lc = new JLabel("COUNTRY");
		lc.setBounds(20,400,100,20);
		lc.setOpaque(true);
		lc.setBackground(Color.white);
		background.add(lc);

		tc = new JTextField();
		tc.setBounds(130,400,190,25);
		background.add(tc);
		
		//pro
		lpro = new JLabel("PROVINCE");
		lpro.setBounds(20,300,100,20);
		lpro.setOpaque(true);
		lpro.setBackground(Color.white);
		background.add(lpro);

		tPro = new JTextField();
		tPro.setBounds(130,300,50,25);
		background.add(tPro);
		
		//pincode
		lpincode = new JLabel("PINCODE");
		lpincode.setBounds(20,350,100,20);
		lpincode.setOpaque(true);
		lpincode.setBackground(Color.white);
		background.add(lpincode);

		tpincode = new JTextField();
		tpincode.setBounds(130,350,80,25);
		background.add(tpincode);
		
		//buttons
		add = new JButton("ADD");
		add.setBounds(40,450,100,40);
		add.setBackground(Color.green);
		background.add(add);

		JButton btnFindButton = new JButton("FIND");
		btnFindButton.setBounds(160,450,100,40);
		btnFindButton.setBackground(Color.cyan);
		background.add(btnFindButton);
		
		
		
		JButton btnDisplay = new JButton("Display File");
		btnDisplay.setBounds(160,500,100,40);
		btnDisplay.setBackground(Color.yellow);
		background.add(btnDisplay);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(40,500,100,40);
		btnRefresh.setBackground(Color.orange);
		background.add(btnRefresh);
		getContentPane().setLayout(null);
		
		//table new
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(386, 35, 588, 251);
		getContentPane().add(scrollPane);
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] {"LAST NAME","FIRST NAME","ADDRESS","PHONE NUMBER","CITY","COUNTRY","province","PINCODE" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(102);
		table.getColumnModel().getColumn(1).setPreferredWidth(103);
		table.getColumnModel().getColumn(2).setPreferredWidth(94);
		table.getColumnModel().getColumn(3).setPreferredWidth(104);
		table.getColumnModel().getColumn(4).setPreferredWidth(84);
		JTableHeader head = table.getTableHeader();
		head.setFont(new Font("Times New Roman", Font.BOLD, 16));

		// testTable.setModel(model);
		table.setBackground(Color.white);
		table.setForeground(Color.black);
		Font font = new Font("", 1, 16);
		table.setFont(font);
		table.setRowHeight(25);
		
		//panel
		getContentPane().add(background);
		
		btnDisplayDB = new JButton("Display DB");
		btnDisplayDB.setBounds(290, 500,100,40);
		btnDisplayDB.setBackground(Color.orange);
		getContentPane().add(btnDisplayDB);
		setVisible(true);
		
		del = new JButton("DELETE");
		del.setBounds(350,500,100,40);
		del.setBackground(Color.red);
		background.add(del);
		
		//buttons listeners
		add.addActionListener(new SaveButtonHandler());
		btnFindButton.addActionListener(new FindButtonHandler());
		btnDisplay.addActionListener(new DisplayButtonHandler());
		btnDisplayDB.addActionListener(new DisplayDBButtonHandler());
		del.addActionListener(new DeleteButtonHandler());
		btnRefresh.addActionListener(new RefreshButtonHandler());
	}
	
	//save button event
	private class SaveButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (!isValidData())
				return;
			String firstName = tFname.getText();
			String lastName = tLname.getText();
			String phoneno = tPhone.getText();
			String country = tc.getText();
			String province = tPro.getText();
			String city = tcity.getText();
			String zip = tpincode.getText();
			String address = tAddress.getText();
			CustomerInfo cus = new CustomerInfo(firstName,lastName,address,phoneno,city,province,country,zip);
			
			if (cDao.addCustomer(cus)) {
				String result = "First Name: " + firstName + "\n last Name: " + lastName + "\n";
				JOptionPane.showMessageDialog(null, result, "Info Save", JOptionPane.INFORMATION_MESSAGE);
				try {
					db = new DBCustomer();
					db.insertCustomer(cus);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			} else {
				JOptionPane.showMessageDialog(null, "Not Saved!", "Info Save", JOptionPane.WARNING_MESSAGE);
			}
			
			//emptying the form
			tFname.setText("");
			tLname.setText("");
			tPhone.setText("");
			tAddress.setText("");
			tc.setText("");
			tcity.setText("");
			tPro.setText("");
			tpincode.setText("");
		}
		
		public boolean isValidData() {
			if(!Validator.isPresent(tFname,"Customer first name")) return false;
			if(!Validator.isPresent(tLname,"Customer last name")) return false;
			if(!Validator.isPresent(tPhone,"Phone number")) return false;
			if(!Validator.isInteger(tPhone,"Phone number")) return false;
			if(!Validator.isPresent(tAddress,"tAddress")) return false;
			if(!Validator.isPresent(tcity,"City")) return false;
			if(!Validator.isPresent(tPro,"Province")) return false;
			if(!Validator.isPresent(tpincode,"Pincode ")) return false;
			if(!Validator.isPresent(tc,"Country")) return false;
			return true;
		}
	}
	//find
	private class FindButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			String search = JOptionPane.showInputDialog(null, "ENTER LAST NAME", "CUSTOMER SEARCH",JOptionPane.QUESTION_MESSAGE);
			tFname.setText(search);
			String targetName = tFname.getText();
			try {
				db=new DBCustomer();
			} catch (ClassNotFoundException | SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				result = db.SeachCustomer(targetName);
				
					while(result.next()) {
						int customerid = result.getInt("customer_id");
						tFname.setText(result.getString("first_name"));
						tLname.setText(result.getString("last_name"));
						tPhone.setText(result.getString("phone_num"));
						tAddress.setText(result.getString("address"));
						tcity.setText(result.getString("city"));
						tPro.setText(result.getString("province"));
						tpincode.setText(result.getString("code"));
						tc.setText(result.getString("country"));
						tCidname.setText(String.valueOf(customerid));
					}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"hereherre "+e1.toString());
			}
		}
	}
	
	//display list from file
	private class DisplayButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			table.setModel(new DefaultTableModel(new Object[][] {},
					new String[] {"LAST NAME","FIRST NAME","ADDRESS","PHONE NUMBER","CITY","COUNTRY","province","PINCODE"}));
		//	 DefaultTableModel model = (DefaultTableModel) testTable.getModel();
			java.util.ArrayList<business.CustomerInfo> customers = cDao.getCustomers();

			for (business.CustomerInfo ct : customers) {

				AddRowToTable(new Object[] { ct.getlastName(),ct.getfirstName(),ct.getAddress(),ct.getPhoneNumber(),ct.getCity(),ct.getCountry(),ct.getProvince(),ct.getZip() });
			}
		}
	}
	
	private class DisplayDBButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				db=new DBCustomer();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			result = db.getAllCustomer();
			
			try {
				if(result.isBeforeFirst()) {
					 int i=0;
					 ArrayList<Object[]> data = new ArrayList<Object[]>();
					 while (result.next()) {
						 Object[] row = new Object[]{
							 
							 result.getString("last_name"),
							 result.getString("first_name"),
							 result.getString("address"),
							 result.getString("phone_num"),
							 result.getString("city"),
							 result.getString("country"),
							 result.getString("province"),
							 result.getString("code"),
							 };
						 data.add(row);
					 }
					 table.setModel(new DefaultTableModel(
						data.toArray(new Object[data.size()][]),
		                new String[] {"LAST NAME","FIRST NAME","ADDRESS","PHONE NUMBER","CITY","COUNTRY","province","PINCODE"}
		              ));
					 
				}else {
					JOptionPane.showMessageDialog(null, "No Users Found. You can add new users. ");
				}					
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	//delete user
	private class DeleteButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			String search = JOptionPane.showInputDialog(null, "ENTER LAST NAME", "DELETE CUSTOMER",JOptionPane.QUESTION_MESSAGE);
			tFname.setText(search);
			String targetName = tFname.getText();
			
			try {
				db=new DBCustomer();
			} catch (ClassNotFoundException | SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				result = db.deleteCustomer(targetName);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			result = db.getAllCustomer();
			
			try {
				if(result.isBeforeFirst()) {
					 int i=0;
					 ArrayList<Object[]> data = new ArrayList<Object[]>();
					 while (result.next()) {
						 Object[] row = new Object[]{
							 
							 result.getString("last_name"),
							 result.getString("first_name"),
							 result.getString("address"),
							 result.getString("phone_num"),
							 result.getString("city"),
							 result.getString("country"),
							 result.getString("province"),
							 result.getString("code"),
							 };
						 data.add(row);
					 }
					 table.setModel(new DefaultTableModel(
						data.toArray(new Object[data.size()][]),
		                new String[] {"LAST NAME","FIRST NAME","ADDRESS","PHONE NUMBER","CITY","COUNTRY","province","PINCODE"}
		              ));
					 
				}else {
					JOptionPane.showMessageDialog(null, "No Users Found. You can add new users. ");
				}	
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "error. ");
			}
		}
	}
	
	
	private class RefreshButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,"Form Refreshed");
			tFname.setText("");
			tLname.setText("");
			tPhone.setText("");
			tAddress.setText("");
			tc.setText("");
			tcity.setText("");
			tPro.setText("");
			tpincode.setText("");
		}
	}
	//main
	public static void main(String args[]) {
		CustomerFrame frame = new CustomerFrame();
		frame.setTitle("CUSTOMER DATABASE");frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,700);
	}
	
	//row for the table
	public void AddRowToTable(Object[] datarow) {
		DefaultTableModel model1 = (DefaultTableModel) table.getModel();
		model1.addRow(datarow);
	}

	public void RemoveRowToTable() {
		// int i=Integer.parseInt((String) object);
		DefaultTableModel model1 = (DefaultTableModel) table.getModel();
		int i = table.getSelectedRow();
		if (i >= 0)
			model1.removeRow(i);
		else
			JOptionPane.showMessageDialog(null, "no row");

	}
}