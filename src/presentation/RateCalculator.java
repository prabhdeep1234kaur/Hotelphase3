package presentation;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RateCalculator extends JFrame {
	private JLabel checkin,checkout,rate;
	private JTextField trate,tres;
	private JComboBox day,month,year,day1;
	private JButton cal;
	public RateCalculator() {
		Container c = getContentPane();
		c.setLayout(null);
		
		checkin = new JLabel("CHECK-IN DATE");
		checkin.setBounds(20,50,100,20);
		checkin.setOpaque(true);
		checkin.setBackground(Color.white);
		c.add(checkin);
		
		String d[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19",
				"20","21","22","23","24","25","26","27","28","29","30","31"};
		day = new JComboBox(d);
		day.setBounds(170,50,50,20);
		c.add(day);
		
		String m[] = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		month = new JComboBox(m);
		month.setBounds(230,50,50,20);
		c.add(month);
		
		String y[] = {"2018","2019","2020","2021"};
		year = new JComboBox(y);
		year.setBounds(290,50,60,20);
		c.add(year);
		
		checkout = new JLabel("CHECK-OUT DATE");
		checkout.setBounds(20,100,120,20);
		checkout.setOpaque(true);
		checkout.setBackground(Color.white);
		c.add(checkout);
		
		String d1[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19",
				"20","21","22","23","24","25","26","27","28","29","30","31"};
		day1 = new JComboBox(d);
		day1.setBounds(170,100,50,20);
		c.add(day1);
		
		String m1[] = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		month = new JComboBox(m);
		month.setBounds(230,100,50,20);
		c.add(month);
		
		String y1[] = {"2018","2019","2020","2021"};
		year = new JComboBox(y);
		year.setBounds(290,100,60,20);
		c.add(year);
		
		rate = new JLabel("RATE PER NIGHT");
		rate.setBounds(20,150,120,20);
		rate.setOpaque(true);
		rate.setBackground(Color.white);
		c.add(rate);
		
		trate = new JTextField();
		trate.setBounds(170,150,120,20);
		c.add(trate);
		
		cal = new JButton("CALCULATE");
		cal.setBounds(150,250,150,40);
		//cal.setBackground(Color.);
		c.add(cal);
		cal.addActionListener(new Cal());
		
		tres = new JTextField();
		tres.setBounds(150,310,150,30);
		c.add(tres);
		
	}

	private class Cal implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String val = day.getSelectedItem().toString();
			String val1 = day1.getSelectedItem().toString();
			String night = trate.getText();
			int res = Integer.parseInt(val1)-Integer.parseInt(val);
			double total = res*(Double.parseDouble(night))*(1.13);
			tres.setText("Rate(incl of taxes) = $"+Double.toString(total));
			
		}
		
	}
}
