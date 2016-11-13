package panels;

import javax.swing.JPanel;

import domain.PlayerSummary;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SummaryPanel extends JPanel {

	public SummaryPanel(PlayerSummary ps) {
		setLayout(null);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(10, 11, 46, 14);
		add(lblUrl);
		
		JLabel lblLastOnline = new JLabel("Last Online");
		lblLastOnline.setBounds(10, 36, 53, 14);
		add(lblLastOnline);
		
		JLabel lblRealName = new JLabel("Real Name");
		lblRealName.setBounds(10, 61, 53, 14);
		add(lblRealName);
		
		JLabel lblMemberSince = new JLabel("Member Since");
		lblMemberSince.setBounds(10, 86, 72, 14);
		add(lblMemberSince);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(10, 111, 46, 14);
		add(lblCountry);

	}
}
