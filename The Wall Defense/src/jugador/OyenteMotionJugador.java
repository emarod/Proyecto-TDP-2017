package jugador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import Controladores.Director;
import main.CONFIG;
import main.GameObject;

public class OyenteMotionJugador extends MouseMotionAdapter {

	@Override
	public void mouseDragged(MouseEvent e) {
		int x_mouse = Director.getMapa().get_x_mouse();
		int y_mouse = Director.getMapa().get_y_mouse();
		GameObject player = Director.getMapa().ver()[CONFIG.PROFUNDIDAD_JUGADOR];
		if (player != null) {
			player.getGrafico().setBounds(x_mouse, y_mouse, 64, 64);
		}
	}
}
