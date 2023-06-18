package ternilapilli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

public class TerniLapilliTest {

    @Test public void testElJuegoYNoHayNingunaFichaEnJuego() {  
    	TerniLapilli game = new TerniLapilli();
    	assertTrue(game.getXs().isEmpty());
    	assertTrue(game.getOs().isEmpty());
    }

   @Test public void testPruebaQueSePuedaPonerUnaFichaXYQueOEsteVacia() {
	   TerniLapilli game = new TerniLapilli();
	   game.putAt( new Position( 1, 1 ));
	   assertEquals(1, game.getXs().size());
	   assertTrue(game.getXs().contains(new Position( 1, 1 )));
	   assertTrue(game.getOs().isEmpty());
   }

   @Test public void testPruebaQueSePuedaPonerUnaFichaXYO() {
	   TerniLapilli game = new TerniLapilli();
	   game.putAt( new Position( 1, 1 ));
	   game.putAt( new Position( 2, 2 ));
	   assertEquals(1, game.getXs().size());
	   assertTrue(game.getXs().contains(new Position( 1, 1 )));
	   assertEquals(1, game.getOs().size());
	   assertTrue(game.getOs().contains(new Position( 2, 2 )));
   }
	
	@Test public void testPruebaQueElTurnoSeCambia() {  
       TerniLapilli game = new TerniLapilli();
       game.putAt( new Position( 1, 1 ));  //X
       game.putAt( new Position( 2, 1 ));  //O
       game.putAt( new Position( 3, 1 ));  //X
       
	   assertTrue(game.getXs().contains(new Position( 1, 1 )));
	   assertTrue(game.getOs().contains(new Position( 2, 1 )));
	   assertTrue(game.getXs().contains(new Position( 3, 1 )));
    }
   

  

	   @Test public void testPruebaQueNoPuedasPonerXEnElMismoLugarQueX() {
		   TerniLapilli game = new TerniLapilli();
		   game.putAt( new Position( 1, 1 ));
		   game.putAt( new Position( 2, 2 ));
		   
		   try {
			   game.putAt( new Position( 1, 1 ));
			   fail("Expected error");
		   }catch(RuntimeException anError) {
			   assertEquals(ValidMoveCheck.positionTakenErrorMessage, anError.getMessage());
			   assertEquals(1, game.getXs().size());
			   assertTrue(game.getXs().contains(new Position( 1, 1 )));
			   assertEquals(1, game.getOs().size());
			   assertTrue(game.getOs().contains(new Position( 2, 2 )));			   
		   }	   
   }	   

	   @Test public void testPruebaQueNoPuedasPonerXEnElMismoLugarQueO() {
		   TerniLapilli game = new TerniLapilli();
		   game.putAt( new Position( 1, 1 ));
		   game.putAt( new Position( 2, 2 ));
		  
		   try {
			   game.putAt( new Position( 2, 2 ));
			   fail("Expected error");
		   }catch(RuntimeException anError) {
			   assertEquals(ValidMoveCheck.positionTakenErrorMessage, anError.getMessage());
			   assertEquals(1, game.getXs().size());
			   assertTrue(game.getXs().contains(new Position( 1, 1 )));
			   assertEquals(1, game.getOs().size());
			   assertTrue(game.getOs().contains(new Position( 2, 2 )));			   
		   }	  
	   }	   

	   @Test public void testPruebaQueNoPuedasPonerOEnElMismoLugarQueX() {
		   TerniLapilli game = new TerniLapilli();
		   game.putAt( new Position( 1, 1 ));
		   
		   try {
			   game.putAt( new Position( 1, 1 ));
			   fail("Expected error");
		   }catch(RuntimeException anError) {
			   assertEquals(ValidMoveCheck.positionTakenErrorMessage, anError.getMessage());
			   assertEquals(1, game.getXs().size());
			   assertTrue(game.getXs().contains(new Position( 1, 1 )));
			   assertTrue(game.getOs().isEmpty());
		   }	   
	   }	   

