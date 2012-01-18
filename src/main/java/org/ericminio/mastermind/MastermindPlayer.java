package org.ericminio.mastermind;

public class MastermindPlayer {

	public Combinaison secret;
	public Combinaison propositionToAssess;
	public MastermindPlayer secretHolder;
	
	public void acceptsTheChallengeOf(MastermindPlayer player) {
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
			if (propositionToAssess.get( i ).equals( secret.get( i ) ) ) {
				count ++;
			}
		}
		return count;
	}

	public int whiteCount() {
		return secret.intersect( propositionToAssess ).size() - blackCount();
	}

}
