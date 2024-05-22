package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SelectUserType extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					SelectUserType frame = new SelectUserType();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SelectUserType() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAppleIcon = new JLabel("");
		lblAppleIcon.setBounds(70, 32, 96, 96);
		lblAppleIcon.setIcon(new ImageIcon("C:\\Users\\1050482013033\\eclipse-workspace\\acadio\\apple.png"));
		contentPane.add(lblAppleIcon);

		JLabel lblProfessor = new JLabel("Professor");
		lblProfessor.setBounds(80, 139, 75, 22);
		lblProfessor.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfessor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProfessor.setLabelFor(lblAppleIcon);
		contentPane.add(lblProfessor);
	}

}
