package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import db.DbRequest;
import models.Document;
import models.Magazine;
import services.MagazineImpl;

public class MagazineController {

	public static void index() {
		MagazineImpl magazineImpl = new MagazineImpl();
		List<Magazine> list = magazineImpl.displayMagazines();

		list.stream().forEach(magazine -> magazine.displayDetails());

	}

	public void store(String title, String author, LocalDate publicationDate, int pagesNumber, int number) {
		Magazine document = new Magazine(0, title, author, publicationDate, pagesNumber, number, false);

		MagazineImpl magazineImpl = new MagazineImpl();
		magazineImpl.addMagazine(document);
	}

	public void update(Magazine magzine) {
		MagazineImpl documentImpl = new MagazineImpl();
		documentImpl.updateMagazine(magzine);
	}

	public static Document getDocumentByTitle(String title) {
		Object[] value = { title };
		ResultSet rs = DbRequest.getAll("magazines", "title=?", value);

		if (!DbRequest.hasResults(rs))
			return null;

		Magazine magazine = null;
		try {
			LocalDate date = LocalDate.parse(rs.getString("publicationDate"));
			magazine = new Magazine(rs.getInt("id"), title, rs.getString("author"), date, rs.getInt("pagesNumber"),
					rs.getInt("number"), rs.getBoolean("borrowed"));
		} catch (SQLException e) {

		}
		return magazine;
	}

}
