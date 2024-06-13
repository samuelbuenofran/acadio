package deprecated;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import professor.DashboardProfessor;

/**
 * EN: This class is deprecated and will be removed in the future. PT: Esta
 * classe está obsoleta e será removida no futuro.
 */
public class LoginProfessor extends JFrame {

	/**
	 * EN: Serial version UID for serialization. PT: UID de versão serial para a
	 * serialização.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * EN: Constructor for the LoginProfessor class. It sets the size and layout of
	 * the window, and loads the images.
	 *
	 * PT: Construtor para a classe LoginProfessor. Define o tamanho e layout da
	 * janela, e carrega as imagens.
	 */
	public LoginProfessor() {
		super("Login");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Login panel
		JPanel loginPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JLabel idLabel = new JLabel("Username:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		loginPanel.add(idLabel, c);

		JTextField idField = new JTextField(20);
		c.gridx = 1;
		c.gridy = 0;
		loginPanel.add(idField, c);

		JLabel passwordLabel = new JLabel("Password:");
		c.gridy = 1;
		c.gridx = 0;
		loginPanel.add(passwordLabel, c);

		JPasswordField passwordField = new JPasswordField(20);
		c.gridy = 1;
		c.gridx = 1;
		loginPanel.add(passwordField, c);

		// Button panel
		JPanel buttonPanel = new JPanel();
		JButton loginButton = new JButton("Login");

		// Implement login logic

		/**
		 * EN: ActionListener for the login button. It prints the username and password
		 * entered in the text fields, and then checks if the username and password are
		 * correct. If they are, it opens the next screen. PT: ActionListener para o
		 * botão de login. Ele imprime o nome de usuário e a senha inseridos nos campos
		 * de texto, e então verifica se o nome de usuário e a senha estão corretos. Se
		 * estiverem, ele abre a próxima tela.
		 * 
		 */
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
		buttonPanel.add(loginButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(e -> dispose());
		buttonPanel.add(cancelButton);

		// Add panels to frame
		add(loginPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		pack();
		setLocationRelativeTo(null);
	}
}
