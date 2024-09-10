package models;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Document {
	protected long id;
	protected String tilte;
	protected String author;
	protected LocalDate publicationDate;
	protected int pagesnumber;
	protected boolean borrowed = false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTilte() {
		return tilte;
	}

	public void setTilte(String tilte) {
		this.tilte = tilte;
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

	public int getPagesnumber() {
		return pagesnumber;
	}

	public void setPagesnumber(int pagesnumber) {
		this.pagesnumber = pagesnumber;
	}

	public boolean isBorrowed() {
		return borrowed;
	}

	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}

	public abstract ArrayList<?> index();

	public abstract void store();

	public abstract void update(int id);

	public abstract void delete(int id);

}
