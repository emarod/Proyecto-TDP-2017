package interfaz.botones;

import javax.swing.ImageIcon;

import interfaz.Escenario;
import mapa.Celda;
import preciosos.Barricada;

/*
 * Clase BtnBarricada.
 * Clase encargada del boton para el despliegue de una barricadao.
 */

public class BtnBarricada extends BtnObjetoPrecioso {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;

	// Constructor.
	public BtnBarricada(Escenario e) {
		super(e);
		Celda[] c = new Celda[4];
		precioso = new Barricada(c, 3);
		this.setIcon(
				new ImageIcon(this.getClass().getResource("/resources/static/terrenos/barricada/barricada_3.png")));
	};

	// Metodos heredados.
	@Override
	public void create() {
		stage.getMapa().crearPrecioso(precioso);

	}
}
