package disparo;

import javax.swing.JLabel;

import main.CONFIG;
import main.Unidad;

/*
 * Clase abstracta Disparo.
 * clase que generaliza la idea de un proyectil.
 */

public abstract class Disparo extends Unidad {

	// Constructor.
	public Disparo() {
		profundidad = CONFIG.PROFUNDIDAD_DISPARO;
		ancho = 64;
		alto = 64;
		grafico = new JLabel();
	}

	// Metodos locales.
	public int getAlto() {
		return alto;
	}

	public int getAncho() {
		return ancho;
	}

	@Override
	public void destruir() {
		super.destruir();
	}

	// Metodos abstractos.
	public abstract void restarDisparosEnEjecucion();

	public abstract int getDaño();
}