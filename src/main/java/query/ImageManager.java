package query;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.ImageIcon;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class ImageManager {

	private static String TMP_IMG_DIR = "C:\\Users\\Nick\\Desktop";

	public static String getImage(String externalURL) throws IOException {
		Client client = ClientBuilder.newClient();
		Response response = client.target(externalURL).request().get();
		InputStream in = response.readEntity(InputStream.class);
		Path path = Paths.get(TMP_IMG_DIR, "avatar.png");
		Files.copy(in, path, StandardCopyOption.REPLACE_EXISTING);
		response.close();
		in.close();
		return path.toString();
	}

	public static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = ImageManager.class.getResource(path);
	    if (imgURL != null) {
	        return new ImageIcon(imgURL);
	    } else {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
	}
}
