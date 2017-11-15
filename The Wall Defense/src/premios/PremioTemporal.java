package premios;

import mapa.Celda;

public abstract class PremioTemporal extends Premio implements Runnable {

	protected int tiempo;

	public PremioTemporal(Celda c) {
		super(c);
	}

	public PremioTemporal() {
		super();
	}

}
