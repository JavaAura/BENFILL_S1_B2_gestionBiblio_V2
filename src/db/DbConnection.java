package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private String url = System.getenv("DB_URL");
	private String username = System.getenv("DB_USERNAME");
	private String password = System.getenv("DB_PASSWORD");
	private Connection connection;
	private static DbConnection single_instance = null;

	public static synchronized DbConnection getInstance() {
		if (single_instance == null)
			single_instance = new DbConnection();

		return single_instance;

	}

	public Connection connect() {
		try {
			connection = DriverManager.getConnection(url, username, password);
			if (connection != null) {
				System.out.println("Connection established successfully !");
			} else {
				System.out.println("Connection failed !!");
			}
		} catch (SQLException e) {
			System.out.println("error: " + e);
		}
		return connection;
	}
}
