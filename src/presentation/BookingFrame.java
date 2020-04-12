package presentation;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import	javax.swing.*;
import business.Book;
import data.DAOFactory;
import data.DAOFactoryb;
import data.BookDAO;
import java.util.*;
public class BookingFrame extends JFrame{
	
	private JLabel fname,lname,email,numOfAdults,noOfChild,roomType,checkin,checkout,cc,rate;
	private JComboBox fName,lName,type,day,month,year,day1;
	private JTextField txtEmail,txtnumOfAdults,txtnoOfChild,ccDetail;
	private JButton cal,save;
	String roomTypes[] = {"KING ROOM","QUEEN ROOM","WHEELCHAIR ACCESSIBLE","KING DELUX"};
	private BookDAO bDao = DAOFactoryb.getBookDAO();
	JLabel background;
	
	
	/**/
	String[] values=new String[6];
	//JComboBox<String>[] combos=new JComboBox<String>[6];
	/**/
	public BookingFrame() {
		
		/*File*/
		try{
            ArrayList<String> tmp=new ArrayList<String>();
            InputStream ips=new FileInputStream("CustomerInfoFixed.dat"); 
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            //String line;
            int ij=0;
            
            for (String line = br.readLine(); line != null; line = br.readLine()) {
            	 String[] s = line.split(" ");
                 tmp.add(s[ij]);
                 ij += 1;
             }
            /*while ((line=br.readLine())!=null) {
            	
                String[] s = line.split(" ");
                tmp.add(s[ij]);
                ij += 1;
            }*/
            br.close(); 
            //values = tmp.toArray(new String[3]);
    	    for(int i=0;i<values.length;i++) {
    	    	fName=new JComboBox(values);
    	    }
        }       
        catch (Exception e){
            e.printStackTrace();
        }
		
	   
		/*File*/
		
		/*background*/
		ImageIcon bg_img = new ImageIcon("images/images.jpg");
		Image img = bg_img.getImage();
		Image temp_img = img.getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
		bg_img = new ImageIcon(temp_img);
		background = new JLabel("",bg_img,JLabel.CENTER);
		background.setBackground(new Color(0, 128, 0));
		background.setBounds(0,0,1200,700);
		/*background*/
		
		Container c = getContentPane();
		c.setLayout(null);
		
		fname = new JLabel("FIRST NAME");
		fname.setBounds(120,50,100,20);
		background.add(fname);
		
		/*fName = new JComboBox();*/
		fName.setBounds(250,50,150,20);
		background.add(fName);
		
		lname = new JLabel("LAST NAME");
		lname.setBounds(120,100,100,20);
		background.add(lname);
		
		lName = new JComboBox();
		lName.setBounds(250,100,150,20);
		background.add(lName);
		
		email = new JLabel("EMAIL");
		email.setBounds(120,150,80,20);
		background.add(email);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(250,150,150,20);
		background.add(txtEmail);
		
		numOfAdults = new JLabel("NUMBER OF ADULTS");
		numOfAdults.setBounds(80,200,150,20);
		background.add(numOfAdults);
		
		txtnumOfAdults = new JTextField();
		txtnumOfAdults.setBounds(250,200,50,20);
		background.add(txtnumOfAdults);
	
		noOfChild = new JLabel("NUMBER OF CHILDREN");
		noOfChild.setBounds(70,250,150,20);
		background.add(noOfChild);
		
		txtnoOfChild = new JTextField();
		txtnoOfChild.setBounds(250,250,50,20);
		background.add(txtnoOfChild);
		
		checkin = new JLabel("CHECK-IN DATE");
		checkin.setBounds(100,300,100,20);
		background.add(checkin);
		
		String d[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19",
				"20","21","22","23","24","25","26","27","28","29","30","31"};
		day = new JComboBox(d);
		day.setBounds(250,300,50,20);
		background.add(day);
		
		String m[] = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		month = new JComboBox(m);
		month.setBounds(310,300,50,20);
		background.add(month);
		
		String y[] = {"2018","2019","2020","2021"};
		year = new JComboBox(y);
		year.setBounds(370,300,60,20);
		background.add(year);
		
		checkout = new JLabel("CHECK-OUT DATE");
		checkout.setBounds(100,350,120,20);
		background.add(checkout);
		
		String d1[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19",
				"20","21","22","23","24","25","26","27","28","29","30","31"};
		day1 = new JComboBox(d);
		day1.setBounds(250,350,50,20);
		background.add(day1);
		
		String m1[] = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		month = new JComboBox(m1);
		month.setBounds(310,350,50,20);
		background.add(month);
		
		String y1[] = {"2018","2019","2020","2021"};
		year = new JComboBox(y1);
		year.setBounds(370,350,60,20);
		background.add(year);
		
		cc = new JLabel("CREDIT CARD DETAILS");
		cc.setBounds(70,400,150,20);
		background.add(cc);
		
		ccDetail = new JTextField();
		ccDetail.setBounds(250,400,190,20);
		background.add(ccDetail);
		
		roomType = new JLabel("ROOM TYPE  ");
		roomType.setBounds(70,450,200,20);
		background.add(roomType);
		
		type=new JComboBox(roomTypes);
		type.setBounds(240,450,150,20);
		background.add(type);
		
		cal = new JButton("CALCULATE");
		cal.setBounds(250,550,150,40);
		background.add(cal);
		cal.addActionListener(new Cal());
		
		save = new JButton("SAVE");
		save.setBounds(250,650,150,40);
		background.add(save);
		save.addActionListener(new Save());
		
		add(background);
		setVisible(true);

	}
	private class Cal implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String val = day.getSelectedItem().toString();
			String val1 = day1.getSelectedItem().toString();
			int res = Integer.parseInt(val1)-Integer.parseInt(val);
			double total = res*(150*(1.13));
			JOptionPane.showMessageDialog(null, total, "TOTAL RATE", JOptionPane.INFORMATION_MESSAGE);
			
		}

	}
	private class Save implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (!isValidData())
				return;
			String firstName = (String) fName.getSelectedItem();
			String lastName = (String) lName.getSelectedItem();
			String rtype = (String) type.getSelectedItem();
			
			Book br = new Book(firstName,lastName,rtype);
			
			if (bDao.addBook(br)) {
				String result = "INFORMATION SAVED";
				JOptionPane.showMessageDialog(null, result, "Save Info", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "INFORMATION NOT SAVED!", "Save Info", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		public boolean isValidData() {
			if(!Validator.isPresent(txtEmail,"Email")) return false;
			if(!Validator.isEmail(txtEmail,"Email")) return false;
			if(!Validator.isInteger(txtnumOfAdults,"Number of Adults")) return false;
			if(!Validator.isInteger(txtnoOfChild,"Number of Children")) return false;
			//if(!Validator.isInteger(ccDetail,"Credit Card")) return false;
			return true;
		}
	}
	
	public static void main(String[] args) {
		BookingFrame frame= new BookingFrame();
		frame.setTitle("BOOKINGS");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200,1000);
		frame.setVisible(true);
		
	}
}
