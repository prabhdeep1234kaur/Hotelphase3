package presentation;
import java.awt.*;
import java.awt.event.*;

import	javax.swing.*;

import business.Room;
import data.DAOFactory;
import data.RoomDAO;
import javax.swing.GroupLayout.Alignment;

public class RoomPanel extends JFrame{
	private RoomDAO roomDAO = DAOFactory.getRoomDAO();
	private JComboBox type,number;
	private JButton butSave;
	private JRadioButton c1,c2,c3;
	String roomType[] = {"KING ROOM","QUEEN ROOM","WHEELCHAIR ACCESSIBLE","KING DELUX"};
	String roomNo[] = {"101","102","103","104","105","106","201","202","203","204","205","206"};
	private JPanel panel;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	String roomstatus;

	public RoomPanel() {
		
		ImageIcon bg_img = new ImageIcon("images/images.jpg");
		Image img = bg_img.getImage();
		Image temp_img = img.getScaledInstance(1200, 1200, Image.SCALE_SMOOTH);
		bg_img = new ImageIcon(temp_img);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		number=new JComboBox(roomNo);
		number.setBounds(80,50,90,20);
		
		type=new JComboBox(roomType);
		type.setBounds(80,50,90,20);
		
		rdbtnNewRadioButton = new JRadioButton("Vacant");
		
		rdbtnNewRadioButton_1 = new JRadioButton("Occupied");
		
		
		butSave = new JButton("SAVE");
		butSave.setBounds(150,100,100,30);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addComponent(number, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(rdbtnNewRadioButton)
					.addGap(5)
					.addComponent(rdbtnNewRadioButton_1)
					.addGap(5)
					.addComponent(butSave))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addComponent(number, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addComponent(type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(rdbtnNewRadioButton))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(rdbtnNewRadioButton_1))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(butSave))
		);
		panel.setLayout(gl_panel);
		butSave.addActionListener(new SaveButtonHandler());
		setVisible(true);
	}
	
	private class SaveButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String roomno = (String) number.getSelectedItem();
			String roomtype = (String) type.getSelectedItem();
			String roomstatus = "Test";
			boolean roomstatus_vacant = rdbtnNewRadioButton.isSelected();
			if (rdbtnNewRadioButton.isSelected()) {
				//boolean roomstatus = rdbtnNewRadioButton.isSelected();
				roomstatus = "Vacant";
            }else{
            	//boolean roomstatus = rdbtnNewRadioButton_1.isSelected();
            	roomstatus = "Occupied";
            }
			
			if (roomDAO.addRoom(new Room(roomno,roomtype,roomstatus))) {
				String result = "INFORMATION SAVED";
				JOptionPane.showMessageDialog(null, result, "Save Info", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "INFORMATION NOT SAVED!", "Save Info", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	
	public static void main(String args[]) {
		RoomPanel frame = new RoomPanel();
		frame.setTitle("ROOM DATABASE");frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,250);
	}
	
	
	
}
