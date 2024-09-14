package models;

import java.time.LocalDate;

import utils.DateUtils;

public class ScientificJournal extends Document implements Reservable {
	private String researchField;

	public ScientificJournal(int id, String title, String author, LocalDate publicationDate, int pagesNumber,
			String researchField) {
		setId(id);
		setTitle(title);
		setAuthor(author);
		setPublicationDate(publicationDate);
		setPagesNumber(pagesNumber);
		setResearchField(researchField);
	}

	public String getResearchField() {
		return researchField;
	}

	public void setResearchField(String researchField) {
		this.researchField = researchField;
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
		System.out.printf("%-20s | %-20s | %-20s | %-25s | %-15s | %-10s | Research Field: %-15s%n",
				"Scientific Journal", getTitle(), getAuthor(), DateUtils.toHumanDate(getPublicationDate()),
				getPagesNumber(), isBorrowed() ? "YES" : "NO", researchField);
	}

}
