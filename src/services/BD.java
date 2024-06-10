package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * EN: Class responsible for the connection to the database. PT: Classe
 * responsável pela conexão com o banco de dados.
 * 
 */
public class BD {

	// EN: Connection object PT: Objeto de conexão
	public Connection con = null;
	// EN: Statement object PT: Objeto de instrução
	public PreparedStatement st = null;
	// EN: ResultSet object PT: Objeto de resultado
	public ResultSet rs = null;

	private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final String DATABASENAME = "acadio";
	private final String URL = "jdbc:sqlserver://localhost;databasename=" + DATABASENAME;
	private final String LOGIN = "sa";
	private final String PASSWORD = "p@$$w0rd!";

	/**
	 * EN: Establishes a connection with the database. PT: Estabelece uma conexão
	 * com o banco de dados.
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
	 * 
	 * EN: Closes the connection and releases the objects used. PT: Fecha a conexão
	 * e libera os objetos utilizados.
	 * 
	 */
	public void close() {

	}

	/**
	 * EN: Executes a query. PT: Executa uma query.
	 * 
	 * @param - none;
	 * @return - none;
	 * 
	 */
	public static void main(String[] args) {
		BD bd = new BD();
		bd.getConnection();
	}
}
