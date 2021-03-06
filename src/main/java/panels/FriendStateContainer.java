package panels;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import domain.Friend;
import domain.PlayerSummary;
import query.QueryManager;
import utils.Fonts;
import utils.ImageManager;

@SuppressWarnings("serial")
public class FriendStateContainer extends JPanel {

	public FriendStateContainer(Friend friend) {
		setLayout(null);

		PlayerSummary friendSummary = QueryManager.getPlayerSummary(friend.getSteam64ID());

		JLabel avatarImgLbl = new JLabel("");
		avatarImgLbl.setBounds(10, 11, 64, 64);
		avatarImgLbl.setIcon(ImageManager.createImageIcon(friendSummary.getAvatarImageURL()));
		add(avatarImgLbl);

		JLabel displayNameLabel = new JLabel("DisplayName - SignInState");
		displayNameLabel.setBounds(84, 11, 222, 64);
		displayNameLabel.setFont(Fonts.displayNameLabelFont);
		add(displayNameLabel);

		JLabel lblFriendSince = new JLabel("FriendSince");
		lblFriendSince.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFriendSince.setFont(Fonts.displayNameLabelFont);
		lblFriendSince.setBounds(332, 11, 108, 64);
		add(lblFriendSince);

		// TODO: Assign relevant fields to FSC from PlayerSummary and Friend
		// objects

	}
}
