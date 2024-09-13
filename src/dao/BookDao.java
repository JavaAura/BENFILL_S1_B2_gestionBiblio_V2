package dao;

import java.util.List;

import models.Book;

public interface BookDao {

	public abstract void addBook(Book book);

	public abstract List<Book> displayBooks();

	public abstract void updateBook(Book book);

	public abstract void deleteBook(Book book);
}