	   @Test public void testPruebaQueNoPuedasPonerOEnElMismoLugarQueO() {
		   TerniLapilli game = new TerniLapilli();
		   game.putAt( new Position( 1, 1 ));
		   game.putAt( new Position( 2, 2 ));
		   game.putAt( new Position( 3, 3 ));
		   
		   try {
			   game.putAt( new Position( 2, 2 ));
			   fail("Expected error");
		   }catch(RuntimeException anError) {
			   assertEquals(ValidMoveCheck.positionTakenErrorMessage, anError.getMessage());
			   assertEquals(2, game.getXs().size());
			   assertTrue(game.getXs().contains(new Position( 1, 1 )));
			   assertTrue(game.getXs().contains(new Position( 3, 3 )));
			   assertEquals(1, game.getOs().size());
			   assertTrue(game.getOs().contains(new Position( 2, 2 )));
		   }	   
	   }	   

	   @Test public void testPruebaQueXNiOGanaSiNoTienen3FichasSeguidas() {
		   TerniLapilli game = new TerniLapilli();
		   game.putAt( new Position( 1, 1 ));
		   game.putAt( new Position( 2, 2 ));
		   game.putAt( new Position( 3, 3 ));
		   game.putAt( new Position( 1, 2 ));
		   assertFalse(game.isWinnerX());
		   assertFalse(game.isWinnerO());
	   }

	   @Test public void testPruebaQueAlTener3FichasSeguidasXGana() {
		   TerniLapilli game = new TerniLapilli();
		   game.putAt( new Position( 2, 1 ));
		   game.putAt( new Position( 1, 2 ));
		   game.putAt( new Position( 2, 2 ));
		   game.putAt( new Position( 1, 3 ));
		   game.putAt( new Position( 2, 3 ));
		   assertTrue(game.isWinnerX());
		   assertFalse(game.isWinnerO());
	   }
	   
	   @Test public void testPruebaQueOSoloPuedaPoner3Fichas() {
		   TerniLapilli game = new TerniLapilli();
		   game.putAt( new Position( 1, 1 ));
		   game.putAt( new Position( 2, 1 ));
		   game.putAt( new Position( 1, 2 ));
		   game.putAt( new Position( 2, 2 ));
		   game.putAt( new Position( 2, 3 ));
		   game.putAt( new Position( 1, 3 ));
		   try {
			   game.putAt( new Position( 3, 1 ));
		   }catch(RuntimeException anError){
			   assertEquals(ValidMoveCheck.alreadyHave3PositionsErrorMessage, anError.getMessage());
			   assertEquals(3, game.getOs().size());
			   
		   }
	   }
	   
	   @Test public void testPruebaQueXSoloPuedaPoner3Fichas() {
		   TerniLapilli game = new TerniLapilli();
		   game.putAt( new Position( 1, 1 ));
		   game.putAt( new Position( 2, 1 ));
		   game.putAt( new Position( 1, 2 ));
		   game.putAt( new Position( 2, 2 ));
		   game.putAt( new Position( 2, 3 ));
		   game.putAt( new Position( 1, 3 ));
		   game.slideTo( new Position( 3, 3 ), new Position( 2, 3));
		   try {
			   game.putAt( new Position( 3, 1 ));
		   }catch(RuntimeException anError){
			   assertEquals(ValidMoveCheck.alreadyHave3PositionsErrorMessage, anError.getMessage());
			   assertEquals(3, game.getOs().size());
			   assertEquals(3, game.getXs().size());
			   
		   }
	   }
	   
	    @Test public void testPruebaQuePuedasMoverO() {  
	       TerniLapilli game = new TerniLapilli();
	       game.putAt( new Position( 1, 1 ));  //X
	       game.putAt( new Position( 2, 1 ));  //O
		   game.putAt( new Position( 1, 2 ));  //X
		   game.putAt( new Position( 2, 2 ));  //O
		   game.putAt( new Position( 2, 3 ));  //X
		   game.putAt( new Position( 1, 3 ));  //O
		   game.slideTo(new Position( 3, 1 ), new Position( 2, 1 ));  //X
		   game.slideTo(new Position( 3, 2 ), new Position( 2, 2 ));  //O
		   assertEquals(3, game.getOs().size());
		   assertTrue(game.getOs().contains(new Position( 3, 2 )));
		   assertTrue(game.getOs().contains(new Position( 2, 1 )));
		   assertTrue(game.getOs().contains(new Position( 1, 3 )));
	    }
	    
