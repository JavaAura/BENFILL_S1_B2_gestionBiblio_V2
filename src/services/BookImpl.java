package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.BookDao;
import db.DbRequest;
import models.Book;

public class BookImpl implements BookDao {

	@Override
	public void addBook(Book book) {
		String columns = "title, author, publicationDate, pagesNumber, isbn, type";
		Object[] values = { book.getTitle(), book.getAuthor(), book.getPublicationDate(), book.getPagesNumber(),
				book.getIsbn(), "book" };
		DbRequest.insert("books", columns, values);
	}

	@Override
	public List<Book> displayBooks() {
		ResultSet rs = DbRequest.getAll("books", "", null);
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			while (rs != null && rs.next()) {
				LocalDate date = LocalDate.parse(rs.getString("publicationDate"));
				Book book = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), date,
						rs.getInt("pagesNumber"), rs.getString("isbn"), rs.getBoolean("borrowed"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Make sure to close the ResultSet and the associated Statement
			try {
				if (rs != null) {
					Statement stmt = rs.getStatement(); // Retrieve statement before closing ResultSet
					rs.close();
					if (stmt != null) {
						stmt.close(); // Close the statement
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	@Override
	public void updateBook(Book book) {
		String columns = "title, author, publicationDate, pagesNumber, isbn, borrowed";
		Object[] values = { book.getTitle(), book.getAuthor(), book.getPublicationDate(), book.getPagesNumber(),
				book.getIsbn(), book.isBorrowed() };
		DbRequest.update("books", book.getId(), columns, values);
	}

	@Override
	public void deleteBook(Book book) {
		DbRequest.delete("books", book.getId());

	}

}
