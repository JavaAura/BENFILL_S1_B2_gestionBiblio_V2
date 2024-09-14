package views;

import controllers.UserController;

public class User {

	public User() {
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|      ✨ Document Management Menu ✨       |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|  1. 📄 Manage Students                   |");
		System.out.println("|  2. 🔄 Manage Professors                 |");
		System.out.println("|  3. 🔙 Back                              |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.println("Please enter your choice (1-4): ");
		System.out.println("============================================");

		int inputHolder = ConsoleUI.getUserInputInteger("User Management Choice", "Enter Your Choice", false);
		int choiceHolder = ConsoleUI.checkChoice(inputHolder, 3, 1, 3);
		UserController.manageUser(choiceHolder);
	}

	public static int manageStudent() {
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|      ✨ Document Management Menu ✨       |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|  1. 📄 Add a Student                     |");
		System.out.println("|  2. 🔄 Update a Student                  |");
		System.out.println("|  3. ❌ delete a Student                  |");
		System.out.println("|  4. 🔙 Back                              |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.println("Please enter your choice (1-4): ");
		System.out.println("============================================");

		int inputHolder = ConsoleUI.getUserInputInteger("Document Management Choice", "Enter Your Choice", false);
		int choiceHolder = ConsoleUI.checkChoice(inputHolder, 4, 1, 4);

		return choiceHolder;
	}

	public static int manageProfessor() {
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|      ✨ Document Management Menu ✨       |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|  1. 📄 Add a Professor                   |");
		System.out.println("|  2. 🔄 Update a Professor                |");
		System.out.println("|  3. ❌ delete a Professor                |");
		System.out.println("|  4. 🔙 Back                              |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.println("Please enter your choice (1-4): ");
		System.out.println("============================================");

		int inputHolder = ConsoleUI.getUserInputInteger("Document Management Choice", "Enter Your Choice", false);
		int choiceHolder = ConsoleUI.checkChoice(inputHolder, 4, 1, 4);
		return choiceHolder;

	}
}
