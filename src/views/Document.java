package views;

import java.time.LocalDate;

import controllers.BookController;
import controllers.MagazineController;
import controllers.ScientificJournalController;
import controllers.UniversityThesisController;

public class Document {

	private int choice;
	private String title;
	private String author;
	private LocalDate date;
	private int pagesNumber;

	public Document() {
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|      ✨ Document Management Menu ✨       |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|  1. 📄 Add a document                    |");
		System.out.println("|  2. 🔄 Update a document                 |");
		System.out.println("|  3. ❌ delete a document                 |");
		System.out.println("|  4. 🔙 Back                              |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.println("Please enter your choice (1-4): ");
		System.out.println("============================================");

		int inputHolder = ConsoleUI.getUserInputInteger("Document Management Choice", "Enter Your Choice", false);
		int choiceHolder = ConsoleUI.checkChoice(inputHolder, 4, 1, 4);
		setChoice(choiceHolder);

		switch (choice) {
		case 1:
			addDocument();
			break;
		case 2:
			updateDocument();
			break;
		case 3:
			break;
		case 4:
			break;
		}
	}

	private void updateDocument() {

	}

	private void addDocument() {
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|      ✨ Document Management Menu ✨       |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|  1. 📄 Add a Book                        |");
		System.out.println("|  2. 📄 add a Magazine          	       |");
		System.out.println("|  3. 📄 add an University Thesis          |");
		System.out.println("|  4. 📄 add a Scientific Journal          |");
		System.out.println("|  5. 🔙 Back                              |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.println("Please enter your choice (1-5): ");
		System.out.println("============================================");

		int inputHolder = ConsoleUI.getUserInputInteger("Management Menu Choice", "Enter Your Choice", false);
		int choiceHolder = ConsoleUI.checkChoice(inputHolder, 5, 1, 5);

		title = ConsoleUI.getUserInputString("title", "Enter a title for the document", false);
		author = ConsoleUI.getUserInputString("author", "Enter the author's name", false);
		date = ConsoleUI.getUserInputDate("date", "Enter the publication date (YYYY-MM-DD)", false);
		pagesNumber = Integer.parseInt(ConsoleUI.getUserInputString("pagesNumber", "Enter the number of pages", false));

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
			String researchField = ConsoleUI.getUserInputString("Research Field",
					"Enter the Research Field of the Scientific Journal", false);
			ScientificJournalController sJournalController = new ScientificJournalController();
			sJournalController.store(title, author, date, pagesNumber, researchField);
			break;
		case 5:
			break;
		}
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

}
