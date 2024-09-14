package models;

import java.time.LocalDate;

import db.DbRequest;
import services.BookImpl;
import utils.DateUtils;

public class Book extends Document {
	private String isbn;

	public Book(int id, String title, String author, LocalDate publicationDate, int pagesNumber, String isbn,
			Boolean borrowed) {
		setId(id);
		setTitle(title);
		setAuthor(author);
		setPublicationDate(publicationDate);
		setPagesNumber(pagesNumber);
		setIsbn(isbn);
		setBorrowed(borrowed);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void displayDetails() {
		System.out.printf("%-20s | %-20s | %-20s | %-25s | %-15s | %-10s | ISBN: %-15s%n", "Book ", getTitle(),
				getAuthor(), DateUtils.toHumanDate(getPublicationDate()), getPagesNumber(), isBorrowed() ? "YES" : "NO",
				isbn);
	}

	@Override
	public void borrow(int userId, int documentId) {
		setBorrowed(true);
		String columns = "user_id, document_id, status";
		Object[] values = { userId, documentId, "borrowed" };
		DbRequest.insert("borrowings", columns, values);
		BookImpl bImpl = new BookImpl();
		bImpl.updateBook(this);
	}

	@Override
	public void reserve(int userId, int documentId) {
		String columns = "user_id, document_id, status";
		Object[] values = { userId, documentId, "pending" };
		DbRequest.insert("reservations", columns, values);
	}

	@Override
	public void cancelReservation(int id) {
		Object[] value = { "canceled" };
		DbRequest.update("reservations", id, "status", value);
	}

	@Override
	public void returnItem(int id) {
		setBorrowed(false);
		BookImpl bImpl = new BookImpl();
		bImpl.updateBook(this);
		Object[] value = { "returned" };
		DbRequest.update("borrowings", id, "status", value);

	}
}
