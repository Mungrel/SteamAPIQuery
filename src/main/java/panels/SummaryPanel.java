package panels;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import domain.PlayerSummary;
import listeners.URLMouseListener;

@SuppressWarnings("serial")
public class SummaryPanel extends JPanel {

	public SummaryPanel(PlayerSummary ps) {
		setLayout(null);

		JLabel lblUrl = new JLabel("URL");
		lblUrl.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUrl.setBounds(10, 11, 96, 14);
		add(lblUrl);

		JLabel lblLastLogin = new JLabel("Last Login");
		lblLastLogin.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLastLogin.setBounds(20, 36, 86, 14);
		add(lblLastLogin);

		JLabel lblRealName = new JLabel("Real Name");
		lblRealName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRealName.setBounds(10, 61, 96, 14);
		add(lblRealName);

		JLabel lblMemberSince = new JLabel("Member Since");
		lblMemberSince.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMemberSince.setBounds(10, 86, 96, 14);
		add(lblMemberSince);

		JLabel lblCountry = new JLabel("Country");
		lblCountry.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCountry.setBounds(20, 111, 86, 14);
		add(lblCountry);

		JLabel URLValueLabel = new JLabel(ps.getProfileURL());
		URLValueLabel.setBounds(116, 11, 289, 14);
		URLValueLabel.addMouseListener(new URLMouseListener());
		add(URLValueLabel);

		JLabel lastOnlineValueLabel = new JLabel("" + ps.getLastLogOff());
		lastOnlineValueLabel.setBounds(116, 36, 289, 14);
		add(lastOnlineValueLabel);

		JLabel realNameValueLabel = new JLabel(ps.getRealName());
		realNameValueLabel.setBounds(116, 61, 81, 14);
		add(realNameValueLabel);

		JLabel memberSinceValueLabel = new JLabel("" + ps.getTimeCreated());
		memberSinceValueLabel.setBounds(116, 86, 289, 14);
		add(memberSinceValueLabel);

		JLabel countryValueLabel = new JLabel(ps.getCountry());
		countryValueLabel.setBounds(116, 111, 81, 14);
		add(countryValueLabel);

	}
}
