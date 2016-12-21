package utils;

import com.google.gson.Gson;

import domain.Settings;

public class SettingsManager {
	
	public Settings fromJSON(String json){
		Gson gson = new Gson();
		return gson.fromJson(json, Settings.class);
	}
	
	public String toJSON(Settings settings){
		Gson gson = new Gson();
		return gson.toJson(settings);
	}
}