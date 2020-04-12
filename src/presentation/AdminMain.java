package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMain extends JFrame{
	public AdminMain() {
		setTitle("Admin Panel");
		getContentPane().setLayout(null);
		
		JLabel lblAdminPanel = new JLabel("Welocome Back!");
		lblAdminPanel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAdminPanel.setBounds(141, 47, 141, 39);
		getContentPane().add(lblAdminPanel);
		
		JLabel lblSelectAnOperation = new JLabel("Select an operation : ");
		lblSelectAnOperation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelectAnOperation.setBounds(138, 95, 157, 13);
		getContentPane().add(lblSelectAnOperation);
		
		JButton btnManUsers = new JButton("Manage Users");
		btnManUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminManageUsers Iframe = new AdminManageUsers();
				Iframe.setSize(500,500);
				Iframe.setVisible(true);
			}
		});
		btnManUsers.setBounds(112, 134, 141, 21);
		getContentPane().add(btnManUsers);
		
		JButton btnManRoom = new JButton("Manage Rooms");
		btnManRoom.setBounds(112, 182, 141, 21);
		getContentPane().add(btnManRoom);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Logging out..");
				LandingPage Iframe = new LandingPage();
				Iframe.setSize(500,500);
				Iframe.setVisible(true);
			}
		});
		btnLogout.setBounds(282, 134, 85, 21);
		getContentPane().add(btnLogout);
	}


	public static void main(String[] args) {
		
		AdminMain frame = new AdminMain();
		frame.setTitle("Admin Panel");
		frame.setLocationRelativeTo(null);
		frame.setSize(500,500);
		frame.setVisible(true);
		
		
		// TODO Auto-generated method stub

	}
}
