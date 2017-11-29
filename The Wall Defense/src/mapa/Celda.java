package mapa;

import java.util.LinkedList;

import main.CONFIG;
import main.GameObject;

/*
 * Clase Celda.
 * Clase encargada de la construccion logica de una posicion en el campo de batalla.
 */

public abstract class Celda {

	// Atributos locales.
	protected GameObject[] listaObjetosLogicos;
	protected Mapa mapa;
	protected int posX;
	protected int posY;
	protected boolean hayDisparo;
	protected boolean estaOcupada;
	protected LinkedList<GameObject> disparos;
	protected int hijos;

	// Constructor.
	public Celda(int posX, int posY) {
		hijos = 0;
		hayDisparo = false;
		this.posX = posX;
		this.posY = posY;
		listaObjetosLogicos = new GameObject[CONFIG.PROFUNDIDAD_CELDA];
		disparos = new LinkedList<GameObject>();
	}

	// Metodos locales.
	public GameObject[] getObjects() {
		refresh();
		return listaObjetosLogicos;
	}

	public void addDisparo(GameObject d) {
		if (hayDisparo) {
			disparos.addFirst(d);
			refresh();
		}
		else {
			listaObjetosLogicos[CONFIG.PROFUNDIDAD_DISPARO] = d;
			hayDisparo = true;
		}
	}

	public void refresh() {
		if (listaObjetosLogicos[CONFIG.PROFUNDIDAD_DISPARO] == null) {
			if (hayDisparo) {
				GameObject recarga = disparos.pollLast();
				if (recarga != null) {
					listaObjetosLogicos[CONFIG.PROFUNDIDAD_DISPARO] = recarga;
				}
				else {
					hayDisparo = false;
				}
			}
		}
	}

	public GameObject hayDisparo() {
		return listaObjetosLogicos[CONFIG.PROFUNDIDAD_DISPARO];
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	// Si la celda contiene un enemigo, aliado, o obstaculo lo retorna cc null
	public GameObject estaOcupada() {
		int i = 1;
		while (!estaOcupada && i < 4) {
			if (listaObjetosLogicos[i] != null) {
				estaOcupada = true;
			}
			else {
				i++;
			}
		}
		return listaObjetosLogicos[i];
	}

	public abstract void addChild(Celda c);

	public abstract void removeChild();

	public abstract Celda getChild();

	public abstract int size();

	public abstract void removeTail();
}
