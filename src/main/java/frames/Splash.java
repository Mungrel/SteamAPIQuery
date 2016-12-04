package frames;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Splash extends JFrame {

	private JPanel contentPane;
	private static Splash splash;
	
	public static void open(){
		if (splash == null){
			splash = new Splash();
		}
		splash.setUndecorated(true);
		splash.setBackground(new Color(0, 255, 0 ,0));
		splash.setLocationRelativeTo(null);
		splash.setVisible(true);
	}
	
	public static void close(){
		splash.setVisible(false);
	}

	private Splash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JLabel label = new JLabel("",new ImageIcon("src/main/resources/images/SteamLogo.png"), SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.CENTER);
	}

}
