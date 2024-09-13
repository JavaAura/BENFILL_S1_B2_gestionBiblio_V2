package controllers;

import java.time.LocalDate;
import java.util.List;

import models.Magazine;
import services.MagazineImpl;

public class MagazineController {

	public void index() {
		MagazineImpl magazineImpl = new MagazineImpl();
		List<Magazine> list = magazineImpl.displayMagazines();

		list.stream().forEach(magazine -> magazine.displayDetails());

	}

	public void store(String title, String author, LocalDate publicationDate, int pagesNumber, int number) {
		Magazine document = new Magazine(0, title, author, publicationDate, pagesNumber, number);

		MagazineImpl magazineImpl = new MagazineImpl();
		magazineImpl.addMagazine(document);
	}

	public void update(String title, String author, LocalDate publicationDate, int pagesNumber, int number) {
		Magazine document = new Magazine(0, title, author, publicationDate, pagesNumber, number);

		MagazineImpl documentImpl = new MagazineImpl();
		documentImpl.updateMagazine(document);
	}

}
