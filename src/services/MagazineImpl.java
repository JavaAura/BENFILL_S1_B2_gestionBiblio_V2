package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.MagazineDao;
import db.DbRequest;
import models.Magazine;

public class MagazineImpl implements MagazineDao {

	@Override
	public void addMagazine(Magazine magazine) {
		String columns = "title, author, publicationDate, pagesNumber, number, type";
		Object[] values = { magazine.getTitle(), magazine.getAuthor(), magazine.getPublicationDate(),
				magazine.getPagesNumber(), magazine.getNumber(), "magazine" };
		DbRequest.insert("magazines", columns, values);

	}

	@Override
	public List<Magazine> displayMagazines() {
		ResultSet rs = DbRequest.getAll("magazines", "", null);
		ArrayList<Magazine> list = new ArrayList<Magazine>();
		try {
			while (rs != null && rs.next()) {
				LocalDate date = LocalDate.parse(rs.getString("publicationDate"));
				Magazine magazine = new Magazine(rs.getInt("id"), rs.getString("title"), rs.getString("author"), date,
						rs.getInt("pagesNumber"), rs.getInt("number"), rs.getBoolean("borrowed"));
				list.add(magazine);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Make sure to close the ResultSet and the associated Statement
			try {
				if (rs != null) {
					Statement stmt = rs.getStatement(); // Retrieve statement before closing ResultSet
					rs.close();
					if (stmt != null) {
						stmt.close(); // Close the statement
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	@Override
	public void updateMagazine(Magazine magazine) {
		String columns = "title, author, publicationDate, pagesNumber, number";
		Object[] values = { magazine.getTitle(), magazine.getAuthor(), magazine.getPublicationDate(),
				magazine.getPagesNumber(), magazine.getNumber() };
		DbRequest.update("magazines", magazine.getId(), columns, values);

	}

	@Override
	public void deleteMagazine(Magazine magazine) {
		DbRequest.delete("magazines", magazine.getId());

	}

}
