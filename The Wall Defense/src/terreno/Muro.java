package terreno;

import javax.swing.ImageIcon;

import Controladores.RandomGenerator;
import main.Visitor;
import mapa.Celda;

/*
 * Clase Muro.
 * Clase encargada de establecer el comportamiento del terreno muro.
 */

public class Muro extends Terreno {

	// Constructor
	public Muro(Celda c, int nivel) {
		super();
		celda[0] = c;
		// Este es un random limitado entre 1 y 2, para establecer un rango
		// nuevo Random[n,m]: (Math.random()*m)+n
		RandomGenerator r = new RandomGenerator();
		this.sprite = r.nextInt(2) + 1;
		grafico.setIcon(new ImageIcon(
				this.getClass().getResource("/resources/static/terrenos/muro/" + nivel + "_muro" + sprite + ".png")));

	}

	// Metodos heredados.
	@Override
	public boolean accept(Visitor V) {
		return false;
	}

}