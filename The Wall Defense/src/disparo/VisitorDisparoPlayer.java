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
	protected DisparoJugador disparo;

	// Constructor
	public VisitorDisparoPlayer(DisparoJugador dp) {
		disparo = dp;
	}

	// Metodos heredados.
	public boolean visitObstaculo(Obstaculo o) {
		return true;
	}

	@Override
	public boolean visitPlayer(Jugador j) {
		return true;
	}

	@Override
	public boolean visitEnemigo(Enemigo e) {
		e.recibirDaño(disparo.getDaño());
		disparo.destruir();
		return false;
	}

	@Override
	public boolean visitObstaculo(ObstaculoVida o) {
		return true;
	}

	@Override
	public boolean visitObstaculo(ObstaculoTemporal o) {
		return true;
	}

	@Override
	public boolean visitObjetoPrecioso(ObjetoPrecioso op) {
		return true;
	}

	@Override
	public boolean visitDisparo(DisparoJugador d) {
		return true;
	}

	@Override
	public boolean visitDisparo(DisparoEnemigo d) {
		// El disparo mas fuerte sobrevive
		disparo.colision(d);
		return true;
	}

}
