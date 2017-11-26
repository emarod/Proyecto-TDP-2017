package enemigo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Celda;

/*
 * Clase WhiteWalker.
 * Clase que especifica las caracteristicas y comportamiento del enemigo whitewalker.
 */

public class WhiteWalker extends Enemigo {

	// Atributos locales.

	// Constructor.
	public WhiteWalker(Celda c) {
		super(c);
		puntaje = 100;
		velocidad = 50;
		vida = 6;
		daño = 4;
		graficos = new Icon[11];
		graficos[0] = new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando00.png"));
		graficos[1] = new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando01.png"));
		graficos[2] = new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando02.png"));
		graficos[3] = new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando03.png"));
		graficos[4] = new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando04.png"));
		graficos[5] = new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando05.png"));
		graficos[6] = new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando06.png"));
		graficos[7] = new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando07.png"));
		graficos[8] = new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando08.png"));
		graficos[9] = new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando09.png"));
		graficos[10] = new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando10.png"));
	}

	// Metodos heredados.

	@Override
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(
				this.getClass().getResource("/resources/static/ww_atacando/ww_atacando00.png"));
		graph = 0;
		grafico.setIcon(imagen);
	}

	public void setGraficos(Icon[] graficos, JLabel grafico) {

	}

	@Override
	public int getPuntaje() {
		return puntaje;
	}

	@Override
	public Enemigo clone(Celda c) {
		// Profundidad 1 predeterminada. Retorna una unidad de mismo tipo.
		Enemigo clon = new WhiteWalker(c);
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
	public void guardarInicio() {
		guardarEstado("WW");
	}

	@Override
	public void regresarInicio() {
		reset("WW");
		careTaker.clearSavepoint();

	}
}