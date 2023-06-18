package ternilapilli;

import java.util.Set;

public class CheckIfSlideValid extends ValidMoveCheck {
	public void checkMove(Position positionTo, Set<Position> set1, Set<Position> set2) {
		if(set1.size() < 3) { 
			throw new RuntimeException(hasLessThan3PositionsErrorMessage);
		}
		if(set1.contains(positionTo) || set2.contains(positionTo)) {
			throw new RuntimeException(positionTakenErrorMessage);
		}
	}
}