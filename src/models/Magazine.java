package models;

import java.time.LocalDate;

import utils.DateUtils;

public class Magazine extends Document implements Borrowable, Reservable {
	private int number;

	public Magazine(int id, String title, String author, LocalDate publicationDate, int pagesNumber, int number) {
		setId(id);
		setTitle(title);
		setAuthor(author);
		setPublicationDate(publicationDate);
		setPagesNumber(pagesNumber);
		setNumber(number);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public void borrow() {
		// TODO Auto-generated method stub

	}

	@Override
	public void reserve() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelReservation() {
		// TODO Auto-generated method stub

	}

	public void displayDetails() {
		System.out.printf("%-20s | %-15s | %-20s | %-20s | %-25s | %-15s | %-10s | Number: %-15s%n", "Magazine ",
				getId(), getTitle(), getAuthor(), DateUtils.toHumanDate(getPublicationDate()), getPagesNumber(),
				isBorrowed() ? "YES" : "NO", number);
	}
}
