package services;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

/**
 * EN: This class is responsible for creating a table model based on the result
 * set of a SQL query.
 *
 * PT: Esta classe é responsável por criar um modelo de tabela com base no
 * conjunto de resultados de uma consulta SQL.
 *
 */
public class MyTableModel {
	private static DefaultTableModel tableModel;

	/**
	 * EN: Method to get the table model. PT: Método para obter o modelo de tabela.
	 * 
	 * @param bd
	 * @param sql
	 * @return
	 */
	public static DefaultTableModel getModel(BD bd, String sql) {
		try {
			Vector<String> header = new Vector<>();
			Vector<Vector<String>> rows = new Vector<>();
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();

			// Check if there are any rows in the result set
			if (bd.rs.next()) {
				// Get the column names directly from the ResultSetMetaData
				ResultSetMetaData rsmd = bd.rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				for (int i = 1; i <= columnCount; i++) {
					header.addElement(rsmd.getColumnName(i));
				}

				// Search for the rows' data
				do {
					Vector<String> currentRow = new Vector<>();
					for (int i = 1; i <= columnCount; i++) {
						switch (rsmd.getColumnType(i)) {
						// Handle specific data types if needed
						case Types.DATE:
							currentRow.addElement("" + bd.rs.getDate(i));
							break;
						// Add more cases for other data types as needed
						default:
							currentRow.addElement(bd.rs.getString(i));
						}
					}
					rows.addElement(currentRow);
				} while (bd.rs.next());
			} else {
				// Handle no rows scenario (e.g., display a message)
				System.out.println("No data found in the table.");
			}

			tableModel = new DefaultTableModel(rows, header);
		} catch (SQLException error) {
			System.out.println(error.toString());
			return null;
		}
		return tableModel;
	}
}
