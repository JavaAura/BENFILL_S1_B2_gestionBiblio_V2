package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	public static String toHumanDate(LocalDate publicationDate) {
		// Define the desired human-readable date format, e.g., "dd MMMM yyyy"
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		// Format the LocalDate using the formatter and return the result
		return publicationDate.format(formatter);
	}

}