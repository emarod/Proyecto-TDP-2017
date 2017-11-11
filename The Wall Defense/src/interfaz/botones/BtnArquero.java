package interfaz.botones;

import javax.swing.ImageIcon;

import interfaz.Escenario;
import jugador.Arquero;
import mapa.Celda;

/*
 * Clase BtnArquero.
 * Clase encargada del boton para el despliegue de un arquero.
 */

public class BtnArquero extends BtnJugador {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;

	// Constructor.
	public BtnArquero(Escenario e) {
		super(e);
		Celda[] c = new Celda[4];
		player = new Arquero(c);
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/ygritte2.png")));
	}

	// Metodos heredados.
	@Override
	public void create() {
		stage.getMapa().crearJugador(player);

	}

}