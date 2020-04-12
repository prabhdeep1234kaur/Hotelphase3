package presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import data.DBCustomer;
import data.DBMain;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public  class NewBook  extends JFrame{
	private JLabel heading;

	JPanel bookPanel;
	private JLabel fname,lname,cno,roomNo,guestNo,chkinD,chkoutD,notes;
	private JTextField tFname,tLname,contactNo,room,guests,chkin,chkout,noteText;
	//private JButton add,del;
	private JComboBox membershipSatus;
	private JButton del;
	private JButton add;

	private DBCustomer db=null;
	ResultSet result;
	public NewBook() throws Exception {
		Font font = new Font("Comic Sans MS",Font.BOLD,30);

		/*background*/
		setSize(773,548);
		ImageIcon bg_img = new ImageIcon("images/new_book.jpg");
		//image resize
		Image img = bg_img.getImage();
		Image temp_img = img.getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
		bg_img = new ImageIcon(temp_img);
		JLabel background = new JLabel("",bg_img,JLabel.CENTER);
		background.setBounds(0,0,860,646);


		/*Header*/
		JPanel heading;
		heading = new JPanel();
		heading.setBackground( new Color(255, 255, 255, 80));
		heading.setBounds(0,0,900,100);
		JLabel name = new JLabel("New Booking");
		name.setBounds(450,25,400,50);
		name.setFont(font);


		/*form info*/
		//form info
		fname = new JLabel("FIRST NAME");
		fname.setBounds(400,100,100,20);
		background.add(fname,BorderLayout.CENTER);
		
		//
		/*Vector comboBoxItems=new Vector();
	    
	    final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
	   
		db=new DBCustomer();
		try {
			result = db.getAllCustomer();
			if(result.next()) {
				 int i=0;
				 //ComboBoxModel strings;
				 //ArrayList<String> strings = new ArrayList<String>();
				 
				 while (result.next()) {
					 i ++;
					 comboBoxItems.add(result.getString("first_name"));
				 }
				 //JOptionPane.showMessageDialog(null, i);
				 //fnamm.addItem(addNames); 
			}else {
				JOptionPane.showMessageDialog(null, "No Guests Found. ");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e1.getMessage());
		}
			
		 JComboBox fnamm = new JComboBox(model);
		    
		//JComboBox fnamm = new JComboBox();
		fnamm.setBounds(500,100,190,25);
		background.add(fnamm);*/
		
		
		
		

		tFname = new JTextField();
		tFname.setBounds(500,100,190,25);
		background.add(tFname,BorderLayout.CENTER);

		lname = new JLabel("LAST NAME");
		lname.setBounds(400,150,100,20);
		background.add(lname);

		tLname = new JTextField();
		tLname.setBounds(500,150,190,25);
		background.add(tLname);


		/////
		cno = new JLabel("Contact no.");
		cno.setBounds(400,200,100,20);
		background.add(cno);


		contactNo = new JTextField("");
		contactNo.setBounds(500,200,190,25);
		background.add(contactNo);

		roomNo = new JLabel("Rooms");
		roomNo.setBounds(400,250,100,20);
		background.add(roomNo);
		
		room = new JTextField("");
		room.setBounds(500,250,190,25);
		//room.setPreferredSize(new Dimension(90,90));
		background.add(room);
	 	
		
		//guests
		JLabel guestNo = new JLabel("Guests");
		guestNo.setBounds(400,300,100,20);
		background.add(guestNo);

		guests = new JTextField("");
		guests.setBounds(500,300,190,25);
		//guests.setPreferredSize(new Dimension(90,90));
		background.add(guests);

		
		//check in///////////////////////
		JLabel chkinD = new JLabel("Check in");
		chkinD.setBounds(400,350,100,20);
		background.add(chkinD);
		
		//adding calender
		String d[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19",
				"20","21","22","23","24","25","26","27","28","29","30","31"};
		JComboBox day = new JComboBox(d);
		day.setBounds(500,350,80,25);
		background.add(day);
		
		String m[] = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		JComboBox month = new JComboBox(m);
		month.setBounds(600,350,100,25);
		background.add(month);
		
		String y[] = {"2018","2019","2020","2021"};
		JComboBox year = new JComboBox(y);
		year.setBounds(700,350,100,25);
		background.add(year);
		
		
		//check out///////////////////////
		chkoutD = new JLabel("Check out");
		chkoutD.setBounds(400,400,100,20);
		background.add(chkoutD);
		
		//adding calender
		chkoutD = new JLabel("Check out");
		chkoutD.setBounds(400,400,100,20);
		background.add(chkoutD);
		
		String out_d[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19",
				"20","21","22","23","24","25","26","27","28","29","30","31"};
		JComboBox out_day = new JComboBox(out_d);
		out_day.setBounds(500,400,80,25);
		background.add(out_day);
		
		String out_m[] = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		JComboBox out_month = new JComboBox(out_m);
		out_month.setBounds(600,400,100,25);
		background.add(out_month);
		
		String out_y[] = {"2018","2019","2020","2021"};
		getContentPane().setLayout(null);
		JComboBox out_year = new JComboBox(out_y);
		out_year.setBounds(700,400,100,25);
		background.add(out_year);
		
		
		//notes
		notes = new JLabel("Notes");
		notes.setBounds(400,450,100,20);
		background.add(notes);

		noteText = new JTextField("");
		noteText.setBounds(500,450,190,25);
		noteText.setPreferredSize(new Dimension(90,90));
		background.add(noteText);

		//buttons
		add = new JButton("ADD");
		add.setBounds(530,500,100,20);
		add.setBackground(Color.green);
		background.add(add);

		del = new JButton("DELETE");
		del.setBounds(530,550,100,20);
		del.setBackground(Color.red);
		background.add(del);
		
		
		JButton mainp = new JButton("Main Page");
		mainp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose(); // this will close current login box window
				 Index iframe = new Index();
				iframe.setTitle("Admin Panel");
				iframe.setLocationRelativeTo(null);
				iframe.setVisible(true);
			}
		});
		mainp.setBounds(530,600,100,20);
		mainp.setBackground(Color.orange);
		background.add(mainp);


		//background.add(bookPanel);
		heading.add(name);
		getContentPane().add(background);
		background.add(heading);
		
		db=new DBCustomer();
		
		
		
		//background.add(bookPanel);
		setVisible(true);
		add.addActionListener(new SaveButtonHandler());
		del.addActionListener(new SaveButtonHandler());
	}

	public static void main(String args[]) throws Exception {
		// TODO Auto-generated method stub
		NewBook frame = new NewBook();
		frame.setTitle("New Booking");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200,700);
		frame.setVisible(true);

		//del.addActionListener(new FindButtonHandler());
	}

	private class SaveButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			//extracting value from GUI
			String cusfname = tFname.getText();
			String cuslname = tLname.getText();
			String contact = contactNo.getText();
			String rm = room.getText();
			String gst = guests.getText();
			//String chk_in = chkin.getText();
			//String chk_out = chkout.getText();
			String note = noteText.getText();

			if(isValidData()) {
				String result = "Customer Name : "+cusfname+""+cuslname+" \n Contact : "+contact+" \n Rooms : "+rm;
				JOptionPane.showMessageDialog(null,"Book confirmed." +result,"Book confirmed",JOptionPane.INFORMATION_MESSAGE);
			}
		}

		public boolean isValidData() {
			if(!Validator.isPresent(tFname,"Customer first name")) return false;
			if(!Validator.isPresent(tLname,"Customer last name")) return false;
			if(!Validator.isPresent(contactNo,"Contact number")) return false;
			if(!Validator.isInteger(contactNo,"Contact number")) return false;
			if(!Validator.isPresent(room,"Room")) return false;
			if(!Validator.isInteger(room,"Room")) return false;
			if(!Validator.isPresent(guests,"Guests")) return false;
			if(!Validator.isInteger(guests,"Guests")) return false;
			if(!Validator.isPresent(chkin,"Check-in")) return false;
			if(!Validator.isPresent(chkout,"Check-out")) return false;
			//if(!Validator.isPresent(noteText,"Note")) return false;
			return true;
		}
	}
}