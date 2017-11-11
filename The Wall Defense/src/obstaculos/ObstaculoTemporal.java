package obstaculos;

import enemigo.Enemigo;
import mapa.Celda;

public abstract class ObstaculoTemporal extends Obstaculo {

	public ObstaculoTemporal(Celda[] c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	public abstract void aplicarEfecto(Enemigo e);
}
