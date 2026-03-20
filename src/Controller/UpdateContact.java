package Controller;

import database.DBConnection;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Contact;

public class UpdateContact extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label lblTitle, lblID, lblName, lblPhone, lblEmail, lblAddress;
		TextField txtID, txtName, txtPhone, txtEmail, txtAddress;
		Button btnSearch, btnClose, btnSave, btnUpdate;
		
		
		lblTitle = new Label("UPDATE");
		lblTitle.setStyle("-fx-font-size:22px; -fx-font-weight:bold; -fx-text-fill:#2c3e50;");
		lblTitle.relocate(130, 20);
		
		lblID = new Label("CONTACTID : ");
		lblID.relocate(20, 60);
		txtID = new TextField();
		txtID.relocate(100, 55);
		
		lblName = new Label("NAME : ");
		lblName.relocate(20, 100);
		txtName = new TextField();
		txtName.relocate(100, 95);
		
		lblPhone = new Label("PHONE : ");
		lblPhone.relocate(20, 140);
		txtPhone = new TextField();
		txtPhone.relocate(100, 135);
		
		lblEmail = new Label("EMAIL : ");
		lblEmail.relocate(20, 180);
		txtEmail = new TextField();
		txtEmail.relocate(100, 175);
		
		lblAddress = new Label("ADDRESS : ");
		lblAddress.relocate(20, 220);
		txtAddress = new TextField();
		txtAddress.relocate(100, 215);
		
//		SAVE
		btnUpdate = new Button("UPDATE");
		btnUpdate.relocate(180, 260);
		btnUpdate.setOnAction(event->{
			try {
				Contact contact = new Contact();
				
				contact.setContactId(Integer.parseInt(txtID.getText()));
				contact.setName(txtName.getText());
				contact.setPhone(txtPhone.getText());
				contact.setEmail(txtEmail.getText());
				contact.setAddress(txtAddress.getText());
				
				new DBConnection().update(contact);
				System.out.println("Update Sucessfully");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		
//		SEARCH
		btnSearch = new Button("SEARCH");
		btnSearch.relocate(260, 55);
		btnSearch.setOnAction(event->{
			int contactId = Integer.parseInt(txtID.getText());
			Contact contact = new DBConnection().search(contactId);
			txtName.setText(contact.getName());
			txtPhone.setText(contact.getPhone());
			txtEmail.setText(contact.getEmail());
			txtAddress.setText(contact.getAddress());
		});
		
		btnClose = new Button("CLOSE");
		btnClose.relocate(110, 260);
		btnClose.setOnAction(event->{
			try {
				new Dashboard().start(new Stage());
				primaryStage.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		});
		
		//color for button
		 btnSearch.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;");
	        btnUpdate.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white;");
	        btnClose.setStyle("-fx-background-color: #7f8c8d; -fx-text-fill: white;");
		
		
		
		
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("CONTACT BOOK SYSTEM");
		
		pane.getChildren().add(lblTitle);
		pane.getChildren().addAll(lblID, lblName, lblPhone, lblEmail, lblAddress);
		pane.getChildren().addAll(txtID, txtName,txtPhone, txtEmail, txtAddress);
		pane.getChildren().addAll(btnSearch, btnClose, btnUpdate);
		
	    primaryStage.show();
		
		
	}

}

	


