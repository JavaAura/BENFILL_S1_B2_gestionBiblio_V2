package db;

public class TableCreation {
	public TableCreation() {
		String columns = "title varchar(255), author varchar(255), publicationDate varchar(255), pagesNumber int, borrowed boolean DEFAULT false, type varchar(255)";
		DbRequest.createTable("documents", columns, "");
		DbRequest.createTable("books", "isbn varchar(255)", "INHERITS (documents)");
		DbRequest.createTable("magazines", "number int", "INHERITS (documents)");
		DbRequest.createTable("scientific_journals", "researchField varchar(255)", "INHERITS (documents)");
		columns = "university varchar(255), fieldOfStudy varchar(255)";
		DbRequest.createTable("university_theses", columns, "INHERITS (documents)");
		DbRequest.createTable("users", "name varchar(255), email varchar(255)", "");
		DbRequest.createTable("students", "studentID varchar(255), academicLevel varchar(255)", "INHERITS (users)");
		DbRequest.createTable("professors", "professorID varchar(255), department varchar(255)", "INHERITS (users)");
		columns = "document_id INT REFERENCES documents(id), user_id INT REFERENCES users(id), status varchar(255)";
		DbRequest.createTable("reservations", columns, "");
		columns = "document_id INT REFERENCES documents(id), user_id INT REFERENCES users(id), status varchar(255)";
		DbRequest.createTable("borrowings", columns, "");
	}
}
