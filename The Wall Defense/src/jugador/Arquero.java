package jugador;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Controladores.Director;
import disparo.DisparoArquero;
import mapa.Celda;

/*
 * Clase Arquero.
 * Clase que especifica las caracteristicas y comportamiento del jugador arquero.
 */

public class Arquero extends Shooter {

	// Constructor.
	public Arquero(Celda[] c) {
		super(c);
		velocidad = 15;
		vida = 2;
		daño = 1;
		costo = 50;
		velocidad_disparo = 75;
		graficos = new Icon[5];
		// Areglo que divide el sprite en capas para poder simular el movimiento.
		graficos[0] = new ImageIcon(
				this.getClass().getResource("/resources/static/ygritte_atacando/ygritte_atacando_0.png"));
		graficos[1] = new ImageIcon(
				this.getClass().getResource("/resources/static/ygritte_atacando/ygritte_atacando_1.png"));
		graficos[2] = new ImageIcon(
				this.getClass().getResource("/resources/static/ygritte_atacando/ygritte_atacando_2.png"));
		graficos[3] = new ImageIcon(
				this.getClass().getResource("/resources/static/ygritte_atacando/ygritte_atacando_3.png"));
		graficos[4] = new ImageIcon(
				this.getClass().getResource("/resources/static/ygritte_atacando/ygritte_atacando_4.png"));
		setGrafico(0);
	}

	// Metodos locales.
	public void animarDisparo() {
		if (graph < 4) {
			graph++;
		}
		setGrafico(graph);
		if (graph == 4) {
			setGrafico(0);
		}
	}

	public void setGrafico(int i) {
		getGrafico().setIcon(graficos[i]);
	}

	public int getVelocidadDisparo() {
		return velocidad_disparo;
	}

	// Metodos heredados.
	@Override
	public Jugador clone(Celda[] c) {
		// Profundidad 2 predeterminada. Retorna una unidad de mismo tipo.
		Jugador clon = new Arquero(c);
		return clon;
	}

	@Override
	public void playSound() {
		Director.getBancoRecursos().playFlecha();
	}

	@Override
	public void destruir() {
		super.destruir();
	}

	@Override
	public void atacar() {
		if (shot == null || shot.isCancelled() || shot.isDone()) {
			shot = new DisparoArquero(this).getTask();
		}
		graph = 0;
	}

	@Override
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(
				this.getClass().getResource("/resources/static/ygritte_atacando/ygritte_atacando_0.png"));
		graph = 0;
		grafico.setIcon(imagen);
	}

	@Override
	public int getDaño() {
		return daño;
	}

	@Override
	public void mover() {
	}
}