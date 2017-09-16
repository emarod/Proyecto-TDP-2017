package disparo;

import main.GameObject;
import obstaculo.Rock;
import obstaculo.Water;
import enemigo.Enemigo;
import jugador.Jugador;
import main.Visitor;
public class VisitorDisparoPlayer extends Visitor {
	  public VisitorDisparoPlayer(GameObject o){
	    	objeto=o;
	    }
	    
	   public  boolean VisitRock(Rock r){
		objeto.destruir();
		r.restarResistencia();
		return false;
	   }
	   public  boolean VisitWater(Water w){
		   return true;
	   }
	   public  boolean visitPlayer(Jugador j){
		   return true;
	   }
	   public boolean visitDisparoPlayer(DisparoPlayer d){ 
		   objeto.destruir();
		   d.destruir();
		   return false;
	   }
	   public boolean visitEnemigo(Enemigo e){
		   e.restarResistencia();
		   objeto.destruir();
		   return false;
	   }
	   public boolean visitDisparoEnemigo(DisparoEnemigo d){ 
		   objeto.destruir();
		   d.destruir();
		   return false;
	   }
}

