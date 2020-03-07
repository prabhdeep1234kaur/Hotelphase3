package presentation;
import javax.swing.JFrame;

public class RateMain {
	public static void main(String[] args) {
		RateCalculator frame = new RateCalculator();
		frame.setTitle("RATE CALCULATOR");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,400);
		frame.setVisible(true);
	}
}
