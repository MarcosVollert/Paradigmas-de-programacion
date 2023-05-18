package marsrover;

import java.util.HashMap;

public class CambiosDireccion extends Movimientos{
	
	{
		movimientosHash = new HashMap<>();
		movimientosHash.put('f', 0);
		movimientosHash.put('b', 0);
		movimientosHash.put('r', 1);
		movimientosHash.put('l', -1);
    }
}