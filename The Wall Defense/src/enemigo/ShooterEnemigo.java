package enemigo;

import java.util.concurrent.ScheduledFuture;

import mapa.Celda;

public abstract class ShooterEnemigo extends Enemigo {

	// Atributos locales.
	protected ScheduledFuture<?> shot;
	protected int velocidad_disparo;

	public ShooterEnemigo(Celda c) {
		super(c);
	}

	public int getVelocidadDisparo() {
		return velocidad_disparo;
	}

	public ScheduledFuture<?> getTaskShot() {
		return shot;
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

	public void setGrafico(int i) {
		getGrafico().setIcon(graficos[i]);
	}
}