package powerUp;

import javax.swing.JLabel;

import Controladores.Director;
import jugador.Jugador;
import main.GameObject;
import main.Visitor;
import mapa.Celda;

/*
 * Clase abstracta PowerUp.
 * Clase que generaliza el comportamiento de un poder.
 */

public abstract class PowerUp extends GameObject implements Runnable {

	// Atributos locales.
	protected JLabel graficoToken;
	protected Jugador player;

	// Constructor.
	protected PowerUp(Celda c, int prof) {
		celda[0] = c;
		profundidad = prof;
		Director.ejecutarUna(this, 10);
	}

	// Metodos locales.
	public void setJugador(Jugador j) {
		player = j;
	}

	// Metodos heredados.
	@Override
	public boolean accept(Visitor V) {
		return true;
	}

	@Override
	public void run() {
		if (graficoToken.getIcon() != null) {
			graficoToken.setIcon(null);
			celda[0].getEscenario().remove(graficoToken);
		}
		else {
			player.getCeldas()[0].getObjects()[4] = null;
		}
		this.destruir();
	}

	// Metodos abstractos.
	public abstract void aplicar(Jugador j);

	public abstract JLabel getGraficoToken();

}
