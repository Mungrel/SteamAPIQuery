package responses;
import org.junit.Test;

import domain.PlayerSummary;
import query.QueryManager;

public class TestPlayerSummary {

	@Test
	public void test() {
		@SuppressWarnings("unused")
		PlayerSummary ps = QueryManager.getPlayerSummary("76561198054259683");
	}

}
