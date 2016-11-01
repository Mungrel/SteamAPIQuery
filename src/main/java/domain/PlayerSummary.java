package domain;

import org.json.JSONObject;

public class PlayerSummary {

	private String steamID;
	private String communityVisState;
	private String profileState;
	private String personaName;
	private String lastLogOff;
	private String profileURL;
	private String avatarFullImageURL;
	private String personaState;
	private String realName;
	private String timeCreated;
	private String country;
	
	public PlayerSummary(String json){
		JSONObject obj = new JSONObject(json).getJSONObject("response");
		JSONObject playerSummary = obj.getJSONArray("players").getJSONObject(0);
		this.steamID = playerSummary.getString("steamid");
		this.communityVisState = playerSummary.getString("communityvisibilitystate");
		this.profileState = playerSummary.getString("profilestate");
		this.personaName = playerSummary.getString("personaname");
		this.lastLogOff = playerSummary.getString("lastlogoff");
		this.profileURL = playerSummary.getString("profileurl");
		this.avatarFullImageURL = playerSummary.getString("avatar");
		this.personaState = playerSummary.getString("personastate");
		this.realName = playerSummary.getString("realname");
		this.timeCreated = playerSummary.getString("timecreated");
		this.country = playerSummary.getString("loccountrycode");
	}

	public String getSteamID() {
		return steamID;
	}

	public String getCommunityVisState() {
		return communityVisState;
	}

	public String getProfileState() {
		return profileState;
	}

	public String getPersonaName() {
		return personaName;
	}

	public String getLastLogOff() {
		return lastLogOff;
	}

	public String getProfileURL() {
		return profileURL;
	}

	public String getAvatarFullImageURL() {
		return avatarFullImageURL;
	}

	public String getPersonaState() {
		return personaState;
	}

	public String getRealName() {
		return realName;
	}

	public String getTimeCreated() {
		return timeCreated;
	}

	public String getCountry() {
		return country;
	}
	
}