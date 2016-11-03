package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;

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
		avatarImagePanel.setBounds(328, 11, 64, 64);
		contentPane.add(avatarImagePanel);
	}
}
