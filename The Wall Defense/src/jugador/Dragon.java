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

<<<<<<< HEAD
public class Dragon extends Shooter {

	// Atributos locales.

	// Constructor.
	public Dragon(Celda[] c) {
		super(c);
		velocidad = 20;
		vida = 5;
		daño = 3;
		disparos_simultaneos = 1;
		disparos_en_ejecucion = 0;
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
=======
public class Dragon extends PerfilJugador {
	
	//Atributos locales.
	protected Future<?> shot;
	protected int velocidad_disparo;
	protected int disparos_simultaneos;
	protected int disparos_en_ejecucion;
	
	//Constructor.
	public Dragon() {
		velocidad_jugador=20;
		resistencia=5;
		daño=1;
		disparos_simultaneos=1;
		disparos_en_ejecucion=0;
		velocidad_disparo=75;
		costo=75;
		graficos= new Icon[8];
		graficos[0]=new ImageIcon(this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_0.png"));
		graficos[1]=new ImageIcon(this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_1.png"));
		graficos[2]=new ImageIcon(this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_2.png"));
		graficos[3]=new ImageIcon(this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_3.png"));
		graficos[4]=new ImageIcon(this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_4.png"));
		graficos[5]=new ImageIcon(this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_5.png"));
		graficos[6]=new ImageIcon(this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_6.png"));
		graficos[7]=new ImageIcon(this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_7.png"));
>>>>>>> master
	}

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

	public void restarDisparosEnEjecucion() {
		disparos_en_ejecucion--;
	}

	public int getDisparosEnEjecucion() {
		return disparos_en_ejecucion;
	}

	// Metodos heredados.

	@Override
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/dinamic/dragon_atacando.gif"));
		graph = 0;
		grafico.setIcon(imagen);
	}

	@Override
	public Jugador clone(Celda[] c) {
		// Profundidad 2 predeterminada. Retorna una unidad de mismo tipo.
		Jugador clon = new Dragon(c);
		return clon;
	}
<<<<<<< HEAD

	@Override
	public void destruir() {
		super.destruir();
		celda[1] = null;
=======
	
	public void destruir(){
		jugador.getCeldas()[0].getEscenario().remove(jugador.getGrafico());
		jugador.getCeldas()[0].getDirector().desactivar(this.getJugador());
		jugador.getCeldas()[1].getEscenario().remove(jugador.getGrafico());
		jugador.getCeldas()[1].getDirector().desactivar(this.getJugador());
>>>>>>> master
	}

	@Override
	public void playSound() {
		Director.getBancoRecursos().playBolaFuego();
	}

	@Override
	public void atacar() {
		// if(disparos_en_ejecucion<disparos_simultaneos){
		if (shot == null || shot.isCancelled() || shot.isDone()) {
			playSound();
			shot = new DisparoDragon(this).getTask();
			disparos_en_ejecucion++;
		}
		graph = 0;
	}

	@Override
	public int getDaño() {
		return daño;
	}

	@Override
	public void mover() {
	}
}
