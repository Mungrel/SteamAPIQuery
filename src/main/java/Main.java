import java.io.File;

import frames.SearchFrame;
import query.ImageManager;

public class Main {

	public static void main(String[] args) {
		checkAndBuildTmpDir();
		SearchFrame.open();
	}
	
	private static void checkAndBuildTmpDir(){
		File file = new File(ImageManager.getTmpImgDir());
		if (!file.exists()){
			file.mkdirs();
		}
	}
}