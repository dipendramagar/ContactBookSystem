package Controller;

// Importing DAO class for database operations
import database.UserDAO;

// JavaFX UI libraries
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

// LoginController class - handles login and navigation
public class LoginController extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    // Start method - creates UI
    @Override
    public void start(Stage stage) throws Exception {

        // UI components declaration
        Label lblTitle, lblUser, lblPassword, lblRegUser, lblRegPass, lblMessage, lblStatus;
        TextField txtUser, txtPassword, txtRegPass, txtRegUser;
        Button btnClose, btnLogin, btnRegister;
        PasswordField pafPassword;

        // Title label
        lblTitle = new Label("LOGIN / REGISTER");
        lblTitle.setStyle("-fx-text-fill: #2c3e50; -fx-font-size: 24px; -fx-font-weight: bold;");
        lblTitle.relocate(110, 10);

        // Username label and field
        lblUser = new Label("USERNAME");
        lblUser.relocate(30, 60);
        txtUser = new TextField();
        txtUser.relocate(120, 50);

        // Password label and field (PasswordField hides input)
        lblPassword = new Label("PASSWORD");
        lblPassword.relocate(30, 100);
        pafPassword = new PasswordField();
        pafPassword.relocate(120, 90);

        // Message labels for feedback
        lblMessage = new Label();
        lblMessage.relocate(150, 170);

        lblStatus = new Label();
        lblStatus.relocate(120, 170);

        // LOGIN BUTTON
        btnLogin = new Button("LOGIN");
        btnLogin.setStyle("-fx-background-color:#2980b9; -fx-text-fill:white; -fx-font-weight:bold;");
        btnLogin.relocate(120, 130);

        // Login button action
        btnLogin.setOnAction(e -> {

            // Get user input
            String username = txtUser.getText();
            String password = pafPassword.getText();

            // Validation: check empty fields
            if (username.isEmpty() || password.isEmpty()) {
                lblStatus.setText("Please enter username and password");
                return;
            }

            // Call DAO to verify user from database
            UserDAO dao = new UserDAO();
            String role = dao.loginUser(username, password);

            // If login fails
            if (role == null) {
                lblStatus.setText("Invalid Username or Password");
            } 
            else {
                // If login successful → open dashboard
                try {
                    new Dashboard().start(new Stage());
                    stage.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // CLOSE BUTTON
        btnClose = new Button("CLOSE");
        btnClose.setStyle("-fx-background-color:#c0392b; -fx-text-fill:white; -fx-font-weight:bold;");
        btnClose.relocate(200, 130);

        // Close application
        btnClose.setOnAction(event -> {
            stage.close();
        });

        // REGISTER BUTTON
        btnRegister = new Button("REGISTER NEW ACCOUNT");
        btnRegister.setStyle("-fx-background-color:#27ae60; -fx-text-fill:white; -fx-font-weight:bold;");
        btnRegister.relocate(200, 200);

        // Open register screen
        btnRegister.setOnAction(event -> {
            RegisterController reg = new RegisterController();
            Stage regStage = new Stage();
            try {
                reg.start(regStage);
                stage.close();      
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Root layout
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color:#f5f6fa;");

        // Scene setup
        Scene scene = new Scene(pane, 400, 300);
        stage.setScene(scene);
        stage.setTitle("LOGIN/AUTHENTICATOR");

        // Add components to pane
        pane.getChildren().addAll(lblTitle, lblUser, lblPassword);
        pane.getChildren().addAll(txtUser, pafPassword);
        pane.getChildren().addAll(btnClose, btnLogin, btnRegister);
        pane.getChildren().addAll(lblMessage, lblStatus);

        stage.show();
    }
}