package main;

import java.awt.Point;

import javax.swing.JLabel;

import Controladores.Director;
import mapa.Celda;

/*
 * Clase abstracta GameObject.
 * Clase que generaliza la idea de un elemento u objeto que conforma al juego.
 */

public abstract class GameObject {

	// Atributos locales.
	protected JLabel grafico;
	protected Celda celda;
	protected int profundidad;

	public GameObject() {
		grafico = new JLabel();
	}

	// Metodos locales.
	public JLabel getGrafico() {
		return grafico;
	}

	public void setGrafico(JLabel graf) {
		grafico = graf;
	}

	public void destruir() {
		grafico.setIcon(null);
		Director.getMapa().getEscenario().remove(grafico);
		while (celda.getChild() != null) {
			celda.getChild().getObjects()[profundidad] = null;
			celda.removeChild();
		}
		celda.getObjects()[profundidad] = null;
		grafico = null;
		celda = null;
	}

	public int getProfundidad() {
		return profundidad;
	}

	public Point xy() {
		return new Point(celda.getPosX(), celda.getPosY());
	}

	public void setCelda(Celda c) {
		celda = c;
	}

	public void intercambiar_celdas(Celda C) {
		C.getObjects()[profundidad] = this;
		celda.getObjects()[profundidad] = null;
		celda = C;

	}

	public Celda getCelda() {
		return celda;
	}

	// Metodos abstractos.
	public abstract boolean accept(Visitor V);

}