package db;

public class TableCreation {
	public TableCreation() {
		DbRequest.createTable("global_document_id_seq", "", "SEQUENCE");

		String columns = "id INT DEFAULT nextval('global_document_id_seq') PRIMARY KEY, "
				+ "title varchar(255), author varchar(255), publicationDate varchar(255), "
				+ "pagesNumber int, borrowed boolean DEFAULT false, type varchar(255)";
		DbRequest.createTable("documents", columns, "");
		DbRequest.createTable("books", "isbn varchar(255)", "INHERITS (documents)");
		DbRequest.createTable("magazines", "number int", "INHERITS (documents)");
		DbRequest.createTable("scientific_journals", "researchField varchar(255)", "INHERITS (documents)");
		columns = "university varchar(255), fieldOfStudy varchar(255)";
		DbRequest.createTable("university_theses", columns, "INHERITS (documents)");

		DbRequest.createTable("global_user_id_seq", "", "SEQUENCE");
		DbRequest.createTable("users",
				"id INT DEFAULT nextval('global_document_id_seq') PRIMARY KEY, name varchar(255) UNIQUE, email varchar(255)",
				"");
		DbRequest.createTable("students", "academicLevel varchar(255)", "INHERITS (users)");
		DbRequest.createTable("professors", "professorID varchar(255), department varchar(255)", "INHERITS (users)");
		columns = "document_id INT REFERENCES documents(id), user_id INT REFERENCES users(id), status varchar(255)";
		DbRequest.createTable("reservations", columns, "");
		columns = "document_id INT REFERENCES documents(id), user_id INT REFERENCES users(id), status varchar(255)";
		DbRequest.createTable("borrowings", columns, "");
	}
}
