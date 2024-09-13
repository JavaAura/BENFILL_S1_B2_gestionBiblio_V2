package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ProfessorDao;
import db.DbRequest;
import models.Professor;

public class ProfessorImpl implements ProfessorDao {

	@Override
	public void addProfessor(Professor professor) {
		String columns = "name, email, academicLevel";
		Object[] values = { professor.getName(), professor.getEmail(), professor.getDepartment() };
		DbRequest.insert("professors", columns, values);
	}

	@Override
	public List<Professor> displayProfessors() {
		ResultSet rs = DbRequest.getAll("professors", "", null);
		ArrayList<Professor> list = new ArrayList<Professor>();
		try {
			while (rs != null && rs.next()) {
				Professor prof = new Professor(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("departement"));
				list.add(prof);
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
	public boolean updateProfessor(Professor professor) {
		Object[] value = { professor.getId() };
		ResultSet rs = DbRequest.getAll("professors", "id=?", value);
		Boolean checker = DbRequest.hasResults(rs);
		if (checker) {
			String columns = "name, email, department";
			try {

				Object[] values = { professor.getName().isEmpty() ? rs.getString("name") : professor.getName(),
						professor.getEmail().isEmpty() ? rs.getString("email") : professor.getEmail(),
						professor.getDepartment().isEmpty() ? rs.getString("department") : professor.getDepartment() };
				DbRequest.update("professors", professor.getId(), columns, values);
			} catch (Exception e) {
//				Logger.err
			}
		} else
			return false;
		return true;
	}

	@Override
	public Boolean deleteProfessor(Professor professor) {
		Object[] value = { professor.getId() };
		ResultSet rs = DbRequest.getAll("professors", "id=?", value);
		Boolean checker = DbRequest.hasResults(rs);
		if (checker)
			DbRequest.delete("professors", professor.getId());
		else
			return false;
		return true;

	}

}
