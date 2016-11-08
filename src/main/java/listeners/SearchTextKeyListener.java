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
		String text = searchTextField.getText();
		if (text.equals("")) {
			toDefaultText();
		} else if (text.equals("Enter a Steam64 ID")) {
			toDefaultText();
		} else {
			searchTextField.setForeground(Color.BLACK);
		}
	}
	
	private void toDefaultText(){
		searchTextField.setText("Enter a Steam64 ID");
		searchTextField.setForeground(Color.LIGHT_GRAY);
		searchTextField.setSelectionStart(0);
	}
}