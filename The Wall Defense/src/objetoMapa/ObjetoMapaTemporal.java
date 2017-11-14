package objetoMapa;

import enemigo.Enemigo;
import mapa.Celda;

public abstract class ObjetoMapaTemporal extends ObjetoMapa {

	public ObjetoMapaTemporal(Celda c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	public abstract void aplicarEfecto(Enemigo e);
}
