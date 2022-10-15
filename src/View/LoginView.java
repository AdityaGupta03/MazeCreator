package View;

import Core.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

/**
 * Class which displays and handles the login/signup for the application
 */
public class LoginView extends JComponent implements Runnable {
    private boolean loggedIn;

    JLabel welcomeText;
    JLabel enterUsernameL;
    JLabel enterPasswordL;
    JLabel enterUsernameS;
    JLabel enterPasswordS;
    JLabel enterName;
    JLabel or = new JLabel("Or");

    JButton loginButton;
    JButton signupButton;

    JTextField lUsername = new JTextField(10);
    JTextField sUsername = new JTextField(10);
    JTextField lPassword = new JTextField(10);
    JTextField sPassword = new JTextField(10);
    JTextField sName = new JTextField(10);

    LoginView loginView;

    public LoginView() {
        this.loggedIn = false;
    }

    private void login(String username, String password) {
        System.out.printf("Login Attempted\nUsername: %s\nPassword: %s\n", username, password);
        try {
            Client.controller.login(username, password);
        } catch (Exception e) {
            //TODO: Add Execption Catching
            System.out.println("Empty Fields");
        }
    }

    private void signup(String name, String username, String password) {
        Client.controller.signup(name, username, password);
    }

    private boolean isLoggedIn() {
        return loggedIn;
    }

    private void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void run() {
        JFrame frame = new JFrame();
        frame.setTitle("MazeCreator");
        Container content = frame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        loginView = new LoginView();
        content.add(loginView);
        frame.setSize(700, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        enterUsernameL = new JLabel("Enter Username:");
        enterPasswordL = new JLabel("Enter Password:");
        enterUsernameS = new JLabel("Enter Username:");
        enterPasswordS = new JLabel("Enter Password:");
        enterName = new JLabel("Enter Full Name:");
        welcomeText = new JLabel("Welcome to MazeCreator!");
        loginButton = new JButton("Log In");
        signupButton = new JButton("Create Account");

        JPanel welcomePanel = new JPanel();
        welcomePanel.add(welcomeText);
        content.add(welcomePanel, BorderLayout.PAGE_START);

        JPanel optionPanel = new JPanel();

        content.add(optionPanel, BorderLayout.CENTER);

        JPanel loginPanel = new JPanel();

        JPanel loginUsername = new JPanel();
        loginUsername.add(enterUsernameL);
        loginUsername.add(lUsername);
        loginPanel.add(loginUsername);

        JPanel loginPassword = new JPanel();
        loginPassword.add(enterPasswordL);
        loginPassword.add(lPassword);
        loginPanel.add(loginPassword);

        loginPanel.add(loginButton);

        loginPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginPanel.setPreferredSize(new Dimension(300, 650));
        loginPanel.setMaximumSize(new Dimension(500, 650));

        optionPanel.add(loginPanel);

        JPanel orPanel = new JPanel();
        orPanel.add(or);

        orPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        orPanel.setPreferredSize(new Dimension(50, 600));
        orPanel.setMaximumSize(new Dimension(50, 600));

        optionPanel.add(orPanel);

        JPanel signupPanel = new JPanel();

        JPanel signupName = new JPanel();
        signupName.add(enterName);
        signupName.add(sName);
        signupPanel.add(signupName);

        JPanel signupUsername = new JPanel();
        signupUsername.add(enterUsernameS);
        signupUsername.add(sUsername);
        signupPanel.add(signupUsername);

        JPanel signupPassword = new JPanel();
        signupPassword.add(enterPasswordS);
        signupPassword.add(sPassword);
        signupPanel.add(signupPassword);

        signupPanel.add(signupButton);

        signupPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        signupPanel.setPreferredSize(new Dimension(300, 700));
        signupPanel.setMaximumSize(new Dimension(300, 700));

        optionPanel.add(signupPanel);

        optionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionPanel.setPreferredSize(new Dimension(950, 500));
        optionPanel.setMaximumSize(new Dimension(950, 500));

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = lUsername.getText();
                String password = lPassword.getText();
                loginView.login(username, password);
            }
        });
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = sName.getText();
                String username = sUsername.getText();
                String password = sPassword.getText();
                loginView.signup(name, username, password);
            }
        });
    }

    public static void start() {
        SwingUtilities.invokeLater(new LoginView());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new LoginView());
    }
}
