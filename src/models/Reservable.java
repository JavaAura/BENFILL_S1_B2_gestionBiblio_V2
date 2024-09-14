package models;

public interface Reservable {
	public void reserve(int userId, int documentId);;

	public void cancelReservation(int id);
}
