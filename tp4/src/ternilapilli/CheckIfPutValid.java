package ternilapilli;

import java.util.Set;

public class CheckIfPutValid extends ValidMoveCheck {
	
	public void checkMove(Position position, Set<Position> set1, Set<Position> set2) {
		if(set1.size() == 3) {
			throw new RuntimeException(alreadyHave3PositionsErrorMessage);
		}
		if(set1.contains(position) || set2.contains(position)) {
			throw new RuntimeException(positionTakenErrorMessage);
		}
	}

}

