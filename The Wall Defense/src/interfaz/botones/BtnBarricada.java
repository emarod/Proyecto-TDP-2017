package interfaz.botones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import comprables.Barricada;
import interfaz.Escenario;
import mapa.Celda;

/*
 * Clase BtnBarricada.
 * Clase encargada del boton para el despliegue de una barricadao.
 */

public class BtnBarricada extends BtnComprables {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;

	// Constructor.
	public BtnBarricada(Escenario e) {
		super(e);
		Celda c = null;
		comprable = new Barricada(c);
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/objetos/barricada.png")));
		info = new ImageIcon(this.getClass().getResource("/resources/static/botones/objetos/barricadadescripcion.png"));
		oyente();
		costo = comprable.getCosto();

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
				setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/objetos/barricada.png")));

			}

		});
	}

	// Metodos heredados.
	@Override
	public void create() {
		stage.getMapa().crearComprable(comprable);

	}

	public void crearObjeto() {

		if (this.isEnabled()) {
			create();
		}

	}

	public void deshabilitar() {
		this.setEnabled(false);
	}
}
