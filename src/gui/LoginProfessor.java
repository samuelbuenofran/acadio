package gui;

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

import professor.DashboardProfessor;
import services.BD;

/**
 * EN: This class represents the login screen for the Professor user type. PT:
 * Esta classe representa a tela de login para o tipo de usuário Professor.
 * 
 */
public class LoginProfessor extends JFrame {

	// Database connection
	private BD bd;

	/**
	 * EN: Serial version UID for serialization. PT: UID de versão serial para a
	 * serialização.
	 */
	private static final long serialVersionUID = 1L;

	// EN: Create a panel to store the content. PT: Cria um painel para armazenar o
	// conteúdo.
	private JPanel contentPane;

	// EN: Create the text field for the Professor ID. PT: Cria o campo de texto
	// para o ID do Professor.
	private JTextField idField;

	// EN: Create the buttons for the login, help and cancel actions. PT: Cria os
	// botões para as ações de login, ajuda e cancelar.
	private JButton loginButton;
	private JButton helpButton;
	private JButton cancelButton;

	// EN: Create the password field for the Professor password. PT: Cria o campo de
	// senha para a senha do Professor.
	private JPasswordField passwordField;

	/**
	 * EN: Launch the application. PT: Inicia a aplicação.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					LoginProfessor frame = new LoginProfessor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * EN: Create the professor's login frame. PT: Cria o frame de login do
	 * professor.
	 */
	public LoginProfessor() {
		super("Login");
		setResizable(false);
		setTitle("Login as Professor");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// EN: Create the labels for the ID and password fields. PT: Cria os rótulos
		// para os campos de ID e senha.

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

				/*
				 * // Implement login logic here
				 * System.out.println("Login attempted with username: " + idField.getText() +
				 * ", password: (hidden)"); // Simple login logic in order to move to the next
				 * screen // This should be replaced with a real login logic if
				 * (idField.getText().equals("admin") && new
				 * String(passwordField.getPassword()).equals("admin")) { // Open the next
				 * screen System.out.println("Login successful!"); dispose(); DashboardProfessor
				 * dp = new DashboardProfessor(); dp.setVisible(true); } else {
				 * System.out.println("Login failed!"); }
				 * 
				 */

				// Now that we have a functioning database, it's time to implement the login
				// logic
				// There will be no ProfessorDAO class in this example, the logic only makes a
				// query to the professor_tb table in the database and compares the password
				// entered by the user with the password stored there;
				bd = new BD();
				if (bd.getConnection()) {
					// If the connection is successful, the query is made
					String query = "SELECT * FROM professor_tb WHERE professor_id = ? AND professor_password = ?";
					try {
						bd.st = bd.con.prepareStatement(query);
						bd.st.setString(1, idField.getText());
						bd.st.setString(2, new String(passwordField.getPassword()));
						bd.rs = bd.st.executeQuery();
						if (bd.rs.next()) {
							System.out.println("Login successful!");
							dispose();
							DashboardProfessor dp = new DashboardProfessor();
							dp.setVisible(true);
						} else {
							System.out.println("Login failed!");
						}
					} catch (Exception error) {
						System.out.println("Error: " + error.toString());

					} finally {
						bd.close();
					}
				}
				// If the connection is successful, the query is made

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
