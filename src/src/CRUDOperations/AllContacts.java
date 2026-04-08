package CRUDOperations; // Package for CRUD operations

// Import required classes
import java.util.List;

import Controller.Dashboard;
import database.DBConnection;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Contact;

// Class to display all contacts (READ operation)
public class AllContacts extends Application {

    // Main method
    public static void main(String[] args) {
        launch(args);
    }

    // Start method - builds UI
    @Override
    public void start(Stage primaryStage) throws Exception {

        // TableView to display contacts
        TableView<Contact> tableView;

        // Labels and buttons
        Label lblTitle;
        Button btnRefresh, btnClose, btnDelete;

        // Title
        lblTitle = new Label("ALL CONTACTS");
        lblTitle.setStyle("-fx-font-size:22px; -fx-font-weight:bold; -fx-text-fill:#2c3e50;");
        lblTitle.relocate(220, 10);

        // Create table
        tableView = new TableView<>();
        tableView.setPrefHeight(250);
        tableView.setPrefWidth(550);
        tableView.relocate(20, 40);

        // Create columns
        TableColumn<Contact, Integer> column1 = new TableColumn<>("contactId");
        TableColumn<Contact, String> column2 = new TableColumn<>("name");
        TableColumn<Contact, String> column3 = new TableColumn<>("phone");
        TableColumn<Contact, String> column4 = new TableColumn<>("email");
        TableColumn<Contact, String> column5 = new TableColumn<>("address");

        // Map columns to Contact class properties
        column1.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        column2.setCellValueFactory(new PropertyValueFactory<>("name"));
        column3.setCellValueFactory(new PropertyValueFactory<>("phone"));
        column4.setCellValueFactory(new PropertyValueFactory<>("email"));
        column5.setCellValueFactory(new PropertyValueFactory<>("address"));

        // Add columns to table
        tableView.getColumns().addAll(column1, column2, column3, column4, column5);

        // Fetch data from database
        List<Contact> contacts = new DBConnection().all();

        // Add data to table
        tableView.getItems().addAll(contacts);

        // CLOSE BUTTON
        btnClose = new Button("CLOSE");
        btnClose.relocate(50, 300);

        btnClose.setOnAction(event -> {
            try {
                new Dashboard().start(new Stage()); // Go to dashboard
                primaryStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // DELETE BUTTON (Delete selected contact)
        btnDelete = new Button("DELETE");
        btnDelete.relocate(200, 300);

        btnDelete.setOnAction(event -> {
            // Get selected contact from table
            Contact selectedContact = tableView.getSelectionModel().getSelectedItem();

            if (selectedContact != null) {
                int id = selectedContact.getContactId();

                // Delete from database
                DBConnection db = new DBConnection();
                db.Delete(id);

                // Remove from table
                tableView.getItems().remove(selectedContact);
            } else {
                System.out.println("No contact selected!");
            }
        });

        // REFRESH BUTTON
        btnRefresh = new Button("REFRESH");
        btnRefresh.relocate(120, 300);

        btnRefresh.setOnAction(event -> {
            tableView.getItems().clear(); // Clear old data
            tableView.getItems().addAll(new DBConnection().all()); // Reload data
        });

        // Layout
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("SHOW CONTACTS");

        // Add components
        pane.getChildren().addAll(lblTitle);
        pane.getChildren().addAll(tableView);
        pane.getChildren().addAll(btnClose, btnRefresh, btnDelete);

        primaryStage.show();
    }
}