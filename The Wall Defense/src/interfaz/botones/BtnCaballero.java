package interfaz.botones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import interfaz.Escenario;
import jugador.Caballero;
import mapa.Celda;

/*
 * Clase BtnCaballero.
 * Clase encargada del boton para el despliegue de un caballero.
 */

public class BtnCaballero extends BtnJugador {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;

	// Constructor.
	public BtnCaballero(Escenario e) {
		super(e);
		Celda[] c = new Celda[4];
		player = new Caballero(c);
		imagen = new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/lannister.png"));
		info = new ImageIcon(
				this.getClass().getResource("/resources/static/botones/personajes/caballerodescripcion.png"));
		this.setIcon(imagen);

	}

	// Metodos heredados.
	@Override
	public void create() {
		stage.getMapa().crearJugador(player);

	}

	@Override
	public void oyente() {

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent evento) {
				setIcon(info);

			}

			@Override
			public void mouseExited(MouseEvent evento) {
				setIcon(imagen);

			}

		});
	}

}