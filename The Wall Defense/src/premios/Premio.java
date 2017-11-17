package premios;

import javax.swing.Icon;

import main.CONFIG;
import main.GameObject;
import main.Visitor;
import mapa.Celda;

public abstract class Premio extends GameObject {
	// Atributos locales.
	protected Icon[] graficos;
	protected int graph;

	public Premio(Celda c) {
		super();
		construir(c);
		construir();
	}

	public Premio() {
		construir();
	}

	private void construir() {
		profundidad = CONFIG.PROFUNDIDAD_PREMIO;
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

	@Override
	public boolean accept(Visitor V) {
		return true;
	}

	public abstract Premio clone(Celda c);

}
