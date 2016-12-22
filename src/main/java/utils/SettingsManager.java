package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

import domain.Settings;

public class SettingsManager {
	
	private static String settingsFilePath = "config";
	
	private String readSettings() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(settingsFilePath));
		
		String json = "";
		String line = null;
		while((line = br.readLine()) != null){
			json += line;
		}
		br.close();
		return json;
	}

	public Settings fromJSON(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, Settings.class);
	}

	public String toJSON(Settings settings) {
		Gson gson = new Gson();
		return gson.toJson(settings);
	}
}

// pull json string from settings file
// marshall to Settings object
// execute any settings, e.g. show splash
// reflect saved state in options frame