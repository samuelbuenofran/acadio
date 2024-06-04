package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BD {

	public Connection con = null;
	public PreparedStatement st = null;
	public ResultSet rs = null;

	private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final String DATABASENAME = "acadio";
	private final String URL = "jdbc:sqlserver://localhost;databasename=" + DATABASENAME;
	private final String LOGIN = "sa";
	private final String PASSWORD = "p@$$w0rd!";
	// private final String INTEGRATED_SECURITY = "true";

	/**
	 * 
	 * Establishes a connection with the database
	 *
	 * @param - none;
	 * @return - true in case of success, or false otherwise
	 * 
	 */
	public boolean getConnection() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			System.out.println("Connected successfully!");
			return true;
		} catch (SQLException error) {
			System.out.println("Error connecting to the database: " + error.toString());
			return false;

		} catch (ClassNotFoundException error) {
			System.out.println("Error loading the driver: " + error.toString());
		}
		return true;
	}

	/**
	 * Closes the connection and releases the objects used
	 */
	public void close() {

	}

	public static void main(String[] args) {
		BD bd = new BD();
		bd.getConnection();
	}
}
