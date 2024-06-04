package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
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
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblProfessor = new JLabel("Professor/Coordinator");
		lblProfessor.setBounds(418, 155, 204, 40);
		lblProfessor.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfessor.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		contentPane.add(lblProfessor);

		JLabel lblSysadmin = new JLabel("Sysadmin");
		lblSysadmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblSysadmin.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblSysadmin.setBounds(260, 155, 125, 40);
		contentPane.add(lblSysadmin);

		JButton btnProfessorCoord = new JButton("");
		btnProfessorCoord.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SelectUserType.this.dispose();
				LoginProfessor loginProfessor = new LoginProfessor();
				loginProfessor.setVisible(true);
			}
		});
		btnProfessorCoord.setVerticalAlignment(SwingConstants.BOTTOM);
		btnProfessorCoord.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnProfessorCoord.setToolTipText("Login as a Professor/Coordinator");
		btnProfessorCoord.setIcon(new ImageIcon(SelectUserType.class.getResource("/images/apple.png")));
		btnProfessorCoord.setBounds(468, 48, 96, 96);
		contentPane.add(btnProfessorCoord);

		JButton btnSysadmin = new JButton("");
		btnSysadmin.setIcon(new ImageIcon(SelectUserType.class.getResource("/images/wrench.png")));
		btnSysadmin.setBounds(273, 48, 96, 96);
		contentPane.add(btnSysadmin);

		JButton btnStudent = new JButton("");
		btnStudent.setIcon(new ImageIcon(SelectUserType.class.getResource("/images/graduation_cap.png")));
		btnStudent.setBounds(96, 48, 96, 96);
		contentPane.add(btnStudent);

		JLabel lblStudent = new JLabel("Student");
		lblStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudent.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblStudent.setBounds(96, 152, 125, 40);
		contentPane.add(lblStudent);

		JLabel lblCopyright = new JLabel("Acadio®, 2024.");
		lblCopyright.setBounds(23, 286, 77, 14);
		contentPane.add(lblCopyright);
	}
}
