package models;

import java.time.LocalDate;

import db.DbRequest;
import services.MagazineImpl;
import utils.DateUtils;

public class Magazine extends Document {
	private int number;

	public Magazine(int id, String title, String author, LocalDate publicationDate, int pagesNumber, int number,
			Boolean borrowed) {
		setId(id);
		setTitle(title);
		setAuthor(author);
		setPublicationDate(publicationDate);
		setPagesNumber(pagesNumber);
		setNumber(number);
		setBorrowed(borrowed);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void displayDetails() {
		System.out.printf("%-20s | %-20s | %-20s | %-25s | %-15s | %-10s | Number: %-15s%n", "Magazine ", getTitle(),
				getAuthor(), DateUtils.toHumanDate(getPublicationDate()), getPagesNumber(), isBorrowed() ? "YES" : "NO",
				number);
	}

	@Override
	public void borrow(int userId, int documentId) {
		setBorrowed(true);
		String columns = "user_id, document_id, status";
		Object[] values = { userId, documentId, "borrowed" };
		DbRequest.insert("borrowings", columns, values);
		MagazineImpl mImpl = new MagazineImpl();
		mImpl.updateMagazine(this);

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
		MagazineImpl mImpl = new MagazineImpl();
		mImpl.updateMagazine(this);
		Object[] value = { "returned" };
		DbRequest.update("borrowings", id, "status", value);

	}
}
