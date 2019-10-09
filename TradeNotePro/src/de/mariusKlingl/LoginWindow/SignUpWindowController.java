package de.mariusKlingl.LoginWindow;

import java.io.IOException;

import java.net.Inet4Address;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.management.loading.PrivateClassLoader;
import de.mariusKlingl.Database.DatabaseConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.*;

public class SignUpWindowController implements Initializable{
	

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField tfBenutzername;

    @FXML
    private TextField tfEmailAdresse;

    @FXML
    private Button btnRegistrieren;

    @FXML
    private Label lblLoginWindow;

    @FXML
    private PasswordField tfPasswort;

    @FXML
    private PasswordField tfPasswotConfirm;

    @FXML
    private Label lblErrorMessage;
    
    @FXML
    private ImageView lblWhiteTickUsername;

    @FXML
    private ImageView lblWhiteTickEmail;

    @FXML
    private ImageView lblWhiteTickPassword;

    @FXML
    private ImageView lblCross;
    private Pattern pattern;
    private Matcher matcher;
    private String email;
    private String username;
    private String passwort;
    private DatabaseConnector databaseConnector = new DatabaseConnector();
    private LoginModel LoginModel = new LoginModel();
  
    


    
    @FXML
    void tfPassClicked(MouseEvent event) {
    	
    	Pattern pattern = Pattern.compile("^.+@.+\\..+$");
      	Matcher matcher = pattern.matcher(tfEmailAdresse.getText());
    	
   		
   		if (matcher.matches()) {
   			System.out.println("Korrektes Format");
   			if (LoginModel.checkEmaiInDatabase(tfEmailAdresse.getText())) {
   				email = tfEmailAdresse.getText();
   				lblWhiteTickEmail.setVisible(true);
			}else {
				lblCross.setVisible(true);
				lblErrorMessage.setVisible(true);
				lblErrorMessage.setText("Diese Email Adresse wurde schon verwendet");
				lblWhiteTickEmail.setVisible(false);
   			}
   		}else {
   			lblCross.setVisible(true);
   			lblErrorMessage.setText("Bitte geben Sie eine korrekte Email an");
   			lblErrorMessage.setVisible(true);
   			lblWhiteTickEmail.setVisible(false);
   		}
  
    }
    
    @FXML
    void tfEmailClicked(MouseEvent event) {
    	
    	if(tfBenutzername.getText().length()<5) {
    		System.out.println("Zu Kurzer Benutzername");
    		lblCross.setVisible(true);
    		lblErrorMessage.setVisible(true);
    		lblErrorMessage.setText("Benutzername muss aus min. 5 Zeichen bestehen");
    		lblWhiteTickUsername.setVisible(false);
    	}else if(LoginModel.checkUserNameInDatabse(tfBenutzername.getText())){
    		username = tfBenutzername.getText();
    		lblWhiteTickUsername.setVisible(true);
    	}else {
    		System.out.println("Benutzername schon vergeben");
    		lblWhiteTickUsername.setVisible(false);
    		lblCross.setVisible(true);
    		lblErrorMessage.setVisible(true);
    		lblErrorMessage.setText("Benutzername vergeben");
    	}
    }

    @FXML
    void tfPassReleased(KeyEvent event) {
    	
    	
    	if (tfPasswort.getText().equals(tfPasswotConfirm.getText())) {
			lblWhiteTickPassword.setVisible(true);
			System.out.println("Stimmt überein");
			passwort = tfPasswotConfirm.getText();
			
		}else {
			lblWhiteTickPassword.setVisible(false);
			System.out.println("Stimmt nicht überein");
		}
    }

    @FXML
    void tfUsernameReleased(KeyEvent event) {
    	
    }

    @FXML
    void btnRegistrierenPressed(ActionEvent event) {
    	
    	if(LoginModel.createMember(username, email, passwort)) {
    		lblCross.setVisible(true);
    		lblErrorMessage.setVisible(true);
    		lblErrorMessage.setText("Konto erfolgreich angelegt! Willkommen "+username);
    	}

    }

    @FXML
    void lblCrossClicked(MouseEvent event) {
    	
    	lblErrorMessage.setVisible(false);
    	lblCross.setVisible(false);

    }
    
    

    @FXML
    void lblCrossEntered(MouseEvent event) {

    	lblCross.setScaleX(1.3);
    	lblCross.setScaleY(1.3);
    	
    }

    @FXML
    void lblCrossReleased(MouseEvent event) {
    	
    	lblCross.setScaleX(1);
    	lblCross.setScaleY(1);

    }
 	

    @FXML
    void lblLoginPressed(MouseEvent event) throws IOException {
    	
    	AnchorPane root = FXMLLoader.load(getClass().getResource("/de/mariusKlingl/LoginWindow/LoginWindow.fxml"));
    	pane.getChildren().setAll(root);
    }

	public void initialize(URL arg0, ResourceBundle arg1) {
		lblCross.setVisible(false);
		lblErrorMessage.setVisible(false);
		lblWhiteTickUsername.setVisible(false);
		lblWhiteTickEmail.setVisible(false);
		lblWhiteTickPassword.setVisible(false);
	}
    
    
	

}
