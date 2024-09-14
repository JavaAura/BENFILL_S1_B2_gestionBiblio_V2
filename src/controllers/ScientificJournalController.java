package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import db.DbRequest;
import models.Document;
import models.ScientificJournal;
import services.ScientificJournalImpl;

public class ScientificJournalController {
	public static void index() {
		ScientificJournalImpl magazineImpl = new ScientificJournalImpl();
		List<ScientificJournal> list = magazineImpl.displayScientificJournals();

		list.stream().forEach(magazine -> magazine.displayDetails());

	}

	public void store(String title, String author, LocalDate publicationDate, int pagesNumber, String researchField) {
		ScientificJournal document = new ScientificJournal(0, title, author, publicationDate, pagesNumber,
				researchField);

		ScientificJournalImpl magazineImpl = new ScientificJournalImpl();
		magazineImpl.addScientificJournal(document);
	}

	public void update(ScientificJournal document) {

		ScientificJournalImpl documentImpl = new ScientificJournalImpl();
		documentImpl.updateScientificJournal(document);
	}

	public Document getDocumentByTitle(String title) {
		Object[] value = { title };
		ResultSet rs = DbRequest.getAll("magazines", "title=?", value);

		if (!DbRequest.hasResults(rs))
			return null;

		ScientificJournal sj = null;
		try {
			LocalDate date = LocalDate.parse(rs.getString("publicationDate"));
			sj = new ScientificJournal(rs.getInt("id"), title, rs.getString("author"), date, rs.getInt("pagesNumber"),
					rs.getString("pagesNumber"));
		} catch (SQLException e) {

		}
		return sj;
	}
}
