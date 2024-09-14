package controllers;

import java.sql.ResultSet;
import java.time.LocalDate;

import db.DbRequest;
import models.Book;
import models.Magazine;
import models.ScientificJournal;
import models.UniversityThesis;
import views.ConsoleUI;
import views.Document;

public class DocumentController {

	public void reserveDocument() {

	}

	public static void updateDocument(int choice) {
		String title = ConsoleUI.getUserInputString("Title", "Enter the Title of the document you want to update",
				false);

		// Step 2: Retrieve current document details
		models.Document document = null;
		switch (choice) {
		case 1: // Book
			BookController bController = new BookController();
			document = bController.getDocumentByTitle(title);
			break;
		case 2: // Magazine
			MagazineController mController = new MagazineController();
			document = mController.getDocumentByTitle(title);
			break;
		case 3: // University Thesis
			UniversityThesisController uController = new UniversityThesisController();
			document = uController.getDocumentByTitle(title);
			break;
		case 4: // Scientific Journal
			ScientificJournalController sJournalController = new ScientificJournalController();
			document = sJournalController.getDocumentByTitle(title);
			break;
		default:
			System.out.println("Invalid choice.");
			return;
		}

		if (document == null) {
			System.out.println("Document not found.");
			return;
		}

		// Step 3: Display current details and get new details from user
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

		// Update the document with new values or keep old values
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

		// Step 4: Update specific fields based on document type
		switch (choice) {
		case 1: // Book
			String newIsbn = ConsoleUI.getUserInputString("ISBN", "Enter new ISBN (or press Enter to keep current)",
					true);
			if (!newIsbn.isEmpty()) {
				((Book) document).setIsbn(newIsbn);
			}
			BookController bController = new BookController();
			bController.update((Book) document);
			break;
		case 2: // Magazine
			Integer newNumber = ConsoleUI.getUserInputInteger("Number",
					"Enter new number (or press Enter to keep current)", true);
			if (newNumber != -1) {
				((Magazine) document).setNumber(newNumber);
			}
			MagazineController mController = new MagazineController();
			mController.update((Magazine) document);
			break;
		case 3: // University Thesis
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
		case 4: // Scientific Journal
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
			Document.addDocument();
			break;
		case 2:
			Document.updateDocument();
			break;
		case 3:
			Document.DeleteDocument();
			break;
		}
	}

	public static void displayDocuments() {
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
	}

	public static void deleteDocument(int choice) {
		String title = ConsoleUI.getUserInputString("Title", "Enter the Title of the document you want to delete",
				false);

		// Step 2: Retrieve current document details
		models.Document document = null;
		String table = null;
		switch (choice) {
		case 1: // Book
			BookController bController = new BookController();
			document = bController.getDocumentByTitle(title);
			table = "books";
			break;
		case 2: // Magazine
			MagazineController mController = new MagazineController();
			document = mController.getDocumentByTitle(title);
			table = "magazines";
			break;
		case 3: // University Thesis
			UniversityThesisController uController = new UniversityThesisController();
			document = uController.getDocumentByTitle(title);
			table = "university_theses";
			break;
		case 4: // Scientific Journal
			ScientificJournalController sJournalController = new ScientificJournalController();
			document = sJournalController.getDocumentByTitle(title);
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

		// Step 3: Display current details and get new details from user
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
}
