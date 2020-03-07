package data;
import java.util.ArrayList;
public interface CustomerReader {
	business.CustomerInfo getCustomer(String firstName);
	ArrayList<business.CustomerInfo> getCustomers();
}
