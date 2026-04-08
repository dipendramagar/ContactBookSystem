package Controller;

// Import DAO for database operations
import database.UserDAO;

// JavaFX libraries
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class RegisterController extends Application {

    @Override
    public void start(Stage stage) {

        // Title label
        Label lblTitle = new Label("REGISTER ACCOUNT");
        lblTitle.setStyle("-fx-font-size:18px; -fx-font-weight:bold;");
        lblTitle.relocate(90, 20);

        // Username label and input field
        Label lblUser = new Label("Username");
        lblUser.relocate(30, 80);

        TextField txtUser = new TextField();
        txtUser.relocate(120, 70);

        // Password label and input field (hidden input)
        Label lblPass = new Label("Password");
        lblPass.relocate(30, 120);

        PasswordField txtPass = new PasswordField();
        txtPass.relocate(120, 110);

        // Register button
        Button btnRegister = new Button("REGISTER");
        btnRegister.setStyle("-fx-background-color:#27ae60; -fx-text-fill:white;");
        btnRegister.relocate(120, 160);

        // Status label for messages
        Label lblStatus = new Label();
        lblStatus.relocate(120, 200);

        // Register button action
        btnRegister.setOnAction(event -> {

            // Get input values
            String username = txtUser.getText();
            String password = txtPass.getText();

            // Validation: check empty fields
            if (username.isEmpty() || password.isEmpty()) {
                lblStatus.setText("Please fill all fields");
                return;
            }

            // Create DAO object
            UserDAO dao = new UserDAO();

            // Register user with default role "User"
            boolean isRegistered = dao.registerUser(username, password, "User");

            // If registration successful
            if (isRegistered) {
                lblStatus.setText("Registration Successful");

                // Clear input fields
                txtUser.clear();
                txtPass.clear();

                // Show popup message
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Registration Successful");
                alert.show();
            } else {
                // If username already exists
                lblStatus.setText("Username already exists!");
            }
        });

        // Back to Login button
        Button btnClose = new Button("BACK TO LOGIN");
        btnClose.relocate(200, 160);

        // Open login screen
        btnClose.setOnAction(event -> {
            try {
                LoginController login = new LoginController();
                login.start(new Stage()); // Open login window
                stage.close();            // Close register window
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Layout container
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 350, 250);

        stage.setScene(scene);
        stage.setTitle("RegisterWindow");

        // Add all components to pane
        pane.getChildren().addAll(lblTitle, lblUser, txtUser, lblPass, txtPass);
        pane.getChildren().addAll(btnRegister, btnClose);
        pane.getChildren().addAll(lblStatus);

        // Show window
        stage.show();
    }
}