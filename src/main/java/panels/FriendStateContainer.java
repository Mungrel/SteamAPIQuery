package panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.Friend;

@SuppressWarnings("serial")
public class FriendStateContainer extends JPanel {

	public FriendStateContainer(Friend friend) {
		setLayout(null);
		
		JLabel avatarImgLbl = new JLabel("");
		avatarImgLbl.setBounds(10, 11, 64, 64);
		add(avatarImgLbl);

	}
}
