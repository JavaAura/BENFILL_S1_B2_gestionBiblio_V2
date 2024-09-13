package services;

import dao.StudentDao;
import db.DbRequest;
import models.Student;

public class StudentImpl implements StudentDao {

	@Override
	public void addStudent(Student student) {
		String columns = "name, email, academicLevel";
		Object[] values = { student.getName(), student.getEmail(), student.getAcademicLevel() };
		DbRequest.insert("students", columns, values);
	}

	@Override
	public void displayStudents() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStudent(Student student) {
		String columns = "name, email, academicLevel";
		Object[] values = { student.getName(), student.getEmail(), student.getAcademicLevel() };
		DbRequest.update("students", student.getId(), columns, values);

	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub

	}

}