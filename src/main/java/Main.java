import java.io.File;

import frames.SearchFrame;
import utils.FileManager;

public class Main {

	public static void main(String[] args) {
		checkAndBuildTmpDir();
		SearchFrame.open();
	}

	private static void checkAndBuildTmpDir() {
		File file = new File(FileManager.getTmpDir());
		if (!file.exists()) {
			file.mkdirs();
		}
	}
}