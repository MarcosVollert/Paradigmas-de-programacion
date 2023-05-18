package marsrover;

public class OrientacionEste extends Orientacion{

	public Point moveRover(int number, Point position) {
		int xCoordinate = position.getXCoordinate();
        xCoordinate += number;
        position = new Point(xCoordinate,position.getYCoordinate());
        return position;
	}
}
