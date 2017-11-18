package efectos;

import main.Unidad;
import mapa.Celda;

/*
 * Clase VelAtkAumentado.
 * Clase que especifica el comportamiento del poder que aumenta la velocidad de ataque.
 */

public class VelAtkAumentado extends PowerUpTemporal {

	// Constructor.
	public VelAtkAumentado(Celda c) {
		super(c);
		tiempo = 10;
	}

	// Metodos heredados.

	@Override
	public void aplicar(Unidad u) {
		unidad = u;
		unidad.setVelocidad(unidad.getVelocidad() * 2);
		ejecutar();
	}

	@Override
	public void run() {
		super.run();
	}
}
