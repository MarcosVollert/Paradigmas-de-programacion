package ternilapilli;

import java.util.Objects;

public class Position {
	private int row;
	private int column;

	public Position(int i, int j) {
		row = i;
		column = j;
	}

	public boolean equals(Object obj) {
		Position position = (Position) obj;
		return row == position.row && column == position.column;
	}

	public int hashCode() {
		return Objects.hash(row, column);
	}

	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public int addColumnAndRow() {
		return column + row;
	}
}