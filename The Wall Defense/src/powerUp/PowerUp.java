package powerUp;

import Controladores.Director;
import jugador.Jugador;
import main.GameObject;
import main.Visitor;
import mapa.Celda;

/*
 * Clase abstracta PowerUp.
 * Clase que generaliza el comportamiento de un poder.
 */

public abstract class PowerUp extends GameObject implements Runnable {

	// Atributos locales.
	protected Jugador player;

	// Constructor.
	protected PowerUp(Celda c, int prof) {
		celda[0] = c;
		profundidad = prof;
		Director.ejecutarUna(this, 10);
	}

	// Metodos locales.
	public void setJugador(Jugador j) {
		player = j;
	}

	// Metodos heredados.
	@Override
	public boolean accept(Visitor V) {
		return true;
	}

	@Override
	public void run() {
		player.getCeldas()[0].getObjects()[4] = null;
		this.destruir();
	}

	// Metodos abstractos.
	public abstract void aplicar(Jugador j);

}
