package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import domain.PlayerSummary;
import panels.FriendsPanel;
import panels.SummaryPanel;
import utils.Fonts;
import utils.ImageManager;

@SuppressWarnings("serial")
public class ResultsFrame extends JFrame {

	private JPanel contentPane;
	protected static ResultsFrame resultsFrame;

	public static void open(PlayerSummary ps, String localPlayerAvatarURL) {
		resultsFrame = new ResultsFrame(ps, localPlayerAvatarURL);
		resultsFrame.setLocationRelativeTo(null);
		resultsFrame.setVisible(true);
	}

	public static void close() {
		resultsFrame.setVisible(false);
	}

	private ResultsFrame(PlayerSummary ps, String localPlayerAvatarURL) {
		setResizable(false);
		setTitle("SteamQuery - Results");
		setIconImages(ImageManager.getSteamQueryLogoImgs());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBounds(10, 80, 412, 279);
		tabbedPane.setFocusable(false);
		contentPane.add(tabbedPane);

		JPanel playerSummaryPanel = new SummaryPanel(ps);
		tabbedPane.addTab("Summary", null, playerSummaryPanel, null);
		playerSummaryPanel.setLayout(null);
		tabbedPane.setEnabledAt(0, true);

		JPanel friendsPanel = new FriendsPanel(null);
		tabbedPane.addTab("Friends", null, friendsPanel, null);
		friendsPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 407, 251);
		friendsPanel.add(scrollPane);

		JLabel displayNameLabel = new JLabel("DisplayName - SignInState");
		if (ps != null) {
			String labelText = ps.getPersonaName() + " - " + ps.getPersonaState();
			displayNameLabel.setText(labelText);
		}
		displayNameLabel.setFont(Fonts.displayNameLabelFont);
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

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnExit.setFocusable(false);
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(333, 370, 89, 23);
		contentPane.add(btnExit);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ResultsFrame.close();
				SearchFrame.open();
			}
		});
		btnBack.setFocusable(false);
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(234, 370, 89, 23);
		contentPane.add(btnBack);

	}
}
