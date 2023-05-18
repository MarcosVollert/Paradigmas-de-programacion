package marsrover;

public class OrientacionNorte extends Orientacion{

	public Point moveRover(int number, Point position) {
		int yCoordinate = position.getYCoordinate();
        yCoordinate += number;
        position = new Point(position.getXCoordinate(),yCoordinate);
        return position;
	}
}
