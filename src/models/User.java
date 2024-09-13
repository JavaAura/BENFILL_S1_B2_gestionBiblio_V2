package models;

import java.util.ArrayList;

public abstract class User {

	private int id;
	private String name;
	private String email;

	public ArrayList<?> index() {
		return null;

	}

	public abstract void store();

	public abstract void update(int id);

	public abstract void delete(int id);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
