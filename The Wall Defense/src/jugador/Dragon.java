package jugador;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Controladores.Director;
import disparo.DisparoDragon;
import mapa.Celda;

/*
 * Clase Dragon.
 * Clase que especifica las caracteristicas y comportamiento del jugador dragon.
 */

public class Dragon extends Shooter {

	// Atributos locales.

	// Constructor.
	public Dragon(Celda c) {
		super(c);
		velocidad = 20;
		vida = 5;
		daño = 3;
		costo = 75;
		velocidad_disparo = 75;
		graficos = new Icon[8];
		graficos[0] = new ImageIcon(
				this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_0.png"));
		graficos[1] = new ImageIcon(
				this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_1.png"));
		graficos[2] = new ImageIcon(
				this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_2.png"));
		graficos[3] = new ImageIcon(
				this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_3.png"));
		graficos[4] = new ImageIcon(
				this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_4.png"));
		graficos[5] = new ImageIcon(
				this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_5.png"));
		graficos[6] = new ImageIcon(
				this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_6.png"));
		graficos[7] = new ImageIcon(
				this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_7.png"));
		setGrafico(0);
		// disparo = new DisparoDragon(this);
	}

	@Override
	public int getVelocidadDisparo() {
		return velocidad_disparo;
	}
	// Metodos heredados.

	@Override
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/dinamic/dragon_atacando.gif"));
		graph = 0;
		grafico.setIcon(imagen);
	}

	@Override
	public Jugador clone(Celda c) {
		// Profundidad 2 predeterminada. Retorna una unidad de mismo tipo.
		Shooter clon = new Dragon(c);
		return clon;
	}

	@Override
	public void destruir() {
		super.destruir();
	}

	@Override
	public void playSound() {
		Director.getBancoRecursos().playBolaFuego();
	}

	@Override
	public void atacar() {
		if (disparo == null) {
			playSound();
			disparo = new DisparoDragon(this);
			disparo.activar();
		}
		graph = 0;
		activeTask = null;
		activar();
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
		guardarEstado("DRAGON");
	}

	@Override
	public void regresarInicio() {
		reset("DRAGON");
		careTaker.clearSavepoint();

	}
}
