package main;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import efectos.Efecto;
import enemigo.Enemigo;
import jugador.Jugador;
import objetos.Temporal;
import objetos.Vida;

public abstract class Visitor {

	// Metodos abstractos.

	public abstract boolean visitEnemigo(Enemigo a);

	public abstract boolean visitJugador(Jugador m);

	public abstract boolean visitDisparo(DisparoJugador a);

	public abstract boolean visitDisparo(DisparoEnemigo m);

	public abstract boolean visitObjeto(Temporal t);

	public abstract boolean visitObjeto(Vida v);

	public abstract boolean visitEfect(Efecto efecto);

}
