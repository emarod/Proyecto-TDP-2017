package jugador;

import disparo.Disparo;
import enemigo.Enemigo;
import main.Visitor;
<<<<<<< HEAD
import obstaculos.Obstaculo;
import obstaculos.ObstaculoTemporal;
import obstaculos.ObstaculoVida;
import preciosos.ObjetoPrecioso;
=======
import obstaculo.*;
import terreno.Rock;
>>>>>>> master

/*
 * Clase VisitorJugador.
 * Clase encargada de implementar correctamente las colisiones de los jugadores.
 * Especifica sus comportamientos mediante un patron de diseño visitor.
 */

<<<<<<< HEAD
public class VisitorJugador extends Visitor {

	// Atributos locales.
	protected Jugador jugador;

	// Constructor.
	public VisitorJugador(Jugador j) {
		jugador = j;
	}

	// Metodos locales.
	public boolean visitObstaculo(Obstaculo o) {
		return false;
	}

	/*
	 * public boolean VisitRock(Rock r){ return false; }
	 *
	 * public boolean VisitBarricada(Barricada b){ return false; }
	 */

	@Override
	public boolean visitPlayer(Jugador j) {
		return false;
	}

	@Override
	public boolean visitDisparoPlayer(Disparo d) {
		return false;
	}

	@Override
	public boolean visitEnemigo(Enemigo e) {
		System.out.println("el enemigo visita a jugador");
		e.recibirDaño(jugador.getDaño());
		return false;
	}

	@Override
	public boolean visitObstaculo(ObstaculoVida o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitObstaculo(ObstaculoTemporal o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitObjetoPrecioso(ObjetoPrecioso op) {
		// TODO Auto-generated method stub
		return false;
	}
=======
public class VisitorJugador extends Visitor{
	   
		//Atributos locales.
   	   protected Jugador jugador;
   	   
   	   //Constructor.
	   public VisitorJugador(Jugador j){
		   jugador = j;
	   }
	    
	   //Metodos locales.
	   public boolean visitObstaculo(Obstaculo o) {
			return false;
		}
	    
	   public  boolean VisitRock(Rock r){
		   return false;
	   }
	   
	   /*
	   public  boolean VisitBarricada(Barricada b){
		   return false;
	   }
	   */
	   
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
		   System.out.println("el enemigo visita a jugador");
		   e.restarResistencia(jugador.getDaño());
		   return false;
	   }
>>>>>>> master
}
