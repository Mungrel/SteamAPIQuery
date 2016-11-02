package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterASteam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("SteamQuery");
		setIconImage(new ImageIcon("src/main/resources/images/share_steam_logo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		txtEnterASteam = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtEnterASteam, 83, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtEnterASteam, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtEnterASteam, -50, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtEnterASteam, 0, SpringLayout.EAST, contentPane);
		txtEnterASteam.setForeground(Color.LIGHT_GRAY);
		txtEnterASteam.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtEnterASteam.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterASteam.setText("Enter a Steam64 ID");
		contentPane.add(txtEnterASteam);
		txtEnterASteam.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSearch, 17, SpringLayout.SOUTH, txtEnterASteam);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSearch, 137, SpringLayout.WEST, txtEnterASteam);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnSearch, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnSearch, -137, SpringLayout.EAST, contentPane);
		contentPane.add(btnSearch);
	}
}
