package interfaz.botones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Controladores.Director;
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
	public BtnDragon() {
		super();
		Celda c = null;
		player = new Dragon(c);
		player.guardarInicio();
		imagen = new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/dragon.png"));
		info = new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/dragondescripcion.png"));
		this.setIcon(imagen);
		costo = player.getCosto();

		oyente();
	}

	// Metodos heredados.
	@Override
	public void create() {
		Director.getMapa().crearJugadorLargo(player);

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

	@Override
	public int getCosto() {
		// TODO Auto-generated method stub
		return costo;
	}

}