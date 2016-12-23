import domain.Settings;
import frames.SearchFrame;
import frames.Splash;
import utils.FileManager;
import utils.SettingsManager;

public class Main {

	public static void main(String[] args) {
		startupRoutine();
	}
	
	private static void startupRoutine(){
		FileManager.checkAndBuildTmpDir();
		Settings settings = SettingsManager.getSettings();
		if (settings.isSplashStartup())
			Splash.splash();
		if (settings.isClearCacheStartup())
			FileManager.emptyTmpDir();
		SearchFrame.open();
	}
}