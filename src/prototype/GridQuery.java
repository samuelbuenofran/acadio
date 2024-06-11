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

public class GridQuery extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTable studentTable;
	private DefaultTableModel model;
	private JScrollPane studentSP;
	private JTextField filterTF;
	private BD bd;

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

	private void loadTable() {
		String sql = "SELECT * FROM student_tb";
		model = MyTableModel.getModel(bd, sql);
		studentTable.setModel(model);
		studentSP = new JScrollPane(studentTable);
		add(studentSP, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		GridQuery gq = new GridQuery();
		gq.setVisible(true);
		gq.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
