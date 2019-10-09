package de.mariusKlingl.LoginWindow;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class LoginWindowController implements Initializable{
	
	@FXML
    private AnchorPane pane;

    @FXML
    private TextField tfBenutzername;

    @FXML
    private Button btnAnmelden;

    @FXML
    private Label lblRegister;

    @FXML
    private PasswordField tfPasswort;

    @FXML
    private Label lblErrorMessage;

    @FXML
    private ImageView lblCross;
    
    private LoginModel LoginModel = new LoginModel();
    
    
    
    
    @FXML
    void passwordKeyReleased(KeyEvent event) {
    	
    	boolean fieldsAreFilled = ((tfBenutzername.getText().isEmpty() || tfBenutzername.getText().length()<5) || (tfPasswort.getText().isEmpty() || tfPasswort.getText().length()<5));
		
		if(fieldsAreFilled) {
			System.out.println("Nicht genug Info, Button disabled");
			btnAnmelden.setDisable(true);
		}else {
			btnAnmelden.setDisable(false);
		}
    }

    @FXML
   
    
    void btnAnmeldenPressed(ActionEvent event) throws IOException {
    	
    	
    	
    	if(LoginModel.checkLoginInfo(tfBenutzername.getText(), tfPasswort.getText())) {
    		
    		Stage loginStage = (Stage)lblCross.getScene().getWindow();
        	loginStage.close();
        	
        	AnchorPane mainWindow = FXMLLoader.load(getClass().getResource("/de/mariusKlingl/mainWindow/mainWindow.fxml"));
        	Scene mainWindowScene = new Scene(mainWindow);
        	Stage mainWindowStage = new Stage();
        	mainWindowStage.setScene(mainWindowScene);
        	mainWindowStage.show();
        	mainWindowStage.setTitle("Trade Note Pro");
        	mainWindowStage.setMinWidth(1000);
        	mainWindowStage.setMinHeight(780);
    		
    	}else {
    		lblErrorMessage.setText("LoginDaten inkorrekt. Bitte erneut versuchen.");
    		lblErrorMessage.setVisible(true);
    		lblCross.setVisible(true);
    	}
    	
    	
    	
    	
    	
    }

    @FXML
    void crossClicked(MouseEvent event) {
    	
    	lblErrorMessage.setVisible(false);
    	lblCross.setVisible(false);

    }

    @FXML
    void lblCrossEntered(MouseEvent event) {
    	
			lblCross.setScaleX(1.3);
			lblCross.setScaleY(1.3);
    }
    
    @FXML
    
    void lblCrossExited(MouseEvent event) {
    	lblCross.setScaleX(1);
    	lblCross.setScaleY(1);
    }
  
    
    @FXML
    void lblRegisterPressed(MouseEvent event) throws IOException {
    	
    	AnchorPane root = FXMLLoader.load(getClass().getResource("/de/mariusKlingl/LoginWindow/SignUpWindow.fxml"));
    	pane.getChildren().setAll(root);
    }

	public void initialize(URL arg0, ResourceBundle arg1) {
		lblCross.setVisible(false);
		lblErrorMessage.setVisible(false);
		btnAnmelden.setDisable(true);
		
	}
	

}
