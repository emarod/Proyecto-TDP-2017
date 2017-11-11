package powerUp;

import javax.swing.JLabel;

import jugador.Jugador;
import mapa.Celda;

/*
 * Clase VelAtkAumentado.
 * Clase que especifica el comportamiento del poder que aumenta la velocidad de ataque.
 */

public class VelAtkAumentado extends PowerUp {

	// Constructor.
	public VelAtkAumentado(Celda c, int prof) {
		super(c, prof);
		grafico = new JLabel();
	}

	// Metodos heredados.

	@Override
	public void aplicar(Jugador j) {
		// Duplicar la vel de ataque.
	}

	@Override
	public void run() {
		super.run();
	}
}
