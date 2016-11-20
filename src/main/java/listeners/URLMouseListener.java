package listeners;

import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class URLMouseListener implements MouseListener {

	private URI destination;

	public URLMouseListener(String uri) {
		try {
			this.destination = new URI(uri);
		} catch (URISyntaxException e) {
			System.out.println("Invalid URI: " + uri);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Desktop desktop = Desktop.getDesktop();
		try {
			desktop.browse(this.destination);
		} catch (IOException e1) {
			System.out.println("Could not open browser");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
