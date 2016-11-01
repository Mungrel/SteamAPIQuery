package responses;
import org.junit.Test;

import domain.PlayerSummary;
import query.Query;

public class TestPlayerSummary {

	@Test
	public void test() {
		String response = Query.getPlayerSummary("76561198054259683");
		System.out.println(response);
		@SuppressWarnings("unused")
		PlayerSummary ps = new PlayerSummary(response);
	}

}
