package data;

public class DAOFactoryC {
	public static CustomerDAO getCutstomerDAO() {
	//CustomerDAO cDAO = new CustomerDAOText();
	//CustomerDAO cDAO = new CustomerDAOBinary();
	CustomerDAORandom cDAO = new CustomerDAORandom();
		return cDAO;
	}
}