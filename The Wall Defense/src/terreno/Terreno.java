package terreno;

import main.CONFIG;
import main.GameObject;
import mapa.Celda;

/*
 * Clase Abstracta Terreno.
 * Clase que generaliza la idea de terreno.
 */

public abstract class Terreno extends GameObject {

	// Atributos locales.
	protected int sprite;

	public Terreno(Celda c) {
		super();
		celda = c;
		profundidad = CONFIG.PROFUNDIDAD_TERRENO;

	}
}
