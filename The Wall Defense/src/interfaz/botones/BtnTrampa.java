package interfaz.botones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import comprables.Trampa;
import interfaz.Escenario;
import mapa.Celda;

public class BtnTrampa extends BtnComprables {
	// Atributos locales.
	protected static final long serialVersionUID = 1L;

	// Constructor.
	public BtnTrampa(Escenario e) {
		super(e);
		Celda c = null;
		comprable = new Trampa(c);
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/trampa/trampa3.png")));
		// info = new
		// ImageIcon(this.getClass().getResource("/resources/static/botones/objetos/barricadadescripcion.png"));
		costo = comprable.getCosto();

	}

	@Override
	public void oyente() {

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent evento) {

			}

			@Override
			public void mouseExited(MouseEvent evento) {

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
