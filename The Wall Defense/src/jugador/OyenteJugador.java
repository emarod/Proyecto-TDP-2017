package jugador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import Controladores.Director;
import main.CONFIG;
import main.GameObject;
import mapa.Celda;

public class OyenteJugador extends MouseAdapter {

	@Override
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
		int x_mouse = Director.getMapa().get_x_mouse();
		int y_mouse = Director.getMapa().get_y_mouse();
		int x_celd = Math.round(x_mouse / 64);
		int y_celd = Math.round(y_mouse / 64);
		Celda celda = Director.getCelda(x_celd, y_celd);
		Jugador jugador = (Jugador) celda.getObjects()[CONFIG.PROFUNDIDAD_JUGADOR];
		if (jugador != null) {
			GameObject[] objetosCelda = celda.getObjects();
			jugador.getCelda().getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] = null;
			jugador.setCelda(celda);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		super.mouseEntered(e);
		JLabel graficoTerreno = (JLabel) e.getSource();
		Director.getMapa().set_x_mouse(graficoTerreno.getX());
		Director.getMapa().set_y_mouse(graficoTerreno.getY());
	}

}
