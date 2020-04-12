package presentation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;
import java.util.regex.Pattern; 
public class Validator {
	public static boolean isPresent(JTextComponent c, String title) {
		if(c.getText().length()==0) {
			showMessage(c,title + " is a required field. \nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
	}
	public static boolean isInteger(JTextComponent c, String title) {
		try {
			int i = Integer.parseInt(c.getText());
			return true;
		}
		catch(NumberFormatException e) {
			showMessage(c,title + " must be an integer.\nplease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
	}
	public static boolean isDouble(JTextComponent c, String title) {
		try {
			double d = Double.parseDouble(c.getText());
			return true;
		}
		catch(NumberFormatException e){
			showMessage(c,title + " must be a valid number. \nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
	}
	public static boolean isEmail(JTextComponent c, String title) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
		String email = c.getText();          
		Pattern pat = Pattern.compile(emailRegex); 
		if (email == null) {
			return false;
		}else {
			return true;
		}
		//return false; 
		//return pat.matcher(email).matches(); 
	}
	private static void showMessage(JTextComponent c,String message) {
		JOptionPane.showMessageDialog(c, message,"Invalid Entry", JOptionPane.ERROR_MESSAGE);
	}
	
	
}
