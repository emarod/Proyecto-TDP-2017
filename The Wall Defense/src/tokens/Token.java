package tokens;

import javax.swing.JLabel;

import Controladores.Director;
import main.GameObject;
import main.Visitor;
import mapa.Celda;

public abstract class Token extends GameObject implements Runnable {

	protected int duracion;

	public Token(Celda c, int prof) {
		grafico = new JLabel();
		profundidad = prof;
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
