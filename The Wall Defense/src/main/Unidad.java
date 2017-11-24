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

	public Unidad(Celda c) {
		super(c);
		careTaker = Director.getCareTaker();
	}

	// Metodos locales.
	@Override
	public void intercambiar_celdas(Celda C) {
		C.getObjects()[profundidad] = this;
		celda.getObjects()[profundidad] = null;
		celda = C;

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

	public void recibirDaño(int golpe) {
		boolean destruir = false;
		if (vida <= golpe) {
			destruir = true;
		}
		else {
			vida = vida - golpe;
		}
		if (destruir) {
			destruir();
		}
	}

	public void activar() {
		if (activeTask == null || activeTask.isDone()) {
			activeTask = Director.ejecutarUna(this, velocidad);
		}
	}

	public void activar(long l) {
		if (activeTask == null || activeTask.isDone()) {
			activeTask = Director.ejecutar(this, l, velocidad);
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

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int speed) {
		velocidad = speed;
	}

	public void setVida(int i) {
		vida = i;
	}

	public int getVida() {
		return vida;
	}

	public int getDaño() {
		return daño;
	}

	public void setAtaque(int a) {
		daño = a;
	}

	// Metodos abstractos.

}