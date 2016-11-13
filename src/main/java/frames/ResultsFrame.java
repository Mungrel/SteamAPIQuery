package frames;

import java.awt.Font;

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
import query.ImageManager;

@SuppressWarnings("serial")
public class ResultsFrame extends JFrame {

	private JPanel contentPane;
	protected static ResultsFrame resultsFrame;

	public static void open(PlayerSummary ps, String localPlayerAvatarURL) {
		resultsFrame = new ResultsFrame(ps, localPlayerAvatarURL);
		resultsFrame.setVisible(true);
	}

	private ResultsFrame(PlayerSummary ps, String localPlayerAvatarURL) {
		setResizable(false);
		setTitle("SteamQuery - Results");
		setIconImage(new ImageIcon("src/main/resources/images/share_steam_logo.png").getImage());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBounds(10, 80, 412, 313);
		tabbedPane.setFocusable(false);
		contentPane.add(tabbedPane);

		JPanel playerSummaryPanel = new SummaryPanel(ps);
		tabbedPane.addTab("Summary", null, playerSummaryPanel, null);
		playerSummaryPanel.setLayout(null);
		tabbedPane.setEnabledAt(0, true);

		JPanel friendsPanel = new FriendsPanel();
		tabbedPane.addTab("Friends", null, friendsPanel, null);
		friendsPanel.setLayout(null);

		JLabel displayNameLabel = new JLabel("DisplayName");
		if (ps != null) {
			String labelText = ps.getPersonaName() + " - "+ ps.getPersonaState();
			displayNameLabel.setText(labelText);
		}
		displayNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		displayNameLabel.setBounds(10, 11, 338, 64);
		contentPane.add(displayNameLabel);

		JLabel avatarImageLabel = new JLabel("<html>No Avatar<br>Available</html>", SwingConstants.CENTER);
		avatarImageLabel.setBounds(0, 0, 64, 64);
		avatarImageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		avatarImageLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel avatarImagePanel = new JPanel();
		avatarImagePanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		avatarImagePanel.setBounds(358, 11, 64, 64);
		avatarImagePanel.setLayout(null);
		if (localPlayerAvatarURL != null) {
			avatarImageLabel.setIcon(ImageManager.createImageIcon(localPlayerAvatarURL));
			avatarImageLabel.setText("");
		}
		avatarImagePanel.add(avatarImageLabel);
		contentPane.add(avatarImagePanel);

	}
}
