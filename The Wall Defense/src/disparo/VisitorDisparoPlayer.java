package disparo;

import enemigo.Enemigo;
import jugador.Jugador;
import main.Visitor;
import obstaculo.Rock;
import obstaculo.Water;

/*
 * Clase VisitorDisparoPlayer.
 * Clase encargada de implementar correctamente las colisiones de los proyectiles de los jugadores.
 * Especifica sus comportamientos mediante un patron de diseño visitor.
 */

public class VisitorDisparoPlayer extends Visitor {
	
	//Atributos locales.
	protected Disparo disparo;
	
	//Constructor
	public VisitorDisparoPlayer(Disparo dp){
		disparo = dp;
	}
	
	//Metodos heredados.
	public boolean VisitRock(Rock r) {
		return true;
	}

	public boolean VisitWater(Water w) {
		return true;
	}

	public boolean visitPlayer(Jugador j) {
		return true;
	}

	public boolean visitDisparoPlayer(Disparo d) {		
		return true;
	}

	public boolean visitEnemigo(Enemigo e){
		e.restarResistencia();
		disparo.destruir();
		return true;
	}

}

