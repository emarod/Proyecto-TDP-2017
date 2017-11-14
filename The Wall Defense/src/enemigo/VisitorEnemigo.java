package enemigo;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import jugador.Jugador;
import main.Visitor;
import objetoMapa.ObjetoMapaTemporal;
import objetoMapa.ObjetoMapaVida;
import premios.Premio;

/*
 * Clase VisitorEnemigo.
 * Clase encargada de implementar correctamente las colisiones de los enemigos.
 * Especifica sus comportamientos mediante un patron de diseño visitor.
 */

public class VisitorEnemigo extends Visitor {

	// Atributos locales.
	protected Enemigo enemigo;

	// Constructor.
	public VisitorEnemigo(Enemigo e) {
		enemigo = e;
	}

	// Metodos heredados.
	@Override
	public boolean visitObstaculo(ObjetoMapaVida o) {
		o.recibirDaño(enemigo.getDaño());
		return false;
	}

	@Override
	public boolean visitPlayer(Jugador j) {
		j.recibirDaño(enemigo.getDaño());
		return false;
	}

	@Override
	public boolean visitEnemigo(Enemigo e) {
		return false;
	}

	@Override
	public boolean visitObstaculo(ObjetoMapaTemporal o) {
		o.aplicarEfecto(enemigo);
		return true;
	}

	@Override
	public boolean visitObjetoPrecioso(Premio op) {
		op.recibirDaño(enemigo.getDaño());
		return false;
	}

	@Override
	public boolean visitDisparo(DisparoJugador d) {
		enemigo.recibirDaño(d.getDaño());
		d.destruir();
		return true;
	}

	@Override
	public boolean visitDisparo(DisparoEnemigo d) {
		return true;
	}
}