package jugador;

import javax.swing.Icon;
import javax.swing.JLabel;

import main.CONFIG;
import main.Unidad;
import main.Visitor;
import mapa.Celda;

/*
 * Clase Jugador.
 * Clase que generaliza la idea de un jugador y su comportamiento.
 */

public abstract class Jugador extends Unidad {

	// Atributos locales.
	protected Icon[] graficos;
	protected int graph;
	protected int costo;

	// Constructor.
	public Jugador(Celda c) {
		super(c);
		alto = 30;
		ancho = 30;
		profundidad = CONFIG.PROFUNDIDAD_JUGADOR;
		V = new VisitorJugador(this);
	}

	// Metodos locales.

	public void setVisitor(Visitor v) {
		V = v;
	}

	@Override
	public void destruir() {
		super.destruir();
		V = null;
	}

	public void setV() {
		setVisitor(new VisitorJugador(this));

	}

	@Override
	public JLabel getGrafico() {
		return grafico;
	}

	public Visitor getVisitor() {
		return V;
	}

	// Metodos heredados.

	@Override
	public void run() {
		atacar();
	}

	public int getCosto() {
		return costo;
	}

	@Override
	public boolean accept(Visitor V) {
		return V.visitJugador(this);
	}

	public void vender() {

	}

	// abstract methods
	public abstract Jugador clone(Celda c);

	public abstract void atacar();

	public abstract void playSound();

}