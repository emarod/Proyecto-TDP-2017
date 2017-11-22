package objetoMapa;

import javax.swing.ImageIcon;

import main.Visitor;
import mapa.Celda;

/*
 * Clase Tronco
 * Clase que determina como esta compuesta y como se comporta una roca.
 */

public class Tronco extends ObjetoMapaVida {

	// Constructor.
	public Tronco(Celda c) {
		super(c);
		vida = 3;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/tronco/tronco_1.png")));
	}

	// Metodos locales.
	public int getResistencia() {
		return vida;
	}

	@Override
	public void destruir() {
		super.destruir();
	}

	// Metodos heredados.

	@Override
	public ObjetoMapa clone(Celda c) {
		ObjetoMapa clon = new Tronco(c);
		return clon;
	}

	@Override
	public boolean accept(Visitor V) {
		return V.visitObjetoMapa(this);
	}

}
