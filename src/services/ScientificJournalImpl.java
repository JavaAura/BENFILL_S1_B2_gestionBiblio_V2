package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.ScientificJournalDao;
import db.DbRequest;
import models.ScientificJournal;

public class ScientificJournalImpl implements ScientificJournalDao {

	@Override
	public void addScientificJournal(ScientificJournal scientificJournal) {
		String columns = "title, author, publicationDate, pagesNumber, researchField, type";
		Object[] values = { scientificJournal.getTitle(), scientificJournal.getAuthor(),
				scientificJournal.getPublicationDate(), scientificJournal.getPagesNumber(),
				scientificJournal.getResearchField(), "scientificJournal" };
		DbRequest.insert("scientific_journals", columns, values);
	}

	@Override
	public List<ScientificJournal> displayScientificJournals() {
		ResultSet rs = DbRequest.getAll("scientific_journals", "", null);
		ArrayList<ScientificJournal> list = new ArrayList<ScientificJournal>();
		try {
			while (rs != null && rs.next()) {
				LocalDate date = LocalDate.parse(rs.getString("publicationDate"));
				ScientificJournal scientificJournal = new ScientificJournal(rs.getInt("id"), rs.getString("title"),
						rs.getString("author"), date, rs.getInt("pagesNumber"), rs.getString("researchField"),
						rs.getBoolean("borrowed"));
				list.add(scientificJournal);
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
	public void updateScientificJournal(ScientificJournal scientificJournal) {
		String columns = "title, author, publicationDate, pagesNumber, researchField, borrowed";
		Object[] values = { scientificJournal.getTitle(), scientificJournal.getAuthor(),
				scientificJournal.getPublicationDate(), scientificJournal.getPagesNumber(),
				scientificJournal.getResearchField(), scientificJournal.isBorrowed() };
		DbRequest.update("scientific_journals", scientificJournal.getId(), columns, values);
	}

	@Override
	public void deleteScientificJournal(ScientificJournal scientificJournal) {
		DbRequest.delete("scientific_journals", scientificJournal.getId());

	}

}
