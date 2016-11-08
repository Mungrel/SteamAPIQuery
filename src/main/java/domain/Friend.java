package domain;

import org.json.JSONObject;

public class Friend {
	
	private String steam64ID;
	private String relationship;
	private Long friendSince;
	
	public Friend(String json){
		JSONObject obj = new JSONObject(json);
		this.steam64ID = obj.getString("steamid");
		this.relationship = obj.getString("relationship");
		this.friendSince = obj.getLong("friend_since");
	}

}
