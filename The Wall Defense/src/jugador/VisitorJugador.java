package jugador;

import disparo.Disparo;
import enemigo.Enemigo;
import main.Visitor;
import obstaculo.Rock;
import obstaculo.Water;
public class VisitorJugador extends Visitor{
		
   	   protected Jugador jugador;
	
	   public VisitorJugador(Jugador j){
		   jugador = j;
	   }
	    
	   public  boolean VisitRock(Rock r){
		return false;
	   }
	   public  boolean VisitWater(Water w){
		   return false;
	   }
	   public  boolean visitPlayer(Jugador j){
		   
		   return false;
	   }
	   public boolean visitDisparoPlayer(Disparo d){
		   return false;
	   }
	   public boolean visitEnemigo(Enemigo e){
		   e.restarResistencia();
		   return true;
	   }
}
