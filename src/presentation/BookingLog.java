package presentation;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.BookDAO;
import data.DAOFactoryb;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookingLog extends JFrame{
	private JTable table;
	
	private BookDAO cDao = DAOFactoryb.getBookDAO();

	public BookingLog() {
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 35, 345, 182);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Room No", "Customer Name"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnshow = new JButton("Display Data");
		btnshow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel(new Object[][] {},
						new String[] {"Room No","Room Type","Customer Name"}));//	 DefaultTableModel model = (DefaultTableModel) testTable.getModel();
				java.util.ArrayList<business.Book> books = cDao.getBooks();

				for (business.Book ct : books) {
					String aa = ct.getName();
					aa = aa.replaceAll("\\s+","");
					AddRowToTable(new Object[] {aa,ct.getRoomNum(),ct.getRoomType()});
				}
			}
		});
		btnshow.setBounds(39, 227, 128, 21);
		getContentPane().add(btnshow);
		
		JButton btnNewButton = new JButton("Main Page");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Index Iframe = new Index();
	            Iframe.setSize(1200,700);
				Iframe.setVisible(true);;
				
 			}
		});
		btnNewButton.setBounds(251, 227, 102, 21);
		getContentPane().add(btnNewButton);
	}
	public static void main(String args[]) {
		//System.out.println("here!");
		BookingLog frame = new BookingLog();
		frame.setTitle("CUSTOMER DATABASE");frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setVisible(true);
	}
	
	//row for the table
	public void AddRowToTable(Object[] datarow) {
		DefaultTableModel model1 = (DefaultTableModel) table.getModel();
		model1.addRow(datarow);
	}

	public void RemoveRowToTable() {
		// int i=Integer.parseInt((String) object);
		DefaultTableModel model1 = (DefaultTableModel) table.getModel();
		int i = table.getSelectedRow();
		if (i >= 0)
			model1.removeRow(i);
		else
			JOptionPane.showMessageDialog(null, "no row");

	}
}
