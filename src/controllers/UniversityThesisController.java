package controllers;

import java.time.LocalDate;
import java.util.List;

import models.UniversityThesis;
import services.UniversityThesisImpl;

public class UniversityThesisController {
	public void index() {
		UniversityThesisImpl universityThesisImpl = new UniversityThesisImpl();
		List<UniversityThesis> list = universityThesisImpl.displayUniversityTheses();

		list.stream().forEach(elm -> elm.displayDetails());

	}

	public void store(String title, String author, LocalDate publicationDate, int pagesNumber, String university,
			String fieldOfStudy) {
		UniversityThesis document = new UniversityThesis(0, title, author, publicationDate, pagesNumber, university,
				fieldOfStudy);

		UniversityThesisImpl universityThesisImpl = new UniversityThesisImpl();
		universityThesisImpl.addUniversityThesis(document);
	}

	public void update(String title, String author, LocalDate publicationDate, int pagesNumber, String university,
			String fieldOfStudy) {
		UniversityThesis document = new UniversityThesis(0, title, author, publicationDate, pagesNumber, university,
				fieldOfStudy);

		UniversityThesisImpl documentImpl = new UniversityThesisImpl();
		documentImpl.updateUniversityThesis(document);
	}
}
