package presentation;


import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import data.DBMain;


public class LandingPage  extends JFrame{

	private JFrame frame;
	private JTextField username;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	String pswd = "";

	private DBMain db=null;
	ResultSet result;
	 
	public LandingPage() {
		setTitle("Welcome");
		getContentPane().setLayout(null);
		
		JLabel lblWelcomePleaseSelect = new JLabel("Welcome, Please login");
		lblWelcomePleaseSelect.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblWelcomePleaseSelect.setBounds(86, 49, 254, 102);
		getContentPane().add(lblWelcomePleaseSelect);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(96, 159, 109, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(100, 221, 79, 13);
		getContentPane().add(lblNewLabel_1);
		
		JRadioButton rdbtnFrontDesk = new JRadioButton("Front Desk");
		rdbtnFrontDesk.setSelected(true);
		buttonGroup.add(rdbtnFrontDesk);
		rdbtnFrontDesk.setBounds(133, 257, 105, 21);
		getContentPane().add(rdbtnFrontDesk);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		buttonGroup.add(rdbtnAdmin);
		rdbtnAdmin.setBounds(252, 257, 105, 21);
		getContentPane().add(rdbtnAdmin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText("");
			    passwordField.setText("");
			}
		});
		btnReset.setBounds(226, 319, 85, 21);
		getContentPane().add(btnReset);
		
		username = new JTextField();
		username.setBounds(215, 156, 96, 19);
		getContentPane().add(username);
		username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(215, 218, 96, 19);
		getContentPane().add(passwordField);
		

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isValidData())
					return;
				int loginType = 1;
				
				String usernameVal = username.getText();
				String passVal = passwordField.getText();
				try {
					db=new DBMain();
				} catch (ClassNotFoundException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				if(rdbtnFrontDesk.isSelected()) {
					loginType = 2; // front desk
				}else {
					loginType = 1; // admin
				}
				
				result = db.getLoginDetains(loginType,usernameVal,passVal);
				
				try {
					if(result.isBeforeFirst()) {
						while (result.next()) {
							dispose(); // this will close current login box window
							if(loginType == 2) { //front desk
								Index Iframe = new Index();
								Iframe.setSize(1000,700);
								Iframe.setVisible(true);
							}else { //admin
								AdminMain Iframe = new AdminMain();
								Iframe.setSize(500,500);
								Iframe.setVisible(true);
							}
							 
							
						
						}
					}else {
						JOptionPane.showMessageDialog(null, "Incorrect Login Details. ");
					}					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			public boolean isValidData() {
				if(!Validator.isPresent(username,"Username")) return false;
				if(!Validator.isPresent(passwordField,"Password ")) return false;
				return true;
			}
		});
		btnLogin.setBounds(73, 319, 85, 21);
		getContentPane().add(btnLogin);
	}

	
	public static void main(String[] args) {
		
		LandingPage frame = new LandingPage();
		frame.setTitle("Welcome");
		frame.setLocationRelativeTo(null);
		frame.setSize(500,500);
		frame.setVisible(true);
		
		
		// TODO Auto-generated method stub

	}
}
