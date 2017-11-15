package interfaz.botones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import interfaz.Escenario;
import premios.Bomba;
import premios.Premio;

/*
 * Clase BtnBomba.
 * Clase encargada del boton para el despliegue de una bomba.
 */

public class BtnBomba extends BtnPremio {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;

	// Constructor.
	public BtnBomba(Escenario e) {
		super(e);
		precioso = new Bomba();
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/objetos/bomba.png")));
		info = new ImageIcon(this.getClass().getResource("/resources/static/botones/objetos/bombadescripcion.png"));
		oyente();

	}

	// Metodos heredados.
	@Override
	public void create() {
		stage.getMapa().crearPremio(precioso);

	}

	public void crearObjeto() {

		if (this.isEnabled()) {
			create();
		}

	}

	public void deshabilitar() {
		this.setEnabled(false);
	}

	public Premio getObjeto() {
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
