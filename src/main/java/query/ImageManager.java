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

	private static String TMP_IMG_DIR = "tmp";

	public static String getImage(String externalURL, String fileName) throws IOException {
		if (!fileName.endsWith(".png")){
			fileName += ".png";
		}
		Client client = ClientBuilder.newClient();
		Response response = client.target(externalURL).request().get();
		InputStream in = response.readEntity(InputStream.class);
		Path path = Paths.get(TMP_IMG_DIR, fileName);
		Files.copy(in, path, StandardCopyOption.REPLACE_EXISTING);
		response.close();
		in.close();
		return path.toString();
	}

	public static ImageIcon createImageIcon(String path) {
		if (path != null) {
			return new ImageIcon(path);
		} else {
			return null;
		}
	}
	
	public static String getTmpImgDir(){
		return TMP_IMG_DIR;
	}
}
