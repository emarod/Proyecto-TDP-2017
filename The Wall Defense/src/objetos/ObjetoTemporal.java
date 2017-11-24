package objetos;

import main.GameObject;
import mapa.Celda;

public abstract class ObjetoTemporal extends GameObject implements Temporal {

	protected int tiempo;

	public ObjetoTemporal(Celda c) {
		super(c);
	}

	@Override
	public int getTiempo() {
		return tiempo;
	}

	@Override
	public void setTiempo(int t) {
		tiempo = t;
	}

}
