package interfaz.botones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Controladores.Director;
import comprables.Barril;
import mapa.Celda;
import objetos.Comprable;

public class BtnBarril extends BtnComprables {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;

	// Constructor.
	public BtnBarril() {
		super();
		Celda c = null;
		comprable = new Barril(c);
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/barril/000.png")));
		info = new ImageIcon(this.getClass().getResource("/resources/static/barril/000.png"));
		costo = comprable.getCosto();

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

	public Comprable getObjeto() {
		return comprable;
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
				setIcon(new ImageIcon(this.getClass().getResource("/resources/static/barril/000.png")));

			}

		});
	}

}
