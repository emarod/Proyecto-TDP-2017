package efectos;

import main.CONFIG;
import mapa.Celda;

public abstract class BuffTemporal extends Buff implements Runnable {

	protected int tiempo;

	public BuffTemporal(Celda c) {
		super(c);

	}

	@Override
	public void run() {
		unidad.getCelda().getObjects()[CONFIG.PROFUNDIDAD_EFECTO] = null;
		unidad.regresarInicio();
		this.destruir();
	}

}
