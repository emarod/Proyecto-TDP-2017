package interfaz.botones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Controladores.Director;
import jugador.Gigante;
import jugador.Jugador;
import mapa.Celda;

/*
 * Clase BtnArquero.
 * Clase encargada del boton para el despliegue de un arquero.
 */

public class BtnGigante extends BtnJugador {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;

	// Constructor.
	public BtnGigante() {
		super();
		Celda c = null;
		player = new Gigante(c);
		imagen = new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/gigante.png"));
		info = new ImageIcon(
				this.getClass().getResource("/resources/static/botones/personajes/gigantedescripcion.png"));
		this.setIcon(imagen);
		costo = player.getCosto();

		oyente();

	}

	// Metodos heredados.
	@Override
	public boolean create() {
		return Director.getMapa().crearJugadorGrande(player);

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

	public Jugador getPlayer() {
		return player;
	}

}
