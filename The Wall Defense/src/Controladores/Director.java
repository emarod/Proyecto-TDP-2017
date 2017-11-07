package Controladores;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import disparo.Disparo;
import main.Unidad;
import mapa.Map;
import objetos.Water;
import powerUp.PowerUp;

/*
 * Clase Director.
 * Crea un pool de hilos. Mantiene un flujo de ejecución de tareas, actualmente haciendo uso de un solo hilo.
 */

public class Director {
	// Atributos locales.
	protected ScheduledExecutorService taskPool;
	private BancoRecursos banco;

	// Constructor.
	public Director() {
		taskPool = Executors.newSingleThreadScheduledExecutor();
		banco = new BancoRecursos();

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

	public void ejecutar(Map map) {
		taskPool.scheduleWithFixedDelay(map, 1, 200, TimeUnit.MILLISECONDS);
	}

	public void ejecutarUna(PowerUp powerUp, int delay) {
		taskPool.schedule(powerUp, delay, TimeUnit.SECONDS);

	}

	public BancoRecursos getBancoRecursos() {
		return banco;
	}

	public ScheduledFuture<?> ejecutarUna(Water water, int delay) {
		return taskPool.schedule(water, delay, TimeUnit.SECONDS);

	}
}