package interfaz.botones;

import Controladores.Director;
import objetos.Premio;
import premios.Bomba;

/*
 * Clase BtnBomba.
 * Clase encargada del boton para el despliegue de una bomba.
 */

public class BtnBomba extends BtnPremio {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;

	// Constructor.
	public BtnBomba() {
		super();
		precioso = new Bomba(null);
		oyente();

	}

	// Metodos heredados.
	@Override
	public void create() {
		Director.getMapa().crearPremio(precioso);

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
		// TODO Auto-generated method stub

	}

}
