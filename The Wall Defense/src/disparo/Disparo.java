package disparo;

import java.util.concurrent.ScheduledFuture;

import Controladores.Director;
import main.CONFIG;
import main.GameObject;
import main.Visitor;

/*
 * Clase abstracta Disparo.
 * clase que generaliza la idea de un proyectil.
 */

public abstract class Disparo extends GameObject implements Runnable {

	protected int ancho;
	protected int alto;
	protected Visitor V;
	protected ScheduledFuture<?> activeTask;
	protected int velocidad;
	protected int daño;

	// Constructor.
	public Disparo() {
		super(null);
		profundidad = CONFIG.PROFUNDIDAD_DISPARO;
		ancho = 64;
		alto = 64;
	}

	// Metodos locales.
	public int getAlto() {
		return alto;
	}

	public int getAncho() {
		return ancho;
	}

	@Override
	public void destruir() {
		super.destruir();
	}

	public ScheduledFuture<?> getTask() {
		return activeTask;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void activar() {
		if (activeTask == null || activeTask.isDone()) {
			activeTask = Director.ejecutar(this, velocidad);
		}
	}

	public int getDaño() {
		return daño;
	}

	public void reducirDaño(int r) {
		daño -= r;
	}

	// Calcula una colision de disparos.
	// A igual daños se cancelan
	// La de menor daño será destruida y la otra tendrá una penalizacion al daño
	// igual a la diferencia de daño entre disparos
	public void colision(Disparo d) {
		if (daño < d.getDaño()) {
			d.reducirDaño(daño);
			destruir();
		}
		else {
			reducirDaño(d.getDaño());
			d.destruir();
		}
	}

	public abstract void setCelda();

	// Metodos abstractos.
	public abstract void mover();

}