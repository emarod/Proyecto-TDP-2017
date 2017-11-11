package Controladores;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import disparo.Disparo;
import enemigo.Horda;
import main.Partida;
import main.Unidad;
import mapa.Mapa;
import obstaculos.Water;
import powerUp.PowerUp;
import tokens.Token;

/*
 * Clase Director.
 * Crea un pool de hilos. Mantiene un flujo de ejecución de tareas, actualmente haciendo uso de un solo hilo.
 */

public class Director {
	// Atributos locales.
	private static Director director = null;
	protected static ScheduledExecutorService taskPool;
	protected static BancoRecursos banco;
	protected static Partida partida;
	protected static Mapa mapa;

	// Constructor.
	private Director() {
		taskPool = Executors.newSingleThreadScheduledExecutor();
		banco = BancoRecursos.newBancoRecursos();
		partida = new Partida();
		mapa = new Mapa();
	}

	public static Director newDirector() {
		if (director == null) {
			director = new Director();
		}
		return director;
	}

	public static BancoRecursos getBancoRecursos() {
		return banco;
	}

	public static Mapa getMapa() {
		return mapa;
	}

	public static Partida getPartida() {
		return partida;
	}

	// Metodos locales para utilizar el pool piscina loca.
	public static boolean desactivar(Unidad unidad) {
		return unidad.getTask().cancel(true);

	}

	public static ScheduledFuture<?> ejecutar(Unidad d, int delay) {
		return taskPool.scheduleWithFixedDelay(d, 0, 100 * delay, TimeUnit.MILLISECONDS);
	}

	public static ScheduledFuture<?> ejecutarUna(Unidad d, int delay) {
		return taskPool.schedule(d, 100 * delay, TimeUnit.MILLISECONDS);
	}

	public static ScheduledFuture<?> ejecutar(Unidad d, long l, int delay) {
		return taskPool.scheduleWithFixedDelay(d, l + 500, 100 * delay, TimeUnit.MILLISECONDS);
	}

	public static ScheduledFuture<?> ejecutar(Disparo d, int delay) {
		return taskPool.scheduleWithFixedDelay(d, 0, 1000 * delay, TimeUnit.MICROSECONDS);
	}

	public static void ejecutar(Mapa mapa) {
		taskPool.scheduleWithFixedDelay(mapa, 1, 3, TimeUnit.SECONDS);
	}

	public static void ejecutarUna(PowerUp powerUp, int delay) {
		taskPool.schedule(powerUp, delay, TimeUnit.SECONDS);

	}

	public static ScheduledFuture<?>

			ejecutarUna(Water water, int delay) {
		return taskPool.schedule(water, delay, TimeUnit.SECONDS);

	}

	public static void ejecutarUna(Token token, int duracion) {
		taskPool.schedule(token, duracion, TimeUnit.SECONDS);

	}

	public static ScheduledFuture<?> ejecutar(Horda horda, int delay) {
		return taskPool.scheduleWithFixedDelay(horda, 1, delay, TimeUnit.SECONDS);
	}
}