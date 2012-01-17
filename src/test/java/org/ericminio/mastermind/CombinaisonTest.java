package org.ericminio.mastermind;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CombinaisonTest {

	@Test public void
	canBeBuildByString() {
		Combinaison combinaison = Combinaison.combinaison( "input" );
		assertEquals( 1, combinaison.size() );
		assertEquals( "input", combinaison.get( 0 ) );
	}
	
	@Test public void
	parseStringByComma() {
		Combinaison combinaison = Combinaison.combinaison( "one, two" );
		assertEquals( 2, combinaison.size() );
		assertEquals( "one", combinaison.get( 0 ) );
		assertEquals( "two", combinaison.get( 1 ) );
	}

}
