package main;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import enemigo.Enemigo;
import jugador.Jugador;
import obstaculos.ObstaculoTemporal;
import obstaculos.ObstaculoVida;
import preciosos.ObjetoPrecioso;

/*
 * Clase Visitor.
 * Clase que generaliza la noción del visitador.
 * Esta clase es parte de la aplicación del diseño visitor.
 */

public abstract class Visitor {

	// Metodos abstractos.
	public abstract boolean visitObstaculo(ObstaculoVida o);

	public abstract boolean visitObstaculo(ObstaculoTemporal o);

	// public abstract boolean VisitBarricada(Barricada b);
	// public abstract boolean VisitRock(Rock r);

	public abstract boolean visitPlayer(Jugador j);

	public abstract boolean visitDisparo(DisparoJugador d);

	public abstract boolean visitDisparo(DisparoEnemigo d);

	public abstract boolean visitEnemigo(Enemigo e);

	public abstract boolean visitObjetoPrecioso(ObjetoPrecioso op);
}
