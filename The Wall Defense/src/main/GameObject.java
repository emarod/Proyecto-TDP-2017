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
	protected int alto;
	protected int ancho;

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

	public void crear() {
		celda.getObjects()[profundidad] = this;
		grafico.setBounds(celda.getPosX() * 64, celda.getPosY() * 64, 64, 64);
		Director.getMapa().getEscenario().agregar(grafico, profundidad);
	}

	public void crearMulticelda() {
		celda.getObjects()[profundidad] = this;
		Celda ce = celda;
		int cant = 0;
		while (cant < celda.size()) {
			ce.getChild().getObjects()[profundidad] = this;
			ce = ce.getChild();
			cant++;
		}
		Director.getMapa().getEscenario().agregar(grafico, profundidad);
	}

	public void destruir() {
		grafico.setIcon(null);
		Director.getMapa().getEscenario().remove(grafico);
		while (celda.size() > 0) {
			celda.getChild().getObjects()[profundidad] = null;
			celda.removeChild();
		}
		celda.getObjects()[profundidad] = null;
		grafico.getMouseListeners();
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