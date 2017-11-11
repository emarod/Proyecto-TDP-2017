package jugador;

import java.util.concurrent.Future;

import mapa.Celda;

public abstract class Shooter extends Jugador {

	// Atributos locales.
	protected Future<?> shot;
	protected int velocidad_disparo;

	public Shooter(Celda[] c) {
		super(c);
	}

}
