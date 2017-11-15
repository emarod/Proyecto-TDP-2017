package main;

import comprables.ComprableTemporal;
import comprables.ComprableVida;
import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import efectos.Efecto;
import enemigo.Enemigo;
import jugador.Jugador;
import objetoMapa.ObjetoMapaTemporal;
import objetoMapa.ObjetoMapaVida;
import premios.PremioTemporal;
import premios.PremioVida;

/*
 * Clase Visitor.
 * Clase que generaliza la noción del visitador.
 * Esta clase es parte de la aplicación del diseño visitor.
 */

public abstract class Visitor {

	// Metodos abstractos.

	public abstract boolean visitPlayer(Jugador j);

	public abstract boolean visitDisparo(DisparoJugador d);

	public abstract boolean visitDisparo(DisparoEnemigo d);

	public abstract boolean visitEnemigo(Enemigo e);

	public abstract boolean visitPremio(PremioTemporal op);

	public abstract boolean visitPremio(PremioVida op);

	public abstract boolean visitComprable(ComprableVida comprable);

	public abstract boolean visitComprable(ComprableTemporal comprable);

	public abstract boolean visitObjetoMapa(ObjetoMapaVida o);

	public abstract boolean visitObjetoMapa(ObjetoMapaTemporal o);

	public abstract boolean visitEfect(Efecto efecto);

}
