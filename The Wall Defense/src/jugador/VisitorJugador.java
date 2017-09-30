package jugador;
import disparo.DisparoPlayer;
import enemigo.Enemigo;
import main.Visitor;
import obstaculo.Rock;
import obstaculo.Water;
import main.GameObject;
public class VisitorJugador extends Visitor{
	
	   public VisitorJugador(GameObject o){
		   objeto=o;
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
	   public boolean visitDisparoPlayer(DisparoPlayer d){
		   return true;
	   }
	   public boolean visitEnemigo(Enemigo e){
		   return false;
	   }
}
