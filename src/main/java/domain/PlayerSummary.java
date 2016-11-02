package domain;

import org.json.JSONObject;

public class PlayerSummary {

	private String steamID;
	private int communityVisState;
	private int profileState;
	private String personaName;
	private long lastLogOff;
	private String profileURL;
	private String avatarFullImageURL;
	private int personaState;
	private String realName;
	private long timeCreated;
	private String country;
	
	public PlayerSummary(String json){
		JSONObject obj = new JSONObject(json).getJSONObject("response");
		JSONObject playerSummary = obj.getJSONArray("players").getJSONObject(0);
		this.steamID = playerSummary.getString("steamid");
		this.communityVisState = playerSummary.getInt("communityvisibilitystate");
		this.profileState = playerSummary.getInt("profilestate");
		this.personaName = playerSummary.getString("personaname");
		this.lastLogOff = playerSummary.getLong("lastlogoff");
		this.profileURL = playerSummary.getString("profileurl");
		this.avatarFullImageURL = playerSummary.getString("avatar");
		this.personaState = playerSummary.getInt("personastate");
		this.realName = playerSummary.getString("realname");
		this.timeCreated = playerSummary.getLong("timecreated");
		this.country = playerSummary.getString("loccountrycode");
	}

	public String getSteamID() {
		return steamID;
	}

	public int getCommunityVisState() {
		return communityVisState;
	}

	public int getProfileState() {
		return profileState;
	}

	public String getPersonaName() {
		return personaName;
	}

	public long getLastLogOff() {
		return lastLogOff;
	}

	public String getProfileURL() {
		return profileURL;
	}

	public String getAvatarFullImageURL() {
		return avatarFullImageURL;
	}

	public int getPersonaState() {
		return personaState;
	}

	public String getRealName() {
		return realName;
	}

	public long getTimeCreated() {
		return timeCreated;
	}

	public String getCountry() {
		return country;
	}
	
}