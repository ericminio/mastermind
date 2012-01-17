package org.ericminio.mastermind;

import java.util.HashSet;
import java.util.Set;

public class MastermindPlayer {

	public Combinaison secret;
	public Combinaison propositionToAssess;
	public MastermindPlayer secretHolder;
	
	public void acceptToPlayWith(MastermindPlayer player) {
		this.secretHolder = player;
	}

	public void choosesSecret(Combinaison combinaison) {
		this.secret = combinaison ;
	}

	public void plays(Combinaison combinaison) {
		this.secretHolder.propositionToAssess = combinaison;
	}

	public int blackCount() {
		int count = 0;
		for(int i=0; i<propositionToAssess.size(); i++) {
			if (propositionToAssess.get( i )
					.equalsIgnoreCase( secret.get( i ) ) ) {
				count ++;
			}
		}
		return count;
	}

	public int whiteCount() {
		return intersection().size() - blackCount();
	}

	protected Set<String> intersection() {
		Set<String> tmp = new HashSet<String>( secret );
		tmp.retainAll( propositionToAssess );
		return tmp;
	}

}
