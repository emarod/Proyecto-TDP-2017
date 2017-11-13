package preciosos;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.Visitor;
import mapa.Celda;

/*
 * Clase Bomba.
 * Clase que especifica el comportamiento del poder bomba.
 */

public class Bomba extends ObjetoPrecioso {

	// Constructor.
	public Bomba(Celda[] c) {
		super(c);
		vida = 1;
		graficos = new Icon[1];
		graficos[0] = new ImageIcon(this.getClass().getResource("/resources/static/objetospreciosos/bomb.png"));
		// graficos[1] = new
		// ImageIcon(this.getClass().getResource("/resources/dinamic/explosion.gif"));
		// setGrafico(new JLabel(new
		// ImageIcon(this.getClass().getResource("/resources/static/objetospreciosos/bomb.png"))));
		setGrafico(0);
	}

	public Bomba() {
	}

	// Metodos locales.
	public int getResistencia() {
		return vida;
	}

	@Override
	public void destruir() {
		super.destruir();
	}

	// Metodos heredados.

	public void setGrafico(int i) {
		grafico.setIcon(graficos[i]);
	}

	@Override
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/static/objetospreciosos/bomb.png"));
		graph = 0;
		grafico.setIcon(imagen);
	}

	public void playSound() {
	}

	@Override
	public boolean accept(Visitor V) {
		return V.visitObjetoPrecioso(this);
	}

	@Override
	public ObjetoPrecioso clone(Celda[] c) {
		ObjetoPrecioso clon = new Bomba(c);
		return clon;
	}

}
