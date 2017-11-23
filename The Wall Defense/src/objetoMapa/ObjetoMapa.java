package objetoMapa;

import javax.swing.Icon;
import javax.swing.JLabel;

import main.CONFIG;
import main.GameObject;
import mapa.Celda;

public abstract class ObjetoMapa extends GameObject {

	// Atributos locales.
	protected JLabel imagen;
	protected Icon[] graficos;
	protected int graph;

	// Constructor.
	public ObjetoMapa(Celda c) {
		super();
		profundidad = CONFIG.PROFUNDIDAD_OBSTACULO;
		celda = c;
	}

	// Metodos locales
	public void setGrafico() {
		setGrafico(grafico);
	}

	public abstract ObjetoMapa clone(Celda c);// profundidad 2
}
