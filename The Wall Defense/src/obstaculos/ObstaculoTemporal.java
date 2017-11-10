package objetos;

import enemigo.Enemigo;
import mapa.Celda;

public abstract class ObstaculoTemporal extends Obstaculo {

	public ObstaculoTemporal(Celda[] c, int prof) {
		super(c, prof);
		// TODO Auto-generated constructor stub
	}

	public abstract void aplicarEfecto(Enemigo e);
}
