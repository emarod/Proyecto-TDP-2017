package interfaz.botones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import interfaz.Escenario;
import mapa.Celda;
import preciosos.Bomba;
import preciosos.ObjetoPrecioso;

/*
 * Clase BtnBomba.
 * Clase encargada del boton para el despliegue de una bomba.
 */

public class BtnBomba extends BtnObjetoPrecioso {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;

	// Constructor.
	public BtnBomba(Escenario e) {
		super(e);
		Celda[] c = new Celda[4];
		precioso = new Bomba(c);
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/objetos/bomba.png")));
		info = new ImageIcon(this.getClass().getResource("/resources/static/botones/objetos/bombadescripcion.png"));
		oyente();
		costo = precioso.getCosto();

	}

	// Metodos heredados.
	@Override
	public void create() {
		stage.getMapa().crearPrecioso(precioso);

	}

	public void crearObjeto() {

		if (this.isEnabled()) {
			create();
		}

	}

	public void deshabilitar() {
		this.setEnabled(false);
	}

	public ObjetoPrecioso getObjeto() {
		return precioso;
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
				setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/objetos/bomba.png")));

			}

		});

	}
}
