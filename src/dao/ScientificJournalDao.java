package dao;

import java.util.List;

import models.ScientificJournal;

public interface ScientificJournalDao {

	public abstract void addScientificJournal(ScientificJournal scientificJournal);

	public abstract List<ScientificJournal> displayScientificJournals();

	public abstract void updateScientificJournal(ScientificJournal scientificJournal);

	public abstract void deleteScientificJournal(ScientificJournal scientificJournal);
}
