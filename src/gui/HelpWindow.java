package gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 * EN: This class creates a window with help information for the user. PT: Esta
 * classe cria uma janela com informações de ajuda para o usuário.
 */
public class HelpWindow extends JFrame {

	/**
	 * EN: Serial version UID for serialization. PT: UID de versão serial para a
	 * serialização.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * EN: Launch the application. PT: Inicia a aplicação.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					HelpWindow frame = new HelpWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * EN: Create the frame. PT: Cria a janela.
	 * 
	 */
	public HelpWindow() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton returnButton = new JButton("Return");
		contentPane.add(returnButton);
	}

}
