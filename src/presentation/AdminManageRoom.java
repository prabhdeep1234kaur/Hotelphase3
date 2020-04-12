package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import business.DBUserData;
import data.DBMain;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminManageRoom extends JFrame{
	private JTextField textField;
	private DBMain db=null;
	ResultSet result;
	private JTable table;
	public AdminManageRoom() {
		setTitle("Add Room Types");
		getContentPane().setLayout(null);
		
		JLabel lblRoomType = new JLabel("ROOM TYPE");
		lblRoomType.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRoomType.setBounds(105, 155, 87, 13);
		getContentPane().add(lblRoomType);
		
		textField = new JTextField();
		textField.setToolTipText("Enter name you wish to add or delete");
		textField.setBounds(253, 153, 96, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD NEW ROOM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newRoomType = textField.getText();
				//DBUserData userData = new DBUserData(2, textnewUser.getText() ,textNewPass.getText());
				try {
					db=new DBMain();
				} catch (ClassNotFoundException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
					try {
						db.addRoomType(newRoomType);
						JOptionPane.showMessageDialog(null,"Room Added Successfully!!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
			public boolean isValidData() {
				if(!Validator.isPresent(textField,"Room Type")) return false;
				return true;
			}
		});
		btnNewButton.setBounds(94, 192, 130, 21);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(85, 10, 264, 72);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Room ID", "Room Type",
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnDeleteNewRoom = new JButton("DELETE ROOM");
		btnDeleteNewRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isValidData())
					return;
				String roomT = textField.getText();
				
				try {
					db.deleteRoomType(roomT);
					textField.setText("");
					db.getAllRoomType();
					try {
						db=new DBMain();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					result = db.getAllRoomType();
					
					try {
						if(result.isBeforeFirst()) {
							 int i=0;
							 ArrayList<Object[]> data = new ArrayList<Object[]>();
							 while (result.next()) {
								 Object[] row = new Object[]{
									 result.getInt("room_type_id"),
									 result.getString("room_type")
									 };
								 data.add(row);
							 }
							 table.setModel(new DefaultTableModel(
								data.toArray(new Object[data.size()][]),
				                new String[] {
				                		"Room ID", "Room Type",
				                }
				              ));
				              
				              scrollPane.setViewportView(table);
							 
						}else {
							JOptionPane.showMessageDialog(null, "No Users Found. You can add new users. ");
						}					
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//JOptionPane.showMessageDialog(null,"Deleted");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.toString());
				}
				
			}
			public boolean isValidData() {
				if(!Validator.isPresent(textField,"Room Type")) return false;
				return true;
			}
		});
		btnDeleteNewRoom.setBounds(234, 192, 130, 21);
		getContentPane().add(btnDeleteNewRoom);
		
		
		
		JButton btnShowRooms = new JButton("View Room Types");
		btnShowRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db=new DBMain();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				result = db.getAllRoomType();
				
				try {
					if(result.isBeforeFirst()) {
						 int i=0;
						 ArrayList<Object[]> data = new ArrayList<Object[]>();
						 while (result.next()) {
							 Object[] row = new Object[]{
								 result.getInt("room_type_id"),
								 result.getString("room_type")
								 };
							 data.add(row);
						 }
						 table.setModel(new DefaultTableModel(
							data.toArray(new Object[data.size()][]),
			                new String[] {
			                		"Room ID", "Room Type",
			                }
			              ));
			              
			              scrollPane.setViewportView(table);
						 
					}else {
						JOptionPane.showMessageDialog(null, "No Users Found. You can add new users. ");
					}					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShowRooms.setBounds(174, 92, 123, 21);
		getContentPane().add(btnShowRooms);
		
		JButton btnBack = new JButton("Back To Menu");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose(); // this will close current login box window
				 AdminMain frame = new AdminMain();
				frame.setTitle("Admin Panel");
				frame.setLocationRelativeTo(null);
				frame.setSize(500,500);
				frame.setVisible(true);
			}
		});
		btnBack.setBounds(184, 232, 85, 21);
		getContentPane().add(btnBack);
	}
	
	public static void main(String[] args) {
			
			AdminManageRoom frame = new AdminManageRoom();
			frame.setTitle("Manage Users");
			frame.setLocationRelativeTo(null);
			frame.setSize(400,400);
			frame.setVisible(true);
			
			
			// TODO Auto-generated method stub
	
		}
}