package jugador;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparo.DisparoArquero;
import mapa.Celda;

/*
 * Clase Arquero.
 * Clase que especifica las caracteristicas y comportamiento del jugador arquero.
 */

public class Arquero extends Shooter {

	// Constructor.
	public Arquero(Celda[] c, int prof) {
		super(c, prof);
		velocidad = 15;
		vida = 2;
		daño = 1;
		disparos_simultaneos = 1;
		disparos_en_ejecucion = 0;
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

	public void restarDisparosEnEjecucion() {
		disparos_en_ejecucion--;
	}

	public int getDisparosEnEjecucion() {
		return disparos_en_ejecucion;
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
		Jugador clon = new Arquero(c, 2);
		return clon;
	}

	@Override
	public void playSound() {
		getCeldas()[0].getDirector().getBancoRecursos().playFlecha();
	}

	@Override
	public void destruir() {
		super.destruir();
	}

	@Override
	public void atacar() {
		// if(disparos_en_ejecucion<disparos_simultaneos){
		if (shot == null || shot.isCancelled() || shot.isDone()) {
			shot = new DisparoArquero(this, 6).getTask();
			disparos_en_ejecucion++;
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