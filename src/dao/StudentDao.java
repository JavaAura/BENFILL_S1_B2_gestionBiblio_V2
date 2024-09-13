package dao;

import java.util.List;

import models.Student;

public interface StudentDao {

	public abstract void addStudent(Student student);

	public abstract List<Student> displayStudents();

	public abstract Boolean updateStudent(Student student);

	public abstract Boolean deleteStudent(Student student);
}
