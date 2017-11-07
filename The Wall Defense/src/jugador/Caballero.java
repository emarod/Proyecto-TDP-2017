package jugador;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Celda;

/*
 * Clase Caballero.
 * Clase que especifica las caracteristicas y comportamiento del jugador caballero.
 */

public class Caballero extends Jugador {

	// Constructor.
	public Caballero(Celda[] c, int prof) {
		super(c, prof);
		vida = 10;
		velocidad = 10;
		setGrafico(grafico);
	}

	// Metodos heredados.

	@Override
	public void atacar() {

	}

	@Override
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(
				this.getClass().getResource("/resources/dinamic/personajes/lannister_atacando.gif"));
		grafico.setIcon(imagen);
	}

	@Override
	public Jugador clone(Celda[] c) {
		// Profundidad 2 predeterminada. Retorna una unidad de mismo tipo.
		Jugador clon = new Caballero(c, 2);
		return clon;

	}

	@Override
	public void playSound() {

	}

	@Override
	public void destruir() {
		super.destruir();
	}

	@Override
	public int getDaño() {
		return daño;
	}

	@Override
	public void mover() {
	}
}