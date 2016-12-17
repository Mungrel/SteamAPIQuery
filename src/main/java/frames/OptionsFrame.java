package frames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.FileManager;
import utils.ImageManager;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class OptionsFrame extends JFrame {

	private static OptionsFrame optionsFrame;
	private static JLabel lblcacheSize;
	private static JButton btnClearNow;

	private JPanel contentPane;

	public static void open() {
		if (optionsFrame == null) {
			optionsFrame = new OptionsFrame();
		}
		// Update cache size label
		lblcacheSize.setText(FileManager.cacheSize());
		
		// Enable 'Clear Now' button if cache not empty
		btnClearNow.setEnabled(!FileManager.cacheIsEmpty());
		
		optionsFrame.setLocationRelativeTo(null);
		optionsFrame.setVisible(true);
	}

	public static void close() {
		optionsFrame.setVisible(false);
	}

	private OptionsFrame() {
		setTitle("SteamQuery - Options");
		setBounds(100, 100, 360, 294);
		setIconImages(ImageManager.getSteamQueryLogoImgs());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblImageCache = new JLabel("Image Cache");
		lblImageCache.setBounds(10, 11, 83, 14);
		contentPane.add(lblImageCache);

		btnClearNow = new JButton("Clear now");
		btnClearNow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileManager.emptyTmpDir();
				lblcacheSize.setText(FileManager.cacheSize());
				btnClearNow.setEnabled(false);
			}
		});
		if (FileManager.cacheIsEmpty()){
			btnClearNow.setEnabled(false); //Cache is empty, don't let them clear an empty cache
		}
		btnClearNow.setFocusable(false);
		btnClearNow.setBackground(Color.WHITE);
		btnClearNow.setBounds(20, 36, 114, 23);
		contentPane.add(btnClearNow);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OptionsFrame.close();
			}
		});
		btnCancel.setFocusable(false);
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(245, 221, 89, 23);
		contentPane.add(btnCancel);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Persist options
				OptionsFrame.close();
			}
		});
		btnOk.setFocusable(false);
		btnOk.setBackground(Color.WHITE);
		btnOk.setBounds(148, 221, 89, 23);
		contentPane.add(btnOk);
		
		lblcacheSize = new JLabel(FileManager.cacheSize());
		lblcacheSize.setBounds(144, 40, 83, 14);
		contentPane.add(lblcacheSize);
		
		JLabel lblSplash = new JLabel("Splash");
		lblSplash.setBounds(10, 70, 46, 14);
		contentPane.add(lblSplash);
		
		JCheckBox chckbxDisplaySplash = new JCheckBox("Display splash on startup");
		chckbxDisplaySplash.setSelected(true);
		chckbxDisplaySplash.setFocusable(false);
		chckbxDisplaySplash.setBounds(20, 91, 185, 23);
		contentPane.add(chckbxDisplaySplash);
	}
}
