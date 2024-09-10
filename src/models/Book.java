package models;

import java.util.ArrayList;

public class Book extends Document implements Borrowable {
	private String isbn;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public void borrow() {
		// TODO Auto-generated method stub

	}

	@Override
	public void returnItem() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<?> index() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void store() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}
}
