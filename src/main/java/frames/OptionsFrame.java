package frames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class OptionsFrame extends JFrame {

	private static OptionsFrame optionsFrame;
	
	private JPanel contentPane;

	public static void open(){
		if (optionsFrame == null){
			optionsFrame = new OptionsFrame();
		}
		optionsFrame.setLocationRelativeTo(null);
		optionsFrame.setVisible(true);
	}
	
	public OptionsFrame() {
		setTitle("SteamQuery - Options");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImageCache = new JLabel("Image Cache");
		lblImageCache.setBounds(10, 11, 83, 14);
		contentPane.add(lblImageCache);
		
		JCheckBox chckbxClearOnStartup = new JCheckBox("Clear on startup");
		chckbxClearOnStartup.setBounds(20, 32, 120, 23);
		contentPane.add(chckbxClearOnStartup);
		
		JButton btnClearNow = new JButton("Clear now");
		btnClearNow.setFocusable(false);
		btnClearNow.setBackground(Color.WHITE);
		btnClearNow.setBounds(220, 32, 114, 23);
		contentPane.add(btnClearNow);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setFocusable(false);
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(245, 221, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFocusable(false);
		btnOk.setBackground(Color.WHITE);
		btnOk.setBounds(148, 221, 89, 23);
		contentPane.add(btnOk);
	}
}
