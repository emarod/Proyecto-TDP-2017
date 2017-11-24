package objetos;

import mapa.Celda;

public interface Obstaculo extends ObjetoCelda {

	public abstract Obstaculo clone(Celda c);
}
