package enemigo;

import java.util.concurrent.ScheduledFuture;

import javax.swing.JLabel;

import Controladores.Director;
import Controladores.RandomGenerator;
import interfaz.Escenario;
import main.CONFIG;
import mapa.Celda;
import mapa.Mapa;

/*
 * Clase Horda.
 * Clase encargada de crear las hordas de forma random.
 */

public class Horda implements Runnable {

	// Atributos locales.
	protected Celda celda;
	protected Mapa mapa;
	protected Escenario stage;
	protected JLabel graf;
	protected int enemigos = 10;
	protected final int x = 15;
	protected ScheduledFuture<?> activeTask;

	// Constructor.
	public Horda(Escenario s) {
		stage = s;
		mapa = Director.getMapa();
		activeTask = Director.ejecutar(this, 20);
	}

	// Metodos locales.
	public boolean terminoHorda() {
		return enemigos == 0;
	}

	public void actualizarEnemigos() {
		if (enemigos > 0) {
			enemigos--;
			System.out.println("Numero de enemigos en la horda: " + enemigos);
		}
	}

	@Override
	public void run() {
		RandomGenerator rnd = new RandomGenerator();
		int r = rnd.nextInt(2);
		int y;
		Enemigo e;
		y = rnd.nextInt(6);
		while (mapa.getCelda(x, y).getObjects()[CONFIG.PROFUNDIDAD_ENEMIGO] != null) {
			y = rnd.nextInt(6);
		}
		Celda c = mapa.getCelda(x, y);
		Celda[] celdas = new Celda[4];
		celdas[0] = c;
		switch (r) {
			case 0: {
				e = new WhiteWalker(celdas);
				mapa.crearEnemigo(e, x, y);
				break;
			}
			case 1: {
				System.out.println("case 1");
				e = new NightKing(celdas);
				mapa.crearEnemigo(e, x, y);
				break;
			}

		}
		enemigos--;
		if (enemigos == 0) {
			activeTask.cancel(true);
			System.out.println("fin horda");
		}
		else {
			System.out.println("quedan " + enemigos + " enemigos");
		}

	}

}