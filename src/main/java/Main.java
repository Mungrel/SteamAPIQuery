import java.io.File;

import frames.SearchFrame;
import frames.Splash;
import utils.FileManager;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Splash.open();
		checkAndBuildTmpDir();
		Thread.sleep(2000);
		Splash.close();
		SearchFrame.open();
	}

	private static void checkAndBuildTmpDir() {
		File file = new File(FileManager.getTmpDir());
		if (!file.exists()) {
			file.mkdirs();
		}
	}
}