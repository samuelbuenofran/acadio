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

/*
 * Functions explained:
 * 
 * setLocationRelativeTo() -> This function is used to set the location of the JFrame to the center of the screen.
 * If the parameter equals null, the window is placed in the center of the screen.
 * If the parameter is a component, the window is placed in the center of the component.
 * If the parameter is a GraphicsConfiguration, the window is placed in the center of the screen corresponding to the GraphicsConfiguration.
 * If the component is not currently showing, or c is null, the window is centered on the screen. 
 * If the bottom of the component is offscreen, the window is placed to the side of the Component that is closest to the center of the screen. So if the Component is on the right part of the screen, the Window is placed to its left, and visa versa.
 * 
 * */
 