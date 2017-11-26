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
	protected int matados;
	protected int dificultad;

	// Constructor.
	public Horda(int d) {
		dificultad = d;
		mapa = Director.getMapa();
		stage = mapa.getEscenario();
		enemigos = Director.getGui().getLevel().getNroNivel() * dificultad;
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
		activeTask = Director.ejecutar(this, 20);
	}

	@Override
	public void run() {
		RandomGenerator rnd = Director.getRandom();
		int r = rnd.poll(12);
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
				System.out.print("Se creo ww.");
				break;
			}
			case 1: {
				e = new NightKing(c);
				System.out.print("Se creo nk.");
				break;
			}
			case 2: {
				e = new Araña(c);
				System.out.print("Se creo araña.");
				break;
			}
			case 3: {
				e = new KnightWalker(c);
				System.out.print("Se creo kw.");
				break;
			}
			case 4: {
				e = new EsqueletoSuicida(c);
				System.out.print("Se creo es.");
				break;
			}
			case 5: {
				e = new LoboWalker(c);
				System.out.print("Se creo lw.");
				break;
			}

			// los enemigos invulnerables.
			case 6: {
				e = new WhiteWalker(c);
				System.out.print("Se creo ww i.");
				break;
			}
			case 7: {
				e = new NightKing(c);
				System.out.print("Se creo nk i.");
				break;
			}
			case 8: {
				e = new Araña(c);
				System.out.print("Se creo araña i.");
				break;
			}
			case 9: {
				e = new KnightWalker(c);
				System.out.print("Se creo kw i.");
				break;
			}
			case 10: {
				e = new EsqueletoSuicida(c);
				System.out.print("Se creo es i.");
				break;
			}
			case 11: {
				e = new LoboWalker(c);
				System.out.print("Se creo lw i.");
				break;
			}

			default: {
				e = new WhiteWalker(c);
			}

		}
		e.crear();
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

}