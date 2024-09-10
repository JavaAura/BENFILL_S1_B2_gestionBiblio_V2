package dao;

public interface ProfessorDao {
	public abstract void createProfessorTable();

	public abstract void addProfessor();

	public abstract void displayProfessors();

	public abstract void updateProfessor(int id);

	public abstract void deleteProfessor(int id);
}
