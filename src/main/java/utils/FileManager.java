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
		File tmpDir = new File(TMP_DIR);
		return (tmpDir.list().length == 0);
	}
	
	// Adapted from: http://programming.guide/java/formatting-byte-size-to-human-readable-format.html
	// (17/12/16)
	public static String cacheSize(){
		long bytes = new File(TMP_DIR).length();
		int unit = 1024;
	    if (bytes < unit) return bytes + " B";
	    int exp = (int) (Math.log(bytes) / Math.log(unit));
	    char pre = ("KMGTPE").charAt(exp-1);
	    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}

}
