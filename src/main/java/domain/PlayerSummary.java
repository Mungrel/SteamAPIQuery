package domain;

import java.util.Date;

import org.json.JSONObject;

public class PlayerSummary {

	private String steamID;
	private int communityVisState;
	private int profileState;
	private String personaName;
	private long lastLogOff;
	private String profileURL;
	private String avatarImageURL;
	private int personaState;
	private String realName;
	private long timeCreated;
	private String country;

	public PlayerSummary(String json) {
		JSONObject obj = new JSONObject(json).getJSONObject("response");
		JSONObject playerSummary = obj.getJSONArray("players").getJSONObject(0);
		this.steamID = playerSummary.getString("steamid");
		this.communityVisState = playerSummary.getInt("communityvisibilitystate");
		this.profileState = playerSummary.getInt("profilestate");
		this.personaName = playerSummary.getString("personaname");
		this.lastLogOff = playerSummary.getLong("lastlogoff");
		this.profileURL = playerSummary.getString("profileurl");
		this.avatarImageURL = playerSummary.getString("avatarmedium");
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

	public String getLastLogOff() {
		return unixToNormalTime(lastLogOff);
	}

	public String getProfileURL() {
		return profileURL;
	}

	public String getAvatarImageURL() {
		return avatarImageURL;
	}

	public String getPersonaState() {
		switch (personaState) {
		case 0:
			return "Offline";
		case 1:
			return "Online";
		case 2:
			return "Busy";
		case 3:
			return "Away";
		case 4:
			return "Snooze";
		case 5:
			return "Looking to trade";
		case 6:
			return "Looking to play";
		default:
			return "Offline";
		}
	}

	public String getRealName() {
		return realName;
	}

	public String getTimeCreated() {
		return unixToNormalTime(timeCreated);
	}

	public String getCountry() {
		return country;
	}
	
	//TODO research and implement conversion
	private String unixToNormalTime(long unixTime){
		Date date = new Date((long)unixTime*1000);
		return date.toString();
	}

}