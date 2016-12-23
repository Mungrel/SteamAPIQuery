import frames.SearchFrame;
import frames.Splash;
import utils.FileManager;

public class Main {

	public static void main(String[] args) {
		startupRoutine();
	}
	
	private static void startupRoutine(){
		Splash.splash();
		FileManager.checkAndBuildTmpDir();
		SearchFrame.open();
	}
}