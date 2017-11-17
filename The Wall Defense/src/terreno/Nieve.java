package terreno;

import javax.swing.ImageIcon;

import Controladores.Director;
import Controladores.RandomGenerator;
import main.Visitor;
import mapa.Celda;

/*
 * Clase Nieve.
 * Clase encargada de establecer el comportamiento del terreno nieve.
 */

public class Nieve extends Terreno {

	// Constructor.
	public Nieve(Celda c) {
		super(c);
		// Este es un random limitado entre 1 y 3, para establecer un rango nuevo
		// Random[n,m]: (Math.random()*m)+n
		RandomGenerator r = Director.getRandom();
		this.sprite = r.poll(3);
		grafico.setIcon(
				new ImageIcon(this.getClass().getResource("/resources/static/terrenos/nieve/nieve" + sprite + ".png")));
	}

	// Metodos heredados.
	@Override
	public boolean accept(Visitor V) {
		return true;
	}

}
