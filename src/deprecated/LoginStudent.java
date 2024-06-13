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

/**
 * EN: This class is deprecated and will be removed in the future. PT: Esta
 * classe está obsoleta e será removida no futuro.
 */
public class LoginStudent extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * EN: Constructor for the LoginProfessor class. It sets the size and layout of
	 * the window, and loads the images.
	 *
	 * PT: Construtor para a classe LoginProfessor. Define o tamanho e layout da
	 * janela, e carrega as imagens.
	 */
	public LoginStudent() {
		super("Login");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Login panel
		JPanel loginPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JLabel usernameLabel = new JLabel("Username:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		loginPanel.add(usernameLabel, c);

		JTextField usernameField = new JTextField(20);
		c.gridx = 1;
		c.gridy = 0;
		loginPanel.add(usernameField, c);

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

		// Implement login logic when button is clicked
		// Lambda expression to add action listener to button

		/**
		 * EN: This is the action listener for the login button. It prints the username
		 * and password to the console. PT: Este é o action listener para o botão de
		 * login. Ele imprime o nome de usuário e a senha no console.
		 */
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Implement login logic here
				System.out
						.println("Login attempted with username: " + usernameField.getText() + ", password: (hidden)");
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
