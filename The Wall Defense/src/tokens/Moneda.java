package tokens;

import Controladores.Director;
import mapa.Celda;

public abstract class Moneda extends Token {

	protected int valor;

	public Moneda(Celda c) {
		super(c);

	}

	@Override
	public void aplicar() {
		Director.getPartida().cargarDinero(this);
		destruir();
	}

	public int getValor() {
		return valor;
	}

}
