package model;

// Login class represents user login data (username and password)
public class Login {

    // Private variables (Encapsulation)
    private String username;
    private String password;

    // Default constructor (initializes empty values)
    public Login() {
        this.username = "";
        this.password = "";
    }

    // Parameterized constructor (used to set values at object creation)
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Copy constructor (creates a new object by copying another Login object)
    public Login(Login login) {
        this.username = login.username;
        this.password = login.password;
    }

    // Getter method for username
    public String getUsername() {
        return username;
    }

    // Setter method for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter method for password
    public String getPassword() {
        return password;
    }

    // Setter method for password
    public void setPassword(String password) {
        this.password = password;
    }

    // toString method (used to display object details as string)
    @Override
    public String toString() {
        return "Login [username=" + username + ", password=" + password + "]";
    }
}