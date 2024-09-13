package models;

import java.time.LocalDate;

import utils.DateUtils;

public class UniversityThesis extends Document implements Reservable {
	private String university;
	private String fieldOfStudy;

	public UniversityThesis(int id, String title, String author, LocalDate publicationDate, int pagesNumber,
			String university, String fieldOfStudy) {
		setId(id);
		setTitle(title);
		setAuthor(author);
		setPublicationDate(publicationDate);
		setPagesNumber(pagesNumber);
		setUniversity(university);
		setFieldOfStudy(fieldOfStudy);
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

	@Override
	public void reserve() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelReservation() {
		// TODO Auto-generated method stub

	}

	public void displayDetails() {
		System.out.printf(
				"%-20s | %-15s | %-20s | %-20s | %-25s | %-15s | %-10s | University: %-15s | Field of Study: %-15s%n",
				"University Thesis", getId(), getTitle(), getAuthor(), DateUtils.toHumanDate(getPublicationDate()),
				getPagesNumber(), isBorrowed() ? "YES" : "NO", university, fieldOfStudy);
	}

}
