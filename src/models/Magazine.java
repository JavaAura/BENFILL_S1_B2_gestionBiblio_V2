package models;

import java.util.ArrayList;

public class Magazine extends Document implements Borrowable, Reservable {
	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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
	public void reserve() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelReservation() {
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
