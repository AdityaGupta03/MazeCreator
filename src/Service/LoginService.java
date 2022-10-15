package Service;

public class LoginService {
    private boolean loggedIn;

    public LoginService() {
        this.loggedIn = false;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public static boolean login(String username, String password) {
        return false;
    }
}
