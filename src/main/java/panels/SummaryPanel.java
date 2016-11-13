package panels;

import javax.swing.JPanel;

import domain.PlayerSummary;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SummaryPanel extends JPanel {

	public SummaryPanel(PlayerSummary ps) {
		setLayout(null);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUrl.setBounds(10, 11, 72, 14);
		add(lblUrl);
		
		JLabel lblLastOnline = new JLabel("Last Online");
		lblLastOnline.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLastOnline.setBounds(10, 36, 72, 14);
		add(lblLastOnline);
		
		JLabel lblRealName = new JLabel("Real Name");
		lblRealName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRealName.setBounds(10, 61, 72, 14);
		add(lblRealName);
		
		JLabel lblMemberSince = new JLabel("Member Since");
		lblMemberSince.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMemberSince.setBounds(10, 86, 72, 14);
		add(lblMemberSince);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCountry.setBounds(10, 111, 72, 14);
		add(lblCountry);
		
		JLabel label = new JLabel("");
		label.setBounds(92, 11, 81, 14);
		add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(92, 36, 81, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(92, 61, 81, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(92, 86, 81, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(92, 111, 81, 14);
		add(label_4);

	}
}
