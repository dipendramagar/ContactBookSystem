package Controller;

// Importing all CRUD operation classes (each opens a new screen)
import CRUDOperations.AddContact;
import CRUDOperations.AllContacts;
import CRUDOperations.DeleteContact;
import CRUDOperations.SearchContact;
import CRUDOperations.UpdateContact;

// JavaFX libraries for UI
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

// Dashboard class extends Application (JavaFX main class)
public class Dashboard extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    // start() method - entry point of JavaFX UI
    @Override
    public void start(Stage primaryStage) throws Exception {

        // UI Components declaration
        Label lblTitle;
        Button btnNew, btnSearch, btnAll, 
               btnUpdate, btnDelete, btnClose, btnLogout;

        // Title Label
        lblTitle = new Label("DASHBOARD");
        lblTitle.setStyle("-fx-font-size:22px; -fx-font-weight:bold; -fx-text-fill:#2c3e50;");
        lblTitle.relocate(200, 20); // Position on screen

        // ADD CONTACT Button
        btnNew = new Button("ADD CONTACT");
        btnNew.setStyle("-fx-background-color:#3498db; -fx-text-fill:white; -fx-font-weight:bold;");
        btnNew.relocate(80, 80);

        // Event handling: open AddContact screen
        btnNew.setOnAction(event -> {
            try {
                new AddContact().start(new Stage()); // Open new window
                primaryStage.close(); // Close dashboard
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // SEARCH CONTACT Button
        btnSearch = new Button("SEARCH CONTACT");
        btnSearch.setStyle("-fx-background-color:#3498db; -fx-text-fill:white; -fx-font-weight:bold;");
        btnSearch.relocate(80, 120);

        // Open Search screen
        btnSearch.setOnAction(event -> {
            try {
                new SearchContact().start(new Stage());
                primaryStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // VIEW ALL CONTACTS Button
        btnAll = new Button("ALL CONTACT");
        btnAll.setStyle("-fx-background-color:#3498db; -fx-text-fill:white; -fx-font-weight:bold;");
        btnAll.relocate(80, 160);

        // Open AllContacts screen
        btnAll.setOnAction(event -> {
            try {
                new AllContacts().start(new Stage());
                primaryStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // UPDATE CONTACT Button
        btnUpdate = new Button("UPDATE CONTACT");
        btnUpdate.setStyle("-fx-background-color:#3498db; -fx-text-fill:white; -fx-font-weight:bold;");
        btnUpdate.relocate(80, 200);

        // Open Update screen
        btnUpdate.setOnAction(event -> {
            try {
                new UpdateContact().start(new Stage());
                primaryStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // DELETE CONTACT Button
        btnDelete = new Button("DELETE CONTACT");
        btnDelete.setStyle("-fx-background-color:#3498db; -fx-text-fill:white; -fx-font-weight:bold;");
        btnDelete.relocate(80, 240);

        // Open Delete screen
        btnDelete.setOnAction(event -> {
            try {
                new DeleteContact().start(new Stage());
                primaryStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // LOGOUT Button
        btnLogout = new Button("LOGOUT");
        btnLogout.setStyle("-fx-background-color:#c0392b; -fx-text-fill:white; -fx-font-weight:bold;");
        btnLogout.relocate(150, 320);

        // Logout action - return to login screen
        btnLogout.setOnAction(event -> {
            try {
                new LoginController().start(new Stage());
                primaryStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Welcome Label
        Label welcome = new Label("Welcome, Admin/User");
        welcome.setStyle("-fx-font-size:16px; -fx-text-fill:#2c3e50;");
        welcome.relocate(200, 370);

        // Pane (root container)
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #f5f6fa;");

        // Scene setup
        Scene scene = new Scene(pane, 500, 400);

        // Stage setup
        primaryStage.setScene(scene);
        primaryStage.setTitle("DASHBOARD");

        // Adding all components to pane
        pane.getChildren().addAll(lblTitle);
        pane.getChildren().addAll(btnNew, btnSearch, 
                btnAll, btnUpdate, btnDelete, btnLogout);
        pane.getChildren().add(welcome);

        // Display the window
        primaryStage.show();
    }
}
