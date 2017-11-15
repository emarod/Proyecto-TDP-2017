package efectos;

import main.Unidad;
import mapa.Celda;

/*
 * Clase abstracta PowerUp.
 * Clase que generaliza el comportamiento de un poder.
 */

public abstract class PowerUp extends Efecto {

	// Atributos locales.

	// Constructor.
	protected PowerUp(Celda c) {
		super(c);
	}

	// Metodos locales.

	// Metodos heredados.

	// Metodos abstractos.
	public abstract void aplicar(Unidad unidad);
}
