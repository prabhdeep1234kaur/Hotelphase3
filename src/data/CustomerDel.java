package data;
import java.util.ArrayList;
public interface CustomerDel {
	business.CustomerInfo delCustomer(String firstName);
	ArrayList<business.CustomerInfo> delCustomers();
}
