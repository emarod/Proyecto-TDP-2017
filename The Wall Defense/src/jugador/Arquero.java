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
	public Arquero(Celda c) {
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
		// disparo = new DisparoArquero(this);
	}

	// Metodos locales.

	// Metodos heredados.
	@Override
	public Jugador clone(Celda c) {
		// Profundidad 2 predeterminada. Retorna una unidad de mismo tipo.
		Shooter clon = new Arquero(c);
		// clon.getDisparo().setCelda();
		// clon.getDisparo().activar();
		System.out.println("Clonado");
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
		if (disparo == null) {
			disparo = new DisparoArquero(this);
			disparo.setCelda();
			disparo.activar();
		}
		graph = 0;
		activeTask = null;
		activar();
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

	@Override
	public void guardarInicio() {
		guardarEstado("ARQUERO");
	}

	@Override
	public void regresarInicio() {
		reset("ARQUERO");
		careTaker.clearSavepoint();

	}
}