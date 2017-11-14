package efectos;

import jugador.Jugador;
import mapa.Celda;

public abstract class PowerUpVida extends PowerUp {

	protected PowerUpVida(Celda c) {
		super(c);
	}

	@Override
	public void aplicar(Jugador j) {

	}

}
