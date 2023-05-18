package marsrover;

public class MarsRover {
	
    public Point position;
    public Orientacion heading;
    public Orientacion N = new OrientacionNorte();
    public Orientacion E = new OrientacionEste();
    public Orientacion S = new OrientacionSur();
    public Orientacion O = new OrientacionOeste();
    public Movimientos movimientos = new CambiosPosicion();
    public Movimientos rotaciones = new CambiosDireccion();
    public Orientacion[] orientaciones = {N, E, S, O};
    public int cardActual = 0;

    public MarsRover(Point initialPosition) {
        position = initialPosition;
        heading = orientaciones[cardActual];
    }

    public Point getPosition() {
        return position;
    }

    public Orientacion isHeading() {
        return heading;
    }

    public Point moveRover(int number) {
    	return (position = heading.moveRover(number, this.position));
    }
    
	 public void rotate(int number) {
		cardActual += number;
		cardActual = (((cardActual % 4) + 4) % 4);
		heading = orientaciones[cardActual];
	}
	
    public void hashMapper(String sequencia) {
    	char[] charsSequencia = sequencia.toCharArray();
    	for (char character : charsSequencia) {
    		
            this.moveRover(movimientos.move(character));
            this.rotate(rotaciones.move(character));
    	}
    }
}