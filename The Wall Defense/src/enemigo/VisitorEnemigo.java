package enemigo;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import efectos.Efecto;
import jugador.Jugador;
import main.Visitor;
import objetos.Temporal;
import objetos.Vida;

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
	public boolean visitObjeto(Vida o) {
		o.recibirDaño(enemigo.getDaño());
		return false;
	}

	@Override
	public boolean visitJugador(Jugador j) {
		System.out.println("Enemigo visita jugador");
		enemigo.accept(j.getVisitor());
		j.recibirDaño(enemigo.getDaño());
		return false;
	}

	@Override
	public boolean visitEnemigo(Enemigo e) {
		return false;
	}

	@Override
	public boolean visitObjeto(Temporal o) {
		o.aplicarEfecto(enemigo);
		return true;
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

	@Override
	public boolean visitEfect(Efecto efecto) {
		System.out.println("Inicio visitor enemigo");
		// efecto.aplicar(enemigo);
		// System.out.println("Fin visitor enemigo");
		return true;
	}
}