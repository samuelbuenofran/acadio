package login_utilities;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SplashScreen {

	public static void main(String[] args) throws IOException {
		// Load background image
		BufferedImage background = ImageIO.read(SplashScreen.class.getResource("splashscreen.png"));

		// Load loading icon animation
		ImageIcon icon = new ImageIcon(SplashScreen.class.getResource("loading.gif"));

		// Create splash screen frame
		JFrame frame = new JFrame("Application Splash Screen");
		frame.setUndecorated(true); // Remove window decorations
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close on hide

		// Create content panel
		JPanel contentPanel = new JPanel();
		JLabel backgroundLabel = new JLabel(new ImageIcon(background));
		backgroundLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		backgroundLabel.setText("TEXTTEST");

		// Position icon in bottom-left corner
		JLabel iconLabel = new JLabel(icon);
		iconLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT); // Align to the left
		contentPanel.add(Box.createVerticalGlue()); // Push icon to the bottom
		contentPanel.add(iconLabel);

		// Set layout for proper positioning
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

		// Add components and show animation
		contentPanel.add(backgroundLabel);
		frame.setContentPane(contentPanel);
		frame.pack();
		frame.setLocationRelativeTo(null); // Center on screen
		frame.setVisible(true);

		// Simulate loading time (replace with actual loading task)
		try {
			Thread.sleep(2000); // Replace with actual loading time
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Dispose splash screen and continue
		frame.dispose();
		// Start your application's main window here
	}
}
