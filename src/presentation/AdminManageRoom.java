package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminManageRoom extends JFrame{
	private JTextField textField;
	public AdminManageRoom() {
		getContentPane().setLayout(null);
		
		JLabel lblRoomType = new JLabel("ROOM TYPE");
		lblRoomType.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRoomType.setBounds(102, 118, 87, 13);
		getContentPane().add(lblRoomType);
		
		textField = new JTextField();
		textField.setBounds(253, 116, 96, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD NEW ROOM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(71, 208, 118, 21);
		getContentPane().add(btnNewButton);
		
		JButton btnDeleteNewRoom = new JButton("DELETE NEW ROOM");
		btnDeleteNewRoom.setBounds(308, 208, 130, 21);
		getContentPane().add(btnDeleteNewRoom);
	}
}