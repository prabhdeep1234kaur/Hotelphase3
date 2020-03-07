package presentation;
	

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import business.CustomerInfo;


import javax.swing.*;


import data.DAOFactoryC;
//import presentation.Customers.DisplayButtonHandler;
//import presentation.Customers.FindButtonHandler;
import data.CustomerDAO;

public class CustomerFrame extends JFrame{

	private JLabel fname,lname,address,phone,membership,lcity,lpro,lpincode,lc;
	private JTextField tFname,tLname,tAddress,tPhone,tcity,tPro,tpincode,tc;
	private JButton add,del;
	private JComboBox membershipSatus;
	//private JPanel CustomerPanel;
	private JTable table;

	private CustomerDAO cDao = DAOFactoryC.getCutstomerDAO();

	private static JTable customerTable;
	
	public CustomerFrame() {
		
		/*background*/
		ImageIcon bg_img = new ImageIcon("images/images.jpg");
		//image resize
		Image img = bg_img.getImage();
		Image temp_img = img.getScaledInstance(1200, 1200, Image.SCALE_SMOOTH);
		bg_img = new ImageIcon(temp_img);
		JLabel background = new JLabel("",bg_img,JLabel.CENTER);
		background.setBackground(new Color(0, 128, 0));
		background.setBounds(0,0,900,600);
		
		//declare panel
		JPanel guestPanel = new JPanel();
		guestPanel.setSize(400,350);
		guestPanel.setBackground(new Color(0,0,0,60));
		guestPanel.setBounds(566,50,400,350);
		
		
		//form info
		
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
		
		add = new JButton("ADD");
		add.setBounds(150,450,100,40);
		add.setBackground(Color.green);
		background.add(add);

		del = new JButton("DELETE");
		del.setBounds(150,500,100,40);
		del.setBackground(Color.red);
		background.add(del);
		
		/*find and display*/
		
		JButton btnFindButton = new JButton("FIND BY FIRST NAME");
		btnFindButton.setBounds(150,550,100,40);
		btnFindButton.setBackground(Color.red);
		background.add(btnFindButton);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.setBounds(150,600,100,40);
		btnDisplay.setBackground(Color.red);
		background.add(btnDisplay);
		
		
		//adding table
		guestPanel.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "CUSTOMER TABLE", TitledBorder.CENTER, TitledBorder.TOP));
		Object[][] data = {
			    {"Kohli", "Gunveen", "12 Banda Square",123456789 , "Gold"},
			    {"Kaur", "Prabhdeep", "Malton",987654321,"Platinum"}
			};
	    String[] header = {"LAST NAME","FIRST NAME","ADDRESS","PHONE NUMBER", "MEMBERSHIP STATUS"};
	    
	    JTable table = new JTable(data, header);
	    JTableHeader headers = table.getTableHeader();	
	    table.setRowHeight(25);
	    
	    guestPanel.add(headers,BorderLayout.NORTH);
	    guestPanel.add(table);
	    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
	    rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
	    table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);

	    //adding panel to the main background
	    background.add(guestPanel);
	    getContentPane().add(background);
		setVisible(true);
		
		
		
		add.addActionListener(new SaveButtonHandler());
		btnFindButton.addActionListener(new FindButtonHandler());
		//btnDisplay.addActionListener(new DisplayButtonHandler());
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
			CustomerInfo cus = new CustomerInfo(firstName,lastName,phoneno,address,country,city,province,zip);
			
			if (cDao.addCustomer(cus)) {
				String result = "First Name: " + firstName + "\n last Name: " + lastName + "\n";
				JOptionPane.showMessageDialog(null, result, "Info Save", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Not Saved!", "Info Save", JOptionPane.WARNING_MESSAGE);
			}
			
		}
		
		public boolean isValidData() {
			if(!Validator.isPresent(tFname,"Customer first name")) return false;
			if(!Validator.isPresent(tLname,"Customer last name")) return false;
			if(!Validator.isPresent(tPhone,"Phone number")) return false;
			//if(!Validator.isInteger(tPhone,"Phone number")) return false;
			if(!Validator.isPresent(tcity,"City")) return false;
			if(!Validator.isPresent(tc,"Country")) return false;
			if(!Validator.isPresent(tPro,"Province")) return false;
			if(!Validator.isPresent(tpincode,"Pincode ")) return false;
			if(!Validator.isPresent(tAddress,"tAddress")) return false;
			return true;
		}
	
	}
	//find and display
	private class FindButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			String search = JOptionPane.showInputDialog(null, "ENTER CUSTOMER NAME", "CUSTOMER SEARCH",JOptionPane.QUESTION_MESSAGE);
			tFname.setText(search);
			String targetName = tFname.getText();
			System.out.println(targetName);
			business.CustomerInfo customer = cDao.getCustomer(targetName);				
			if (customer != null) {
					tFname.setText(customer.getfirstName());
					tLname.setText(customer.getlastName());
					//tPhone.setText(customer.getPhoneNumber());
				tAddress.setText(customer.getAddress());
				tc.setText(customer.getCity());
				tPro.setText(customer.getProvince());
				tcity.setText(customer.getCity());
				tpincode.setText(customer.getZip());
			} else {
				JOptionPane.showMessageDialog(null,"CUSTOMER DOESNOT EXIST");
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
	}
	
	
	//main
	public static void main(String args[]) {
		CustomerFrame frame = new CustomerFrame();
		frame.setTitle("CUSTOMER DATABASE");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,700);
	}
}