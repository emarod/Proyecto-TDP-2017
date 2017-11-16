package interfaz.botones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import interfaz.Escenario;
import jugador.Jugador;
import jugador.Lobo;
import mapa.Celda;

/*
 * Clase BtnArquero.
 * Clase encargada del boton para el despliegue de un arquero.
 */

public class BtnLobo extends BtnJugador {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;

	// Constructor.
	public BtnLobo(Escenario e) {
		super(e);
		Celda c = null;
		player = new Lobo(c);
		player.guardarInicio();
		imagen = new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/lobo.png"));
		info = new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/lobodescripcion.png"));
		this.setIcon(imagen);
		costo = player.getCosto();
		oyente();

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

	public void crearPersonaje() {

		if (this.isEnabled()) {
			create();
		}

	}

	public void deshabilitar() {
		this.setEnabled(false);
	}

	public Jugador getPlayer() {
		// TODO Auto-generated method stub
		return player;
	}

	@Override
	public int getCosto() {
		// TODO Auto-generated method stub
		return costo;
	}

}
