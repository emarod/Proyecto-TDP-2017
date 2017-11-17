package main;

import java.util.concurrent.ConcurrentHashMap;

import Controladores.Director;
import mapa.Celda;
import premios.Premio;
import tokens.Moneda;

/*
 * Clase Partida.
 * Clase encargada de controlar las estadisticas de la partida. Dinero, puntaje, etc.
 */
public class Partida {
	protected int puntaje;
	protected int dinero;
	protected ConcurrentHashMap<Premio, Integer> objetos;
	protected int nivel;

	public Partida() {
		nivel = 1;
		puntaje = 0;
		dinero = 200;
		objetos = new ConcurrentHashMap<Premio, Integer>();
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

	public int getDinero() {
		return dinero;
	}

	public int getScore() {
		return puntaje;
	}

	// Cada tipo de objeto precioso deberá ser cargado para ser utilizado
	public void cargarObjeto(Premio precioso) {
		objetos.put(precioso, 0);
	}

	// Este metodo debe ser utilizado para aumentar en una unidad un objeto
	public void aumentarObjeto(Premio precioso) {
		objetos.computeIfPresent(precioso, (k, v) -> v + 1);
	}

	// Devuelve true si el jugador tiene stock de objeto.
	// Tener en cuenta que de devolver true se considera que será utilizado
	// y por ende se decrementa una unidad.
	public Premio usarObjeto(Premio precioso, Celda c) {
		int hay = objetos.get(precioso);
		Premio myprecious = null;
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

	public void cargarDinero(Moneda moneda) {
		System.out.println("guitaa " + moneda.getValor());
		dinero += moneda.getValor();
		Director.getMapa().getEscenario().getDinero().actualizar();
	}

	public void perder() {
		Director.getMapa().getEscenario().repaint();
	}

}
