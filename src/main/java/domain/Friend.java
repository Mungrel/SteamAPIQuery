package domain;

import org.json.JSONObject;

import query.QueryManager;

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

	public String getSteam64ID() {
		return steam64ID;
	}

	public String getRelationship() {
		return relationship;
	}

	public Long getFriendSince() {
		return friendSince;
	}
	
	//Queries and builds a PlayerSummary object from this friend (will be used to get their avatar, display name, etc)
	public PlayerSummary getPlayerSummary(){
		return QueryManager.getPlayerSummary(this.steam64ID);
	}
}
