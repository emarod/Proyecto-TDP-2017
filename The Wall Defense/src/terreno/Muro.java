package terreno;

import javax.swing.ImageIcon;

import main.Visitor;
import mapa.Celda;

/*
 * Clase Muro.
 * Clase encargada de establecer el comportamiento del terreno muro.
 */

public class Muro extends Terreno {

	// Constructor
	public Muro(Celda c, int n) {
		super(c);
		// Este es un random limitado entre 1 y 2, para establecer un rango
		// nuevo Random[n,m]: (Math.random()*m)+n
		grafico.setIcon(new ImageIcon(
				this.getClass().getResource("/resources/static/terrenos/muro/" + n + "_muro" + sprite + ".png")));
	}

	// Metodos heredados.
	@Override
	public boolean accept(Visitor V) {
		return false;
	}

}