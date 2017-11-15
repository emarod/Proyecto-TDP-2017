package efectos;

import mapa.Celda;

public abstract class BuffTemporal extends Buff implements Runnable {

	protected int tiempo;

	public BuffTemporal(Celda c) {
		super(c);

	}

}
