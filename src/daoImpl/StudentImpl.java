package daoImpl;

import dao.StudentDao;
import db.DbRequest;

public class StudentImpl implements StudentDao {

	@Override
	public void createStudentTable() {
		DbRequest.createTable("students", "name varchar(255)");

	}

	@Override
	public void addStudent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayStudents() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStudent(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub

	}

}