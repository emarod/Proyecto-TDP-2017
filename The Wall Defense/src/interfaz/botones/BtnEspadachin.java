package interfaz.botones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import interfaz.Escenario;
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
	public BtnEspadachin(Escenario e) {
		super(e);
		Celda[] c = new Celda[4];
		player = new Espadachin(c);
		player.guardarInicio();
		imagen = new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/jonsnow.png"));
		info = new ImageIcon(
				this.getClass().getResource("/resources/static/botones/personajes/espadachindescripcion.png"));
		this.setIcon(imagen);
		oyente();
	};

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

	public void crearPersonaje() {

		if (this.isEnabled()) {
			create();
		}

	}

	public void deshabilitar() {
		this.setEnabled(false);
	}

}