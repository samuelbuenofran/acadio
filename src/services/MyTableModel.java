package services;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MyTableModel {
	private static DefaultTableModel tableModel;

	public static DefaultTableModel getModel(BD bd, String sql) {
		try {
			Vector<String> header = new Vector<>();
			Vector<Vector<String>> rows = new Vector<>();
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			bd.rs.next();
			// Search for the headers
			ResultSetMetaData rsmd = bd.rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				header.addElement(rsmd.getColumnName(i));
			}

			// Search for the rows' data
			do {
				Vector<String> currentRow = new Vector<>();
				// The line below was written for a Brazilian application;
				// DecimalFormat df = new DecimalFormat("R$ 00.00");
				// The line below is adapted to the UK currency;
				DecimalFormat df = new DecimalFormat("£ 00.00");
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					switch (rsmd.getColumnType(i)) {
					case Types.VARCHAR:
						currentRow.addElement(bd.rs.getString(i));
						break;
					case Types.CHAR:
						currentRow.addElement(bd.rs.getString(i));
						break;
					case Types.TIMESTAMP:
						currentRow.addElement("" + bd.rs.getDate(i));
						break;
					case Types.DOUBLE:
						currentRow.addElement("" + bd.rs.getDouble(i));
						break;
					case Types.DECIMAL:
						currentRow.addElement("" + bd.rs.getDouble(i));
						break;
					case Types.INTEGER:
						currentRow.addElement("" + bd.rs.getInt(i));
						break;
					case Types.NUMERIC:
						currentRow.addElement("" + df.format(bd.rs.getDouble(i)));
						break;
					case Types.SMALLINT:
						currentRow.addElement("" + bd.rs.getInt(i));
						break;
					// default:System.out.println(rsmd.getColumnType(i));
					}
				}
				rows.addElement(currentRow);
			} while (bd.rs.next());

			tableModel = new DefaultTableModel(rows, header);
		} catch (SQLException error) {
			System.out.println(error.toString());
			return null;
		}
		return tableModel;
	}
}
