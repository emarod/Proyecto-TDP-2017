package main;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import enemigo.Enemigo;
import jugador.Jugador;
import objetoMapa.ObjetoMapaTemporal;
import objetoMapa.ObjetoMapaVida;
import premios.Premio;

/*
 * Clase Visitor.
 * Clase que generaliza la noción del visitador.
 * Esta clase es parte de la aplicación del diseño visitor.
 */

public abstract class Visitor {

	// Metodos abstractos.
	public abstract boolean visitObstaculo(ObjetoMapaVida o);

	public abstract boolean visitObstaculo(ObjetoMapaTemporal o);

	// public abstract boolean VisitBarricada(Barricada b);
	// public abstract boolean VisitRock(Rock r);

	public abstract boolean visitPlayer(Jugador j);

	public abstract boolean visitDisparo(DisparoJugador d);

	public abstract boolean visitDisparo(DisparoEnemigo d);

	public abstract boolean visitEnemigo(Enemigo e);

	public abstract boolean visitObjetoPrecioso(Premio op);
}
