package main;

import java.util.concurrent.ConcurrentHashMap;

import mapa.Celda;
import objetos.ObjetoPrecioso;

/*
 * Clase Partida.
 * Clase encargada de controlar las estadisticas de la partida. Dinero, puntaje, etc.
 */
public class Partida {
	protected int puntaje;
	protected int dinero;
	protected ConcurrentHashMap<ObjetoPrecioso, Integer> objetos;
	protected int nivel;

	public Partida() {
		nivel = 1;
		puntaje = 0;
		dinero = 0;
		objetos = new ConcurrentHashMap<ObjetoPrecioso, Integer>();
	}

	public void añadirDinero(int i) {
		dinero += i;
	}

	public void quitarDinero(int i) {
		dinero -= i;
	}

	public void añadirPuntaje(int i) {
		puntaje += i;
	}

	public void quitarPuntaje(int i) {
		puntaje -= i;
	}

	// Cada tipo de objeto precioso deberá ser cargado para ser utilizado
	public void cargarObjeto(ObjetoPrecioso precioso) {
		objetos.put(precioso, 0);
	}

	// Este metodo debe ser utilizado para aumentar en una unidad un objeto
	public void aumentarObjeto(ObjetoPrecioso precioso) {
		objetos.computeIfPresent(precioso, (k, v) -> v + 1);
	}

	// Devuelve true si el jugador tiene stock de objeto.
	// Tener en cuenta que de devolver true se considera que será utilizado
	// y por ende se decrementa una unidad.
	public ObjetoPrecioso usarObjeto(ObjetoPrecioso precioso, Celda[] c) {
		int hay = objetos.get(precioso);
		ObjetoPrecioso myprecious = null;
		if (hay > 0) {
			objetos.computeIfPresent(precioso, (k, v) -> v - 1);
			myprecious = precioso.clone(c);
		}
		return myprecious;
	}

	public int getNivel() {
		return nivel;
	}

	public void aumentarNivel() {
		nivel++;
	}

}
