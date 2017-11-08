package enemigo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparo.DisparoEnemigo;
import main.GameObject;
import mapa.Celda;

/*
 * Clase NightKing.
 * Clase que especifica las caracteristicas y comportamiento del enemigo nightking.
 */

public class NightKing extends ShooterEnemigo {

	// Atributos locales.

	// Constructor.
	public NightKing(Celda[] c, int prof) {
		super(c, prof);
		puntaje = 200;
		velocidad = 50;
		daño = 1;
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

	public int getVelocidadDisparo() {
		return velocidad_disparo;
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

	public void restarDisparosEnEjecucion() {
		disparos_en_ejecucion--;
	}

	// Metodos heredados.
	@Override
	public void atacar() {
		if (disparos_en_ejecucion < disparos_simultaneos) {
			playSound();
			shot = new DisparoEnemigo(this, 6).getTask();
			disparos_en_ejecucion++;
		}
		graph = 0;
	}

	@Override
	public void mover() {
		Celda siguiente;
		boolean detener = false;
		int xCelda = getCeldas()[0].getPosX();
		int yCelda = getCeldas()[0].getPosY();
		int xGrafico = getGrafico().getX();
		int yGrafico = getGrafico().getY();
		siguiente = getCeldas()[0].getCelda(xCelda - 1, yCelda);
		for (int i = 0; i < 7; i++) {
			GameObject objeto = siguiente.getObjects()[i];
			if (objeto != null && !objeto.accept(getVisitor())) {
				detener = true;
			}
		}
		if (!detener && xCelda != 0) {
			getGrafico().setBounds(xGrafico - 64, yGrafico, 64, 64);
			intercambiar_celdas(siguiente);
		}
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
		System.out.println("Destruir WhiteWalker");
	}

	@Override
	public int getPuntaje() {
		return puntaje;
	}

	@Override
	public Enemigo clone(Celda[] c) {
		// Profundidad 1 predeterminada. Retorna una unidad de mismo tipo.
		Enemigo clon = new NightKing(c, 1);
		return clon;
	}

	@Override
	public void playSound() {
		getCeldas()[0].getDirector().getBancoRecursos().playFlecha();
	}

	@Override
	public int getDaño() {
		return daño;
	}
}
