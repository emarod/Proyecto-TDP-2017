package jugador;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Controladores.Director;
import main.CONFIG;
import mapa.Celda;

public class Gigante extends Jugador {

	// Constructor.
	public Gigante(Celda c) {
		super(c);
		velocidad = 20;
		vida = 20;
		daño = 10;
		costo = 75;
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
		ImageIcon imagen = new ImageIcon(
				this.getClass().getResource("/resources/dinamic/personajes/gigante_atacando.gif"));
		grafico.setIcon(imagen);
	}

	@Override
	public Jugador clone(Celda c) {
		// Profundidad 2 predeterminada. Retorna una unidad de mismo tipo.
		Jugador clon = new Gigante(c);
		return clon;

	}

	@Override
	public void playSound() {

	}

	@Override
	public void guardarInicio() {
		guardarEstado("GIGANTE");
	}

	@Override
	public void regresarInicio() {
		reset("GIGANTE");

	}

}
