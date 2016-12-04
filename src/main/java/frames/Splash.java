package frames;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Splash extends JFrame {

	private JPanel contentPane;
	private static Splash splashScreen;
	
	public static void open(){
		if (splashScreen == null){
			splashScreen = new Splash();
			splashScreen.setLocationRelativeTo(null);
			splashScreen.setVisible(true);
		}
	}
	
	private  Splash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
