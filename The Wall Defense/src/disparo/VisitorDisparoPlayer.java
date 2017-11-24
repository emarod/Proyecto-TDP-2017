package disparo;

import efectos.Efecto;
import enemigo.Enemigo;
import jugador.Jugador;
import main.Visitor;
import objetos.Temporal;
import objetos.Vida;

/*
 * Clase VisitorDisparoPlayer.
 * Clase encargada de implementar correctamente las colisiones de los proyectiles de los jugadores.
 * Especifica sus comportamientos mediante un patron de diseño visitor.
 */

public class VisitorDisparoPlayer extends Visitor {

	// Atributos locales.
	protected DisparoJugador disparo;

	// Constructor
	public VisitorDisparoPlayer(DisparoJugador dp) {
		disparo = dp;
	}

	// Metodos heredados.
	@Override
	public boolean visitJugador(Jugador j) {
		return true;
	}

	@Override
	public boolean visitEnemigo(Enemigo e) {
		e.recibirDaño(disparo.getDaño());
		disparo.destruir();
		return false;
	}

	@Override
	public boolean visitObjeto(Vida o) {
		return true;
	}

	@Override
	public boolean visitObjeto(Temporal o) {
		return true;
	}

	@Override
	public boolean visitDisparo(DisparoJugador d) {
		return true;
	}

	@Override
	public boolean visitDisparo(DisparoEnemigo d) {
		// El disparo mas fuerte sobrevive
		disparo.colision(d);
		return true;
	}

	@Override
	public boolean visitEfect(Efecto efecto) {
		return true;
	}

}
