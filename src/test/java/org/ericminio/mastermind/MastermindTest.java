package org.ericminio.mastermind;

import static org.ericminio.mastermind.Combinaison.combinaison;
import static org.ericminio.mastermind.Players.bilou;
import static org.ericminio.mastermind.Players.claire;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MastermindTest {

	@Before public void
	init() {
		claire.acceptsTheChallengeOf( bilou );
	}
	
	@Test public void
	theSecretHolderHasASecretToCompareWithWhenHeChoosesASecret() {
		bilou.choosesSecret( combinaison( "anything" ) );
		assertThat( bilou.secret, is( combinaison( "anything" ) ) );
	}
	
	@Test public void
	theSecretHolderHasAPropositionToAssessWhentheChallengerPlays() {
		claire.plays( combinaison( "anything" ) );
		assertThat( bilou.propositionToAssess, is( combinaison( "anything" ) ) );
	}

	@Test public void
	onePlayerCanMakeAPropositionAndGetBlackKudosForWellPlacedItems() {
		bilou.choosesSecret( combinaison( "red, blue, yellow, green" ) );
		claire.plays( combinaison( "red, blue, purple, orange" ) );
		assertThat( bilou.blackCount(), equalTo( 2 ) );
	}

	@Test public void
	onePlayerCanMakeAPropositionAndGetWhiteKudosForNotWellPlacedItems() {
		bilou.choosesSecret( combinaison( "red, blue, yellow, green" ) );
		claire.plays( combinaison( "green, yellow, blue, red" ) );
		assertThat( bilou.whiteCount(), equalTo( 4 ) );
	}
	
	@Test public void
	blackKudosOvertakeWhiteKudos() {
		bilou.choosesSecret( combinaison( "red, blue, yellow, green" ) );
		claire.plays( combinaison( "red, blue, yellow, green" ) );
		assertThat( bilou.whiteCount(), equalTo( 0 ) );
	}
}
