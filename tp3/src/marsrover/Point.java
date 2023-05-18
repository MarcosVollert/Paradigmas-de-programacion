package marsrover;

import java.util.Objects;

public class Point {
    public int xPosition;
    public int yPosition;


    public Point(int i, int j) {
        xPosition = i;
        yPosition = j;
    }
    
    public int getXCoordinate() {
    	return xPosition;
    }
    public int getYCoordinate() {
    	return yPosition;
    }

	@Override
	public int hashCode() {
		return Objects.hash(xPosition, yPosition);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return xPosition == other.xPosition && yPosition == other.yPosition;
	}
	
	
}