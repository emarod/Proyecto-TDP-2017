package enemigo;

import disparo.Disparo;
import mapa.Celda;

public abstract class ShooterEnemigo extends Enemigo {

	// Atributos locales.
	protected int velocidad_disparo;
	protected Disparo disparo;

	protected int pos;

	public ShooterEnemigo(Celda c) {
		super(c);
		pos = 0;
	}

	public int getVelocidadDisparo() {
		return velocidad_disparo;
	}

	public void animarDisparo() {
		if (graph < 4) {
			graph++;
		}
		setGrafico(graph);
		if (graph == 4) {
			setGrafico(0);
		}
	}

	@Override
	public void run() {
		if (pos == 0) {
			atacar();
			pos = 1;
		}
		else {
			mover();
			pos = 0;
		}

	}

	public abstract void atacar();

	public void setGrafico(int i) {
		getGrafico().setIcon(graficos[i]);
	}

	public Disparo getDisparo() {
		return disparo;
	}

	@Override
	public void destruir() {
		super.destruir();
		if (disparo.getTask() != null) {
			disparo.getTask().cancel(true);
		}
		disparo = null;
	}

	public void removeDisparo() {
		disparo = null;
	}
}