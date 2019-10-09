package de.mariusKlingl.mainWindow;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import de.mariusKlingl.APIReader.APIReader;

public class TradeNoteModel {
	

	
	public JSONObject getBTCPrice(String url) throws JSONException, IOException {
		return APIReader.readJsonFromUrl(url);
	}

}
