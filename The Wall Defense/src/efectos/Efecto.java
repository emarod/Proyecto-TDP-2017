package efectos;

import main.CONFIG;
import main.GameObject;
import main.Unidad;
import main.Visitor;
import mapa.Celda;

public abstract class Efecto extends GameObject {

	protected Unidad unidad;
	protected VisitorEfecto visitor;

	public Efecto(Celda c) {
		super();
		celda = c;
		profundidad = CONFIG.PROFUNDIDAD_EFECTO;
		visitor = new VisitorEfecto(this);
	}

	@Override
	public boolean accept(Visitor V) {
		return V.visitEfect(this);
	}

	public Visitor getVisitor() {
		return visitor;
	}

	public abstract void aplicar(Unidad unidad);
}
