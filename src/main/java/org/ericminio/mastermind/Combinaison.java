package org.ericminio.mastermind;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class Combinaison extends ArrayList<String> {

	public Combinaison(Collection<String> source) {
		super( source );
	}

	public Combinaison() {
	}

	public static Combinaison combinaison(String input) {
		String[] splitted = input.split( "," );
		Combinaison secret = new Combinaison();
		for (int i=0; i<splitted.length; i++) {
			secret.add( splitted[i].trim() );
		}
		return secret;
	}

	public Combinaison intersect(Combinaison other) {
		Set<String> tmp = new HashSet<String>( this );
		tmp.retainAll( other );
		return new Combinaison( tmp );
	}

}
