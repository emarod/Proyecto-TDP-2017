package preciosos;

import javax.swing.ImageIcon;

import jugador.Jugador;
import main.GameObject;
import main.Visitor;
import mapa.Celda;

/*
 * Clase Bomba.
 * Clase que especifica el comportamiento del poder bomba.
 */

public class Bomba extends ObjetoPrecioso {

	// Constructor.
	public Bomba(int prof) {
		super(prof);
		construir();
	}

	public Bomba(Celda[] c, int prof) {
		super(c, prof);
		construir();
	}

	private void construir() {
		celda[0].getEscenario().repaint();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/explosion.gif")));
	}

	public void aplicar(Celda c) {
		GameObject objetos[] = c.getObjects();
		for (int i = 1; i < objetos.length; i++) {
			objetos[i] = null;
		}
	}

	// Metodos heredados.
	public void aplicar(Jugador j) {

	}

	@Override
	public ObjetoPrecioso clone(Celda[] c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean accept(Visitor V) {
		// TODO Auto-generated method stub
		return false;
	}

}
