package objetoMapa;

import java.util.concurrent.Callable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Controladores.Director;
import efectos.Relentizar;
import main.CONFIG;
import main.Unidad;
import main.Visitor;
import mapa.Celda;
import objetos.ObjetoTemporal;
import objetos.Obstaculo;

/*
 * Clase Water
 * Clase que determina como esta compuesta y como se comporta el agua.
 */

public class Water extends ObjetoTemporal implements Obstaculo, Callable<Boolean> {

	// Atributos locales.
	protected JLabel[] labels;

	// Constructor.
	public Water(Celda c) {
		super(c);
		ancho = 128;
		alto = 128;
		tiempo = 100;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/lago/lago.gif")));
		Director.ejecutarUna(this, 20);
		profundidad = CONFIG.PROFUNDIDAD_OBSTACULO;
	}

	// Metodos heredados.

	@Override
	public void aplicarEfecto(Unidad u) {
		Relentizar r = new Relentizar(celda);
		r.aplicar(u);
	}

	@Override
	public void destruir() {
		super.destruir();
		int i = 0;
		while (i < labels.length) {
			labels[i].setIcon(null);
			Director.getMapa().getEscenario().remove(labels[i]);
			graficos[i] = null;
			labels[i] = null;
			i++;
		}

	}

	@Override
	public void terminar() {
		destruir();

	}

	@Override
	public Obstaculo clone(Celda c) {
		Obstaculo clon = new Water(c);
		return clon;
	}

	@Override
	public boolean accept(Visitor V) {
		return V.visitObjeto(this);
	}

	@Override
	public Boolean call() throws Exception {
		destruir();
		return true;
	}
}
