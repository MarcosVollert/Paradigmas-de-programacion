package marsrover;

import java.util.HashMap;

public class CambiosPosicion extends Movimientos{
	
	{
		movimientosHash = new HashMap<>();
		movimientosHash.put('f', 1);
		movimientosHash.put('b', -1);
		movimientosHash.put('r', 0);
		movimientosHash.put('l', 0);
    }
}