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

public class ContactController extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label lblTitle, lblID, lblName, lblPhone, lblEmail, lblAddress;
		TextField txtID, txtName, txtPhone, txtEmail, txtAddress;
		Button btnSearch, btnClose, btnSave, btnUpdate, btnDelete;
		
		//ADD CONTACT
		lblTitle = new Label("CONTACT ENTRY FORM");
		lblTitle.relocate(100, 20);
		
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
		btnSave = new Button("SAVE");
		btnSave.relocate(180, 260);
		btnSave.setOnAction(event->{
			Contact contact = new Contact();
			contact.setContactId(Integer.parseInt(txtID.getText()));
			contact.setName(txtName.getText());
			contact.setPhone(txtPhone.getText());
			contact.setEmail(txtEmail.getText());
			contact.setAddress(txtAddress.getText());
			new DBConnection().save(contact);
			
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
			primaryStage.close();
		});
		
		//UPDATE
		btnUpdate = new Button("UPDATE");
		btnUpdate.relocate(230, 260);

		btnUpdate.setOnAction(event -> {
		    Contact contact = new Contact();
		    contact.setContactId(Integer.parseInt(txtID.getText()));
		    contact.setName(txtName.getText());
		    contact.setPhone(txtPhone.getText());
		    contact.setEmail(txtEmail.getText());
		    contact.setAddress(txtAddress.getText());

		    new DBConnection().update(contact);
		    
		
		
		});
		
		//DELETE
		btnDelete = new Button("DELETE");
		btnDelete.relocate(180, 260);
		btnDelete.setOnAction(event->{
			int id = Integer.parseInt(txtID.getText());
			boolean result = new DBConnection().Delete(id);
			System.out.println(result);
		});
		
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 350, 350);
		primaryStage.setScene(scene);
		primaryStage.setTitle("CONTACT BOOK SYSTEM");
		
		pane.getChildren().add(lblTitle);
		pane.getChildren().addAll(lblID, lblName, lblPhone, lblEmail, lblAddress);
		pane.getChildren().addAll(txtID, txtName,txtPhone, txtEmail, txtAddress);
		pane.getChildren().addAll(btnSearch, btnClose, btnSave, btnUpdate, btnDelete);
		
	    primaryStage.show();
		
		
	}

}

	


