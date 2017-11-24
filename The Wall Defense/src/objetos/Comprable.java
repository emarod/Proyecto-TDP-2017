package objetos;

import mapa.Celda;

public interface Comprable extends Acumulable {

	public abstract int getCosto();

	public abstract void setCosto(int c);

	public abstract Comprable clone(Celda c);

}
