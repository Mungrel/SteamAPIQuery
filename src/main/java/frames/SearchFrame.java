package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JTextField searchTextField;
	protected static SearchFrame searchFrame = new SearchFrame();

	public static void open() {
		searchFrame.setLocationRelativeTo(null); // centre the frame
		searchFrame.setVisible(true);
	}

	public static void close() {
		searchFrame.setVisible(false);
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

		searchTextField = new JTextField();
		searchTextField.setBounds(10, 15, 368, 34);
		searchTextField.setForeground(Color.LIGHT_GRAY);
		searchTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		searchTextField.setHorizontalAlignment(SwingConstants.CENTER);
		searchTextField.setText("Enter a Steam64 ID");
		searchTextField.addKeyListener(new SearchTextKeyListener(searchTextField));
		searchTextField.setSelectionStart(0);
		searchTextField.setSelectionEnd(searchTextField.getText().length());
		contentPane.add(searchTextField);
		searchTextField.setColumns(10);

		JButton searchButton = new JButton("Search");
		searchButton.setBounds(144, 74, 99, 29);
		searchButton.setFocusable(false);
		searchButton.setBackground(Color.WHITE);
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlayerSummary ps = QueryManager.getPlayerSummary(searchTextField.getText());
				String localPlayerAvatarURL = null;
				try {
					localPlayerAvatarURL = ImageManager.getImage(ps.getAvatarImageURL(), ps.getSteamID());
				} catch (IOException e1) {
					System.out.println("Failed to load avatar image");
					e1.printStackTrace();
				}
				ResultsFrame.open(ps, localPlayerAvatarURL);
				SearchFrame.close();
			}
		});
		contentPane.add(searchButton);

		this.getRootPane().setDefaultButton(searchButton);
	}
}
