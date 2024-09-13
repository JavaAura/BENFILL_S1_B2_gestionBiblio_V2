package models;

public class Professor extends User {
	private String department;

	public Professor(int id, String name, String email, String departement) {
		setId(id);
		setName(name);
		setEmail(email);
		setDepartment(departement);
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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
