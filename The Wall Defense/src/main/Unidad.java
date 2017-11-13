package main;

import java.util.concurrent.ScheduledFuture;

import Controladores.CareTaker;
import Controladores.Director;
import Controladores.MementoUnidad;
import mapa.Celda;

/*
 * Clase abstracta Unidad.
 * Clase que generaliza la nocion de personaje, tanto aliado como enemigo.
 */

public abstract class Unidad extends GameObject implements Runnable {

	// Atributos locales.
	protected Visitor V;
	// Parametros de conducta
	protected int vida;
	protected int daño;
	protected int alto;
	protected int ancho;
	protected int velocidad;
	protected ScheduledFuture<?> activeTask;
	protected CareTaker careTaker;
	protected String backup;

	public Unidad() {
		careTaker = Director.getCareTaker();
	}

	// Metodos locales.
	@Override
	public void intercambiar_celdas(Celda C) {
		C.getObjects()[profundidad] = this;
		celda[0].getObjects()[profundidad] = null;
		celda[0] = C;

	}

	@Override
	public void destruir() {
		super.destruir();
		activeTask.cancel(true);
	}

	public ScheduledFuture<?> getTask() {
		return activeTask;
	}

	public void setTask(ScheduledFuture<?> ejecutar) {
		activeTask = ejecutar;

	}

	public void activar() {
		if (activeTask == null || activeTask.isDone()) {
			// System.out.println("unidad activada " + this.getClass());
			activeTask = Director.ejecutarUna(this, velocidad);
		}
		else {
			System.out.println("ya está activado " + this.getClass());
		}
	}

	public void activar(long l) {
		if (activeTask == null || activeTask.isDone()) {
			activeTask = Director.ejecutar(this, l, velocidad);
		}
		else {
			System.out.println("ya está activado" + this.getClass());
		}

	}

	public void guardarEstado(String save) {
		careTaker.saveMemento(new MementoUnidad(daño, vida, velocidad), save);
		backup = save;
	}

	public void regresarUltimo() {
		reset(backup);
	}

	public abstract void guardarInicio();

	public abstract void regresarInicio();

	protected void reset(String save) {
		MementoUnidad recuperar = careTaker.getMemento(save);
		vida = recuperar.getVida();
		daño = recuperar.getDaño();
		velocidad = recuperar.getVelocidad();
	}

	// Metodos abstractos.
	public abstract void atacar();

	public abstract void mover();

	public abstract int getVelocidad();

	public abstract void setVelocidad(int speed);

}