package objetos;

import mapa.Celda;

public interface Premio extends Acumulable {

	@Override
	public abstract Premio clone(Celda c);

}
