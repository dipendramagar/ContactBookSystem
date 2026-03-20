package Controller;

import java.util.List;

import database.DBConnection;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Contact;

public class AllContacts extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		TableView<Contact> tableView;
		Label lblTitle;
		Button btnRefresh, btnClose, btnDelete;
		TextField txtID = null, txtName, txtPhone, txtEmail, txtAddress;
		
		lblTitle = new Label("ALL CONTACTS");
		lblTitle.setStyle("-fx-font-size:22px; -fx-font-weight:bold; -fx-text-fill:#2c3e50;");
		lblTitle.relocate(220, 10);
		
		tableView = new TableView<>();
		tableView.setPrefHeight(250);
		tableView.setPrefWidth(550);
		tableView.relocate(20, 40);
		
		//table Columns
		TableColumn<Contact, Integer> column1 = new TableColumn<>("contactId");
		TableColumn<Contact, String> column2 = new TableColumn<>("name");
		TableColumn<Contact, String> column3 = new TableColumn<>("phone");
		TableColumn<Contact, String> column4 = new TableColumn<>("email");
		TableColumn<Contact, String> column5 = new TableColumn<>("address");
		
		
		//Mapping Field with Column
		column1.setCellValueFactory(new PropertyValueFactory<>("contactId"));
		column1.setPrefWidth(60); // Set a fixed width of 50 pixels
		column1.setResizable(false); // Prevent user resizing
		
		column2.setCellValueFactory(new PropertyValueFactory<>("name"));
		column2.setPrefWidth(150); // Set a fixed width of 150 pixels
		column2.setResizable(false); // Prevent user resizing

		column3.setCellValueFactory(new PropertyValueFactory<>("phone"));
		column3.setPrefWidth(100); // Set a fixed width of 150 pixels
		column3.setResizable(false); // Prevent user resizing

		column4.setCellValueFactory(new PropertyValueFactory<>("email"));
		column4.setPrefWidth(150); // Set a fixed width of 150 pixels
		column4.setResizable(false); // Prevent user resizing

		column5.setCellValueFactory(new PropertyValueFactory<>("address"));
		column5.setPrefWidth(100); // Set a fixed width of 150 pixels
		column5.setResizable(false); // Prevent user resizing
		
tableView.getColumns().addAll(column1, column2, column3, column4, column5);
		
		//Person person = new PersonDatabase().search(2);
				List<Contact> contacts = new DBConnection().all();
				
				tableView.getItems().addAll(contacts);
		
				//Close button
				btnClose = new Button("CLOSE");
				btnClose.relocate(50, 300);
				btnClose.setOnAction(event->{
					try {
						new Dashboard().start(new Stage());
						primaryStage.close();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				});
				
				//Delete button
				btnDelete = new Button("DELETE");
				btnDelete.relocate(200, 300);
				btnDelete.setOnAction(event->{
					 Contact selectedContact = tableView.getSelectionModel().getSelectedItem();

					    if (selectedContact != null) {
					        int id = selectedContact.getContactId();

					        DBConnection db = new DBConnection();
					        db.Delete(id); // delete from database

					        tableView.getItems().remove(selectedContact); // remove from table
					    } else {
					        System.out.println("No contact selected!");
					    }
					});
				
				//Refresh button
				btnRefresh = new Button("REFRESH");
				btnRefresh.relocate(120, 300);
				btnRefresh.setOnAction(event -> {
				    tableView.getItems().clear();
				    tableView.getItems().addAll(new DBConnection().all());
				});
				
				//color for button
				 btnRefresh.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;");
			        btnDelete.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white;");
			        btnClose.setStyle("-fx-background-color: #7f8c8d; -fx-text-fill: white;");
				
				
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("SHOW CONTACTS");
		
		pane.getChildren().addAll(lblTitle);
		pane.getChildren().addAll(tableView);
		pane.getChildren().addAll(btnClose, btnRefresh, btnDelete);
	
		
		primaryStage.show();
		
	}

}
