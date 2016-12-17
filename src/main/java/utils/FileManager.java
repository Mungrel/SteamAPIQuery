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
		return (cacheSize().equals("0 B"));
	}
	
	public static String cacheSize(){
		File dir = new File(TMP_DIR);
		long bytes = 0;
		
		// We'll only sum file lengths for surface of directory, shouldn't need to recurse at this stage
		// As our tmp dir likely won't have sub directories
		
		for (File file : dir.listFiles()){
			bytes += file.length();
		}
		
		//Formatting the string, converting to B/KB/MB, whatever's appropriate
		// Adapted from: http://programming.guide/java/formatting-byte-size-to-human-readable-format.html
		// (17/12/16)
		int unit = 1024;
	    if (bytes < unit) return bytes + " B";
	    int exp = (int) (Math.log(bytes) / Math.log(unit));
	    char pre = ("KMGTPE").charAt(exp-1);
	    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}

}
