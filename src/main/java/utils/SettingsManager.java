package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import domain.Settings;

public class SettingsManager {
	
	private static String SETTINGS_FILE_PATH = "config";
	
	public static Settings getSettings() {
		String json = null;
		try {
			json = readSettingsFile();
		} catch (IOException e) {
			System.out.println("Could not read settings file");
		}
		Gson gson = new Gson();
		return gson.fromJson(json, Settings.class);
	}

	public static void saveSettings(Settings settings) {
		Gson gson = new Gson();
		try {
			writeSettingsFile(gson.toJson(settings));
		} catch (IOException e) {
			System.out.println("Could not write to settings file");
		}
	}
	
	private static void writeSettingsFile(String json) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(SETTINGS_FILE_PATH));
		
		bw.write(json);
		bw.close();
	}
	
	private static String readSettingsFile() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(SETTINGS_FILE_PATH));
		
		String json = "";
		String line = null;
		while((line = br.readLine()) != null){
			json += line;
		}
		br.close();
		return json;
	}
	
}

// execute any settings, e.g. show splash
// reflect saved state in options frame