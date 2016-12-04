package utils;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Settings {
	
	private String configFilePath; 
	private Map<String, String> state;
	
	public Settings(){
		configFilePath = Paths.get(FileManager.getTmpDir(), "config").toString();
		state = new HashMap<String, String>();
	}
	
	public static void save(Settings settings){
		//TODO: save settings to config file
	}
	
	private Settings loadFromFile(){
		return new Settings(); //TODO: load settings to this object from config file
	}

}
