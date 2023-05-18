package marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class MarsRoverTest{
	
	Point initialPosition = new Point(1,1);
	String errorAlLeerSequencia = "Hubo un error al leer la sequencia, se ingreso un caracter invalido";
	
    @Test public void Test00CheckIfInitialPositionIsCorrect() {
       
        MarsRover rover = new MarsRover(initialPosition); //El rover debe estar ubicado en la posicion incial
        assertEquals(initialPosition, rover.getPosition()); //assert que el rover este ubicado en la posicion inicial
        assertEquals(rover.heading, rover.isHeading()); //assert que esta apuntando al norte
    }
    
    @Test public void Test01CheckIfMovementWorks() {
     
        MarsRover rover = new MarsRover(initialPosition);
        rover.moveRover(1);
        rover.moveRover(1);
        assertEquals(new Point(1,3), rover.getPosition());

    }
    
    @Test public void Test02GoingBackAndForth() {
  
        MarsRover rover = new MarsRover(initialPosition);
        rover.moveRover(1);
        rover.moveRover(-1);
        assertEquals(initialPosition, rover.getPosition());

    }
    
    @Test public void Test03CheckIfMovementWorksBackwards() {
    	
        MarsRover rover = new MarsRover(initialPosition);
        rover.moveRover(-1);
        rover.moveRover(1);
        rover.moveRover(-1);
        rover.moveRover(-1);
        rover.moveRover(-1);
        assertEquals(new Point(1,-2), rover.getPosition());

    }
    

    @Test public void Test04CheckIfMovementWorksWithRotations() {

        MarsRover rover = new MarsRover(initialPosition);
        OrientacionOeste O = new OrientacionOeste();
        rover.moveRover(1);
        rover.moveRover(1);
        rover.rotate(1);
        rover.moveRover(1);
        rover.rotate(-1);
        rover.rotate(-1);
        rover.moveRover(1);
        assertTrue(rover.isHeading().getClass().isInstance(O));
        assertEquals(new Point(1,3), rover.getPosition());

    }
    
    @Test public void Test05CheckIfRotatingDoesntGoOutOfIndex() {

        MarsRover rover = new MarsRover(initialPosition);
        OrientacionEste E = new OrientacionEste();
        rover.moveRover(1);
        rover.moveRover(1);
        rover.rotate(1);
        rover.moveRover(1);
        rover.rotate(1);
        rover.moveRover(1);
        rover.rotate(1);
        rover.rotate(1);
        rover.rotate(1);
        rover.moveRover(1);
        assertTrue(rover.isHeading().getClass().isInstance(E));
    }
    
    @Test public void Test06CheckIfRoverEndsInSamePlace() {

        MarsRover rover = new MarsRover(initialPosition);
        OrientacionNorte N = new OrientacionNorte();
        String sequence = "frfrfrfr";
        rover.hashMapper(sequence);
        assertEquals(new Point(1,1), rover.getPosition());
        assertTrue(rover.isHeading().getClass().isInstance(N));
        
    }
  
    @Test public void Test07CheckIfSequencesWorks() {

        MarsRover rover = new MarsRover(initialPosition);
        String sequence = "fffrfbblbbrrrff";
        rover.hashMapper(sequence);
        
        assertEquals(new Point(-2,2), rover.getPosition());

    }
    
    
    @Test public void Test08CheckIfWrongInputStopsProcess() {

        MarsRover rover = new MarsRover(initialPosition);
        String sequence = "frfmfff";
        
        assertThrowsLike(errorAlLeerSequencia, () -> rover.hashMapper(sequence));
        assertEquals(new Point(2,2), rover.getPosition());
    }
    
    
    public void assertThrowsLike (String msg, Executable codeToRun) {
    	assertEquals(msg, assertThrows(Exception.class, codeToRun).getMessage());
    }
}

