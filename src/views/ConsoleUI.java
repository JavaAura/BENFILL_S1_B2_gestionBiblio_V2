package views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI {
	public static Scanner scanner = new Scanner(System.in);

	public static int getUserInputInteger(String label, String textToPrint, boolean optional) {
		int input = 0;
		boolean checker = false;
		while (!checker) {
			System.out.print(textToPrint + ": ");
			if (scanner.hasNextInt()) {
				input = scanner.nextInt();
				checker = true;
			} else if (!optional) {
				System.out.println(label + " cannot be empty. " + textToPrint + ": ");
				scanner.next();
			}
		}
		scanner.nextLine();
		return input;
	}

	public static String getUserInputString(String label, String textToPrint, boolean optional) {
		String input = "";
		while (input.isEmpty()) {
			System.out.print(textToPrint + ": ");
			input = scanner.nextLine();
			if (input.isEmpty() && !optional)
				System.out.println(label + " cannot be empty. " + textToPrint + ": ");
			else
				break;
		}
		return input;
	}

	public static LocalDate getUserInputDate(String label, String textToPrint, boolean optional) {
		LocalDate date = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		while (date == null) {
			System.out.print(textToPrint + " (format: yyyy-MM-dd): ");
			String input = scanner.nextLine();

			// If optional and input is empty, return null
			if (input.isEmpty() && optional) {
				break;
			}

			try {
				// Parse the input to LocalDate
				date = LocalDate.parse(input, formatter);

				// Check if the date is today or in the future
				if (!date.isBefore(LocalDate.now())) {
					System.out.println("The date cannot be today or in the future. Please try again.");
					date = null; // Reset the date so the loop continues
				}
			} catch (DateTimeParseException e) {
				System.out.println("Invalid date format. Please enter the date in 'yyyy-MM-dd' format.");
			}
		}

		return date;
	}

	public static int checkChoice(int holder, int defaultChoice, int min, int max) {
		if (holder >= min && holder <= max)
			return holder;
		return defaultChoice;
	}

	public static void clear() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				new ProcessBuilder("clear").inheritIO().start().waitFor();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void tableStyleUp() {
		System.out.println(" ");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-20s | %-15s | %-20s | %-20s | %-25s | %-15s | %-10s | %-40s |%n", "Type", "ID", "Title",
				"Author", "Publication Date", "Pages Number", "Borrowed", "More Details");

		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	public static void tableStyleDown() {
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(" ");
	}
}
