package enemigo;

import java.util.concurrent.ScheduledFuture;

import javax.swing.JLabel;

import Controladores.Director;
import Controladores.RandomGenerator;
import efectos.DañoAtkAumentado;
import efectos.Invulnerable;
import efectos.PowerUp;
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
	protected int matados;
	protected int dificultad;

	// Constructor.
	public Horda(int d) {
		dificultad = d;
		mapa = Director.getMapa();
		stage = mapa.getEscenario();
		enemigos = 5 + dificultad;
		restantes = enemigos;
		matados = 0;

	}

	// Metodos locales.
	public void terminoHorda() {
		Director.getPartida().aumentarNivel();
		Director.getGui().nextLevel();
	}

	public void actualizarEnemigos() {
		if (enemigos > 0) {
			enemigos--;
		}
	}

	public void ejecutar() {
		activeTask = Director.ejecutar(this, 10);
	}

	@Override
	public void run() {
		RandomGenerator rnd = Director.getRandom();
		int r = rnd.poll(6);
		int y;
		Enemigo e;
		y = rnd.poll(6);
		while (mapa.getCelda(x, y).getObjects()[CONFIG.PROFUNDIDAD_ENEMIGO] != null) {
			y = rnd.poll(6);
		}
		Celda c = mapa.getCelda(x, y);
		switch (r) {
			// Los enemigos simples.
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
			case 5: {
				e = new LoboWalker(c);
				break;
			}
			default: {
				e = new WhiteWalker(c);
			}

		}
		e.crear();
		randomPow(c, e);
		e.activar();
		e.setHorda(this);
		restantes--;
		if (restantes == 0) {
			activeTask.cancel(true);

		}

	}

	public int getEnemigos() {
		return enemigos;
	}

	public void setLlego(boolean c) {
		llego = c;
		if (llego) {
			Director.getPartida().perder();
			Director.getGui().getGame().terminarGUI(false);
		}
	}

	public boolean llegoCaminante() {
		return llego;
	}

	public void setMatados() {
		matados++;
		if (matados == enemigos) {
			terminoHorda();
		}
	}

	public void randomPow(Celda c, Enemigo e) {
		RandomGenerator r = Director.getRandom();
		int n = r.poll(3);
		PowerUp p = null;
		switch (n) {
			case 0:
				p = new Invulnerable(c);
				p.aplicar(e);
				break;

			case 1:
				p = new DañoAtkAumentado(c);
				p.aplicar(e);
				break;
			default:
				break;
		}
	}

}