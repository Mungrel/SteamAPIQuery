package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class ResultsFrame extends JFrame {

	private JPanel contentPane;
	protected static ResultsFrame resultsFrame = new ResultsFrame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					resultsFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ResultsFrame() {
		setResizable(false);
		setTitle("SteamQuery - Results");
		setIconImage(new ImageIcon("src/main/resources/images/share_steam_logo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 80, 382, 313);
		tabbedPane.setFocusable(false);
		contentPane.add(tabbedPane);
		
		JPanel playerSummaryPanel = new JPanel();
		tabbedPane.addTab("Summary", null, playerSummaryPanel, null);
		tabbedPane.setEnabledAt(0, true);
		
		JLabel lblDisplayname = new JLabel("DisplayName");
		lblDisplayname.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblDisplayname.setBounds(10, 11, 278, 64);
		contentPane.add(lblDisplayname);
		
		
		JPanel avatarImagePanel = new JPanel();
		avatarImagePanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		avatarImagePanel.setBounds(328, 11, 64, 64);
		
		JLabel imageLabel = new JLabel("<html>No Avatar<br>Available</html>", SwingConstants.CENTER);
		imageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		avatarImagePanel.add(imageLabel);
		
		contentPane.add(avatarImagePanel);
		
		
	}
}
