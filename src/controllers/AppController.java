package controllers;

import views.RoleChoosing;

public class AppController {

	public static boolean running = true;
	public static String role;
	public int choice;

	public AppController() {
		RoleChoosing roleChoosing = new RoleChoosing();
		choice = roleChoosing.getChoice();
		while (running) {
			switch (choice) {
			case 1:
				role = "student";
				new LibraryController(role);
				break;
			case 2:
				role = "professor";
				new LibraryController(role);
				break;
			case 3:
				running = false;
				System.out.println("Exiting the application...");
				break;
			}
		}
	}
}
