package models;

import java.time.LocalDate;

import db.DbRequest;
import services.UniversityThesisImpl;
import utils.DateUtils;

public class UniversityThesis extends Document {
	private String university;
	private String fieldOfStudy;

	public UniversityThesis(int id, String title, String author, LocalDate publicationDate, int pagesNumber,
			String university, String fieldOfStudy, Boolean borrowed) {
		setId(id);
		setTitle(title);
		setAuthor(author);
		setPublicationDate(publicationDate);
		setPagesNumber(pagesNumber);
		setUniversity(university);
		setFieldOfStudy(fieldOfStudy);
		setBorrowed(borrowed);
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getFieldOfStudy() {
		return fieldOfStudy;
	}

	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}

	public void displayDetails() {
		System.out.printf("%-20s | %-20s | %-20s | %-25s | %-15s | %-10s | University: %-15s | Field of Study: %-15s%n",
				"University Thesis", getTitle(), getAuthor(), DateUtils.toHumanDate(getPublicationDate()),
				getPagesNumber(), isBorrowed() ? "YES" : "NO", university, fieldOfStudy);
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
		UniversityThesisImpl uImpl = new UniversityThesisImpl();
		uImpl.updateUniversityThesis(this);
	}

	@Override
	public void returnItem(int id) {
		setBorrowed(false);
		UniversityThesisImpl uImpl = new UniversityThesisImpl();
		uImpl.updateUniversityThesis(this);
		Object[] value = { "returned" };
		DbRequest.update("borrowings", id, "status", value);

	}

}
