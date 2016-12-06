package panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.Friend;
import domain.PlayerSummary;
import query.QueryManager;
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

		// TODO: Assign relevant fields to FSC from PlayerSummary and Friend
		// objects

	}
}