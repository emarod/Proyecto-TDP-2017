package interfaz.botones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import interfaz.Escenario;
import jugador.Dragon;
import mapa.Celda;

/*
 * Clase BtnDrgon.
 * Clase encargada del boton para el despliegue de un dragon.
 */

public class BtnDragon extends BtnJugador {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;

	// Constructor.
	public BtnDragon(Escenario e) {
		super(e);
		Celda[] c = new Celda[4];
		player = new Dragon(c);
		imagen = new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/dragon.png"));
		info = new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/dragondescripcion.png"));
		this.setIcon(imagen);
	}

	// Metodos heredados.
	@Override
	public void create() {
		stage.getMapa().crearJugadorLargo(player);

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