package models;

import java.time.LocalDate;

import db.DbRequest;
import services.ScientificJournalImpl;
import utils.DateUtils;

public class ScientificJournal extends Document {
	private String researchField;

	public ScientificJournal(int id, String title, String author, LocalDate publicationDate, int pagesNumber,
			String researchField, Boolean borrowed) {
		setId(id);
		setTitle(title);
		setAuthor(author);
		setPublicationDate(publicationDate);
		setPagesNumber(pagesNumber);
		setResearchField(researchField);
		setBorrowed(borrowed);
	}

	public String getResearchField() {
		return researchField;
	}

	public void setResearchField(String researchField) {
		this.researchField = researchField;
	}

	public void displayDetails() {
		System.out.printf("%-20s | %-20s | %-20s | %-25s | %-15s | %-10s | Research Field: %-15s%n",
				"Scientific Journal", getTitle(), getAuthor(), DateUtils.toHumanDate(getPublicationDate()),
				getPagesNumber(), isBorrowed() ? "YES" : "NO", researchField);
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
	public void borrow(int userId, int documentId) {
		setBorrowed(true);
		String columns = "user_id, document_id, status";
		Object[] values = { userId, documentId, "borrowed" };
		DbRequest.insert("borrowings", columns, values);
		ScientificJournalImpl sImpl = new ScientificJournalImpl();
		sImpl.updateScientificJournal(this);

	}

	@Override
	public void returnItem(int id) {
		setBorrowed(false);
		ScientificJournalImpl sImpl = new ScientificJournalImpl();
		sImpl.updateScientificJournal(this);
		Object[] value = { "returned" };
		DbRequest.update("borrowings", id, "status", value);

	}

}
