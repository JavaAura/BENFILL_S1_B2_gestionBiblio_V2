package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.DbRequest;
import models.Professor;
import models.Student;
import services.ProfessorImpl;
import services.StudentImpl;
import views.ConsoleUI;
import views.User;

public class UserController {

	public static void manageUser(int choiceHolder) {
		int choice;
		if (choiceHolder == 1) {
			choice = User.manageStudent();
			switch (choice) {
			case 1:
				addUser(true);
				break;
			case 2:
				updateUser(true);
				break;
			case 3:
				deleteUser(true);
				break;
			}

		} else {
			choice = User.manageProfessor();
			switch (choice) {
			case 1:
				addUser(false);
				break;
			case 2:
				updateUser(false);
				break;
			case 3:
				deleteUser(false);
				break;
			}
		}

	}

	private static void addUser(Boolean isStudent) {

		String name = ConsoleUI.getUserInputString("Name", "Please Enter User Name", false);
		String email = ConsoleUI.getUserInputString("Name", "Please Enter User Name", false);

		if (isStudent) {
			String text = "Please Enter Student Academic Level";
			String academicLevel = ConsoleUI.getUserInputString("Academic Level", text, true);
			Student student = new Student(0, name, email, academicLevel);
			StudentImpl sImpl = new StudentImpl();
			sImpl.addStudent(student);
		} else {
			String department = ConsoleUI.getUserInputString("Department", "Please Enter Prof Department", true);
			Professor professor = new Professor(0, name, email, department);
			ProfessorImpl pImpl = new ProfessorImpl();
			pImpl.addProfessor(professor);
		}
	}

	private static void updateUser(Boolean isStudent) {

		Object[] oldName = {
				ConsoleUI.getUserInputString("Name", "Please Enter User Name that you want to update", false) };

		ResultSet rs;
		if (isStudent) {
			rs = DbRequest.getAll("students", "name=?", oldName);
		} else {
			rs = DbRequest.getAll("professors", "name=?", oldName);
		}

		Boolean checker = DbRequest.hasResults(rs);

		if (!checker) {
			System.out.println("User not found.");
			return;
		}

		String currentName = null;
		String currentEmail = null;
		String currentAcademicLevel = null;
		String currentDepartment = null;
		int id;

		try {
			currentName = rs.getString("name");
			currentEmail = rs.getString("email");
			id = rs.getInt("id");

			System.out.println("User found:");
			System.out.println("Name: " + currentName);
			System.out.println("Email: " + currentEmail);

			if (isStudent) {
				currentAcademicLevel = rs.getString("academicLevel");
				System.out.println("Academic Level: " + currentAcademicLevel);
			} else {
				currentDepartment = rs.getString("department");
				System.out.println("Department: " + currentDepartment);
			}
		} catch (

		SQLException e) {
			e.printStackTrace();
			return;
		}

		String response = ConsoleUI.getUserInputString("Confirmation", "Do you want to update this user? (y/n)", false);
		if (!response.equalsIgnoreCase("y")) {
			System.out.println("Update operation cancelled.");
			return;
		}

		String newName = ConsoleUI.getUserInputString("Name", "Please Enter New User Name (Optional)", true);
		String email = ConsoleUI.getUserInputString("Email", "Please Enter New User Email (Optional)", true);

		if (isStudent) {
			String academicLevel = ConsoleUI.getUserInputString("Academic Level",
					"Please Enter New Student Academic Level (Optional)", true);

			String updatedName = newName.isEmpty() ? currentName : newName;
			String updatedEmail = email.isEmpty() ? currentEmail : email;

			Student student = new Student(id, updatedName, updatedEmail, academicLevel);
			StudentImpl sImpl = new StudentImpl();
			boolean updated = sImpl.updateStudent(student);

			if (updated) {
				System.out.println("Student details updated successfully.");
			} else {
				System.out.println("Failed to update student details.");
			}
		} else {
			String department = ConsoleUI.getUserInputString("Department", "Please Enter Prof Department (Optional)",
					true);
			String updatedName = newName.isEmpty() ? currentName : newName;
			String updatedEmail = email.isEmpty() ? currentEmail : email;

			Professor professor = new Professor(id, updatedName, updatedEmail, department);
			ProfessorImpl pImpl = new ProfessorImpl();
			boolean updated = pImpl.updateProfessor(professor);

			if (updated) {
				System.out.println("Professor details updated successfully.");
			} else {
				System.out.println("Failed to update professor details.");
			}
		}
	}

	private static void deleteUser(Boolean isStudent) {
		Object[] oldName = {
				ConsoleUI.getUserInputString("Name", "Please Enter User Name that you want to update", false) };

		ResultSet rs;
		if (isStudent) {
			rs = DbRequest.getAll("students", "name=?", oldName);
		} else {
			rs = DbRequest.getAll("professors", "name=?", oldName);
		}

		Boolean checker = DbRequest.hasResults(rs);

		if (!checker) {
			System.out.println("User not found.");
			return;
		}

		String currentName = null;
		String currentEmail = null;
		String currentAcademicLevel = null;
		String currentDepartment = null;
		int id;
		try {
			currentName = rs.getString("name");
			currentEmail = rs.getString("email");
			id = rs.getInt("id");

			System.out.println("User found:");
			System.out.println("Name: " + currentName);
			System.out.println("Email: " + currentEmail);

			if (isStudent) {
				currentAcademicLevel = rs.getString("academicLevel");
				System.out.println("Academic Level: " + currentAcademicLevel);
			} else {
				currentDepartment = rs.getString("department");
				System.out.println("Department: " + currentDepartment);
			}
		} catch (

		SQLException e) {
			e.printStackTrace();
			return;
		}
		String response = ConsoleUI.getUserInputString("Confirmation", "Do you want to update this user? (y/n)", false);
		if (!response.equalsIgnoreCase("y")) {
			System.out.println("Update operation cancelled.");
			return;
		}

		DbRequest.delete(isStudent ? "students" : "professors", id);
		System.out.println("User deleted successfully.");
	}
}
