package models;

public class Student extends User {

	private String academicLevel;

	public Student(int id, String name, String email, String academicLevel) {
		setId(id);
		setName(name);
		setEmail(email);
		setAcademicLevel(academicLevel);
	}

	public String getAcademicLevel() {
		return academicLevel;
	}

	public void setAcademicLevel(String academicLevel) {
		this.academicLevel = academicLevel;
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
