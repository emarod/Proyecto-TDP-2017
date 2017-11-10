package disparo;

import enemigo.Enemigo;
import jugador.Jugador;
import main.Visitor;
import obstaculos.Obstaculo;
import obstaculos.ObstaculoTemporal;
import obstaculos.ObstaculoVida;
import preciosos.ObjetoPrecioso;

/*
 * Clase VisitorDisparoPlayer.
 * Clase encargada de implementar correctamente las colisiones de los proyectiles de los jugadores.
 * Especifica sus comportamientos mediante un patron de diseño visitor.
 */

public class VisitorDisparoPlayer extends Visitor {

	// Atributos locales.
	protected Disparo disparo;

	// Constructor
	public VisitorDisparoPlayer(Disparo dp) {
		disparo = dp;
	}

	// Metodos heredados.
	public boolean visitObstaculo(Obstaculo o) {
		return true;
	}

	/*
	 * public boolean VisitRock(Rock r) { return true; }
	 *
	 * public boolean VisitBarricada(Barricada b) { return true; }
	 */

	@Override
	public boolean visitPlayer(Jugador j) {
		return true;
	}

	@Override
	public boolean visitDisparoPlayer(Disparo d) {
		return true;
	}

	@Override
	public boolean visitEnemigo(Enemigo e) {
		e.recibirDaño(disparo.getDaño());
		disparo.destruir();
		return true;
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

}
