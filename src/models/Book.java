package models;

import java.time.LocalDate;

import utils.DateUtils;

public class Book extends Document implements Borrowable {
	private String isbn;

	public Book(int id, String title, String author, LocalDate publicationDate, int pagesNumber, String isbn) {
		setId(id);
		setTitle(title);
		setAuthor(author);
		setPublicationDate(publicationDate);
		setPagesNumber(pagesNumber);
		setIsbn(isbn);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public void borrow() {
		// TODO Auto-generated method stub

	}

	public void displayDetails() {
		System.out.printf("%-20s | %-15s | %-20s | %-20s | %-25s | %-15s | %-10s | ISBN: %-15s%n", "Book ", getId(),
				getTitle(), getAuthor(), DateUtils.toHumanDate(getPublicationDate()), getPagesNumber(),
				isBorrowed() ? "YES" : "NO", isbn);
	}
}
