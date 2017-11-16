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
		celda = c;
		celda.getObjects()[profundidad] = this;
		grafico.setBounds(celda.getPosX() * 64, celda.getPosY() * 64, 64, 64);
		Director.getMapa().getEscenario().agregar(grafico, new Integer(profundidad));

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

	public abstract void aplicar();

}
