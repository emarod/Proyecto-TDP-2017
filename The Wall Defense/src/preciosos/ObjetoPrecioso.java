package preciosos;

import javax.swing.Icon;

import main.CONFIG;
import main.GameObject;
import mapa.Celda;

public abstract class ObjetoPrecioso extends GameObject {
	// Atributos locales.
	protected int vida;
	protected Icon[] graficos;
	protected int graph;

	public ObjetoPrecioso(Celda c) {
		super();
		construir(c);
		construir();
	}

	public ObjetoPrecioso() {
		construir();
	}

	private void construir() {
		profundidad = CONFIG.PROFUNDIDAD_PRECIOSO;
	}

	private void construir(Celda c) {
		celda = c;
	}

	public boolean recibirDaño(int golpe) {
		boolean destruir = false;
		if (vida <= golpe) {
			destruir = true;
		}
		else {
			vida = vida - golpe;
		}
		if (destruir) {
			destruir();
		}
		return destruir;
	}

	// Si el objeto se construyo con el constructor alternativo debe setearse la
	// celda para poder ubicarlo en el mapa
	@Override
	public void setCelda(Celda c) {
		construir(c);
	}

	public abstract ObjetoPrecioso clone(Celda c);

	public abstract int getCosto();

}
