package Controladores;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import disparo.Disparo;
import main.Unidad;
import mapa.Mapa;
import objetos.Water;
import powerUp.PowerUp;

/*
 * Clase Director.
 * Crea un pool de hilos. Mantiene un flujo de ejecución de tareas, actualmente haciendo uso de un solo hilo.
 */

public class Director {
	// Atributos locales.
	private static final Director director = new Director();
	protected ScheduledExecutorService taskPool;
	private BancoRecursos banco;

	// Constructor.
	private Director() {
		taskPool = Executors.newSingleThreadScheduledExecutor();
		banco = new BancoRecursos();

	}

	public static Director newDirector() {
		return director;
	}

	public BancoRecursos getBancoRecursos() {
		return banco;
	}

	// Metodos locales.
	public boolean desactivar(Unidad unidad) {
		return unidad.getTask().cancel(true);

	}

	public ScheduledFuture<?> ejecutar(Unidad d, int delay) {
		return taskPool.scheduleWithFixedDelay(d, 0, 100 * delay, TimeUnit.MILLISECONDS);
	}

	public ScheduledFuture<?> ejecutarUna(Unidad d, int delay) {
		return taskPool.schedule(d, 100 * delay, TimeUnit.MILLISECONDS);
	}

	public ScheduledFuture<?> ejecutar(Unidad d, long l, int delay) {
		return taskPool.scheduleWithFixedDelay(d, l + 500, 100 * delay, TimeUnit.MILLISECONDS);
	}

	public ScheduledFuture<?> ejecutar(Disparo d, int delay) {
		return taskPool.scheduleWithFixedDelay(d, 0, 1000 * delay, TimeUnit.MICROSECONDS);
	}

	public void ejecutar(Mapa mapa) {
		taskPool.scheduleWithFixedDelay(mapa, 1, 3, TimeUnit.SECONDS);
	}

	public void ejecutarUna(PowerUp powerUp, int delay) {
		taskPool.schedule(powerUp, delay, TimeUnit.SECONDS);

	}

	public ScheduledFuture<?> ejecutarUna(Water water, int delay) {
		return taskPool.schedule(water, delay, TimeUnit.SECONDS);

	}
}