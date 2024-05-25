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

public class StudentManagement extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable tbProdutos;
	private DefaultTableModel model;
	private JScrollPane spProdutos;
	private BD bd;

	/**
	 * Create the panel.
	 */
	public StudentManagement() {
		JLabel lblNewLabel = new JLabel("This is a test.");
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

	}

	private void carregarTabela() {
		String sql = "select * from produtos";
		model = MyTableModel.getModel(bd, sql);
		tbProdutos.setModel(model);
		spProdutos = new JScrollPane(tbProdutos);
		add(spProdutos, BorderLayout.CENTER);
	}

//	public static void main(String[] args) {
//		StudentManagement sm = new StudentManagement();
//		sm.setVisible(true);
//	}

}
