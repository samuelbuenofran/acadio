package login_utilities;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LoginScreen extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginScreen() {
        super("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        loginPanel.add(passwordLabel, c);

        JPasswordField passwordField = new JPasswordField(20);
        c.gridy = 1;
        c.gridx = 1;
        loginPanel.add(passwordField, c);

        // Button panel
        JPanel buttonPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement login logic here
                System.out.println("Login attempted with username: " + usernameField.getText() +
                        ", password: (hidden)");
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

