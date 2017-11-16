package main;

import jugador.Shooter;

public class Animator implements Runnable {

	protected Shooter arquero;

	public void setUnit(Shooter arquero) {
		this.arquero = arquero;
	}

	@Override
	public void run() {
		arquero.animarDisparo();
	}
}
