package powerUp;

import jugador.Jugador;
import mapa.Celda;

/*
 * Clase VelAtkAumentado.
 * Clase que especifica el comportamiento del poder que aumenta la velocidad de ataque.
 */

public class VelAtkAumentado extends PowerUp {

	// Constructor.
	public VelAtkAumentado(Celda c) {
		super(c);
	}

	// Metodos heredados.

	@Override
	public void aplicar(Jugador j) {
		jugador = j;
		jugador.setVelocidad(jugador.getVelocidad() * 2);
	}

	@Override
	public void run() {
		super.run();
	}
}
