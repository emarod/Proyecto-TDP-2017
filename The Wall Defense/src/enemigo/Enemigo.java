package enemigo;

import javax.swing.Icon;
import javax.swing.JLabel;

import Controladores.Director;
import main.CONFIG;
import main.GameObject;
import main.Unidad;
import main.Visitor;
import mapa.Celda;

/*
 * Clase Enemigo.
 * Clase que generaliza la idea de un enemigo y su comportamiento.
 */

public abstract class Enemigo extends Unidad {

	// Atributos locales.
	protected int puntaje;
	protected Icon[] graficos;
	protected int graph;
	protected int matados;
	protected Horda horda;

	// Constructor.
	public Enemigo(Celda c) {
		super(c);
		V = new VisitorEnemigo(this);
		profundidad = CONFIG.PROFUNDIDAD_ENEMIGO;
		setGrafico();
	}

	// Metodos locales.

	public Visitor getVisitor() {
		return V;
	}

	public void setGrafico() {
		setGrafico(grafico);
	}

	@Override
	public JLabel getGrafico() {
		return grafico;
	}

	@Override
	public void destruir() {
		super.destruir();
		Director.getMapa().agregarTokens();
		Director.getPartida().añadirPuntaje(puntaje);
		horda.setMatados();
	}

	public int getPuntaje() {
		return getPuntaje();
	}

	// Metodos heredados.

	@Override
	public void regresarInicio() {
		reset("ENEMIGO");
		careTaker.clearSavepoint();
	}

	@Override
	public void run() {
		mover();
	}

	@Override
	public boolean accept(Visitor V) {
		return V.visitEnemigo(this);
	}

	public abstract Enemigo clone(Celda c);

	public void mover() {
		Celda siguiente;
		boolean detener = false;
		int xCelda = celda.getPosX();
		int yCelda = celda.getPosY();
		int xGrafico = getGrafico().getX();
		int yGrafico = getGrafico().getY();
		siguiente = Director.getMapa().getCelda(xCelda - 1, yCelda);
		for (int i = 0; i < CONFIG.PROFUNDIDAD_CELDA; i++) {
			GameObject objeto = siguiente.getObjects()[i];
			if (objeto != null && !objeto.accept(getVisitor())) {
				detener = true;
				activeTask = null;
				activar();

			}
		}
		if (!detener && xCelda != 0) {
			System.out.println("x:" + xCelda);
			getGrafico().setBounds(xGrafico - 64, yGrafico, 64, 64);
			intercambiar_celdas(siguiente);
			notificar();
			activeTask = null;
			activar();
		}

		if (!detener && xCelda == 2) {
			// getGrafico().setBounds(xGrafico - 64, yGrafico, 64, 64);
			activeTask = null;
			System.out.println("LLego");
			Director.getMapa().getHorda().setLlego(true);
		}
	}

	public void setHorda(Horda h) {
		horda = h;
	}

	public abstract void playSound();
}
