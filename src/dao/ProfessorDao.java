package dao;

import java.util.List;

import models.Professor;

public interface ProfessorDao {

	public abstract void addProfessor(Professor professor);

	public abstract List<Professor> displayProfessors();

	public abstract boolean updateProfessor(Professor professor);

	public abstract Boolean deleteProfessor(Professor professor);
}