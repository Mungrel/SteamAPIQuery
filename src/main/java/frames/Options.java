package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Color;

public class Options extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Options frame = new Options();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Options() {
		setTitle("SteamQuery - Options");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 263, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImageCache = new JLabel("Image Cache");
		lblImageCache.setBounds(10, 11, 83, 14);
		contentPane.add(lblImageCache);
		
		JCheckBox chckbxClearOnStartup = new JCheckBox("Clear on startup");
		chckbxClearOnStartup.setBounds(20, 32, 120, 23);
		contentPane.add(chckbxClearOnStartup);
		
		JButton btnClearNow = new JButton("Clear now");
		btnClearNow.setBackground(Color.WHITE);
		btnClearNow.setBounds(148, 32, 89, 23);
		contentPane.add(btnClearNow);
	}
}
