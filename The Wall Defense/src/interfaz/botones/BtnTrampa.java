package interfaz.botones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Controladores.Director;
import comprables.Trampa;
import mapa.Celda;

public class BtnTrampa extends BtnComprables {
	// Atributos locales.
	protected static final long serialVersionUID = 1L;

	// Constructor.
	public BtnTrampa() {
		super();
		Celda c = null;
		comprable = new Trampa(c);
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/objetos/trampa.png")));
		info = new ImageIcon(this.getClass().getResource("/resources/static/botones/objetos/trampadescripcion.png"));
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
				setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/objetos/trampa.png")));
			}

		});
	}

	// Metodos heredados.
	@Override
	public boolean create() {
		return Director.getMapa().crearComprable(comprable);

	}

	public boolean crearObjeto() {
		boolean desplego = false;
		if (this.isEnabled()) {
			desplego = create();
		}

		return desplego;
	}

	public void deshabilitar() {
		this.setEnabled(false);
	}

}
