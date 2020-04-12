package presentation;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import	javax.swing.*;

import business.Room;
import data.DAOFactory;
import data.DBCustomer;
import data.RoomDAO;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class RoomPanel extends JFrame{
	private RoomDAO roomDAO = DAOFactory.getRoomDAO();
	private JComboBox type,number;
	private JButton butSave;
	private JRadioButton c1,c2,c3;
	//String roomType[] = {"KING ROOM","QUEEN ROOM","WHEELCHAIR ACCESSIBLE","KING DELUX"};
	String roomNo[] = {"101","102","103","104","105","106","201","202","203","204","205","206"};
	private JPanel panel;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	String roomstatus;

	
	private DBCustomer db=null;
	ResultSet result;
	
	public RoomPanel() throws ClassNotFoundException, SQLException {
		
		ImageIcon bg_img = new ImageIcon("images/images.jpg");
		Image img = bg_img.getImage();
		Image temp_img = img.getScaledInstance(1200, 1200, Image.SCALE_SMOOTH);
		bg_img = new ImageIcon(temp_img);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		number=new JComboBox(roomNo);
		number.setBounds(80,50,90,20);

		
		/* room type */
		db=new DBCustomer();
		String[] roomType1 = new String[10];
		try {
			result = db.getAllRoomTypes();
			if(result.next()) {
				 int i=0;
				 while (result.next()) {
					 i ++;
					 //Rlist.add(result.getString("room_type"));
					 roomType1[i] = result.getString("room_type");
				 }
			}else {
				JOptionPane.showMessageDialog(null, "No Guests Found. ");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e1.getMessage());
		}
		//JSONArray jsArray = new JSONArray(Rlist);
		
		type=new JComboBox(roomType1);
		type.setBounds(80,50,90,20);
		
		
		/**/
		
		rdbtnNewRadioButton = new JRadioButton("Vacant");
		
		rdbtnNewRadioButton_1 = new JRadioButton("Occupied");
		
		
		butSave = new JButton("SAVE");
		butSave.setBounds(150,100,100,30);
		
		JLabel lblRoomNumber = new JLabel("ROOM NUMBER");
		lblRoomNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblRoomType = new JLabel("ROOM TYPE");
		lblRoomType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblRoomCondition = new JLabel("ROOM CONDITION");
		lblRoomCondition.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(199)
					.addComponent(butSave)
					.addContainerGap(180, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(102)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRoomNumber)
						.addComponent(lblRoomType, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRoomCondition, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnNewRadioButton_1)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(number, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(rdbtnNewRadioButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(type, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
					.addGap(92))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(57)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(number, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRoomNumber))
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRoomType, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnNewRadioButton)
						.addComponent(lblRoomCondition, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnNewRadioButton_1)
					.addGap(33)
					.addComponent(butSave)
					.addGap(42))
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
	
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		RoomPanel frame = new RoomPanel();
		frame.setTitle("ROOM DATABASE");frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,250);
	}
}