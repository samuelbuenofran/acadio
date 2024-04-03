package login_utilities;

import javax.swing.*;

public class SplashAndLogin {

    public static void main(String[] args) {
        NewSplashScreen splash = new NewSplashScreen();
        LoginScreen login = new LoginScreen();
        // Link splash screen with login screen
        splash.setLoginScreen(login);
        splash.setVisible(true);
    }
}
