package frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import domain.Friend;
import domain.PlayerSummary;
import listeners.SearchTextKeyListener;
import query.ImageManager;
import query.QueryManager;

@SuppressWarnings("serial")
public class SearchFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterASteam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					SearchFrame frame = new SearchFrame();
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
	public SearchFrame() {
		setResizable(false);
		setTitle("SteamQuery - Search");
		setIconImage(new ImageIcon("src/main/resources/images/share_steam_logo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		txtEnterASteam = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtEnterASteam, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtEnterASteam, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtEnterASteam, 44, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtEnterASteam, -5, SpringLayout.EAST, contentPane);
		txtEnterASteam.setForeground(Color.LIGHT_GRAY);
		txtEnterASteam.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtEnterASteam.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterASteam.setText("Enter a Steam64 ID");
		txtEnterASteam.setSelectionStart(0);
		txtEnterASteam.addKeyListener(new SearchTextKeyListener(txtEnterASteam));
		contentPane.add(txtEnterASteam);
		txtEnterASteam.setColumns(10);

		JButton btnSearch = new JButton("Search");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSearch, 25, SpringLayout.SOUTH, txtEnterASteam);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSearch, 139, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnSearch, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnSearch, -140, SpringLayout.EAST, contentPane);
		btnSearch.setBackground(Color.WHITE);
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlayerSummary ps = QueryManager.getPlayerSummary(txtEnterASteam.getText());
				List<Friend> friendsList = QueryManager.getFriendsList(txtEnterASteam.getText());
				BufferedImage playerAvatar = null;
				try {
					playerAvatar = ImageManager.getImage(ps.getAvatarImageURL());
				} catch (IOException e1) {
					System.out.println("Failed to load avatar image");
					e1.printStackTrace();
				}
				ResultsFrame.buildResults(ps, playerAvatar);
				ResultsFrame.resultsFrame.setVisible(true);
			}
		});
		contentPane.add(btnSearch);

		this.getRootPane().setDefaultButton(btnSearch);
	}
}
