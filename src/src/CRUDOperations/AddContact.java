package CRUDOperations; 

// Import required classes
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

// AddContact class - used to add new contact
public class AddContact extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    // Start method - builds UI
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Labels for form fields
        Label lblTitle, lblID, lblName, lblPhone, lblEmail, lblAddress;

        // TextFields for user input
        TextField txtID, txtName, txtPhone, txtEmail, txtAddress;

        // Buttons
        Button btnSearch, btnClose, btnSave;

        // Title
        lblTitle = new Label("CONTACT ENTRY FORM");
        lblTitle.relocate(100, 20);

        // Contact ID
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

        // SAVE BUTTON
        btnSave = new Button("SAVE");
        btnSave.relocate(180, 260);

        // Action when SAVE is clicked
        btnSave.setOnAction(event -> {

            // Create Contact object (Model)
            Contact contact = new Contact();

            // Set values from UI to object
            contact.setContactId(Integer.parseInt(txtID.getText())); // convert String → int
            contact.setName(txtName.getText());
            contact.setPhone(txtPhone.getText());
            contact.setEmail(txtEmail.getText());
            contact.setAddress(txtAddress.getText());

            // Save contact to database
            new DBConnection().save(contact);

            // Clear fields after saving
            txtID.clear();
            txtName.clear();
            txtPhone.clear();
            txtEmail.clear();
            txtAddress.clear();
        });

        // CLOSE BUTTON
        btnClose = new Button("CLOSE");
        btnClose.relocate(110, 260);

        // Go back to dashboard
        btnClose.setOnAction(event -> {
            try {
                new Dashboard().start(new Stage()); // open dashboard
                primaryStage.close();              // close current window
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Styling
        btnSave.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white;");
        btnClose.setStyle("-fx-background-color: #7f8c8d; -fx-text-fill: white;");

        // Layout container
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #f5f6fa;");

        // Scene setup
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CONTACT BOOK SYSTEM");

        // Add components to pane
        pane.getChildren().add(lblTitle);
        pane.getChildren().addAll(lblID, lblName, lblPhone, lblEmail, lblAddress);
        pane.getChildren().addAll(txtID, txtName, txtPhone, txtEmail, txtAddress);
        pane.getChildren().addAll(btnClose, btnSave);

        // Show window
        primaryStage.show();
    }
}