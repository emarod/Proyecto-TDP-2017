package jugador;

import Controladores.Director;
import disparo.Disparo;
import mapa.Celda;

public abstract class Shooter extends Jugador {

	// Atributos locales.
	protected int velocidad_disparo;
	protected Disparo disparo;

	public Shooter(Celda c) {
		super(c);
	}

	public int getVelocidadDisparo() {
		return velocidad_disparo;
	}

	public void animarDisparo() {
		if (graph == 4) {
			// setGrafico(0);
			graph++;
			atacar();

		}
		if (graph < 4) {
			graph++;
			activeTask = null;
			Director.ejecutarUna(this, 5);
		}
		setGrafico(graph);

	}

	public void setGrafico(int i) {
		getGrafico().setIcon(graficos[i]);
	}

	public Disparo getDisparo() {
		return disparo;
	}

	public void removeDisparo() {
		disparo = null;
	}

}
