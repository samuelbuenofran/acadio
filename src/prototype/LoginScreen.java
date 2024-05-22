package prototype;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LoginScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
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
	public LoginScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(10, 13, 22, 25);
		lblID.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblID.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblID);

		textFieldID = new JTextField();
		textFieldID.setBounds(140, 10, 166, 31);
		textFieldID.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textFieldID.setText("Professor ID");
		textFieldID.setToolTipText("Enter your Professor ID here.");
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 49, 80, 25);
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		contentPane.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(140, 52, 166, 31);
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textField.setToolTipText("Enter your Professor password.");
		textField.setText("***********");
		contentPane.add(textField);
		textField.setColumns(10);

		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(20, 178, 89, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(143, 178, 89, 23);
		contentPane.add(btnNewButton_1);

		btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(273, 178, 89, 23);
		contentPane.add(btnNewButton_2);
	}

}
