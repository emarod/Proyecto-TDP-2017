package terreno;

import javax.swing.ImageIcon;

import Controladores.Director;
import Controladores.RandomGenerator;
import main.Visitor;
import mapa.Celda;

/*
 * Clase Muro.
 * Clase encargada de establecer el comportamiento del terreno muro.
 */

public class Muro extends Terreno {

	// Constructor
	public Muro(Celda c) {
		super(c);
		// Este es un random limitado entre 1 y 2, para establecer un rango
		// nuevo Random[n,m]: (Math.random()*m)+n
		RandomGenerator r = Director.getRandom();
		this.sprite = r.poll(2);
		grafico.setIcon(new ImageIcon(this.getClass().getResource(
				"/resources/static/terrenos/muro/" + Director.getPartida().getNivel() + "_muro" + sprite + ".png")));
	}

	// Metodos heredados.
	@Override
	public boolean accept(Visitor V) {
		return false;
	}

}