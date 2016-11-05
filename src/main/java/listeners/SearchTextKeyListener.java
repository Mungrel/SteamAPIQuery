package listeners;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class SearchTextKeyListener implements KeyListener {

	private JTextField searchTextField;

	public SearchTextKeyListener(JTextField searchTextField) {
		this.searchTextField = searchTextField;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (searchTextField.getText().equals("")) {
			searchTextField.setText("Enter a Steam64 ID");
			searchTextField.setForeground(Color.LIGHT_GRAY);
			searchTextField.setSelectionStart(0);
		} else if (searchTextField.getText().equals("Enter a Steam64 ID")) {
			searchTextField.setForeground(Color.LIGHT_GRAY);
			searchTextField.setSelectionStart(0);
		} else {
			searchTextField.setForeground(Color.BLACK);
		}
	}
}