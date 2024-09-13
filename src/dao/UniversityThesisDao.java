package dao;

import java.util.List;

import models.UniversityThesis;

public interface UniversityThesisDao {
	public abstract void addUniversityThesis(UniversityThesis UniversityThesis);

	public abstract List<UniversityThesis> displayUniversityTheses();

	public abstract void updateUniversityThesis(UniversityThesis UniversityThesis);

	public abstract void deleteUniversityThesis(UniversityThesis universityThesis);
}
