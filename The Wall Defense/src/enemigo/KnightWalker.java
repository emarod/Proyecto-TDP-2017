package enemigo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Celda;

public class KnightWalker extends Enemigo {

	// Constructor.
	public KnightWalker(Celda c) {
		super(c);
		puntaje = 100;
		velocidad = 50;
		vida = 8;
		daño = 2;
		graficos = new Icon[1];
		graficos[0] = new ImageIcon(
				this.getClass().getResource("/resources/dinamic/whitewalker_caballero_estatico.gif"));
	}

	// Metodos heredados.

	@Override
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(
				this.getClass().getResource("/resources/dinamic/whitewalker_caballero_estatico.gif"));
		graph = 0;
		grafico.setIcon(imagen);
	}

	public void setGraficos(Icon[] graficos, JLabel grafico) {

	}

	@Override
	public Enemigo clone(Celda c) {
		// Profundidad 1 predeterminada. Retorna una unidad de mismo tipo.
		Enemigo clon = new KnightWalker(c);
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