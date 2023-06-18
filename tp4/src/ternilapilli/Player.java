package ternilapilli;

import java.util.HashSet;
import java.util.Set;

public class Player {

	public Set<Position> positionsPlaced;
	public ValidMoveCheck putMoveChecker;
	public ValidMoveCheck slideMoveChecker;
	
	
	public Player() {
		putMoveChecker = new CheckIfPutValid();
		slideMoveChecker = new CheckIfSlideValid();
		positionsPlaced = new HashSet<>();
	}
}
