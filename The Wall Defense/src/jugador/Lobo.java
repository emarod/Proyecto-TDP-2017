package jugador;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Celda;

/*
 * Clase Lobo.
 * Clase que especifica las caracteristicas y comportamiento del jugador lobo.
 */

public class Lobo extends Jugador {

	// Constructor.
	public Lobo(Celda c) {
		super(c);
		vida = 3;
		daño = 3;
		velocidad = 10;
		costo = 8;
		setGrafico(grafico);
	}

	// Metodos heredados.

	@Override
	public void atacar() {
	}

	@Override
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(
				this.getClass().getResource("/resources/dinamic/personajes/lobo_estatico.gif"));
		grafico.setIcon(imagen);
	}

	@Override
	public Jugador clone(Celda c) {
		// Profundidad 2 predeterminada. Retorna una unidad de mismo tipo.
		Jugador clon = new Lobo(c);
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
	public void guardarInicio() {
		guardarEstado("LOBO");
	}

	@Override
	public void regresarInicio() {
		reset("LOBO");
		careTaker.clearSavepoint();

	}

}
