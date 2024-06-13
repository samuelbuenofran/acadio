package professor;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import services.BD;

/**
 * EN: This class represents the filter query for the Student entity. PT: Esta
 * classe representa a consulta de filtro para a entidade Estudante.
 */
public class StudentFilterQuery extends JFrame {

	/**
	 * EN: Serial version UID for serialization. PT: UID de versão serial para a
	 * serialização.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * EN: The main method for the StudentFilterQuery class. It creates the window
	 * and sets its visibility. PT: O método principal para a classe
	 * StudentFilterQuery. Ele cria a janela e define sua visibilidade.
	 */
	public static void main(String[] args) {
		BD bd = new BD();
		if (bd.getConnection()) {
			String sql = "SELECT * FROM student_tb WHERE student_name LIKE ?";
			try {
				String s = JOptionPane.showInputDialog("Type the filter:");
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setString(1, "%" + s + "%");
				bd.rs = bd.st.executeQuery();
				while (bd.rs.next()) {
					System.out.println(bd.rs.getInt(1));
					System.out.println(bd.rs.getString(2));
					System.out.println(bd.rs.getString(3));
					System.out.println(bd.rs.getString(4));
					System.out.println(bd.rs.getDate(5));
					System.out.println(bd.rs.getString(6));
					System.out.println(bd.rs.getDate(7));
					System.out.println(bd.rs.getString(8));
					System.out.println(bd.rs.getString(9));
					System.out.println(bd.rs.getString(10));
					System.out.println(bd.rs.getString(11));
					System.out.println("-----------------------");
				}
			} catch (SQLException e) {
				System.out.println(e);
			}

		} else {
			System.out.println("Error: Connection failed!");
		}

	}

}