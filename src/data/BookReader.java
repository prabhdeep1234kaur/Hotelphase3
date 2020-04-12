package data;

import java.util.ArrayList;

public interface BookReader {
	business.Book getBook(String firstName);
	ArrayList<business.Book> getBooks();
}
