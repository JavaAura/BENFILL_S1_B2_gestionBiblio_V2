package controllers;

import views.DocumentView;
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
				choice = DocumentController.borrowDocument();
				break;
			case 2:
				choice = DocumentController.returnDocument();
				break;
			case 3:
				choice = DocumentController.cancelReservation();
				break;
			case 4:
				choice = DocumentController.displayDocuments();
				break;
			case 5:
				choice = DocumentController.searchForDocument();
				break;
			case 6:
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
				choice = DocumentController.borrowDocument();
				break;
			case 2:
				choice = DocumentController.returnDocument();
				break;
			case 3:
				choice = DocumentController.cancelReservation();
				break;
			case 4:
				choice = DocumentController.displayDocuments();
				break;
			case 5:
				choice = DocumentController.searchForDocument();
				break;
			case 6:
				new DocumentView();
				choice = 0;
				break;
			case 7:
				new User();
				choice = 0;
				break;
			case 8:
				AppController.running = false;
				System.out.println("Exiting the application...");
				break;
			}
		}
	}

}
