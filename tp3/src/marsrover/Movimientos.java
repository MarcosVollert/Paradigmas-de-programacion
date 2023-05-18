package marsrover;

import java.util.HashMap;

public abstract class Movimientos {
	
	public HashMap<Character, Integer> movimientosHash;
	String errorAlLeerSequencia = "Hubo un error al leer la sequencia, se ingreso un caracter invalido";
	
	public int move(char character){
		
		movimientosHash.computeIfAbsent(character, key -> {
			
			throw new IllegalArgumentException(errorAlLeerSequencia);
        });
		return movimientosHash.get(character);
	}
}