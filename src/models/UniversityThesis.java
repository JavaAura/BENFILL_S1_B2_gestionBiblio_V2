package models;

import java.util.ArrayList;

public class UniversityThesis extends Document implements Reservable {
	private String university;
	private String fieldOfStudy;

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

	@Override
	public ArrayList<?> index() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void store() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}
}
