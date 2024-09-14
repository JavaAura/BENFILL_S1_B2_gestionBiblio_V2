package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import db.DbRequest;
import models.Book;
import models.Document;
import services.BookImpl;

public class BookController {

	public static void index() {
		BookImpl bookImpl = new BookImpl();
		List<Book> booksList = bookImpl.displayBooks();

		booksList.stream().forEach(book -> book.displayDetails());

	}

	public void store(String title, String author, LocalDate publicationDate, int pagesNumber, String isbn) {
		Book book = new Book(0, title, author, publicationDate, pagesNumber, isbn, false);

		BookImpl bookImpl = new BookImpl();
		bookImpl.addBook(book);
	}

	public void update(Book book) {
		BookImpl bookImpl = new BookImpl();
		bookImpl.updateBook(book);
	}

	public static Document getDocumentByTitle(String title) {
		Object[] value = { title };
		ResultSet rs = DbRequest.getAll("books", "title=?", value);

		if (!DbRequest.hasResults(rs))
			return null;

		Book book = null;
		try {
			LocalDate date = LocalDate.parse(rs.getString("publicationDate"));
			book = new Book(rs.getInt("id"), title, rs.getString("author"), date, rs.getInt("pagesNumber"),
					rs.getString("isbn"), rs.getBoolean("borrowed"));
		} catch (SQLException e) {

		}
		return book;
	}

}
