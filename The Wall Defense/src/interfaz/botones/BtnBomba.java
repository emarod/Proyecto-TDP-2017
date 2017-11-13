package interfaz.botones;

import javax.swing.ImageIcon;

import interfaz.Escenario;
import mapa.Celda;
import preciosos.Bomba;

/*
 * Clase BtnBomba.
 * Clase encargada del boton para el despliegue de una bomba.
 */

public class BtnBomba extends BtnObjetoPrecioso {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;

	// Constructor.
	public BtnBomba(Escenario e) {
		super(e);
		Celda[] c = new Celda[4];
		precioso = new Bomba(c);
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/objetos/bomba.png")));
	}

	// Metodos heredados.
	@Override
	public void create() {
		stage.getMapa().crearPrecioso(precioso);

	}

	public void crearPersonaje() {

		if (this.isEnabled()) {
			create();
		}

	}

	public void deshabilitar() {
		this.setEnabled(false);
	}
}
