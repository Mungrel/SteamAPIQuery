package utils;

import java.io.File;

public class FileManager {

	private static String TMP_DIR = "tmp";

	public static void emptyTmpDir() {
		File tmpDir = new File(TMP_DIR);
		File[] imgs = tmpDir.listFiles();
		for (File f : imgs) {
			f.delete();
		}
	}

	public static boolean fileExists(String fullPath) {
		File file = new File(fullPath);
		return file.exists();
	}

	public static String getTmpDir() {
		return TMP_DIR;
	}

	public static void checkAndBuildTmpDir() {
		File file = new File(getTmpDir());
		if (!file.exists()) {
			file.mkdirs();
		}
	}
	
	public static boolean cacheIsEmpty(){
		//TODO: Implement this and tie to 'Clear Now' button for cache clearing in OptionsFrame
		return false;
	}
	
	public static String cacheSize(){
		//TODO: For showing the current cache size next to 'Clear Now' button in KB/MB, whatever's appropriate
		return null;
	}

}
