package disparo;

import efectos.Efecto;
import enemigo.Enemigo;
import jugador.Jugador;
import main.Visitor;
import objetos.Temporal;
import objetos.Vida;

/*
 * Clase VisitorDisparoEnemigo.
 * Clase encargada de implementar correctamente las colisiones de los proyectiles de los enemigos.
 * Especifica sus comportamientos mediante un patron de diseño visitor.
 */

public class VisitorDisparoEnemigo extends Visitor {

	// Atributos locales.
	protected DisparoEnemigo disparo;

	public VisitorDisparoEnemigo(DisparoEnemigo dp) {
		disparo = dp;
	}

	// Metodos heredados.
	@Override
	public boolean visitJugador(Jugador j) {
		j.recibirDaño(disparo.getDaño());
		disparo.destruir();
		return false;
	}

	@Override
	public boolean visitEnemigo(Enemigo e) {
		return true;
	}

	@Override
	public boolean visitDisparo(DisparoJugador d) {
		disparo.colision(d);
		return true;
	}

	@Override
	public boolean visitDisparo(DisparoEnemigo d) {
		return true;
	}

	@Override
	public boolean visitObjeto(Vida v) {
		v.recibirDaño(disparo.getDaño());
		return false;
	}

	@Override
	public boolean visitObjeto(Temporal t) {
		return true;
	}

	@Override
	public boolean visitEfect(Efecto efecto) {
		return true;
	}

}
