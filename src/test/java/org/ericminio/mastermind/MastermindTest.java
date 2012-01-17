package org.ericminio.mastermind;
import static org.ericminio.mastermind.Combinaison.combinaison;
import static org.ericminio.mastermind.Players.bilou;
import static org.ericminio.mastermind.Players.claire;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MastermindTest {

	@Before public void
	init() {
		claire.acceptToPlayWith( bilou );
	}
	
	@Test public void
	theSecretHolderHasASecretToCompareWithWhenHeChoosesASecret() {
		bilou.choosesSecret( combinaison( "anything" ) );
		assertEquals( combinaison( "anything" ), bilou.secret );
	}
	
	@Test public void
	theChallengerHasAPropositionToAssessWhenHisOpponentPlays() {
		claire.plays( combinaison( "anything" ) );
		assertEquals( combinaison( "anything" ), bilou.propositionToAssess );
	}

	@Test public void
	onePlayerCanMakeAPropositionAndGetBlackKudosForWellPlacedItems() {
		bilou.choosesSecret( combinaison( "red, blue, yellow, green" ) );
		claire.plays( combinaison( "red, blue, purple, orange" ) );
		assertEquals( 2, bilou.blackCount() );
	}

	@Test public void
	onePlayerCanMakeAPropositionAndGetWhiteKudosForNotWellPlacedItems() {
		bilou.choosesSecret( combinaison( "red, blue, yellow, green" ) );
		claire.plays( combinaison( "green, yellow, blue, red" ) );
		assertEquals( 4, bilou.whiteCount() );
	}
	
	@Test public void
	blackKudosOvertakeWhiteKudos() {
		bilou.choosesSecret( combinaison( "red, blue, yellow, green" ) );
		claire.plays( combinaison( "red, blue, yellow, green" ) );
		assertEquals( 0, bilou.whiteCount() );
	}
}
