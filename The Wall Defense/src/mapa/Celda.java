package mapa;

import java.util.LinkedList;
import java.util.List;

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

	// Constructor.
	public Celda(int posX, int posY) {
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
		while (!estaOcupada && i < 3) {
			if (listaObjetosLogicos[i] != null) {
				estaOcupada = true;
			}
		}
		return listaObjetosLogicos[i];
	}

	public abstract void addChild(Celda c);

	public abstract void removeChild(Celda c);

	public abstract List<Celda> getChildren(Celda c);

}
