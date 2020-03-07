package presentation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class CustomerLog extends JFrame{
	private JTable table;
	private JLabel background;
	private String[][] row= {} ;
	private String[] col = {"LAST NAME","FIRST NAME","PHONE NUMBER","CHECK-IN DATE","CHECK-OUT DATE","NUMBER OF ROOMS","CC DETAILS"};
	
	
	JFrame frame = new JFrame();
	public CustomerLog() {
		ImageIcon img = new ImageIcon("images/bg_img.jpg");
		background = new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,1200,700);
		
		JPanel guestPanel = new JPanel();
		guestPanel.setSize(500,500);
		guestPanel.setBackground(new Color(0,0,0,60));
		guestPanel.setBounds(50,150,700,350);
		
		JLabel title = new JLabel("CUSTOMER LOG-BOOK");
		title.setBounds(500,20,150,50);
		
		title.setOpaque(true);
		title.setBackground(Color.white);
		background.add(title);
		
		guestPanel.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "CUSTOMER TABLE", TitledBorder.CENTER, TitledBorder.TOP));
		table = new JTable(row,col);
	    JTableHeader headers = table.getTableHeader();
	    headers.setSize(100,200);
	    table.setRowHeight(25);

	    int[] columnsWidth = {100, 100, 100, 100, 100, 100, 100};
	    
	    int i = 0;
        for (int width : columnsWidth) {
            TableColumn column = table.getColumnModel().getColumn(i++);
            column.setMinWidth(width);
            column.setMaxWidth(width);
            column.setPreferredWidth(width);
        }
	    
	    guestPanel.add(headers,BorderLayout.WEST);
		guestPanel.add(table);
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
	    leftRenderer.setHorizontalAlignment(JLabel.LEFT);
	    table.getColumnModel().getColumn(6).setCellRenderer(leftRenderer);
		
		JScrollPane sp = new JScrollPane(table); 
		Container c = frame.getContentPane();
		//c.add(sp,BorderLayout.WEST);
		this.setPreferredSize(new Dimension(700,700));
		background.add(guestPanel);
		add(background);
		setVisible(true);
		
	}
}
