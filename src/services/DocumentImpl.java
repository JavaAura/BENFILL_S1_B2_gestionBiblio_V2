package services;

import java.sql.ResultSet;

import dao.DocumentDao;
import db.DbRequest;
import models.Document;

public class DocumentImpl implements DocumentDao {

	@Override
	public Document reservation(int id) {
		Object[] value = { id };
		ResultSet rs = DbRequest.getAll("documents", "id=?", value);
		Boolean checker = DbRequest.hasResults(rs);
		if (checker) {

		}
		return null;
	}

	public void displayAllDocuments() {
		ResultSet rs = DbRequest.getAll("documents", null, null);

		Boolean checker = DbRequest.hasResults(rs);
		if (checker) {

		}
		System.out.println("There is no document yet");
	}
}
