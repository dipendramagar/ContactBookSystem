package Controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Label lblTitle,lblUser, lblPassword, lblRegUser, lblRegPass;
		TextField txtUser, txtPassword, txtRegUser,txtRegPass;
		Button btnClose, btnLogin, btnRegister;
		PasswordField pafPassword;
		
		lblTitle = new Label("LOGIN / REGISTER");
		lblTitle.setStyle("-fx-text-fill: #2c3e50; -fx-font-size: 24px; -fx-font-weight: bold;");
		lblTitle.relocate(110, 10);
		
		lblUser = new Label("USERNAME  ");
		lblUser.relocate(30, 60);
		txtUser = new TextField();
		txtUser.relocate(120, 50);
		
		lblPassword = new Label("PASSWORD  ");
		lblPassword.relocate(30, 100);
		pafPassword = new PasswordField();
		pafPassword.relocate(120, 90);
		
	    
	  		
        //Login
		btnLogin = new Button("LOGIN");
		btnLogin.setStyle("-fx-background-color:#2980b9; -fx-text-fill:white; -fx-font-weight:bold;");
		btnLogin.relocate(120, 130);
		btnLogin.setOnAction(event->{
			String username = txtUser.getText();
			String password = pafPassword.getText();
			if(username.endsWith("admin") && password.equals("admin123")) {
				System.out.println("Login Sucessful");
				
				
			
				// after login open new dashboard window
				Dashboard dash = new Dashboard();
				Stage dashboardstage = new Stage();
				try {
					dash.start(dashboardstage);
					stage.close();
				} catch (Exception e) {
					e.printStackTrace();	
				} 
		
			}else {
				System.out.println("incorrect password or username");
			}
			
		});
		
		
		//close window
		btnClose=new Button("CLOSE");
		btnClose.setStyle("-fx-background-color:#c0392b; -fx-text-fill:white; -fx-font-weight:bold;");
		btnClose.relocate(200, 130);
		btnClose.setOnAction(event->{
			stage.close();
		});
		
	/*
		//register new acc
		btnRegister = new Button("REGISTER");
        btnRegister.setStyle("-fx-background-color:#27ae60; -fx-text-fill:white; -fx-font-weight:bold;");
        btnRegister.relocate(120, 250);
        btnRegister.setOnAction(event -> {
            String newUser = txtRegUser.getText();
            String newPass = txtRegPass.getText();

            if (newUser.isEmpty() || newPass.isEmpty()) {
                System.out.println("Please fill in all registration fields");
            } else {
                // Here you can add database insertion if you have DB
                System.out.println("User Registered: " + newUser);

                // Clear fields after registration
                txtRegUser.clear();
                txtRegPass.clear();
            }
        });
		*/
		
		Pane pane = new Pane();
		pane.setStyle("-fx-background-color:#f5f6fa;");
		Scene scene = new Scene(pane, 400, 300);
		stage.setScene(scene);
		stage.setTitle("LOGIN/AUTHINCATOR");
		
		pane.getChildren().addAll(lblTitle, lblUser, lblPassword);
		pane.getChildren().addAll(txtUser, pafPassword);
		pane.getChildren().addAll(btnClose, btnLogin);
		stage.show();
		
		
	}
}