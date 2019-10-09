package de.mariusKlingl.mainWindow;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;

public class TradeNoteProTradesVerwaltenController {
	
	   @FXML
	    private AnchorPane pane;

	    @FXML
	    private MenuBar menuBar;

	    @FXML
	    private Button btnPortfolio;

	    @FXML
	    private Button btnTradesVerwalten;

	    @FXML
	    private Label lblEthPrice;

	    @FXML
	    private Label lblBTCPrice;

	    @FXML
	    private Label lblEuroWert;

	    @FXML
	    void btnPortfolioClicked(ActionEvent event) throws IOException {
	    	
	    	AnchorPane mainWindow = FXMLLoader.load(getClass().getResource("/de/mariusKlingl/mainWindow/mainWindow.fxml"));
	    	pane.getChildren().clear();
	    	pane.getChildren().addAll(mainWindow);

	    }

	    @FXML
	    void btnTradesVerwaltenClicked(ActionEvent event) {

	    }

}
