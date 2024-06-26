package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 * EN: This is the about window that displays information about the application.
 * PT: Esta é a janela sobre que exibe informações sobre a aplicação.
 */
public class AboutWindow extends JFrame {

	/**
	 * EN: Serial version UID for serialization. PT: UID de versão serial para a
	 * serialização.
	 */
	private static final long serialVersionUID = 1L;

	// EN: Create a panel to store the content. PT: Cria um painel para armazenar o
	// conteúdo.
	private JPanel contentPane;

	/**
	 * EN: Launch the application. PT: Inicia a aplicação.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					AboutWindow frame = new AboutWindow();
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
	public AboutWindow() {

		// This is an about window that displays information about the application.

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Add a label to display the application name
		JLabel lblAppName = new JLabel("Application Name");
		lblAppName.setBounds(10, 11, 414, 14);
		contentPane.add(lblAppName);

		// Add a label to display the application version
		JLabel lblAppVersion = new JLabel("Version 1.0");
		lblAppVersion.setBounds(10, 36, 414, 14);
		contentPane.add(lblAppVersion);

		// Add a label to display the application description
		JLabel lblAppDescription = new JLabel("This application is a prototype for a student management system.");
		lblAppDescription.setBounds(10, 61, 414, 14);
		contentPane.add(lblAppDescription);

		// Add a label to display the application author
		JLabel lblAppAuthor = new JLabel("Author: John Doe");
		lblAppAuthor.setBounds(10, 86, 414, 14);
		contentPane.add(lblAppAuthor);

	}

}
