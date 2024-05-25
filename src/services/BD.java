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
	private final String DATABASENAME = "java";
	private final String URL = "jdbc:sqlserver://localhost;databasename=" + DATABASENAME;
	private final String LOGIN = "usuario";
	private final String SENHA = "fatec";

	/**
	 * Realiza a conexão com o banco de dados
	 * 
	 * @return - true em caso de sucesso, ou false caso contrário
	 */
	public boolean getConnection() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, LOGIN, SENHA);
			System.out.println("Conectou!");
			return true;
		} catch (SQLException erro) {
			System.out.println("Falha na conexão: " + erro.toString());
			return false;

		} catch (ClassNotFoundException erro) {
			System.out.println("Driver não encontrado");
		}
		return true;
	}

	/**
	 * Encerra a conexão e libera os objetos utilizados
	 */
	public void close() {

	}

	public static void main(String[] args) {
		BD bd = new BD();
		bd.getConnection();
	}
}
