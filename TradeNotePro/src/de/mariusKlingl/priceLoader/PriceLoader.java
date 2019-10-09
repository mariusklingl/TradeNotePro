package de.mariusKlingl.priceLoader;

import java.io.IOException;
import java.util.TimerTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.glass.ui.Timer;

import de.mariusKlingl.mainWindow.TradeNoteModel;
import de.mariusKlingl.mainWindow.TradeNoteProMainWindowController;


public class PriceLoader extends Thread{
	
	private  TradeNoteModel tradeNoteModel = new TradeNoteModel();
	public static String ethPrice;
	public static  String btcPrice;

	
	
	private String loadBtcPrice() throws JSONException, IOException {
			
			JSONObject btc = tradeNoteModel.getBTCPrice("https://www.worldcoinindex.com/apiservice/ticker?key=L1SiW1rYHws2OxH3pG2HHNej3SZG6K&label=btcbtc&fiat=eur");
			JSONArray btcArray = (JSONArray) btc.get("Markets");
			System.out.println("Loading btc price");
			btcPrice = ((btcArray.getJSONObject(0).get("Price").toString()));
			System.out.println(ethPrice);
			TradeNoteProMainWindowController.lblBTCPrice.setText(btcPrice);
			return (btcArray.getJSONObject(0).get("Price").toString());	
			
	}
	
	private String loadEthPrice() throws JSONException, IOException {
		
		JSONObject ethPrice = tradeNoteModel.getBTCPrice("https://www.worldcoinindex.com/apiservice/ticker?key=L1SiW1rYHws2OxH3pG2HHNej3SZG6K&label=ethbtc&fiat=usd");
		JSONArray ethArray = (JSONArray) ethPrice.get("Markets");
		System.out.println("Load eth price");
		PriceLoader.ethPrice = ((ethArray.getJSONObject(0).get("Price").toString()));
		System.out.println(btcPrice);
		TradeNoteProMainWindowController.lblEthPrice.setText(PriceLoader.ethPrice);
		return (ethArray.getJSONObject(0).get("Price").toString());
	}
	
	  
	
	
	
	
	
	
	
	public String getEthPrice() {
		return ethPrice;
	}



	public void setEthPrice(String ethPrice) {
		this.ethPrice = ethPrice;
	}



	public String getBtcPrice() {
		return btcPrice;
	}



	public void setBtcPrice(String btcPrice) {
		this.btcPrice = btcPrice;
	}



	@Override
	public void run() {
	
		try {
			loadBtcPrice();
			loadEthPrice();
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
