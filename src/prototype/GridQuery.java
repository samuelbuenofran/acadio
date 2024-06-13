package prototype;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import services.BD;
import services.MyTableModel;

/**
 * EN: This class is responsible for creating a grid query. PT: Esta classe é
 * responsável por criar uma consulta em grade.
 */
public class GridQuery extends JFrame {

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
		setTitle("Search for students:");
		setBounds(100, 100, 600, 500);
		setLayout(new BorderLayout());
		filterTF = new JTextField();
		add(filterTF, BorderLayout.NORTH);
		studentTable = new JTable();
		bd = new BD();
		if (bd.getConnection()) {
			loadTable();
		} else {
			JOptionPane.showMessageDialog(studentSP, "Error connecting to the database.");
			System.exit(0);
		}
		filterTF.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				String sql = "SELECT * FROM student_tb WHERE student_name " + "LIKE '%" + filterTF.getText() + "%'";
				model = MyTableModel.getModel(bd, sql);
				studentTable.setModel(model);

			}

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

	/**
	 * EN: The main method for the GridQuery class. It creates the window and sets
	 * its visibility. PT: O método principal para a classe GridQuery. Ele cria a
	 * janela e define sua visibilidade.
	 */
	public static void main(String[] args) {
		GridQuery gq = new GridQuery();
		gq.setVisible(true);
		gq.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
