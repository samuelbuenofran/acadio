// Purpose: GridQuery class for the professor package.
package professor;

// EN: Importing the necessary classes for the GridQuery class. PT: Importando as classes necessárias para a classe GridQuery.
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import services.BD;
import services.MyTableModel;

/**
 * EN: This class is responsible for creating a grid query. PT: Esta classe é
 * responsável por criar uma consulta em grade.
 */
public class GridQuery extends JPanel {

	/**
	 * EN: Default serial version ID. PT: ID de versão serial padrão.
	 */
	private static final long serialVersionUID = 1L;
	private JTable studentTable;
	private DefaultTableModel model;
	private JScrollPane studentSP;
	private JTextField filterTF;
	private BD bd;

	/**
	 * EN: Constructor for the GridQuery class. PT: Construtor para a classe
	 * GridQuery.
	 */
	public GridQuery() {
		setBounds(100, 100, 600, 500);
		setLayout(new BorderLayout());
		filterTF = new JTextField();
		add(filterTF, BorderLayout.NORTH);
		studentTable = new JTable();
		bd = new BD();

		// EN: Check if the connection to the database was successful. PT: Verifica se a
		// conexão com o banco de dados foi bem sucedida.
		if (bd.getConnection()) {
			loadTable();
		} else {
			JOptionPane.showMessageDialog(studentSP, "Error connecting to the database.");
			System.exit(0);
		}
		filterTF.addKeyListener(new KeyListener() {

			/**
			 * EN: Method to handle the key typed event. PT: Método para lidar com o evento
			 * de tecla digitada.
			 */
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			/**
			 * EN: Method to handle the key released event. PT: Método para lidar com o
			 * evento de tecla liberada.
			 */
			@Override
			public void keyReleased(KeyEvent e) {
				String sql = "SELECT * FROM student_tb WHERE student_name " + "LIKE '%" + filterTF.getText() + "%'";
				model = MyTableModel.getModel(bd, sql);
				studentTable.setModel(model);

			}

			/**
			 * EN: Method to handle the key pressed event. PT: Método para lidar com o
			 * evento de tecla pressionada.
			 */
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	/**
	 * EN: Method to load the table. PT: Método para carregar a tabela.
	 */
	private void loadTable() {
		String sql = "SELECT * FROM student_tb";
		model = MyTableModel.getModel(bd, sql);
		studentTable.setModel(model);
		studentSP = new JScrollPane(studentTable);
		add(studentSP, BorderLayout.CENTER);

	}

}
