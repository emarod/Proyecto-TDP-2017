package main;

<<<<<<< HEAD
import java.awt.Point;

=======
>>>>>>> master
import javax.swing.JLabel;

import mapa.Celda;

/*
 * Clase abstracta GameObject.
 * Clase que generaliza la idea de un elemento u objeto que conforma al juego.
 */

public abstract class GameObject {

	// Atributos locales.
	protected JLabel grafico;
	protected Celda[] celda = new Celda[4];
	protected int profundidad;

	// Metodos locales.
	public JLabel getGrafico() {
		return grafico;
	}

	public void setGrafico(JLabel graf) {
		grafico = graf;
	}

	public void destruir() {
		grafico.setIcon(null);
<<<<<<< HEAD
		celda[0].getEscenario().remove(grafico);
		celda[0].getObjects()[profundidad] = null;
=======
>>>>>>> master
	}

	public int getProfundidad() {
		return profundidad;
	}

	public Celda[] getCeldas() {
		return celda;
	}

<<<<<<< HEAD
	public Point xy() {
		return new Point(celda[0].getPosX(), celda[0].getPosY());
	}

=======
>>>>>>> master
	public void setCelda(Celda c, int pos) {
		celda[pos] = c;
	}

	// Metodos abstractos.
	public abstract boolean accept(Visitor V);

}