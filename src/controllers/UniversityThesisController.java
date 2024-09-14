package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import db.DbRequest;
import models.Document;
import models.UniversityThesis;
import services.UniversityThesisImpl;

public class UniversityThesisController {
	public static void index() {
		UniversityThesisImpl universityThesisImpl = new UniversityThesisImpl();
		List<UniversityThesis> list = universityThesisImpl.displayUniversityTheses();

		list.stream().forEach(elm -> elm.displayDetails());

	}

	public void store(String title, String author, LocalDate publicationDate, int pagesNumber, String university,
			String fieldOfStudy) {
		UniversityThesis document = new UniversityThesis(0, title, author, publicationDate, pagesNumber, university,
				fieldOfStudy);

		UniversityThesisImpl universityThesisImpl = new UniversityThesisImpl();
		universityThesisImpl.addUniversityThesis(document);
	}

	public void update(UniversityThesis document) {
		UniversityThesisImpl documentImpl = new UniversityThesisImpl();
		documentImpl.updateUniversityThesis(document);
	}

	public Document getDocumentByTitle(String title) {
		Object[] value = { title };
		ResultSet rs = DbRequest.getAll("universityTheses", "title=?", value);

		if (!DbRequest.hasResults(rs))
			return null;

		UniversityThesis u = null;
		try {
			LocalDate date = LocalDate.parse(rs.getString("publicationDate"));
			u = new UniversityThesis(rs.getInt("id"), title, rs.getString("author"), date, rs.getInt("pagesNumber"),
					rs.getString("university"), rs.getString("fieldOfStudy"));
		} catch (SQLException e) {

		}
		return u;
	}
}
