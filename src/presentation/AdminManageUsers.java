package presentation;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import business.DBUserData;
import data.DBMain;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class AdminManageUsers  extends JFrame{
	
	private JTable tableUsers;
	
	private DBMain db=null;
	ResultSet result;
	public AdminManageUsers() {
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 52, 305, 181);
		getContentPane().add(scrollPane);
		
		 tableUsers = new JTable();
		
		JButton btnShowUsers = new JButton("Show Users");
		btnShowUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db=new DBMain();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				result = db.getAllUsers();
				
				try {
					if(result.isBeforeFirst()) {
						 int i=0;
						 ArrayList<Object[]> data = new ArrayList<Object[]>();
						 while (result.next()) {
							 Object[] row = new Object[]{
								 result.getInt("user_id"),
								 result.getString("username"),
								 result.getString("password"),
								 };
							 data.add(row);
						 }
						 tableUsers.setModel(new DefaultTableModel(
							data.toArray(new Object[data.size()][]),
			                new String[] {
			                  "#", "User Name", "Password"
			                }
			              ));
			              
			              scrollPane.setViewportView(tableUsers);
						 
					}else {
						JOptionPane.showMessageDialog(null, "No Users Found. You can add new users. ");
					}					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShowUsers.setBounds(23, 264, 115, 21);
		getContentPane().add(btnShowUsers);
		
		JTextPane textnewUser = new JTextPane();
		textnewUser.setBounds(274, 338, 105, 19);
		getContentPane().add(textnewUser);
		
		JTextPane textNewPass = new JTextPane();
		textNewPass.setBounds(271, 367, 105, 19);
		getContentPane().add(textNewPass);
		
		JLabel lblNewUsername = new JLabel("Add username");
		lblNewUsername.setBounds(84, 344, 85, 13);
		getContentPane().add(lblNewUsername);
		
		JLabel lblNewLabel_1 = new JLabel("Add Password");
		lblNewLabel_1.setBounds(84, 378, 85, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(123, 416, 46, 13);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewUser = new JButton("Add User");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newusername = textnewUser.getText();
				String newpasswordField = textNewPass.getText();
				DBUserData userData = new DBUserData(2, textnewUser.getText() ,textNewPass.getText());
					
					try {
						db.addUser(userData);
						JOptionPane.showMessageDialog(null,"User Added Successfully!!");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,e1.getMessage());
					}
					
			}
			public boolean isValidData() {
				if(!Validator.isPresent(textnewUser,"Username")) return false;
				if(!Validator.isPresent(textNewPass,"Password ")) return false;
				return true;
			}
		});
		btnNewUser.setBounds(84, 408, 85, 21);
		getContentPane().add(btnNewUser);
		
		JTextArea textSearch = new JTextArea();
		textSearch.setBounds(181, 489, 99, 22);
		getContentPane().add(textSearch);
		
		
		JTextPane textUserID = new JTextPane();
		textUserID.setBounds(181, 460, 99, 19);
		getContentPane().add(textUserID);
		
		JLabel lblNewLabel = new JLabel("User ID");
		lblNewLabel.setBounds(92, 466, 46, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("UserName");
		lblNewLabel_3.setBounds(92, 495, 59, 13);
		getContentPane().add(lblNewLabel_3);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isValidData())
					return;
					String userSearch = textSearch.getText();
					try {
						result = db.SeachUser(userSearch);
						if(result.next()) {
							int userid = result.getInt("user_id");
							String username = result.getString("username");
							textSearch.setText(username);
							textUserID.setText(String.valueOf(userid));
						}else {
							JOptionPane.showMessageDialog(null,"No user Found");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,e1.getMessage());
					}
				//db.updateProgram(program);
			}
			public boolean isValidData() {
				if(!Validator.isPresent(textSearch,"Search field")) return false;
				return true;
			}
		});
		btnSearch.setBounds(84, 521, 85, 21);
		getContentPane().add(btnSearch);

		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!isValidData())
						return;
					String userN = textSearch.getText();
					int userId = Integer.parseInt(textUserID.getText());
					try {
						db.updateUser( userN, userId);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,e1.getMessage());
					}
					
				}
				public boolean isValidData() {
					if(!Validator.isPresent(textSearch,"Username")) return false;
					if(!Validator.isPresent(textUserID,"User ID ")) return false;
					return true;
				}
		});
		btnUpdate.setBounds(191, 521, 85, 21);
		getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isValidData())
					return;
				String userN = textSearch.getText();
				int userId = Integer.parseInt(textUserID.getText());
				try {
					db.deleteUser( userN, userId);
					textSearch.setText("");
					textUserID.setText("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
				
			}
			public boolean isValidData() {
				if(!Validator.isPresent(textSearch,"Username")) return false;
				if(!Validator.isPresent(textUserID,"User ID ")) return false;
				return true;
			}
		});
		btnDelete.setBounds(291, 521, 85, 21);
		getContentPane().add(btnDelete);
		
		JButton btnBackToMain = new JButton("Back To Main Menu");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LandingPage frame = new LandingPage();
				frame.setSize(450,400);
				frame.setVisible(true);
			}
		});
		btnBackToMain.setBounds(388, 521, 162, 21);
		getContentPane().add(btnBackToMain);
	}
	
	
	public static void main(String[] args) {
		
		AdminManageUsers frame = new AdminManageUsers();
		frame.setTitle("Manage Users");
		frame.setLocationRelativeTo(null);
		frame.setSize(700,700);
		frame.setVisible(true);
		
		
		// TODO Auto-generated method stub

	}
}