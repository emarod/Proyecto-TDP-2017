package efectos;

import Controladores.Director;
import main.CONFIG;
import main.Unidad;
import mapa.Celda;

public abstract class PowerUpTemporal extends PowerUp implements Runnable {

	protected int tiempo;

	public PowerUpTemporal(Celda c) {
		super(c);
	}

	@Override
	public void run() {
		unidad.getCelda().getObjects()[CONFIG.PROFUNDIDAD_EFECTO] = null;
		unidad.regresarUltimo();
		unidad.dejarObservar(this);
		unidad = null;
		this.destruir();

	}

	@Override
	public void aplicar(Unidad u) {
		u.guardarEstado(this.hashCode());
	}

	public void ejecutar() {
		Director.ejecutarUna(this, tiempo);
	}

}
