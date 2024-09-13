package main;

import controllers.AppController;
import db.TableCreation;

public class Main {

	public static void main(String[] args) {
		startApp();
	}

	private static void startApp() {
		new TableCreation();
		new AppController();
	}
}
