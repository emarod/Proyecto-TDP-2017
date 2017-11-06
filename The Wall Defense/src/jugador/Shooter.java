package jugador;

import java.util.concurrent.Future;

import mapa.Celda;

public abstract class Shooter extends Jugador{
	
	//Atributos locales.
	protected Future<?> shot;
	protected int velocidad_disparo;
	protected int disparos_simultaneos;
	protected int disparos_en_ejecucion;

	public Shooter(Celda[] c, int prof) {
		super(c, prof);
		// TODO Auto-generated constructor stub
	}

}
