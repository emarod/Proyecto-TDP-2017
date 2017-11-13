package interfaz.botones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		imagen = new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/ygritte2.png"));
		info = new ImageIcon(
				this.getClass().getResource("/resources/static/botones/personajes/ygrittedescripcion.png"));
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

	public void deshabilitar() {
		this.setEnabled(false);
	}

}