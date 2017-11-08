package objetos;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.Visitor;
import mapa.Celda;

/*
 * Clase Rock
 * Clase que determina como esta compuesta y como se comporta una roca.
 */

public class Barricada extends ObjetoPrecioso {

	// Constructor.
	public Barricada(Celda[] c, int prof) {
		super(c, prof);
		vida = 3;
		graficos = new Icon[3];
		graficos[0] = new ImageIcon(
				this.getClass().getResource("/resources/static/terrenos/barricada/barricada_1.png"));
		graficos[1] = new ImageIcon(
				this.getClass().getResource("/resources/static/terrenos/barricada/barricada_2.png"));
		graficos[2] = new ImageIcon(
				this.getClass().getResource("/resources/static/terrenos/barricada/barricada_3.png"));
		setGrafico(2);
	}

	// Metodos locales.
	public int getResistencia() {
		return vida;
	}

	@Override
	public void destruir() {

	}

	// Metodos heredados.
	public void run() {

	}

	public void setGrafico(int i) {
		grafico.setIcon(graficos[i]);
	}

	@Override
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(
				this.getClass().getResource("/resources/static/terrenos/barricada/barricada_3.png"));
		graph = 0;
		grafico.setIcon(imagen);
	}

	public void playSound() {
		celda[0].getDirector().getBancoRecursos().playBarricada();
	}

	@Override
	public boolean accept(Visitor V) {
		return V.visitObjetoPrecioso(this);
	}

	@Override
	public ObjetoPrecioso clone(Celda[] c) {
		ObjetoPrecioso clon = new Barricada(c, 3);
		return clon;
	}
}
