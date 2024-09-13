package controllers;

import java.sql.ResultSet;

import db.DbRequest;
import views.ConsoleUI;

public class DocumentController {

	public void reserveDocument() {

	}

	public void updateDocument() {

	}

	public void displayDocuments() {
		ResultSet rs = DbRequest.getAll("documents", "", null);

		Boolean checker = DbRequest.hasResults(rs);
		if (checker) {
			BookController bController = new BookController();
			MagazineController mController = new MagazineController();
			ScientificJournalController sController = new ScientificJournalController();
			UniversityThesisController uController = new UniversityThesisController();

			ConsoleUI.tableStyleUp();
			bController.index();
			mController.index();
			sController.index();
			uController.index();
			ConsoleUI.tableStyleDown();
		} else
			System.out.println("There is no document yet");
	}

}
