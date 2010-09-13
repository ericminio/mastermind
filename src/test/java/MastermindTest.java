import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;



public class MastermindTest {

	private Mastermind mastermind;
	
	@Before public void
	init() {
		mastermind = new Mastermind();
	}
	
	@Test public void
	returnsTheNumberOfItemsAsBlackPointsWhenPlayerWins() {
		mastermind.givenTheSecret = "A";
		mastermind.whenPlayerPlays = "A";
		assertEquals( 1, mastermind.black() );
		
		mastermind.givenTheSecret = "A B";
		mastermind.whenPlayerPlays = "A B";
		assertEquals( 2, mastermind.black() );
	}
}
