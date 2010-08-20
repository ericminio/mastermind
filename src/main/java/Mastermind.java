

public class Mastermind {

	public String givenTheSecret;
	public String whenPlayerPlays;

	public boolean doesHeWin() {
		if (whenPlayerPlays.equalsIgnoreCase(givenTheSecret)) {
			return true;
		}
		return false;
	}
	
	public int black() {
		return 0;
	}
	
	public int white() {
		return 0;
	}
	
}