	    @Test public void testPruebaQuePuedasMoverX() {  
		       TerniLapilli game = new TerniLapilli();
		       game.putAt( new Position( 1, 1 ));
		       game.putAt( new Position( 2, 1 ));
			   game.putAt( new Position( 1, 2 ));
			   game.putAt( new Position( 2, 2 ));
			   game.putAt( new Position( 2, 3 ));	
			   game.putAt( new Position( 1, 3 ));
			   game.slideTo(new Position( 3, 3 ), new Position( 2, 3 ));
			   assertEquals(3, game.getXs().size());
			   assertTrue(game.getXs().contains(new Position( 3, 3 )));
			   assertTrue(game.getXs().contains(new Position( 1, 1 )));
			   assertTrue(game.getXs().contains(new Position( 1, 2 )));
		    }
	    
	    @Test public void testPruebaQuePuedasMoverXDelCentroAUnaEsquinaYAlCentroDevuelta() {  
		       TerniLapilli game = new TerniLapilli();
		       game.putAt( new Position( 1, 1 ));
		       game.putAt( new Position( 2, 1 ));
			   game.putAt( new Position( 1, 2 ));
			   game.putAt( new Position( 2, 3 ));
			   game.putAt( new Position( 2, 2 ));	
			   game.putAt( new Position( 1, 3 ));
			   game.slideTo(new Position( 3, 3 ), new Position( 2, 2 ));
			   game.slideTo(new Position( 3, 1 ), new Position( 2, 1 ));
			   game.slideTo(new Position( 2, 2 ), new Position( 3, 3 ));
			   assertEquals(3, game.getXs().size());
			   assertTrue(game.getXs().contains(new Position( 2, 2 )));
			   assertTrue(game.getXs().contains(new Position( 1, 1 )));
			   assertTrue(game.getXs().contains(new Position( 1, 2 )));
		    }
		    
		    @Test public void testPruebaQuePuedasMoverODelCentroAUnaEsquinaYAlCentroDevuelta() {  
			       TerniLapilli game = new TerniLapilli();
			       game.putAt( new Position( 2, 1 ));  //X
			       game.putAt( new Position( 1, 1 ));  //O
				   game.putAt( new Position( 2, 3 ));  //X
				   game.putAt( new Position( 1, 2 ));  //O
				   game.putAt( new Position( 1, 3 ));  //X
				   game.putAt( new Position( 2, 2 ));  //O
				   game.slideTo(new Position( 3, 3 ), new Position( 2, 3 ));  //X
				   game.slideTo(new Position( 3, 1 ), new Position( 2, 2 ));  //O
				   game.slideTo(new Position( 3, 2 ), new Position( 3, 3 ));  //X
				   game.slideTo(new Position( 2, 2 ), new Position( 3, 1 ));  //O
				   assertEquals(3, game.getOs().size());
				   assertTrue(game.getOs().contains(new Position( 2, 2 )));
				   assertTrue(game.getOs().contains(new Position( 1, 1 )));
				   assertTrue(game.getOs().contains(new Position( 1, 2 )));
			    }
	    
	    @Test public void testPruebaQuePuedasMoverOYQueAlTener3FichasSeguidasOGana() {  
		       TerniLapilli game = new TerniLapilli();
		       game.putAt( new Position( 3, 1 ));  //X
		       game.putAt( new Position( 2, 1 ));  //O
			   game.putAt( new Position( 1, 2 ));  //X
			   game.putAt( new Position( 2, 2 ));  //O
			   game.putAt( new Position( 2, 3 ));  //X	
			   game.putAt( new Position( 3, 3 ));  //O
			   game.slideTo(new Position( 1, 3 ), new Position( 2, 3 ));  //X
			   game.slideTo(new Position( 2, 3 ), new Position( 3, 3 ));  //O
			   assertEquals(3, game.getOs().size());
			   assertTrue(game.getOs().contains(new Position( 2, 1 )));
			   assertTrue(game.getOs().contains(new Position( 2, 2 )));
			   assertTrue(game.getOs().contains(new Position( 2, 3 )));
			   assertTrue(game.isWinnerO());
			   assertFalse(game.isWinnerX());
		    }
	    

	    
	    @Test public void testPruebaQueXSlidePeroTieneMenosDe3FichasEnJuego() {
			   TerniLapilli game = new TerniLapilli();
			   game.putAt( new Position( 1, 1 ));
			   game.putAt( new Position( 2, 2 ));
			   game.putAt( new Position( 3, 3 ));
			   game.putAt( new Position( 1, 2 ));
			   try {
				   game.slideTo( new Position( 3, 2 ), new Position( 3, 3 ));
			   }catch(RuntimeException anError){
				   assertEquals(ValidMoveCheck.hasLessThan3PositionsErrorMessage, anError.getMessage());
				   assertEquals(2, game.getOs().size());
				   assertEquals(2, game.getXs().size());
			   }
	       }
	     
