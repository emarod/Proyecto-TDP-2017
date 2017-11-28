package efectos;

import java.util.Observable;
import java.util.Observer;

import main.CONFIG;
import main.GameObject;
import main.Unidad;
import main.Visitor;
import mapa.Celda;

public abstract class Efecto extends GameObject implements Observer {

	protected Unidad unidad;
	protected VisitorEfecto visitor;

	public Efecto(Celda c) {
		super(c);
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

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1.equals("DEAD")) {
			destruir();
		}
		if (arg1.equals("MOVE")) {
			if (unidad != null) {
				int x = unidad.getCelda().getPosX();
				int y = unidad.getCelda().getPosY();
				grafico.setBounds(x * 64, y * 64, 64, 64);
				intercambiar_celdas(unidad.getCelda());
			}
		}

	}

	public abstract void aplicar(Unidad unidad);
}
