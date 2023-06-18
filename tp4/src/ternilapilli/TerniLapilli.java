package ternilapilli;

import java.util.Set;

public class TerniLapilli {
	
	private Player X = new Player();
	private Player O = new Player();
	
	public static final String movementToFarAwayErrorMessage 
	= "Cant move more than 1 row or 1 column";

	private Player[] turns = {X,O};
	private int turnNum = 0;
	private Player turn;
	
	public TerniLapilli() {
	
		turn = turns[turnNum];
	}

	public Set<Position> getXs() {
		return X.positionsPlaced;
	}

	public Set<Position> getOs() {
		return O.positionsPlaced;
	}

	public void putAt(Position position) {
		turn.putMoveChecker.checkMove(position, turn.positionsPlaced, turns[(turnNum+1)%2].positionsPlaced);
		turn.positionsPlaced.add(position);
		changeTurn();
	}
	
	public void slideTo(Position positionTo, Position positionFrom) {
		
		turn.slideMoveChecker.checkMove(positionTo, turn.positionsPlaced, turns[(turnNum+1)%2].positionsPlaced);
		checkDistanceBetweenPositions(positionTo, positionFrom);
			turn.positionsPlaced.remove(positionFrom);
			turn.positionsPlaced.add(positionTo);
			changeTurn();
		}
	
	public int distanceBetweenPositions(Position pos1, Position pos2) {
		int newPos1 = pos1.addColumnAndRow();
		int newPos2 = pos2.addColumnAndRow();
		return Math.abs(newPos1 - newPos2);
	}
	
	public void checkDistanceBetweenPositions(Position positionTo, Position positionFrom) {
		if(distanceBetweenPositions(positionFrom, positionTo) == 0 && (positionFrom.getRow() != 2 && positionFrom.getColumn() != 2) && (positionTo.getRow() != 2 && positionTo.getColumn() != 2)) {
			throw new RuntimeException(movementToFarAwayErrorMessage);
		}
		if((distanceBetweenPositions(positionFrom, positionTo) == 1) || (positionFrom.getRow() == 2 && positionFrom.getColumn() == 2) || (positionTo.getRow() == 2 && positionTo.getColumn() == 2)) {
			return;
		}else {
			throw new RuntimeException(movementToFarAwayErrorMessage);
			}	
		
	}
	
	public void changeTurn() {
		turnNum += 1;
		turn = turns[(turnNum)%2];
	}

	public boolean isWinnerX() {
		return hasCompletedRow(X.positionsPlaced);
	}
	
	public boolean isWinnerO() {
		return hasCompletedRow(O.positionsPlaced);
	}

	private boolean hasCompletedRow(Set<Position> xsOrOs) {
		for( int iteradorFilas = 1; iteradorFilas <= 3; iteradorFilas++ ) {
			int filaObservable = iteradorFilas;
			int count = (int) xsOrOs.stream().filter(p -> p.getRow() == filaObservable).count();
			if(count == 3 ) {
				return true;
			}
		}
		return false;
	}
}
