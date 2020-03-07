package presentation;
//package hotal_project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Index  extends JFrame{
	
	public Index() {
		
		Font font = new Font("Comic Sans MS",Font.BOLD,30);
	
		
		/*sidebar*/
		JPanel sidebar;
		sidebar = new JPanel();
		sidebar.setBackground( new Color(255, 255, 255, 80));
		sidebar.setBounds(0,0,100,700);
		
		/*welcome msg*/
		JPanel wlcm;
		wlcm = new JPanel();
		wlcm.setBackground(new Color(255, 255, 255, 80));
		wlcm.setSize(150,150);
		wlcm.setBounds(400,350,300,50);
		JLabel wlcm_txt = new JLabel("Hotel Management");
		wlcm_txt.setBounds(200,25,400,50);
		wlcm_txt.setFont(font);
		wlcm_txt.setForeground(new Color(0, 0, 51));
		wlcm.add(wlcm_txt);
		
		/*Buttons*/
		JButton addCus = new JButton("Add Guest");
		addCus.setBounds(0,0,100,700);
		addCus.setBackground(new Color(0, 255, 153 ));
		addCus.addActionListener(new NewGuestEventHandler());//to open the new gues
		
		JButton newBook = new JButton("New Booking");
		newBook.setBounds(0,0,100,700);
		newBook.setBackground(new Color(0, 255, 153 ));
		newBook.addActionListener(new NewBookEventHandler());//to open the new booking
		
		JButton rooms = new JButton("Manage rooms");
		rooms.setBounds(0,0,100,700);
		rooms.setBackground(new Color(0, 255, 153 ));
		
		JButton loginfo = new JButton("Log Info");
		loginfo.setBounds(0,0,100,700);
		loginfo.setBackground(new Color(0, 255, 153 ));
		loginfo.addActionListener(new LogInfoEventHandler()); //to open guest info
		
		
		/*background*/
		ImageIcon bg_img = new ImageIcon("images/bg_img.jpg");
		
		/*image resize*/
		Image img = bg_img.getImage();
		Image temp_img = img.getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
		bg_img = new ImageIcon(temp_img);
		JLabel background = new JLabel("",bg_img,JLabel.CENTER);
		
		
		background.add(sidebar);
		background.add(wlcm);
		sidebar.add(addCus);
		sidebar.add(newBook);
		sidebar.add(rooms);
		sidebar.add(loginfo);
		background.setBounds(0,0,900,600);
		
		add(background);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		// TODO Auto-generated method stub
		Index frame = new Index();
		frame.setTitle("Hotel Management");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200,700);
		frame.setVisible(true);
	}
	
	private class NewBookEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			NewBook frame = new NewBook();
			frame.setSize(1200,700);
			frame.setVisible(true);
		}
	}
	
	private class NewGuestEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			CustomerFrame frame = new CustomerFrame();
			frame.setTitle("CUSTOMER DATABASE");
			frame.setSize(1000,500);
		}
	}
	
	private class LogInfoEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			CustomerLog frame = new CustomerLog();
			frame.setTitle("CUSTOMER LOG");
			frame.setLocationRelativeTo(null);
			frame.setSize(1100,700);
		}
	}
	
	
}
