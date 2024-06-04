package prototype;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import gui.HelpWindow;
import professor.DashboardProfessor;

public class LoginScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idField;
	private JButton loginButton;
	private JButton helpButton;
	private JButton cancelButton;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		super("Login");
		setResizable(false);
		setTitle("Login as Professor");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(10, 13, 22, 25);
		idLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		idLabel.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(idLabel);

		idField = new JTextField();
		idField.setBounds(140, 10, 195, 30);
		idField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		idField.setText("Professor ID");
		idField.setToolTipText("Enter your Professor ID here.");
		contentPane.add(idField);
		idField.setColumns(10);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10, 49, 80, 25);
		passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		contentPane.add(passwordLabel);

		loginButton = new JButton("Login");
		loginButton.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		loginButton.setToolTipText("Button to login to the system.");
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Implement login logic here
				System.out.println("Login attempted with username: " + idField.getText() + ", password: (hidden)");
				// Simple login logic in order to move to the next screen
				// This should be replaced with a real login logic
				if (idField.getText().equals("admin") && new String(passwordField.getPassword()).equals("admin")) {
					// Open the next screen
					System.out.println("Login successful!");
					dispose();
					new DashboardProfessor().setVisible(true);
				} else {
					System.out.println("Login failed!");
				}
			}
		});
		loginButton.setBounds(23, 101, 89, 23);
		contentPane.add(loginButton);

		helpButton = new JButton("Help");

		// Action listener for help button
		helpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Opens a help window
				HelpWindow hw = new HelpWindow();
				hw.setVisible(true);
			}
		});
		helpButton.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		helpButton.setToolTipText("Button to get help or troubleshoot potential issues.");
		helpButton.setBounds(134, 101, 89, 23);
		contentPane.add(helpButton);

		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Closes the application's login window
				dispose();
			}
		});
		cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		cancelButton.setToolTipText("Cancel login attempt and return to user type selection.");
		cancelButton.setBounds(246, 101, 89, 23);
		contentPane.add(cancelButton);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		passwordField.setToolTipText("Enter your password here.");
		passwordField.setBounds(140, 50, 195, 30);
		contentPane.add(passwordField);
	}
}
