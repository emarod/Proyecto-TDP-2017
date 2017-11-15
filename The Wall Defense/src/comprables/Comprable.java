package comprables;

import javax.swing.Icon;

import main.CONFIG;
import main.GameObject;
import mapa.Celda;

public abstract class Comprable extends GameObject {

	// Atributos locales.
	protected Icon[] graficos;
	protected int graph;
	protected int costo;

	public Comprable(Celda c) {
		super();
		construir();
		construir(c);
	}

	public Comprable() {
		construir();
	}

	private void construir() {
		profundidad = CONFIG.PROFUNDIDAD_COMPRABLE;
	}

	private void construir(Celda c) {
		celda = c;
	}

	// Si el objeto se construyo con el constructor alternativo debe setearse la
	// celda para poder ubicarlo en el mapa
	@Override
	public void setCelda(Celda c) {
		construir(c);
	}

	public abstract Comprable clone(Celda c);

	public int getCosto() {
		return costo;
	}

}
