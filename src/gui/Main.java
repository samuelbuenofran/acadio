package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

// Class definition
public class Main extends JWindow {

	// Create variables to store the images
	private BufferedImage backgroundImage;
	private ImageIcon loadingIcon;

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public Main() {

		// Load the images
		backgroundImage = loadImage("splashscreen.png");
		loadingIcon = new ImageIcon("loading_s.gif");

		// Set size and layout
		setSize(626, 358);
		// Use null layout for absolute positioning
		getContentPane().setLayout(null);

		// Load background image
		JLabel background = new JLabel(new ImageIcon(backgroundImage));
		background.setBounds(0, 0, 626, 358); // Set bounds for the background. The first two 0s indicate that the
												// background is at the top left corner of the window
		// Add the background to the content pane
		getContentPane().add(background);

		// Load loading GIF icon
		JLabel loadingIcon = new JLabel(this.loadingIcon);
		loadingIcon.setBounds(525, 265, 64, 64); // Adjust as needed for your icon size and position
		background.add(loadingIcon);

		// If the image glitches out, set the background color to black
		// getContentPane().setBackground(new java.awt.Color(0, 0, 0));
		// If the splash screen somehow glitches and shows the top bar, set the icon
		setIconImage(new ImageIcon("logo.png").getImage()); // Set window icon

		// Center the window
		setLocationRelativeTo(null);

		// Show the window
		setVisible(true);

		// Set a timer to close the splash screen and open the next screen after 3
		// seconds
		Timer timer = new Timer();

		// Schedule a task to run after 3 seconds
		timer.schedule(new TimerTask() {
			// We use override because there already is a run method in the TimerTask class
			@Override
			public void run() {
				// Close the splash screen
				dispose();

				// Open the next screen
				// new NextScreen().setVisible(true);
				// LoginScreen ls = new LoginScreen();
				// ls.setVisible(true);
				SelectUserType sut = new SelectUserType();
				sut.setVisible(true);

			}
		}, 3000); // 3000 milliseconds = 3 seconds
		// Forcibly hides the splash screen after 3 seconds
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		// Apply rendering hints for high-quality graphics
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Draw the background image with high-quality scaling
		if (backgroundImage != null) {
			g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		}

		// Draw the loading icon
		if (loadingIcon != null) {
			g2d.drawImage(loadingIcon.getImage(), 525, 265, 64, 64, this);

		}
	}

	private BufferedImage loadImage(String path) {
		try {
			return javax.imageio.ImageIO.read(new java.io.File(path));
		} catch (Exception error) {
			error.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		// Create and show the splash screen
		Main m = new Main();
		m.setVisible(true);
	}
}
