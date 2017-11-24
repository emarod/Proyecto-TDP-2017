package objetos;

import main.Unidad;

public interface Temporal {

	public abstract int getTiempo();

	public abstract void setTiempo(int t);

	public abstract void aplicarEfecto(Unidad u);

	public abstract void terminar();

}
