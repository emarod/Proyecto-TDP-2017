package enemigo;

import obstaculo.Rock;
import obstaculo.Water;
import disparo.Disparo;
import jugador.Jugador;
import main.Visitor;

public class VisitorEnemigo extends Visitor{
	
	protected Enemigo enemigo;
	
	public VisitorEnemigo(Enemigo e){
    	enemigo = e;
    }
    
   public  boolean VisitRock(Rock r){
	   r.restarResistencia();
	   return false;
   }
   public  boolean VisitWater(Water w){
	   enemigo.relentizar(w.getPenalizacion());
	   return true;
   }
   public  boolean visitPlayer(Jugador j){
	   j.restarResistencia();
	   return false;
   }
   public boolean visitDisparoPlayer(Disparo d){
	   d.destruir();
	   enemigo.restarResistencia();
	   return false;
   }   
   
   public boolean visitEnemigo(Enemigo e){
	   return false;
   }
}