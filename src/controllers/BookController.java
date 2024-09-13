package controllers;

import java.time.LocalDate;
import java.util.List;

import models.Book;
import services.BookImpl;

public class BookController {

	public void index() {
		BookImpl bookImpl = new BookImpl();
		List<Book> booksList = bookImpl.displayBooks();

		booksList.stream().forEach(book -> book.displayDetails());

	}

	public void store(String title, String author, LocalDate publicationDate, int pagesNumber, String isbn) {
		Book book = new Book(0, title, author, publicationDate, pagesNumber, isbn);

		BookImpl bookImpl = new BookImpl();
		bookImpl.addBook(book);
	}

	public void update(String title, String author, LocalDate publicationDate, int pagesNumber, String isbn) {
		Book book = new Book(0, title, author, publicationDate, pagesNumber, isbn);

		BookImpl bookImpl = new BookImpl();
		bookImpl.updateBook(book);
	}

}
