package models;

public interface Borrowable {
	public void borrow(int userId, int documentId);;

	public void returnItem(int id);;
}
