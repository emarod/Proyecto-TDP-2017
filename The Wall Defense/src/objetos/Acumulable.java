package objetos;

import mapa.Celda;

public interface Acumulable extends ObjetoCelda {

	public abstract void guardar();

	public abstract Acumulable clone(Celda c);

}
