package login_utilities;

import java.awt.*;
import javax.swing.*;

public class SplashScreen extends JFrame {

    public SplashScreen() {
        super("Application Splash");
        setSize(400, 300); // Adjust size as needed
        setLocationRelativeTo(null); // Center on screen
        setContentPane(new JLabel(new ImageIcon("splash.png"), JLabel.CENTER)); // Replace "splash.png" with your image path
        setUndecorated(true); // Remove frame decorations

        // Display for 5 seconds and close
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setVisible(false);
            dispose();
        }).start();

        setVisible(true);
    }
}
