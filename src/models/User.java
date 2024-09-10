package models;

import java.util.ArrayList;

public abstract class User {

	protected int id;
	protected String name;
	protected String email;

	public ArrayList<?> index() {
		return null;

	}

	public abstract void store();

	public abstract void update(int id);

	public abstract void delete(int id);
}
