package efectos;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import enemigo.Enemigo;
import jugador.Jugador;
import main.Visitor;
import objetos.Temporal;
import objetos.Vida;

public class VisitorEfecto extends Visitor {

	protected Efecto efecto;

	public VisitorEfecto(Efecto e) {
		efecto = e;
	}

	@Override
	public boolean visitJugador(Jugador j) {
		efecto.aplicar(j);
		return true;
	}

	@Override
	public boolean visitDisparo(DisparoJugador d) {
		return true;
	}

	@Override
	public boolean visitDisparo(DisparoEnemigo d) {
		return true;
	}

	@Override
	public boolean visitEnemigo(Enemigo e) {
		efecto.aplicar(e);
		return true;
	}

	@Override
	public boolean visitObjeto(Vida op) {
		return true;
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
