package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	public List<Student> displayStudents() {
		ResultSet rs = DbRequest.getAll("students", "", null);
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			while (rs != null && rs.next()) {
				Student student = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("academicLevel"));
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					Statement stmt = rs.getStatement();
					rs.close();
					if (stmt != null) {
						stmt.close();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	@Override
	public Boolean updateStudent(Student student) {
		Object[] value = { student.getId() };
		ResultSet rs = DbRequest.getAll("students", "id=?", value);
		Boolean checker = DbRequest.hasResults(rs);
		if (checker) {
			String columns = "name, email, academicLevel";
			try {

				Object[] values = { student.getName().isEmpty() ? rs.getString("name") : student.getName(),
						student.getEmail().isEmpty() ? rs.getString("email") : student.getEmail(),
						student.getAcademicLevel().isEmpty() ? rs.getString("academicLevel")
								: student.getAcademicLevel() };
				DbRequest.update("students", student.getId(), columns, values);
			} catch (Exception e) {
//				Logger.err
				return false;
			}
		} else
			return false;
		return true;

	}

	@Override
	public Boolean deleteStudent(Student student) {
		Object[] value = { student.getId() };
		ResultSet rs = DbRequest.getAll("students", "id=?", value);
		Boolean checker = DbRequest.hasResults(rs);
		if (checker)
			DbRequest.delete("students", student.getId());
		else
			return false;
		return true;

	}

}