package tokens;

import Controladores.Director;
import main.CONFIG;
import main.GameObject;
import main.Visitor;
import mapa.Celda;

public abstract class Token extends GameObject implements Runnable {

	protected int duracion;

	public Token(Celda c) {
		super();
		profundidad = CONFIG.PROFUNDIDAD_TOKEN;
		celda[0] = c;
	}

	public void activar() {
		Director.ejecutarUna(this, duracion);
	}

	@Override
	public void run() {
		super.destruir();
	}

	@Override
	public boolean accept(Visitor V) {
		return true;
	}

}
