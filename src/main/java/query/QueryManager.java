package query;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import domain.PlayerSummary;

public class QueryManager {

	private static String STEAM_API_KEY = "E9F252F7547BF2108C30DFDCD4C53F58";

	public static PlayerSummary getPlayerSummary(String steamID) {
		Client client = ClientBuilder.newClient();
		String url = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=" + STEAM_API_KEY
				+ "&steamids=" + steamID + "&format=json";
		return new PlayerSummary(client.target(url).request().get(String.class));
	}

}
