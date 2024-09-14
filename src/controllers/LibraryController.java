package controllers;

import views.ConsoleUI;
import views.Document;
import views.ProfView;
import views.StudentView;
import views.User;

public class LibraryController {
	public int choice = 0;

	public LibraryController(String role) {
		if (role == "student") {
			System.out.println(role);
			displayStudentView();
		} else {
			displayProfView();
		}
	}

	public void displayStudentView() {
		while (AppController.running) {
			switch (choice) {
			case 0:
				StudentView sView = new StudentView();
				choice = sView.getChoice();
				break;
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:
				DocumentController.displayDocuments();
				ConsoleUI.getUserInputInteger("Main Menu Choice", "Enter 0 to Return Back to Home", false);
				choice = 0;
				break;
			case 6:

				break;
			case 7:
				AppController.running = false;
				System.out.println("Exiting the application...");
				break;
			}
		}
	}

	public void displayProfView() {
		while (AppController.running) {
			switch (choice) {
			case 0:
				ProfView profView = new ProfView();
				choice = profView.getChoice();
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:
				DocumentController.displayDocuments();
				ConsoleUI.getUserInputInteger("Main Menu Choice", "Enter 0 to Return Back to Home", false);
				choice = 0;
				break;
			case 6:

				break;
			case 7:
				new Document();
				choice = 0;
				break;
			case 8:
				new User();
				choice = 0;
				break;
			case 9:
				AppController.running = false;
				System.out.println("Exiting the application...");
				break;
			}
		}
	}

}
