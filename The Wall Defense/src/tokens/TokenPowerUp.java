package tokens;

import javax.swing.JLabel;

import Controladores.Director;
import efectos.PowerUp;
import main.CONFIG;
import main.GameObject;
import mapa.Celda;

public abstract class TokenPowerUp extends Token {

	protected PowerUp power;

	public TokenPowerUp(Celda c) {
		super(c);
	}

	@Override
	public void aplicar() {
		JLabel celdaLabel = Director.getMapa().getCeldaLabel();
		int x_jugador = Math.round(celdaLabel.getX() / 64);
		int y_jugador = Math.round(celdaLabel.getY() / 64);
		GameObject jugador = Director.getCelda(x_jugador, y_jugador).getObjects()[CONFIG.PROFUNDIDAD_JUGADOR];
		if (jugador != null) {
			jugador.accept(power.getVisitor());
			destruir();
		}
	}

}
