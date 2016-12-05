package utils;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class ImageManager {
	
	private static String STEAM_QUERY_LOGO_PATH = "src/main/resources/images/SteamLogoVerySmall.png";
	private static String STEAM_QUERY_LOGO_PATH_LARGE = "src/main/resources/images/SteamLogoSmall.png";

	public static String getImage(String externalURL, String fileName) throws IOException {
		if (!fileName.endsWith(".png")) {
			fileName += ".png";
		}
		// Check if file already exists in tmp dir, return it if true
		Path path = Paths.get(FileManager.getTmpDir(), fileName);
		if (FileManager.fileExists(path.toString())) {
			return path.toString();
		} else { // Doesn't exist, wget it
			Client client = ClientBuilder.newClient();
			Response response = client.target(externalURL).request().get();
			InputStream in = response.readEntity(InputStream.class);

			Files.copy(in, path, StandardCopyOption.REPLACE_EXISTING);
			response.close();
			in.close();
		}
		return path.toString();
	}

	public static ImageIcon createImageIcon(String path) {
		if (path != null) {
			return new ImageIcon(path);
		} else {
			return null;
		}
	}
	
	public static List<Image> getSteamQueryLogoImgs(){
		List<Image> imgs = new ArrayList<Image>();
		imgs.add(new ImageIcon(STEAM_QUERY_LOGO_PATH_LARGE).getImage());
		imgs.add(new ImageIcon(STEAM_QUERY_LOGO_PATH).getImage());
		return imgs;
	}
}
