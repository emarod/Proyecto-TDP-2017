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

	public void ejecutar() {
		activeTask = Director.ejecutar(this, 20);
	}

	@Override
	public void run() {
		System.out.println("Inicio horda");
		RandomGenerator rnd = Director.getRandom();
		int r = rnd.poll(4);
		int y;
		Enemigo e;
		y = rnd.poll(6);
		while (mapa.getCelda(x, y).getObjects()[CONFIG.PROFUNDIDAD_ENEMIGO] != null) {
			y = rnd.poll(6);
		}
		Celda c = mapa.getCelda(x, y);
		switch (r) {
			case 0: {
				e = new WhiteWalker(c);
				mapa.crearEnemigo(e, x, y);
				break;
			}
			case 1: {
				e = new NightKing(c);
				mapa.crearEnemigo(e, x, y);
				break;
			}
			case 2: {
				e = new Araña(c);
				mapa.crearEnemigo(e, x, y);
				break;
			}
			case 3: {
				e = new KnightWalker(c);
				mapa.crearEnemigo(e, x, y);
				break;
			}
			case 4: {
				e = new EsqueletoSuicida(c);
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