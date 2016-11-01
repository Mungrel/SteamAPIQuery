package query;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class Query {
	
	private static String STEAM_API_KEY = "E9F252F7547BF2108C30DFDCD4C53F58";
	
	
	public static String getPlayerSummary(String steamID){
		String url = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key="+STEAM_API_KEY+"&steamids="+steamID+"&format=json";
		Client client = ClientBuilder.newClient();
		return client.target(url).request().get(String.class);
	}
}
