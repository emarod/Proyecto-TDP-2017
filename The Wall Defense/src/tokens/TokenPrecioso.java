package tokens;

import Controladores.Director;
import mapa.Celda;
import premios.Premio;

public abstract class TokenPrecioso extends Token {

	protected Premio precioso;

	public TokenPrecioso(Celda c) {
		super(c);
	}

	@Override
	public void aplicar() {
		Director.getPartida().aumentarObjeto(precioso);
		destruir();
	}
}
