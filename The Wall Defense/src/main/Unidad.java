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
	protected int backup;
	protected int inicio;

	public Unidad(Celda c) {
		super(c);
		careTaker = Director.getCareTaker();
		guardarInicio();
		backup = 0;
		inicio = 0;
	}

	// Metodos locales.

	@Override
	public void destruir() {
		super.destruir();
		activeTask.cancel(true);
		careTaker.clearSavepoint(this.hashCode());
	}

	public ScheduledFuture<?> getTask() {
		return activeTask;
	}

	public void setTask(ScheduledFuture<?> ejecutar) {
		activeTask = ejecutar;

	}

	@Override
	public void crear() {
		super.crear();
		new BarraVida(this);
	}

	@Override
	public void crearMulticelda() {
		super.crearMulticelda();
		new BarraVida(this);
	}

	public void recibirDaño(int golpe) {
		boolean destruir = false;
		if (vida <= golpe) {
			destruir = true;
		}
		else {
			vida = vida - golpe;
			notificar("DAÑO");
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

	public void guardarEstado(int i) {
		regresarUltimo();
		careTaker.saveMemento(new MementoUnidad(daño, vida, velocidad), i);
		backup = i;
	}

	public void regresarUltimo() {
		if (backup != 0) {
			reset(backup);
			backup = 0;
		}

	}

	public void guardarInicio() {
		careTaker.getMemento(this.hashCode());
	};

	public void regresarInicio() {
		reset(this.hashCode());
	}

	protected void reset(int save) {
		MementoUnidad recuperar = careTaker.getMemento(save);
		vida = recuperar.getVida();
		daño = recuperar.getDaño();
		velocidad = recuperar.getVelocidad();
		notificar("DAÑO");
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int speed) {
		velocidad = speed;
	}

	public void setVida(int i) {
		vida = i;
		setChanged();
		notifyObservers("DAÑO");
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