	    @Test public void testPruebaQueOSlidePeroTieneMenosDe3FichasEnJuego() {
			   TerniLapilli game = new TerniLapilli();
			   game.putAt( new Position( 1, 1 ));
			   game.putAt( new Position( 2, 2 ));
			   game.putAt( new Position( 3, 3 ));
			   try {
				   game.slideTo( new Position( 1, 2 ), new Position( 1, 1 ));
			   }catch(RuntimeException anError){
				   assertEquals(ValidMoveCheck.hasLessThan3PositionsErrorMessage, anError.getMessage());
				   assertEquals(1, game.getOs().size());
				   assertEquals(2, game.getXs().size());
			   }
	       }
	    
	    @Test public void testPruebaQueOSlidePeroSeIntentaMoverAlMismoLugar() {
			   TerniLapilli game = new TerniLapilli();
			   game.putAt( new Position( 1, 1 ));  //X
		       game.putAt( new Position( 2, 1 ));  //O
			   game.putAt( new Position( 1, 2 ));  //X
			   game.putAt( new Position( 2, 2 ));  //O
			   game.putAt( new Position( 2, 3 ));  //X
			   game.putAt( new Position( 3, 3 ));  //O
			   game.slideTo( new Position( 1, 3 ), new Position( 2, 3 ));  //X
			   
			   try {
				   game.slideTo( new Position( 1, 2 ), new Position( 1, 2 ));  //O
			   }catch(RuntimeException anError){
				   assertEquals(ValidMoveCheck.positionTakenErrorMessage, anError.getMessage());
				   assertEquals(3, game.getOs().size());
				   assertEquals(3, game.getXs().size());
			   }
	       }
	    
	    @Test public void testPruebaQueXSlidePeroSeIntentaMoverAlMismoLugar() {
			   TerniLapilli game = new TerniLapilli();
			   game.putAt( new Position( 1, 1 ));
		       game.putAt( new Position( 2, 1 ));
			   game.putAt( new Position( 1, 2 ));
			   game.putAt( new Position( 2, 2 ));
			   game.putAt( new Position( 2, 3 ));	
			   game.putAt( new Position( 3, 3 ));
			   game.slideTo(new Position( 1, 3 ), new Position( 2, 3 ));
			   try {
				   game.slideTo( new Position( 2, 2 ), new Position( 2, 2 ));
			   }catch(RuntimeException anError){
				   assertEquals(ValidMoveCheck.positionTakenErrorMessage, anError.getMessage());
				   assertEquals(3, game.getOs().size());
				   assertEquals(3, game.getXs().size());
			   }
	       }
	    
	    @Test public void testPruebaQueOIntentaSlideAUnLugarOcupado() {
			   TerniLapilli game = new TerniLapilli();
			   game.putAt( new Position( 1, 1 ));
		       game.putAt( new Position( 2, 1 ));
			   game.putAt( new Position( 1, 2 ));
			   game.putAt( new Position( 2, 2 ));
			   game.putAt( new Position( 2, 3 ));	
			   game.putAt( new Position( 3, 3 ));
			   try {
				   game.slideTo( new Position( 2, 2 ), new Position( 1, 2 ));
			   }catch(RuntimeException anError){
				   assertEquals(ValidMoveCheck.positionTakenErrorMessage, anError.getMessage());
				   assertEquals(3, game.getOs().size());
				   assertEquals(3, game.getXs().size());
			   }
	       }
	    
	    @Test public void testPruebaQueXIntentaSlideAUnLugarOcupado() {
			   TerniLapilli game = new TerniLapilli();
			   game.putAt( new Position( 1, 1 ));
		       game.putAt( new Position( 2, 1 ));
			   game.putAt( new Position( 1, 2 ));
			   game.putAt( new Position( 2, 2 ));
			   game.putAt( new Position( 2, 3 ));	
			   game.putAt( new Position( 3, 3 ));
			   game.slideTo(new Position( 1, 3 ), new Position( 2, 3 ));
			   try {
				   game.slideTo( new Position( 1, 2 ), new Position( 2, 2 ));
			   }catch(RuntimeException anError){
				   assertEquals(ValidMoveCheck.positionTakenErrorMessage, anError.getMessage());
				   assertEquals(3, game.getOs().size());
				   assertEquals(3, game.getXs().size());
			   }
	       }
	    
