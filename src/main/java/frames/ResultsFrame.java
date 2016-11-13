package frames;

import java.awt.Font;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import domain.PlayerSummary;
import panels.FriendsPanel;
import panels.SummaryPanel;

@SuppressWarnings("serial")
public class ResultsFrame extends JFrame {

	private JPanel contentPane;
	private JLabel avatarImageLabel;
	private JLabel displayNameLabel;

	public ResultsFrame(PlayerSummary ps, BufferedImage playerAvatar) {
		setResizable(false);
		setTitle("SteamQuery - Results");
		setIconImage(new ImageIcon("src/main/resources/images/share_steam_logo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBounds(10, 80, 382, 313);
		tabbedPane.setFocusable(false);
		contentPane.add(tabbedPane);

		//TODO pass pulled player summary object
		JPanel playerSummaryPanel = new SummaryPanel(ps);
		tabbedPane.addTab("Summary", null, playerSummaryPanel, null);
		playerSummaryPanel.setLayout(null);
		tabbedPane.setEnabledAt(0, true);

		JPanel friendsPanel = new FriendsPanel();
		tabbedPane.addTab("Friends", null, friendsPanel, null);
		friendsPanel.setLayout(null);

		displayNameLabel = new JLabel("DisplayName");
		if (ps != null){
			displayNameLabel.setText(ps.getPersonaName());
		}
		displayNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		displayNameLabel.setBounds(10, 11, 278, 64);
		contentPane.add(displayNameLabel);
		

		JPanel avatarImagePanel = new JPanel();
		avatarImagePanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		avatarImagePanel.setBounds(328, 11, 64, 64);
		avatarImagePanel.setLayout(null);

		avatarImageLabel = new JLabel("<html>No Avatar<br>Available</html>", SwingConstants.CENTER);
		avatarImageLabel.setBounds(0, 0, 64, 64);
		avatarImageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		avatarImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		avatarImagePanel.add(avatarImageLabel);
		if (playerAvatar != null) {
			avatarImageLabel.setIcon(new ImageIcon(playerAvatar));
			avatarImageLabel.setText("");
		}

		contentPane.add(avatarImagePanel);
	}
}
