package efectos;

import main.CONFIG;
import main.GameObject;
import main.Unidad;
import main.Visitor;
import mapa.Celda;

public abstract class Efecto extends GameObject {

	protected Unidad unidad;

	public Efecto(Celda c) {
		celda = c;
		profundidad = CONFIG.PROFUNDIDAD_EFECTO;
	}

	@Override
	public boolean accept(Visitor V) {
		return true;
	}

}
