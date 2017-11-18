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
	protected int enemigos;
	protected int restantes;
	protected final int x = 15;
	protected ScheduledFuture<?> activeTask;
	protected boolean llego = false;
	public int matados;

	// Constructor.
	public Horda() {
		mapa = Director.getMapa();
		stage = mapa.getEscenario();
		enemigos = Director.getPartida().getNivel() * 7;
		restantes = enemigos;
		matados = 0;

	}

	// Metodos locales.
	public boolean terminoHorda() {
		Director.getPartida().aumentarNivel();
		stage.nextLevel();
		return enemigos == matados;
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
				break;
			}
			case 1: {
				e = new NightKing(c);
				break;
			}
			case 2: {
				e = new Araña(c);
				break;
			}
			case 3: {
				e = new KnightWalker(c);
				break;
			}
			case 4: {
				e = new EsqueletoSuicida(c);
				break;
			}
			default: {
				e = new WhiteWalker(c);
			}

		}
		e.crear();
		e.activar();
		restantes--;
		if (restantes == 0) {
			activeTask.cancel(true);
			// terminoHorda();
			System.out.println("fin horda");

		}
		else {
			System.out.println("quedan " + restantes + " enemigos");
		}

	}

	public int getEnemigos() {
		return enemigos;
	}

	public void setLlego(boolean c) {
		llego = c;
		if (llego) {
			Director.getPartida().perder();
			// activeTask.cancel(true);
		}
	}

	public boolean llegoCaminante() {
		return llego;
	}

	public int setMatados() {
		matados++;
		if (matados == enemigos) {
			terminoHorda();
		}
		return matados;
	}

}