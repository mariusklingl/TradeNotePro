package de.mariusKlingl.LoginWindow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginWindow extends Application {
	
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage arg0) throws Exception {
		
		Parent root = (FXMLLoader.load(getClass().getResource("/de/mariusKlingl/LoginWindow/SignUpWindow.fxml")));
		Scene scene = new Scene(root);	
		
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Trade Note Pro");
		
		
		
		
	}
	
	
	

	
}
