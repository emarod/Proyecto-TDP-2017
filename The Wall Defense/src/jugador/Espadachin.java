package jugador;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Controladores.Director;
import main.CONFIG;
import mapa.Celda;

/*
 * Clase Espadachin.
 * Clase que especifica las caracteristicas y comportamiento del jugador espadachin.
 */

public class Espadachin extends Jugador {

	// Constructor.
	public Espadachin(Celda c) {
		super(c);
		vida = 5;
		velocidad = 40;
		daño = 3;
		costo = 25;
		setGrafico(grafico);
	}

	// Metodos heredados.

	@Override
	public void atacar() {
		Celda siguiente = Director.getCelda(celda.getPosX() + 1, celda.getPosY());
		if (siguiente != null) {
			siguiente.getObjects()[CONFIG.PROFUNDIDAD_ENEMIGO].accept(V);
		}
		activeTask = null;
		activar();
	}

	@Override
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/dinamic/personajes/jon_snow.gif"));
		grafico.setIcon(imagen);
	}

	@Override
	public Jugador clone(Celda c) {
		// Profundidad 2 predeterminada. Retorna una unidad de mismo tipo.
		Jugador clon = new Espadachin(c);
		return clon;
	}

	@Override
	public void playSound() {

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