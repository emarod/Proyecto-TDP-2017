package jugador;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Celda;

/*
 * Clase Espadachin.
 * Clase que especifica las caracteristicas y comportamiento del jugador espadachin.
 */

public class Espadachin extends Jugador {

	// Constructor.
	public Espadachin(Celda[] c) {
		super(c);
		vida = 8;
		velocidad = 10;
		costo = 25;
		setGrafico(grafico);
	}

	// Metodos heredados.

	@Override
	public void atacar() {
	}

	@Override
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/dinamic/personajes/jon_snow.gif"));
		grafico.setIcon(imagen);
	}

	@Override
	public Jugador clone(Celda[] c) {
		// Profundidad 2 predeterminada. Retorna una unidad de mismo tipo.
		Jugador clon = new Espadachin(c);
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

	@Override
	public void guardarInicio() {
		guardarEstado("ESPADACHIN");
	}

	@Override
	public void regresarInicio() {
		reset("ESPADACHIN");
		careTaker.clearSavepoint();

	}
}