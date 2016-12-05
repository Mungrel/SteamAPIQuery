import frames.SearchFrame;
import frames.Splash;
import utils.FileManager;

public class Main {

	public static void main(String[] args) {
		Splash.splash();
		FileManager.checkAndBuildTmpDir();
		SearchFrame.open();
	}
}