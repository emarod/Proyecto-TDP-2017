package Controladores;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import disparo.Disparo;
import efectos.BuffTemporal;
import efectos.PowerUpTemporal;
import enemigo.Horda;
import interfaz.GUI;
import main.Juego;
import main.Partida;
import main.Unidad;
import mapa.Celda;
import mapa.Mapa;
import objetoMapa.Water;
import premios.PremioTemporal;
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
	protected static CareTaker careTaker;
	protected static RandomGenerator random;
	protected static Juego gui;
	protected static GUI interfaz;

	// Constructor.
	private Director() {
		taskPool = Executors.newSingleThreadScheduledExecutor();
		banco = BancoRecursos.newBancoRecursos();
		partida = new Partida();
		mapa = new Mapa();
		careTaker = new CareTaker();
		random = new RandomGenerator();
		random.generar(100, 100);
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

	public static CareTaker getCareTaker() {
		return careTaker;
	}

	public static Mapa getMapa() {
		return mapa;
	}

	public static void setMapa(Mapa map) {
		mapa = map;
	}

	public static Partida getPartida() {
		return partida;
	}

	public static RandomGenerator getRandom() {
		return random;
	}

	// Metodos locales para utilizar el pool piscina local.

	// Permite desactivar una tarea activa
	public static boolean desactivar(Unidad unidad) {
		return unidad.getTask().cancel(true);

	}

	public static boolean desactivar(Disparo disparo) {
		return disparo.getTask().cancel(true);

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

	public static void ejecutar(Mapa mapa) {
		taskPool.scheduleWithFixedDelay(mapa, 1, 10, TimeUnit.SECONDS);
	}

	public static void ejecutarUna(PowerUpTemporal powerUp, int delay) {
		taskPool.schedule(powerUp, delay, TimeUnit.SECONDS);
	}

	public static void ejecutarUna(BuffTemporal buff, int delay) {
		taskPool.schedule(buff, delay, TimeUnit.SECONDS);
	}

	public static ScheduledFuture<?> ejecutarUna(Water water, int delay) {
		return taskPool.schedule(water, delay, TimeUnit.SECONDS);

	}

	public static void ejecutarUna(Token token, int duracion) {
		taskPool.schedule(token, duracion, TimeUnit.SECONDS);

	}

	public static ScheduledFuture<?> ejecutar(Horda horda, int delay) {
		return taskPool.scheduleWithFixedDelay(horda, 1, delay, TimeUnit.SECONDS);
	}

	public static ScheduledFuture<?> ejecutarUna(Disparo disparo, int velocidad) {
		return taskPool.schedule(disparo, 500 * velocidad, TimeUnit.MICROSECONDS);
	}

	public static ScheduledFuture<?> ejecutar(Disparo d, int delay) {
		return taskPool.scheduleWithFixedDelay(d, 100, 800 * delay, TimeUnit.MICROSECONDS);
	}

	public static void ejecutarUna(BuffTemporal buff, int delay, TimeUnit t) {
		taskPool.schedule(buff, delay, t);

	}

	public static Celda getCelda(int x, int y) {
		return mapa.getCelda(x, y);
	}

	public static ScheduledFuture<?> ejecutarUna(PremioTemporal premio, int delay) {
		return taskPool.schedule(premio, delay, TimeUnit.SECONDS);

	}

	public void setGui(Juego frame) {
		gui = frame;

	}

	public static GUI getGui() {
		return interfaz;
	}

}