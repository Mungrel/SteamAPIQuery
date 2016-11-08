package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import domain.PlayerSummary;
import listeners.SearchTextKeyListener;
import query.ImageManager;
import query.QueryManager;

@SuppressWarnings("serial")
public class SearchFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterASteam;
	protected static SearchFrame searchFrame = new SearchFrame();

	public static void open() {
		searchFrame.setLocationRelativeTo(null); // centre the frame
		searchFrame.setVisible(true);
	}

	private SearchFrame() {
		setResizable(false);
		setTitle("SteamQuery - Search");
		setIconImage(new ImageIcon("src/main/resources/images/share_steam_logo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtEnterASteam = new JTextField();
		txtEnterASteam.setBounds(10, 15, 368, 34);
		txtEnterASteam.setForeground(Color.LIGHT_GRAY);
		txtEnterASteam.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtEnterASteam.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterASteam.setText("Enter a Steam64 ID");
		txtEnterASteam.setSelectionStart(0);
		txtEnterASteam.addKeyListener(new SearchTextKeyListener(txtEnterASteam));
		contentPane.add(txtEnterASteam);
		txtEnterASteam.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(144, 74, 99, 29);
		btnSearch.setBackground(Color.WHITE);
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlayerSummary ps = QueryManager.getPlayerSummary(txtEnterASteam.getText());
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
