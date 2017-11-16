package enemigo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Controladores.Director;
import disparo.DisparoNightKing;
import mapa.Celda;

/*
 * Clase NightKing.
 * Clase que especifica las caracteristicas y comportamiento del enemigo nightking.
 */

public class NightKing extends ShooterEnemigo {

	// Atributos locales.

	// Constructor.
	public NightKing(Celda c) {
		super(c);
		puntaje = 200;
		velocidad = 100;
		daño = 3;
		vida = 6;
		graficos = new Icon[14];
		graficos[0] = new ImageIcon(
				this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando00.png"));
		graficos[1] = new ImageIcon(
				this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando01.png"));
		graficos[2] = new ImageIcon(
				this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando02.png"));
		graficos[3] = new ImageIcon(
				this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando03.png"));
		graficos[4] = new ImageIcon(
				this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando04.png"));
		graficos[5] = new ImageIcon(
				this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando05.png"));
		graficos[6] = new ImageIcon(
				this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando06.png"));
		graficos[7] = new ImageIcon(
				this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando07.png"));
		graficos[8] = new ImageIcon(
				this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando08.png"));
		graficos[9] = new ImageIcon(
				this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando09.png"));
		graficos[10] = new ImageIcon(
				this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando10.png"));
		graficos[11] = new ImageIcon(
				this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando11.png"));
		graficos[12] = new ImageIcon(
				this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando12.png"));
		graficos[13] = new ImageIcon(
				this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando13.png"));
	}

	// Metodos locales.

	@Override
	public void setGrafico(int i) {
		getGrafico().setIcon(graficos[i]);
	}

	// Metodos heredados.

	public void atacar() {
		if (disparo == null) {
			disparo = new DisparoNightKing(this);
			disparo.activar();
		}
		graph = 0;
		activeTask = null;
		activar();
	}

	@Override
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(
				this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando00.png"));
		graph = 0;
		grafico.setIcon(imagen);
	}

	public void setGraficos(Icon[] graficos, JLabel grafico) {

	}

	@Override
	public void destruir() {
		super.destruir();
	}

	@Override
	public int getPuntaje() {
		return puntaje;
	}

	@Override
	public void run() {
		atacar();
	}

	@Override
	public Enemigo clone(Celda c) {
		// Profundidad 1 predeterminada. Retorna una unidad de mismo tipo.
		Enemigo clon = new NightKing(c);
		return clon;
	}

	@Override
	public void playSound() {
		Director.getBancoRecursos().playFlecha();
	}

	@Override
	public void guardarInicio() {
		guardarEstado("NK");
	}

	@Override
	public void regresarInicio() {
		reset("NK");
		careTaker.clearSavepoint();

	}
}
