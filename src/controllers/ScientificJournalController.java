package controllers;

import java.time.LocalDate;
import java.util.List;

import models.ScientificJournal;
import services.ScientificJournalImpl;

public class ScientificJournalController {
	public void index() {
		ScientificJournalImpl magazineImpl = new ScientificJournalImpl();
		List<ScientificJournal> list = magazineImpl.displayScientificJournals();

		list.stream().forEach(magazine -> magazine.displayDetails());

	}

	public void store(String title, String author, LocalDate publicationDate, int pagesNumber, String researchField) {
		ScientificJournal document = new ScientificJournal(0, title, author, publicationDate, pagesNumber,
				researchField);

		ScientificJournalImpl magazineImpl = new ScientificJournalImpl();
		magazineImpl.addScientificJournal(document);
	}

	public void update(String title, String author, LocalDate publicationDate, int pagesNumber, String researchField) {
		ScientificJournal document = new ScientificJournal(0, title, author, publicationDate, pagesNumber,
				researchField);

		ScientificJournalImpl documentImpl = new ScientificJournalImpl();
		documentImpl.updateScientificJournal(document);
	}
}
