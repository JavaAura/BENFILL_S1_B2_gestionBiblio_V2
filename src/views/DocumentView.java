package views;

import controllers.DocumentController;

public class DocumentView {

	private int choice;

	public DocumentView() {
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
		DocumentController.manageDocument(choice);

	}

	public static void updateDocument() {
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|      ✨ Document Management Menu ✨       |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|  1. 📄 update a Book                     |");
		System.out.println("|  2. 📄 update a Magazine          	       |");
		System.out.println("|  3. 📄 update an University Thesis       |");
		System.out.println("|  4. 📄 update a Scientific Journal       |");
		System.out.println("|  5. 🔙 Back                              |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.println("Please enter your choice (1-5): ");
		System.out.println("============================================");

		int inputHolder = ConsoleUI.getUserInputInteger("Management Menu Choice", "Enter Your Choice", false);
		int choiceHolder = ConsoleUI.checkChoice(inputHolder, 5, 1, 5);

		if (inputHolder > 0 && inputHolder < 5)
			DocumentController.updateDocument(choiceHolder);
	}

	public static void DeleteDocument() {
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|      ✨ Document Management Menu ✨       |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|  1. 📄 delete a Book                     |");
		System.out.println("|  2. 📄 delete a Magazine          	       |");
		System.out.println("|  3. 📄 delete an University Thesis       |");
		System.out.println("|  4. 📄 delete a Scientific Journal       |");
		System.out.println("|  5. 🔙 Back                              |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.println("Please enter your choice (1-5): ");
		System.out.println("============================================");

		int inputHolder = ConsoleUI.getUserInputInteger("Management Menu Choice", "Enter Your Choice", false);
		int choiceHolder = ConsoleUI.checkChoice(inputHolder, 5, 1, 5);
		if (inputHolder > 0 && inputHolder < 5)
			DocumentController.deleteDocument(choiceHolder);
	}

	public static void addDocument() {
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

		if (inputHolder > 0 && inputHolder < 5)
			DocumentController.addDocument(inputHolder);

	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

}
