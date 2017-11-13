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
	public Caballero(Celda[] c) {
		super(c);
		vida = 10;
		velocidad = 10;
		costo = 30;
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
		Jugador clon = new Caballero(c);
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
		guardarEstado("CABALLERO");
	}

	@Override
	public void regresarInicio() {
		reset("CABALLERO");
		careTaker.clearSavepoint();

	}
}