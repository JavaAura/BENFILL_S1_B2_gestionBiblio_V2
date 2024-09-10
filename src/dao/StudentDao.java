package dao;

public interface StudentDao {

	public abstract void createStudentTable();

	public abstract void addStudent();

	public abstract void displayStudents();

	public abstract void updateStudent(int id);

	public abstract void deleteStudent(int id);
}
