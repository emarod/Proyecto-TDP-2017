package objetoMapa;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Controladores.Director;
import efectos.Relentizar;
import enemigo.Enemigo;
import main.Visitor;
import mapa.Celda;

/*
 * Clase Water
 * Clase que determina como esta compuesta y como se comporta el agua.
 */

public class Water extends ObjetoMapaTemporal implements Runnable {

	// Atributos locales.
	protected int penalizacion;
	protected JLabel[] labels;

	// Constructor.
	public Water(Celda c) {
		super(c);
		ancho = 128;
		alto = 128;
		penalizacion = 100;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/lago/lago.gif")));
		Director.ejecutarUna(this, 20);
		System.out.println("Water finalizada");
	}

	// Metodos locales.
	public int getPenalizacion() {
		return penalizacion;
	}

	// Metodos heredados.
	@Override
	public ObjetoMapa clone(Celda c) {
		ObjetoMapa clon = new Water(c);
		return clon;
	}

	@Override
	public boolean accept(Visitor V) {
		return V.visitObjetoMapa(this);
	}

	@Override
	public void aplicarEfecto(Enemigo e) {
		Relentizar r = new Relentizar(celda);
		r.aplicar(e);
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
	public void run() {
		destruir();
	}
}
