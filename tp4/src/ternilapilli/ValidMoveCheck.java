package ternilapilli;

import java.util.Set;

public abstract class ValidMoveCheck {

	public static final String alreadyHave3PositionsErrorMessage = "Use sliding functions";
	public static final String hasLessThan3PositionsErrorMessage = "Use placing functions";
	public static final String movementToFarAwayErrorMessage = "Cant move more than 1 row or 1 column";
	public static final String notXTurnErrorMessage = "Not X's turn";
	public static final String notOTurnErrorMessage = "Not O's turn";
	public static final String positionTakenErrorMessage = "Position taken";
	
	public ValidMoveCheck() {
		
		
	}
	
	public abstract void checkMove(Position position, Set<Position> set1, Set<Position> set2);
	

}
