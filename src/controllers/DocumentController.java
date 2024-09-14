package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import db.DbRequest;
import models.Book;
import models.Document;
import models.Magazine;
import models.ScientificJournal;
import models.UniversityThesis;
import views.ConsoleUI;
import views.DocumentView;

public class DocumentController {

	public static int borrowDocument() {
		String title = ConsoleUI.getUserInputString("Title", "Enter the Title of the document you want to borrow",
				false);
		Object[] value = { title };

		ResultSet dSet = DbRequest.getAll("documents", "title=?", value);

		if (!DbRequest.hasResults(dSet)) {
			System.out.println("Document not found.");
			return 0;
		}

		String type = "";
		try {
			type = dSet.getString("type");
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

		Document document = null;
		switch (type) {
		case "book":
			document = BookController.getDocumentByTitle(title);
			break;
		case "magazine":
			document = MagazineController.getDocumentByTitle(title);
			break;
		case "universityThesis":
			document = UniversityThesisController.getDocumentByTitle(title);
			break;
		case "scientificJournal":
			document = ScientificJournalController.getDocumentByTitle(title);
			break;
		}

		System.out.println("Current details:");
		System.out.println("Title: " + document.getTitle());
		System.out.println("Author: " + document.getAuthor());
		System.out.println("Publication Date: " + document.getPublicationDate());
		System.out.println("Number of Pages: " + document.getPagesNumber());

		String response = ConsoleUI.getUserInputString("Confirmation", "Do you want to borrow this Document? (y/n)",
				false);
		if (!response.equalsIgnoreCase("y")) {
			System.out.println("Update operation cancelled.");
			return 0;
		}

		int documentId = document.getId();
		Boolean isBorrowed = document.isBorrowed();

		if (isBorrowed) {
			response = ConsoleUI.getUserInputString("Reservation",
					"This Document is borrowed do you want to reserve this Document? (y/n)", false);
			if (!response.equalsIgnoreCase("y")) {
				System.out.println("Borrow operation cancelled.");
				return 0;
			}
		}

		ResultSet uSet = null;
		boolean userFound = false;
		while (!userFound) {
			String name = ConsoleUI.getUserInputString("Name",
					"Enter the User Name of the User who want to borrow this Document", false);
			Object[] value2 = { name };
			uSet = DbRequest.getAll("users", "name=?", value2);

			if (DbRequest.hasResults(uSet)) {
				userFound = true;
			} else {
				System.out.println("User not found.");
				response = ConsoleUI.getUserInputString("Username", "Try Again? (y/n)", false);
				if (!response.equalsIgnoreCase("y")) {
					System.out.println("Update operation cancelled.");
					return 0;
				}
			}
		}

		int userId;

		try {
			userId = uSet.getInt("id");
			System.out.println("User found:");
			System.out.println("Name: " + uSet.getString("name"));
			System.out.println("Email: " + uSet.getString("email"));
		} catch (

		SQLException e) {
			e.printStackTrace();
			return 0;
		}

		response = ConsoleUI.getUserInputString("Confirmation", "Do you want to choose this user? (y/n)", false);
		if (!response.equalsIgnoreCase("y")) {
			System.out.println("Update operation cancelled.");
			return 0;
		}

		switch (type) {
		case "book":
			if (isBorrowed)
				document.reserve(userId, documentId);
			else
				document.borrow(userId, documentId);
			break;
		case "magazine":
			if (isBorrowed)
				document.reserve(userId, documentId);
			else
				document.borrow(userId, documentId);
			break;
		case "universityThesis":
			if (isBorrowed)
				document.reserve(userId, documentId);
			else
				document.borrow(userId, documentId);
			break;
		case "scientificJournal":
			if (isBorrowed)
				document.reserve(userId, documentId);
			else
				document.borrow(userId, documentId);
			break;

		}

		if (isBorrowed)
			System.out.println("Document reserved successfully.");
		else
			System.out.println("Document borrowed successfully.");
		return 0;

	}

	public static void updateDocument(int choice) {
		String title = ConsoleUI.getUserInputString("Title", "Enter the Title of the document you want to update",
				false);
		Document document = null;
		switch (choice) {
		case 1:
			document = BookController.getDocumentByTitle(title);
			break;
		case 2:
			document = MagazineController.getDocumentByTitle(title);
			break;
		case 3:
			document = UniversityThesisController.getDocumentByTitle(title);
			break;
		case 4:
			document = ScientificJournalController.getDocumentByTitle(title);
			break;
		default:
			System.out.println("Invalid choice.");
			return;
		}

		if (document == null) {
			System.out.println("Document not found.");
			return;
		}

		System.out.println("Current details:");
		System.out.println("Title: " + document.getTitle());
		System.out.println("Author: " + document.getAuthor());
		System.out.println("Publication Date: " + document.getPublicationDate());
		System.out.println("Number of Pages: " + document.getPagesNumber());

		String response = ConsoleUI.getUserInputString("Confirmation", "Do you want to update this Document? (y/n)",
				false);
		if (!response.equalsIgnoreCase("y")) {
			System.out.println("Update operation cancelled.");
			return;
		}

		String newTitle = ConsoleUI.getUserInputString("Title", "Enter new title (or press Enter to keep current)",
				true);
		String newAuthor = ConsoleUI.getUserInputString("Author", "Enter new author (or press Enter to keep current)",
				true);
		LocalDate newDate = ConsoleUI.getUserInputDate("Date",
				"Enter new publication date (YYYY-MM-DD) (or press Enter to keep current)", true);
		Integer newPagesNumber = ConsoleUI.getUserInputInteger("Pages Number",
				"Enter new number of pages (or press Enter to keep current)", true);
		newPagesNumber = newPagesNumber == -1 ? null : newPagesNumber;

		if (!newTitle.isEmpty()) {
			document.setTitle(newTitle);
		}
		if (!newAuthor.isEmpty()) {
			document.setAuthor(newAuthor);
		}
		if (newDate != null) {
			document.setPublicationDate(newDate);
		}
		if (newPagesNumber != null) {
			document.setPagesNumber(newPagesNumber);
		}

		switch (choice) {
		case 1:
			String newIsbn = ConsoleUI.getUserInputString("ISBN", "Enter new ISBN (or press Enter to keep current)",
					true);
			if (!newIsbn.isEmpty()) {
				((Book) document).setIsbn(newIsbn);
			}
			BookController bController = new BookController();
			bController.update((Book) document);
			break;
		case 2:
			Integer newNumber = ConsoleUI.getUserInputInteger("Number",
					"Enter new number (or press Enter to keep current)", true);
			if (newNumber != -1) {
				((Magazine) document).setNumber(newNumber);
			}
			MagazineController mController = new MagazineController();
			mController.update((Magazine) document);
			break;
		case 3:
			String newUniversity = ConsoleUI.getUserInputString("University",
					"Enter new University (or press Enter to keep current)", true);
			String newFieldOfStudy = ConsoleUI.getUserInputString("Field of Study",
					"Enter new Field of Study (or press Enter to keep current)", true);
			if (!newUniversity.isEmpty()) {
				((UniversityThesis) document).setUniversity(newUniversity);
			}
			if (!newFieldOfStudy.isEmpty()) {
				((UniversityThesis) document).setFieldOfStudy(newFieldOfStudy);
			}
			UniversityThesisController uController = new UniversityThesisController();
			uController.update((UniversityThesis) document);
			break;
		case 4:
			String newResearchField = ConsoleUI.getUserInputString("Research Field",
					"Enter new Research Field (or press Enter to keep current)", true);
			if (!newResearchField.isEmpty()) {
				((ScientificJournal) document).setResearchField(newResearchField);
			}
			ScientificJournalController sJournalController = new ScientificJournalController();
			sJournalController.update((ScientificJournal) document);
			break;
		}

		System.out.println("Document updated successfully.");
	}

	public static void addDocument(int choiceHolder) {
		String title = ConsoleUI.getUserInputString("title", "Enter a title for the document", false);
		String author = ConsoleUI.getUserInputString("author", "Enter the author's name", false);
		LocalDate date = ConsoleUI.getUserInputDate("date", "Enter the publication date (YYYY-MM-DD)", false);
		int pagesNumber = ConsoleUI.getUserInputInteger("pagesNumber", "Enter the number of pages", false);

		switch (choiceHolder) {
		case 1:
			BookController bController = new BookController();
			String isbn = ConsoleUI.getUserInputString("author", "Enter the isbn", false);
			bController.store(title, author, date, pagesNumber, isbn);
			break;
		case 2:
			MagazineController mController = new MagazineController();
			int number = ConsoleUI.getUserInputInteger("number", "Enter the number of the magazine", false);
			mController.store(title, author, date, pagesNumber, number);
			break;
		case 3:
			String university = ConsoleUI.getUserInputString("University", "Enter the University", false);
			String fieldOfStudy = ConsoleUI.getUserInputString("Field of Study", "Enter the Field of Study", false);
			UniversityThesisController uController = new UniversityThesisController();
			uController.store(title, author, date, pagesNumber, university, fieldOfStudy);
			break;
		case 4:
			String textToPrint = "Enter the Research Field of the Scientific Journal";
			String researchField = ConsoleUI.getUserInputString("Research Field", textToPrint, false);
			ScientificJournalController sJournalController = new ScientificJournalController();
			sJournalController.store(title, author, date, pagesNumber, researchField);
			break;
		}
	}

	public static void manageDocument(int choice) {
		switch (choice) {
		case 1:
			DocumentView.addDocument();
			break;
		case 2:
			DocumentView.updateDocument();
			break;
		case 3:
			DocumentView.DeleteDocument();
			break;
		}
	}

	public static int displayDocuments() {
		ResultSet rs = DbRequest.getAll("documents", "", null);

		Boolean checker = DbRequest.hasResults(rs);
		if (checker) {
			ConsoleUI.tableStyleUp();
			BookController.index();
			MagazineController.index();
			ScientificJournalController.index();
			UniversityThesisController.index();
			ConsoleUI.tableStyleDown();
		} else
			System.out.println("There is no document yet");

		ConsoleUI.getUserInputInteger("Main Menu Choice", "Enter 0 to Return Back to Home", true);
		return 0;
	}

	public static void deleteDocument(int choice) {
		String title = ConsoleUI.getUserInputString("Title", "Enter the Title of the document you want to delete",
				false);

		models.Document document = null;
		String table = null;
		switch (choice) {
		case 1:
			document = BookController.getDocumentByTitle(title);
			table = "books";
			break;
		case 2:
			document = MagazineController.getDocumentByTitle(title);
			table = "magazines";
			break;
		case 3:
			document = UniversityThesisController.getDocumentByTitle(title);
			table = "university_theses";
			break;
		case 4:
			document = ScientificJournalController.getDocumentByTitle(title);
			table = "scientific_journals";
			break;
		default:
			System.out.println("Invalid choice.");
			return;
		}

		if (document == null) {
			System.out.println("Document not found.");
			return;
		}

		System.out.println("Current details:");
		System.out.println("Title: " + document.getTitle());
		System.out.println("Author: " + document.getAuthor());
		System.out.println("Publication Date: " + document.getPublicationDate());
		System.out.println("Number of Pages: " + document.getPagesNumber());

		String response = ConsoleUI.getUserInputString("Confirmation", "Do you want to delete this Document? (y/n)",
				false);
		if (!response.equalsIgnoreCase("y")) {
			System.out.println("Delete operation cancelled.");
			return;
		}

		DbRequest.delete(table, document.getId());
		System.out.println("Document deleted successfully.");

	}

	public static int searchForDocument() {
		String title = ConsoleUI.getUserInputString("Title", "Please Enter Document Title", false);

		ConsoleUI.tableStyleUp();

		Book book = (Book) BookController.getDocumentByTitle(title);
		if (book != null) {
			book.displayDetails();
		} else {
			Magazine magazine = (Magazine) MagazineController.getDocumentByTitle(title);
			if (magazine != null) {
				magazine.displayDetails();
			} else {
				ScientificJournal sJournal = (ScientificJournal) ScientificJournalController.getDocumentByTitle(title);
				if (sJournal != null) {
					sJournal.displayDetails();
				} else {
					UniversityThesis uThesis = (UniversityThesis) UniversityThesisController.getDocumentByTitle(title);
					if (uThesis != null) {
						uThesis.displayDetails();
					} else {
						System.out.println("Document not found.");
					}
				}
			}
		}

		ConsoleUI.tableStyleDown();
		ConsoleUI.getUserInputInteger("Main Menu Choice", "Enter 0 to Return Back to Home", true);
		return 0;
	}

	public static int returnDocument() {
		String title = ConsoleUI.getUserInputString("Title", "Enter the Title of the document you want to return",
				false);
		Object[] value = { title };

		ResultSet dSet = DbRequest.getAll("documents", "title=?", value);

		if (!DbRequest.hasResults(dSet)) {
			System.out.println("Document not found.");
			return 0;
		}

		String type = "";
		try {
			type = dSet.getString("type");
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

		Document document = null;
		switch (type) {
		case "book":
			document = BookController.getDocumentByTitle(title);
			break;
		case "magazine":
			document = MagazineController.getDocumentByTitle(title);
			break;
		case "universityThesis":
			document = UniversityThesisController.getDocumentByTitle(title);
			break;
		case "scientificJournal":
			document = ScientificJournalController.getDocumentByTitle(title);
			break;
		}

		System.out.println("Current details:");
		System.out.println("Title: " + document.getTitle());
		System.out.println("Author: " + document.getAuthor());
		System.out.println("Publication Date: " + document.getPublicationDate());
		System.out.println("Number of Pages: " + document.getPagesNumber());

		String response = ConsoleUI.getUserInputString("Confirmation", "Do you want to return this Document? (y/n)",
				false);
		if (!response.equalsIgnoreCase("y")) {
			System.out.println("Update operation cancelled.");
			return 0;
		}

		int documentId = document.getId();
		Boolean isBorrowed = document.isBorrowed();

		if (!isBorrowed) {
			ConsoleUI.getUserInputString("error", "Document is not borrowed yet. enter anything to return home", true);
			return 0;
		}

		ResultSet uSet = null;
		boolean userFound = false;
		while (!userFound) {
			String name = ConsoleUI.getUserInputString("Name",
					"Enter the User Name of the User who want to return this Document", false);
			Object[] value2 = { name };
			uSet = DbRequest.getAll("users", "name=?", value2);

			if (DbRequest.hasResults(uSet)) {
				userFound = true;
			} else {
				System.out.println("User not found.");
				response = ConsoleUI.getUserInputString("Username", "Try Again? (y/n)", false);
				if (!response.equalsIgnoreCase("y")) {
					System.out.println("Update operation cancelled.");
					return 0;
				}
			}
		}

		int userId;

		try {
			userId = uSet.getInt("id");
			System.out.println("User found:");
			System.out.println("Name: " + uSet.getString("name"));
			System.out.println("Email: " + uSet.getString("email"));
		} catch (

		SQLException e) {
			e.printStackTrace();
			return 0;
		}

		response = ConsoleUI.getUserInputString("Confirmation", "Do you want to choose this user? (y/n)", false);
		if (!response.equalsIgnoreCase("y")) {
			System.out.println("Update operation cancelled.");
			return 0;
		}

		Object[] condition = { userId, documentId };
		ResultSet bSet = DbRequest.getAll("borrowings", "user_id=? AND document_id=?", condition);
		if (!DbRequest.hasResults(bSet)) {
			System.out.println("This user is not borrowing this document. Try again...");
			return 0;
		}
		int id = 0;
		try {
			id = bSet.getInt("id");
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		switch (type) {
		case "book":
			document.returnItem(id);
		case "magazine":
			document.returnItem(id);
			break;
		case "universityThesis":
			document.returnItem(id);
			break;
		case "scientificJournal":
			document.returnItem(id);
			break;

		}
		System.out.println("Document returned successfully.");
		return 0;
	}

	public static int cancelReservation() {
		// TODO Auto-generated method stub
		return 0;
	}

}