package objetos;

import main.Tienda;
import mapa.Celda;

public interface Comprable extends Acumulable {

	public abstract int getCosto();

	public abstract void setCosto(int c);

	@Override
	public abstract Comprable clone(Celda c);

	public abstract void accept(Tienda t);

}
