package query;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import domain.Friend;
import domain.PlayerSummary;

public class QueryManager {

	private static String STEAM_API_KEY = "E9F252F7547BF2108C30DFDCD4C53F58";

	public static PlayerSummary getPlayerSummary(String steamID) {
		Client client = ClientBuilder.newClient();
		String url = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=" + STEAM_API_KEY
				+ "&steamids=" + steamID + "&format=json";
		PlayerSummary ps = new PlayerSummary(client.target(url).request().get(String.class));
		client.close();
		return ps;
	}

	public static List<Friend> getFriendsList(String steamID) {
		Client client = ClientBuilder.newClient();
		String url = "http://api.steampowered.com/ISteamUser/GetFriendList/v0001/?key=" + STEAM_API_KEY + "&steamid="
				+ steamID;
		String response = client.target(url).request().get(String.class);
		client.close();
		List<Friend> friendsList = new ArrayList<Friend>();
		JSONArray friendsArray = new JSONObject(response).getJSONObject("friendslist").getJSONArray("friends");
		for (int i = 0; i < friendsArray.length(); i++) {
			friendsList.add(new Friend(friendsArray.getJSONObject(i).toString()));
		}
		return friendsList;
	}

}
