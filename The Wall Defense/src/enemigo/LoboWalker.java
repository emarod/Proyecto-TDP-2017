package enemigo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Celda;

public class LoboWalker extends Enemigo {

	// Constructor.
	public LoboWalker(Celda c) {
		super(c);
		puntaje = 100;
		velocidad = 50;
		vida = 4;
		daño = 2;
		graficos = new Icon[1];
		graficos[0] = new ImageIcon(
				this.getClass().getResource("/resources/dinamic/personajes/whitewalker_lobo_atacando.gif"));
	}

	// Metodos heredados.

	@Override
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(
				this.getClass().getResource("/resources/dinamic/personajes/whitewalker_lobo_atacando.gif"));
		graph = 0;
		grafico.setIcon(imagen);
	}

	public void setGraficos(Icon[] graficos, JLabel grafico) {

	}

	@Override
	public Enemigo clone(Celda c) {
		// Profundidad 1 predeterminada. Retorna una unidad de mismo tipo.
		Enemigo clon = new LoboWalker(c);
		return clon;
	}

	@Override
	public void playSound() {

	}

	@Override
	public void destruir() {
		super.destruir();
	}

}
