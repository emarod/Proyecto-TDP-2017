package enemigo;

import obstaculo.Rock;
import obstaculo.Water;
import disparo.DisparoPlayer;
import jugador.Jugador;
import main.Visitor;

public class VisitorEnemigo extends Visitor{
	
	Enemigo enemigo;
	
	public VisitorEnemigo(Enemigo e){
    	enemigo = e;
    }
    
   public  boolean VisitRock(Rock r){
	   System.out.println("visito una roca.");
	   enemigo.setVelocidad(0);
	   return true;
   }
   public  boolean VisitWater(Water w){
	   System.out.println("visito zona de agua.");
	   return true;
   }
   public  boolean visitPlayer(Jugador j){
	   return false;
   }
   public boolean visitDisparoPlayer(DisparoPlayer d){
	   d.destruir();
	   enemigo.restarResistencia();
	   return true;
   }   
   
   public boolean visitEnemigo(Enemigo e){
	   return false;
   }
}
