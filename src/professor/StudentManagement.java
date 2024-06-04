package professor;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import services.BD;
import services.MyTableModel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

public class StudentManagement extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable tbProdutos;
	private DefaultTableModel model;
	private JScrollPane spProdutos;
	private BD bd;
	/**
	 * @wbp.nonvisual location=377,-31
	 */
	private final JButton button = new JButton("New button");

	/**
	 * Create the panel.
	 */
	public StudentManagement() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(48, 39, 349, 278);
		add(tabbedPane);
		
		JTabbedPane tpViewTable = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Student Management", null, tpViewTable, null);
		
		JTabbedPane tpAddStudent = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Add Student", null, tpAddStudent, null);
		JLabel lblNewLabel = new JLabel("This is a test.");
		lblNewLabel.setBounds(255, 5, 100, 25);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		add(lblNewLabel);
		setBounds(100, 100, 600, 500);

		tbProdutos = new JTable();
		bd = new BD();
		if (bd.getConnection()) {
			carregarTabela();
		} else {
			JOptionPane.showMessageDialog(spProdutos, "Falha na conexão");
			System.exit(0);
		}
		
		// Adding the table to the already existing tabbed pane
		tpViewTable.add(spProdutos, BorderLayout.CENTER);
		
		

	}

	private void carregarTabela() {
		String sql = "SELECT * FROM produtos";
		model = MyTableModel.getModel(bd, sql);
		tbProdutos.setModel(model);
		spProdutos = new JScrollPane(tbProdutos);
		add(spProdutos, BorderLayout.CENTER);
		
		
		
	}
}
