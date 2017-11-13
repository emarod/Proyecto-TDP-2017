package tokens;

import jugador.Jugador;
import mapa.Celda;
import powerUp.PowerUp;

public abstract class TokenPowerUp extends Token {

	protected PowerUp power;

	public TokenPowerUp(Celda c) {
		super(c);
	}

	public void aplicar(Jugador j) {
		power.aplicar(j);
	}

}
