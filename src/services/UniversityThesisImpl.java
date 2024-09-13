package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.UniversityThesisDao;
import db.DbRequest;
import models.UniversityThesis;

public class UniversityThesisImpl implements UniversityThesisDao {

	@Override
	public void addUniversityThesis(UniversityThesis universityThesis) {
		String columns = "title, author, publicationDate, pagesNumber, fieldOfStudy, university, type";
		Object[] values = { universityThesis.getTitle(), universityThesis.getAuthor(),
				universityThesis.getPublicationDate(), universityThesis.getPagesNumber(),
				universityThesis.getFieldOfStudy(), universityThesis.getUniversity(), "universityThesis" };
		DbRequest.insert("university_theses", columns, values);

	}

	@Override
	public List<UniversityThesis> displayUniversityTheses() {
		ResultSet rs = DbRequest.getAll("university_theses", "", null);
		ArrayList<UniversityThesis> list = new ArrayList<UniversityThesis>();
		try {
			while (rs != null && rs.next()) {
				LocalDate date = LocalDate.parse(rs.getString("publicationDate"));
				UniversityThesis universityThesis = new UniversityThesis(rs.getInt("id"), rs.getString("title"),
						rs.getString("author"), date, rs.getInt("pagesNumber"), rs.getString("university"),
						rs.getString("fieldOfStudy"));
				list.add(universityThesis);
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
	public void updateUniversityThesis(UniversityThesis universityThesis) {
		String columns = "title, author, publicationDate, pagesNumber, fieldOfStudy, university, borrowed";
		Object[] values = { universityThesis.getTitle(), universityThesis.getAuthor(),
				universityThesis.getPublicationDate(), universityThesis.getPagesNumber(),
				universityThesis.getFieldOfStudy(), universityThesis.getUniversity() };
		DbRequest.update("university_theses", universityThesis.getId(), columns, values);

	}

	@Override
	public void deleteUniversityThesis(UniversityThesis universityThesis) {
		DbRequest.delete("university_theses", universityThesis.getId());

	}

}
