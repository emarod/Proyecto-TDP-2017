package efectos;

import Controladores.Director;
import main.CONFIG;
import mapa.Celda;

public abstract class PowerUpTemporal extends PowerUp implements Runnable {

	protected int tiempo;

	public PowerUpTemporal(Celda c) {
		super(c);
		Director.ejecutarUna(this, tiempo);
	}

	@Override
	public void run() {
		unidad.getCelda().getObjects()[CONFIG.PROFUNDIDAD_EFECTO] = null;
		unidad.regresarInicio();
		unidad = null;
		this.destruir();
	}

}
