package powerUp;

import Controladores.Director;
import jugador.Jugador;
import main.CONFIG;
import main.GameObject;
import main.Visitor;
import mapa.Celda;

/*
 * Clase abstracta PowerUp.
 * Clase que generaliza el comportamiento de un poder.
 */

public abstract class PowerUp extends GameObject implements Runnable {

	// Atributos locales.
	protected Jugador jugador;

	// Constructor.
	protected PowerUp(Celda c) {
		super();
		celda = c;
		profundidad = CONFIG.PROFUNDIDAD_POWERUP;
		Director.ejecutarUna(this, 10);
	}

	// Metodos locales.

	// Metodos heredados.
	@Override
	public boolean accept(Visitor V) {
		return true;
	}

	@Override
	public void run() {
		jugador.getCelda().getObjects()[CONFIG.PROFUNDIDAD_POWERUP] = null;
		jugador.regresarInicio();
		this.destruir();
	}

	// Metodos abstractos.
	public abstract void aplicar(Jugador j);
}
