package tokens;

import Controladores.Director;
import mapa.Celda;
import preciosos.ObjetoPrecioso;

public abstract class TokenPrecioso extends Token {

	protected ObjetoPrecioso precioso;

	public TokenPrecioso(Celda c, int prof) {
		super(c, prof);
	}

	public void guardar() {
		Director.getPartida().aumentarObjeto(precioso);
	}
}
