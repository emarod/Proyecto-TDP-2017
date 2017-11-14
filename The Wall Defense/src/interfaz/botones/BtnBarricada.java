package interfaz.botones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import interfaz.Escenario;
import mapa.Celda;
import preciosos.Barricada;
import preciosos.ObjetoPrecioso;

/*
 * Clase BtnBarricada.
 * Clase encargada del boton para el despliegue de una barricadao.
 */

public class BtnBarricada extends BtnObjetoPrecioso {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;

	// Constructor.
	public BtnBarricada(Escenario e) {
		super(e);
		Celda c = null;
		precioso = new Barricada(c);
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/objetos/barricada.png")));
		info = new ImageIcon(this.getClass().getResource("/resources/static/botones/objetos/barricadadescripcion.png"));
		oyente();
		costo = precioso.getCosto();

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
		stage.getMapa().crearPrecioso(precioso);

	}

	public void crearObjeto() {

		if (this.isEnabled()) {
			create();
		}

	}

	public ObjetoPrecioso getObjeto() {
		return precioso;
	}

	public void deshabilitar() {
		this.setEnabled(false);
	}
}
