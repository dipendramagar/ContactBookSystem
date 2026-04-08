package CRUDOperations;

import Controller.Dashboard;
import database.DBConnection;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Contact;

// Class for deleting a contact (DELETE operation)
public class DeleteContact extends Application {

    public static void main(String[] args) {
        launch(args); // Start JavaFX
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // UI Components
        Label lblTitle, lblID, lblName, lblPhone, lblEmail, lblAddress, lblStatus;
        TextField txtID, txtName, txtPhone, txtEmail, txtAddress;
        Button btnSearch, btnClose, btnDelete;

        // Title
        lblTitle = new Label("DELETE");
        lblTitle.setStyle("-fx-font-size:22px; -fx-font-weight:bold;");
        lblTitle.relocate(130, 20);

        // ID field
        lblID = new Label("CONTACTID : ");
        lblID.relocate(20, 60);
        txtID = new TextField();
        txtID.relocate(100, 55);

        // Name
        lblName = new Label("NAME : ");
        lblName.relocate(20, 100);
        txtName = new TextField();
        txtName.relocate(100, 95);

        // Phone
        lblPhone = new Label("PHONE : ");
        lblPhone.relocate(20, 140);
        txtPhone = new TextField();
        txtPhone.relocate(100, 135);

        // Email
        lblEmail = new Label("EMAIL : ");
        lblEmail.relocate(20, 180);
        txtEmail = new TextField();
        txtEmail.relocate(100, 175);

        // Address
        lblAddress = new Label("ADDRESS : ");
        lblAddress.relocate(20, 220);
        txtAddress = new TextField();
        txtAddress.relocate(100, 215);

        // Status message
        lblStatus = new Label();
        lblStatus.setStyle("-fx-text-fill: red;");
        lblStatus.relocate(120, 235);

        // DELETE BUTTON
        btnDelete = new Button("DELETE");
        btnDelete.relocate(180, 260);

        btnDelete.setOnAction(event -> {
            try {
                int id = Integer.parseInt(txtID.getText());

                // Call delete method
                boolean result = new DBConnection().Delete(id);

                if (result) {
                    lblStatus.setText("Contact Deleted Successfully");
                } else {
                    lblStatus.setText("Contact Not Found");
                }

                // Clear fields
                txtID.clear();
                txtName.clear();
                txtPhone.clear();
                txtEmail.clear();
                txtAddress.clear();

            } catch (NumberFormatException e) {
                lblStatus.setText("Invalid ID format");
            }
        });

        // SEARCH BUTTON (to find contact before deleting)
        btnSearch = new Button("SEARCH");
        btnSearch.relocate(260, 55);

        btnSearch.setOnAction(event -> {
            try {
                int contactId = Integer.parseInt(txtID.getText());

                // Fetch contact from database
                Contact contact = new DBConnection().search(contactId);

                if (contact != null) {
                    // Fill fields with data
                    txtName.setText(contact.getName());
                    txtPhone.setText(contact.getPhone());
                    txtEmail.setText(contact.getEmail());
                    txtAddress.setText(contact.getAddress());

                    lblStatus.setText("Contact Found");
                } else {
                    lblStatus.setText("Contact Not Found");

                    // Clear fields
                    txtName.clear();
                    txtPhone.clear();
                    txtEmail.clear();
                    txtAddress.clear();
                }

            } catch (NumberFormatException e) {
                lblStatus.setText("Invalid ID");
            }
        });

        // CLOSE BUTTON
        btnClose = new Button("CLOSE");
        btnClose.relocate(110, 260);

        btnClose.setOnAction(event -> {
            try {
                new Dashboard().start(new Stage());
                primaryStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Layout
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("CONTACT BOOK SYSTEM");

        // Add components
        pane.getChildren().addAll(lblTitle, lblID, lblName, lblPhone, lblEmail, lblAddress);
        pane.getChildren().addAll(txtID, txtName, txtPhone, txtEmail, txtAddress);
        pane.getChildren().addAll(btnSearch, btnDelete, btnClose, lblStatus);

        primaryStage.show();
    }
}