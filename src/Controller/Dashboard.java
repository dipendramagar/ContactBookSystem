package Controller;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

	public class Dashboard extends Application {

		public static void main(String[] args) {
			launch(args);
		}

		

		@Override
		public void start(Stage primaryStage) throws Exception {
			Label lblTitle;
			TextField txtID = null;
			Button btnNew, btnSearch, btnAll, 
			btnUpdate, btnDelete, btnClose, btnLogout;
			
			
			lblTitle = new Label("DASHBOARD");
			lblTitle.setStyle("-fx-font-size:22px; -fx-font-weight:bold; -fx-text-fill:#2c3e50;");
	        lblTitle.relocate(220, 20);
	        

			
			btnNew = new Button("ADD CONTACT");
			btnNew.getStyleClass().add("sidebar-button");
			btnNew.setStyle("-fx-background-color:#3498db; -fx-text-fill:white; -fx-font-weight:bold;");
			btnNew.relocate(80, 80);
			btnNew.setOnAction(event->{
				//display new person entry form
				try {
					new AddContact().start(new Stage());
					primaryStage.close();// Close the stage
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			
			
			btnSearch = new Button("SEARCH CONTACT");
			btnSearch.setStyle("-fx-background-color:#3498db; -fx-text-fill:white; -fx-font-weight:bold;");
			btnSearch.relocate(80, 120);
			btnSearch.setOnAction(event->{
				//display new person entry form
				try {
					new SearchContact().start(new Stage());
					primaryStage.close();// Close the stage
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			btnAll = new Button("ALL CONTACT");
			btnAll.setStyle("-fx-background-color:#3498db; -fx-text-fill:white; -fx-font-weight:bold;");
			btnAll.relocate(80, 160);
			btnAll.setOnAction(event->{
				//display new person entry form
				try {
					new AllContacts().start(new Stage());
					primaryStage.close();// Close the stage
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			btnUpdate = new Button("UPDATE CONTACT");
			btnUpdate.setStyle("-fx-background-color:#3498db; -fx-text-fill:white; -fx-font-weight:bold;");
			btnUpdate.relocate(80, 200);
			btnUpdate.setOnAction(event->{
				try {
					new UpdateContact().start(new Stage());
					primaryStage.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			
			btnDelete = new Button("DELETE CONTACT");
			btnDelete.setStyle("-fx-background-color:#3498db; -fx-text-fill:white; -fx-font-weight:bold;");
			btnDelete.relocate(80, 240);
			btnDelete.setOnAction(event->{
				try {
					new DeleteContact().start(new Stage());
					primaryStage.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			});
			
			
			
			btnLogout = new Button("LOGOUT");
			btnLogout.setStyle("-fx-background-color:#c0392b; -fx-text-fill:white; -fx-font-weight:bold;");
			btnLogout.relocate(150, 320);
			btnLogout.setOnAction(event->{
				
				try {
					new LoginController().start(new Stage());
					primaryStage.close();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			});
			
			
			
			Label welcome = new Label("Welcome, Admin/User");
			welcome.setStyle("-fx-font-size:16px; -fx-text-fill:#2c3e50;");
			welcome.relocate(200,370);
			
			Pane pane = new Pane();
			pane.setStyle("-fx-background-color: #f5f6fa;");
			Scene scene = new Scene(pane, 700, 400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("DASHBOARD");
			
			pane.getChildren().addAll(lblTitle);
			pane.getChildren().addAll(btnNew, btnSearch, 
					btnAll, btnUpdate, btnDelete, btnLogout);
			pane.getChildren().add(welcome);
			
			
			
			primaryStage.show();
		}

	}

