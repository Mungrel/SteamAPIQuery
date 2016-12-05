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

}
