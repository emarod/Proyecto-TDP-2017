package main;

import java.util.concurrent.ConcurrentHashMap;

import Controladores.Director;
import mapa.Celda;
import objetos.Acumulable;
import objetos.Premio;
import tokens.Moneda;

/*
 * Clase Partida.
 * Clase encargada de controlar las estadisticas de la partida. Dinero, puntaje, etc.
 */
public class Partida {
	protected int puntaje;
	protected int dinero;
	protected ConcurrentHashMap<Acumulable, Integer> objetos;
	protected int nivel;
	protected Tienda shop;

	public Partida() {
		nivel = 1;
		puntaje = 0;
		dinero = 200;
		objetos = new ConcurrentHashMap<Acumulable, Integer>();
		shop = new Tienda();
	}

	public Tienda getTienda() {
		return shop;
	}

	public void añadirDinero(int i) {
		dinero += i;
		Director.getGui().getDinero().actualizar();

	}

	public void quitarDinero(int i) {
		dinero -= i;
	}

	public void añadirPuntaje(int i) {
		puntaje += i;
		Director.getGui().getScore().actualizar();

	}

	public void quitarPuntaje(int i) {
		puntaje -= i;
		Director.getGui().getScore().actualizar();
	}

	public int getDinero() {
		return dinero;
	}

	public int getScore() {
		return puntaje;
	}

	// Cada tipo de objeto precioso deberá ser cargado para ser utilizado
	public void cargarObjeto(Acumulable precioso) {
		objetos.put(precioso, 0);
	}

	// Este metodo debe ser utilizado para aumentar en una unidad un objeto
	public void aumentarObjeto(Acumulable precioso) {
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
		dinero += moneda.getValor();
		Director.getGui().getDinero().actualizar();
	}

	public void perder() {
		Director.getMapa().getEscenario().repaint();
	}

}
