package main;

import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.JLabel;

import Controladores.Director;
import mapa.Celda;
import objetos.ObjetoCelda;

public abstract class GameObject extends Observable implements ObjetoCelda {

	protected int profundidad;
	protected Celda celda;
	protected JLabel grafico;
	protected int alto, ancho;
	protected Icon[] graficos;
	protected int graph;

	public GameObject(Celda c) {
		grafico = new JLabel();
		celda = c;
	}

	@Override
	public void setCelda(Celda c) {
		celda = c;
	}

	@Override
	public void intercambiar_celdas(Celda C) {
		C.getObjects()[profundidad] = this;
		celda.getObjects()[profundidad] = null;
		celda = C;

	}

	@Override
	public Celda getCelda() {
		return celda;
	}

	@Override
	public JLabel getGrafico() {
		return grafico;
	}

	@Override
	public void setGrafico(JLabel graf) {
		grafico = graf;
	}

	@Override
	public void setGrafico(int i) {
		grafico.setIcon(graficos[i]);
	}

	@Override
	public void crear() {
		celda.getObjects()[profundidad] = this;
		grafico.setBounds(celda.getPosX() * 64, celda.getPosY() * 64, 64, 64);
		Director.getMapa().getEscenario().agregar(grafico, profundidad);
	}

	@Override
	public void crearMulticelda() {
		celda.getObjects()[profundidad] = this;
		Celda ce = celda;
		int cant = 0;
		while (cant < celda.size()) {
			ce.getChild().getObjects()[profundidad] = this;
			ce = ce.getChild();
			cant++;
		}
		// grafico.setBounds(celda.getPosX() * 64, celda.getPosY() * 64, ancho, alto);
		Director.getMapa().getEscenario().agregar(grafico, profundidad);
	}

	@Override
	public abstract boolean accept(Visitor V);

	@Override
	public void setProfundidad(int i) {
		profundidad = i;

	}

	@Override
	public int getProfundidad() {
		return profundidad;
	}

	@Override
	public void destruir() {
		notificarDefuncion();
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

	public void observar(Observer o) {
		this.addObserver(o);
	}

	public void dejarObservar(Observer o) {
		this.deleteObserver(o);
	}

	public void notificar() {
		this.setChanged();
		this.notifyObservers();
	}

	public void notificar(String str) {
		this.setChanged();
		this.notifyObservers(str);
	}

	private void notificarDefuncion() {
		setChanged();
		notifyObservers("DEAD");
		deleteObservers();

	}

}
