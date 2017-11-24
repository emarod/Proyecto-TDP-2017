package jugador;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import efectos.Efecto;
import enemigo.Enemigo;
import main.Visitor;
import objetos.Temporal;
import objetos.Vida;

/*
 * Clase VisitorJugador.
 * Clase encargada de implementar correctamente las colisiones de los jugadores.
 * Especifica sus comportamientos mediante un patron de diseño visitor.
 */

public class VisitorJugador extends Visitor {

	// Atributos locales.
	protected Jugador jugador;

	// Constructor.
	public VisitorJugador(Jugador j) {
		jugador = j;
	}

	@Override
	public boolean visitJugador(Jugador j) {
		return false;
	}

	@Override
	public boolean visitEnemigo(Enemigo e) {
		e.recibirDaño(jugador.getDaño());
		return false;
	}

	@Override
	public boolean visitDisparo(DisparoJugador d) {
		return true;
	}

	@Override
	public boolean visitDisparo(DisparoEnemigo d) {
		jugador.recibirDaño(d.getDaño());
		d.destruir();
		return true;
	}

	@Override
	public boolean visitEfect(Efecto efecto) {
		efecto.aplicar(jugador);
		return true;
	}

	@Override
	public boolean visitObjeto(Temporal t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitObjeto(Vida v) {
		// TODO Auto-generated method stub
		return false;
	}
}
