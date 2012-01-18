package org.ericminio.mastermind;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CombinaisonTest {

	@Test public void
	canBeBuildByString() {
		Combinaison combinaison = Combinaison.combinaison( "input" );
		assertEquals( 1, combinaison.size() );
		assertEquals( "input", combinaison.get( 0 ) );
	}
	
	@Test public void
	parseInputStringByComma() {
		Combinaison combinaison = Combinaison.combinaison( "one, two" );
		assertEquals( 2, combinaison.size() );
		assertEquals( "one", combinaison.get( 0 ) );
		assertEquals( "two", combinaison.get( 1 ) );
	}
	
	@Test public void
	canBuildANewCombinaisonByIntersectingWithAnother() {
		Combinaison combinaison = Combinaison.combinaison( "one, two, three" );
		Combinaison other = Combinaison.combinaison( "two, three, four" );
		Combinaison intersection = combinaison.intersect( other );
		assertEquals( 2, intersection.size() );
		assertTrue( combinaison.contains( "two" ) );
		assertTrue( combinaison.contains( "three" ) );
	}

}
