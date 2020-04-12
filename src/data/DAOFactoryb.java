package data;

public class DAOFactoryb {
	public static BookDAO getBookDAO() {
		BookDAO bookDAO = new BookDAORandom();
		return bookDAO;
	}
}
