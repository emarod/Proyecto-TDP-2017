package objetoMapa;

import javax.swing.ImageIcon;

import main.CONFIG;
import main.Visitor;
import mapa.Celda;
import objetos.ObjetoVida;
import objetos.Obstaculo;

/*
 * Clase Tronco
 * Clase que determina como esta compuesta y como se comporta una roca.
 */

public class Tronco extends ObjetoVida implements Obstaculo {

	// Constructor.
	public Tronco(Celda c) {
		super(c);
		vida = 3;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/tronco/tronco_1.png")));
		profundidad = CONFIG.PROFUNDIDAD_OBSTACULO;
	}

	// Metodos heredados.

	@Override
	public Obstaculo clone(Celda c) {
		Obstaculo clon = new Tronco(c);
		return clon;
	}

	@Override
	public boolean accept(Visitor V) {
		V.visitObjeto(this);
		return false;
	}
}
