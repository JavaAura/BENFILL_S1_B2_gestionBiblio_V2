package models;

import java.time.LocalDate;

public abstract class Document {
	private int id;
	private String title;
	private String author;
	private LocalDate publicationDate;
	private int pagesNumber;
	private boolean borrowed = false;
//
//	public Document(int id, String title, String author, LocalDate date, int pagesNumber, boolean borrowed) {
//		setId(id);
//		setTitle(title);
//		setAuthor(author);
//		setPublicationDate(date);
//		setPagesNumber(pagesNumber);
//		setBorrowed(borrowed);
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

	public int getPagesNumber() {
		return pagesNumber;
	}

	public void setPagesNumber(int pagesnumber) {
		this.pagesNumber = pagesnumber;
	}

	public boolean isBorrowed() {
		return borrowed;
	}

	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}

}
