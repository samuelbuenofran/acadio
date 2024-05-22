package professor;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StudentManagement extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public StudentManagement() {

		JLabel lblNewLabel = new JLabel("This is a test.");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		add(lblNewLabel);

	}

}
