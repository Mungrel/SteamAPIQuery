package query;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class ImageManager {
	
	private static String TMP_IMG_DIR = "C:\\Users\\Nick\\Desktop\\tmp";
	
	public static BufferedImage getImage(String url) throws IOException{
		Client client = ClientBuilder.newClient();
		Response response = client.target(url).request().get();
		InputStream in = response.readEntity(InputStream.class);
		Path path = Paths.get(TMP_IMG_DIR, "avatar.png");
		Files.copy(in, path);
		BufferedImage img = null;
		img = ImageIO.read(path.toFile());
		return img;
	}

}
