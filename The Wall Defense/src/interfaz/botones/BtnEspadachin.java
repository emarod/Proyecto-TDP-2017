package interfaz.botones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Controladores.Director;
import jugador.Espadachin;
import mapa.Celda;

/*
 * Clase BtnEspadachin.
 * Clase encargada del boton para el despliegue de un espadachin.
 */

public class BtnEspadachin extends BtnJugador {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;

	// Constructor
	public BtnEspadachin() {
		super();
		Celda c = null;
		player = new Espadachin(c);
		imagen = new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/jonsnow.png"));
		info = new ImageIcon(
				this.getClass().getResource("/resources/static/botones/personajes/espadachindescripcion.png"));
		this.setIcon(imagen);
		costo = player.getCosto();

		oyente();
	};

	// Metodos heredados.
	@Override
	public boolean create() {
		return Director.getMapa().crearJugador(player);
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

	public boolean crearPersonaje() {

		if (this.isEnabled()) {
			creo = create();
		}
		return creo;
	}

	public void deshabilitar() {
		this.setEnabled(false);
	}
}