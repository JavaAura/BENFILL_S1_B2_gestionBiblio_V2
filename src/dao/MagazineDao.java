package dao;

import java.util.List;

import models.Magazine;

public interface MagazineDao {
	public abstract void addMagazine(Magazine magazine);

	public abstract List<Magazine> displayMagazines();

	public abstract void updateMagazine(Magazine magazine);

	public abstract void deleteMagazine(Magazine magazine);
}
