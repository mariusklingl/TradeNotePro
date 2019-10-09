package de.mariusKlingl.mainWindow;

import java.io.IOException;


import java.net.URL;
import java.nio.channels.ScatteringByteChannel;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.mysql.cj.jdbc.interceptors.ServerStatusDiffInterceptor;
import com.sun.media.jfxmediaimpl.platform.Platform;

import de.mariusKlingl.priceLoader.PriceLoader;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class TradeNoteProMainWindowController implements Initializable{
	
	 @FXML
	    private AnchorPane pane;

	    @FXML
	    private MenuBar menuBar;
	    
	    @FXML
	    private AnchorPane lblPane1;
	    
	    @FXML
	    private AnchorPane lblPaneBTC;

	    @FXML
	    private Button btnPortfolio;

	    @FXML
	    private Button btnTradesVerwalten;

	    @FXML
	    public static  Label lblEthPrice = new Label("price");

	    @FXML
	    public static  Label lblBTCPrice = new Label("price");

	    @FXML
	    private TableView<?> tableTrades;

	    @FXML
	    private TableColumn<?, ?> columnPaar;

	    @FXML
	    private TableColumn<?, ?> columnKaufkurs;

	    @FXML
	    private TableColumn<?, ?> columnAnzahlCoins;

	    @FXML
	    private TableColumn<?, ?> columnAktuellerKurs;

	    @FXML
	    private TableColumn<?, ?> columnGewinnVerlust;

	    @FXML
	    private LineChart<?, ?> historyChart;

	    @FXML
	    private PieChart pieChart;

	    @FXML
	    private Label lblEuroWert;
	    private TradeNoteModel tradeNoteModel = new TradeNoteModel();
	    private PriceLoader priceLoader = new PriceLoader();
	    
	    

	    @FXML
	    void btnPortfolioClicked(ActionEvent event) throws IOException {

	    	AnchorPane mainWindow = FXMLLoader.load(getClass().getResource("/de/de/mariusKlingl/mainWindow/mainWindow.fxml"));
	    	pane.getChildren().clear();
	    	pane.getChildren().addAll(mainWindow);
	    }

	    @FXML
	    void btnTradesVerwaltenClicked(ActionEvent event) throws IOException {
	    	AnchorPane tradesVerwwaltenWindow = FXMLLoader.load(getClass().getResource("/de/mariusKlingl/mainWindow/mainWindowTradesVerwalten.fxml"));
	    	pane.getChildren().clear();
	    	pane.getChildren().addAll(tradesVerwwaltenWindow);
	    	
	
	    }
	    
	  
	    
	   
	   
		public void initialize(URL arg0, ResourceBundle arg1) {
			lblPaneBTC.getChildren().add(lblBTCPrice);
			lblPane1.getChildren().add(lblEthPrice);
			Timer priceTimer = new Timer();
			
		}
		
		
		

		
		
		
		

}
