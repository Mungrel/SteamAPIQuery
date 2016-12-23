package frames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Settings;
import utils.FileManager;
import utils.ImageManager;

@SuppressWarnings("serial")
public class SettingsFrame extends JFrame {

	private static SettingsFrame optionsFrame;
	private static JLabel lblcacheSize;
	private static JButton btnClearNow;
	private static JCheckBox chckbxDisplaySplash;
	private static JCheckBox chckbxClearCache;

	private JPanel contentPane;

	public static void open(Settings settings) {
		if (optionsFrame == null) {
			optionsFrame = new SettingsFrame();
		}
		// Update cache size label
		lblcacheSize.setText(FileManager.cacheSize());

		// Enable 'Clear Now' button if cache not empty
		btnClearNow.setEnabled(!FileManager.cacheIsEmpty());

		if (settings != null){
			// TODO: Apply existing settings to frame
		}
		
		optionsFrame.setLocationRelativeTo(null);
		optionsFrame.setVisible(true);
	}

	public static void close() {
		optionsFrame.setVisible(false);
	}
	
	public static Settings getBackingSettings(){
		Settings settings = new Settings();
		settings.setClearCacheStartup(chckbxDisplaySplash.isSelected());
		// TODO: get display splash setting
		return settings;
	}

	private SettingsFrame() {
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
		if (FileManager.cacheIsEmpty()) {
			btnClearNow.setEnabled(false); // Cache is empty, don't let them
											// clear an empty cache
		}
		btnClearNow.setFocusable(false);
		btnClearNow.setBackground(Color.WHITE);
		btnClearNow.setBounds(20, 36, 114, 23);
		contentPane.add(btnClearNow);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SettingsFrame.close();
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
				@SuppressWarnings("unused") // tmp warning dodge
				boolean displaySplash = chckbxDisplaySplash.isSelected();
				SettingsFrame.close();
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
		lblSplash.setBounds(10, 108, 46, 14);
		contentPane.add(lblSplash);

		chckbxDisplaySplash = new JCheckBox("Display splash on startup");
		chckbxDisplaySplash.setSelected(true);
		chckbxDisplaySplash.setFocusable(false);
		chckbxDisplaySplash.setBounds(20, 129, 185, 23);
		contentPane.add(chckbxDisplaySplash);
		
		chckbxClearCache = new JCheckBox("Clear cache on startup");
		chckbxClearCache.setBounds(10, 66, 156, 23);
		contentPane.add(chckbxClearCache);
	}
}