	    @Test public void testPruebaQueOIntentaSlideIndiagonalNoHaciaODesdeElCentro() {
			   TerniLapilli game = new TerniLapilli();
			   game.putAt( new Position( 1, 1 ));
		       game.putAt( new Position( 2, 1 ));
			   game.putAt( new Position( 1, 2 ));
			   game.putAt( new Position( 2, 2 ));
			   game.putAt( new Position( 2, 3 ));	
			   game.putAt( new Position( 3, 3 ));
			   try {
				   game.slideTo( new Position( 3, 2 ), new Position( 2, 3 ));
			   }catch(RuntimeException anError){
				   assertEquals(TerniLapilli.movementToFarAwayErrorMessage, anError.getMessage());
				   assertEquals(3, game.getOs().size());
				   assertEquals(3, game.getXs().size());
			   }
	       }
	    
	    @Test public void testPruebaQueXIntentaSlideIndiagonalNoHaciaODesdeElCentro() {
			   TerniLapilli game = new TerniLapilli();
			   game.putAt( new Position( 1, 1 ));
		       game.putAt( new Position( 2, 1 ));
			   game.putAt( new Position( 1, 2 ));
			   game.putAt( new Position( 2, 2 ));
			   game.putAt( new Position( 2, 3 ));	
			   game.putAt( new Position( 3, 3 ));
			   try {
				   game.slideTo( new Position( 3, 2 ), new Position( 2, 3 ));
			   }catch(RuntimeException anError){
				   assertEquals(TerniLapilli.movementToFarAwayErrorMessage, anError.getMessage());
				   assertEquals(3, game.getOs().size());
				   assertEquals(3, game.getXs().size());
			   }
	       }
	    
		   @Test public void testGeneralDePruebaQueOYXPuedeMoverseACuelquierLugarDelTablero() {  
		       TerniLapilli game = new TerniLapilli();
		       game.putAt( new Position( 1, 1 ));
		       game.putAt( new Position( 2, 1 ));
			   game.putAt( new Position( 1, 2 ));
			   game.putAt( new Position( 2, 2 ));
			   game.putAt( new Position( 2, 3 ));	
			   game.putAt( new Position( 1, 3 ));
			   game.slideTo(new Position( 3, 3 ), new Position( 2, 3 ));
			   game.slideTo(new Position( 3, 1 ), new Position( 2, 2 ));
			   game.slideTo(new Position( 2, 2 ), new Position( 1, 1 ));
			   game.slideTo(new Position( 2, 3 ), new Position( 1, 3 ));
			   game.slideTo(new Position( 1, 3 ), new Position( 1, 2 ));
			   game.slideTo(new Position( 1, 1 ), new Position( 2, 1 ));
			   game.slideTo(new Position( 3, 2 ), new Position( 3, 3 ));
			   game.slideTo(new Position( 1, 2 ), new Position( 1, 1 ));
			   game.slideTo(new Position( 2, 1 ), new Position( 2, 2 ));
			   game.slideTo(new Position( 3, 3 ), new Position( 2, 3 ));
			   game.slideTo(new Position( 1, 1 ), new Position( 2, 1 )); 
			   game.slideTo(new Position( 2, 2 ), new Position( 1, 2 ));
			   game.slideTo(new Position( 1, 2 ), new Position( 1, 1 )); 
			   game.slideTo(new Position( 2, 1 ), new Position( 2, 2 ));
			   assertEquals(3, game.getXs().size());
			   assertTrue(game.getXs().contains(new Position( 1, 3 )));
			   assertTrue(game.getXs().contains(new Position( 1, 2 )));
			   assertTrue(game.getXs().contains(new Position( 3, 2 )));
			   assertEquals(3, game.getXs().size());
			   assertTrue(game.getOs().contains(new Position( 3, 3 )));
			   assertTrue(game.getOs().contains(new Position( 3, 1 )));
			   assertTrue(game.getOs().contains(new Position( 2, 1 )));
			   assertFalse(game.isWinnerO());
			   assertFalse(game.isWinnerX());
		    }

}
