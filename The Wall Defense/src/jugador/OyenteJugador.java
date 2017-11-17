package jugador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import Controladores.Director;
import main.CONFIG;
import main.GameObject;
import mapa.Celda;

public class OyenteJugador extends MouseAdapter {

	protected GameObject player;

	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		int x_mouse = Director.getMapa().get_x_mouse();
		int y_mouse = Director.getMapa().get_y_mouse();
		int x_celd = Math.round(x_mouse / 64);
		int y_celd = Math.round(y_mouse / 64);
		Celda celda = Director.getCelda(x_celd, y_celd);
		GameObject[] objetos = Director.getMapa().ver();
		player = objetos[CONFIG.PROFUNDIDAD_JUGADOR];
		System.out.println(player + " " + objetos[1] + " xymouse " + x_celd + " " + y_celd);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
		int x_mouse = Director.getMapa().get_x_mouse();
		int y_mouse = Director.getMapa().get_y_mouse();
		int x_celd = Math.round(x_mouse / 64);
		int y_celd = Math.round(y_mouse / 64);
		Celda celda = Director.getCelda(x_celd, y_celd);
		GameObject[] objetosCelda1 = celda.getObjects();
		if (player != null) {
			objetosCelda1[CONFIG.PROFUNDIDAD_JUGADOR] = player;
			player.getCelda().getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] = null;
			player.setCelda(celda);
			int x_terreno = objetosCelda1[0].getGrafico().getX();
			int y_terreno = objetosCelda1[0].getGrafico().getY();
			player.getGrafico().setBounds(x_terreno, y_terreno, 64, 64);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		super.mouseEntered(e);
		JLabel graficoTerreno = (JLabel) e.getSource();
		Director.getMapa().set_x_mouse(graficoTerreno.getX());
		Director.getMapa().set_y_mouse(graficoTerreno.getY());
	}

	public void setJugador(Jugador p) {
		player = p;
	}

	public GameObject getJugador() {
		return player;
	}

}
