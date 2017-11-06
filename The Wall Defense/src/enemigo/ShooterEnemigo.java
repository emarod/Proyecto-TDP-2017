package enemigo;

import java.util.concurrent.Future;

import mapa.Celda;

public abstract class ShooterEnemigo extends Enemigo{
	
	//Atributos locales.
	protected Future<?> shot;
	protected int velocidad_disparo;
	protected int disparos_simultaneos;
	protected int disparos_en_ejecucion;

	public ShooterEnemigo(Celda[] c, int prof) {
		super(c, prof);
		// TODO Auto-generated constructor stub
	}

}