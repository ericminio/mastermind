package org.ericminio.mastermind;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Combinaison extends ArrayList<String> {

	public static Combinaison combinaison(String input) {
		String[] splitted = input.split( "," );
		Combinaison secret = new Combinaison();
		for (int i=0; i<splitted.length; i++) {
			secret.add( splitted[i].trim() );
		}
		return secret;

	}

}
