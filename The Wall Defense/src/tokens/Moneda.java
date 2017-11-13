package tokens;

import Controladores.Director;
import mapa.Celda;

public abstract class Moneda extends Token {

	protected int valor;

	public Moneda(Celda c) {
		super(c);

	}

	public void cargar() {
		Director.getPartida().cargarDinero(this);
	}

	public int getValor() {
		return valor;
	}

}
