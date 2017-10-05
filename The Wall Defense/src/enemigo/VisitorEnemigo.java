package enemigo;
import main.GameObject;
import obstaculo.Rock;
import obstaculo.Water;
import disparo.DisparoPlayer;
import jugador.Jugador;
import main.Visitor;

public class VisitorEnemigo extends Visitor{
	public VisitorEnemigo(GameObject o){
    	objeto=o;
    }
    
   public  boolean VisitRock(Rock r){
	return true;
   }
   public  boolean VisitWater(Water w){
	   return true;
   }
   public  boolean visitPlayer(Jugador j){
	   return false;
   }
   public boolean visitDisparoPlayer(DisparoPlayer d){
	   d.destruir();
	   Enemigo e=(Enemigo)objeto;
	   e.restarResistencia();
	   return false;
   }   
   
   public boolean visitEnemigo(Enemigo e){
	   return false;
   }
}
