package enemigo;

import comprables.ComprableTemporal;
import comprables.ComprableVida;
import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import efectos.Efecto;
import jugador.Jugador;
import main.Visitor;
import objetoMapa.ObjetoMapaTemporal;
import objetoMapa.ObjetoMapaVida;
import premios.PremioVida;

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
	public boolean visitObjetoMapa(ObjetoMapaVida o) {
		o.recibirDaño(enemigo.getDaño());
		return false;
	}

	@Override
	public boolean visitPlayer(Jugador j) {
		System.out.println("Enemigo visita jugador");
		j.recibirDaño(enemigo.getDaño());
		return false;
	}

	@Override
	public boolean visitEnemigo(Enemigo e) {
		return false;
	}

	@Override
	public boolean visitObjetoMapa(ObjetoMapaTemporal o) {
		o.aplicarEfecto(enemigo);
		return true;
	}

	@Override
	public boolean visitPremio(PremioVida op) {
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

	@Override
	public boolean visitComprable(ComprableVida comprable) {
		return false;
	}

	@Override
	public boolean visitComprable(ComprableTemporal comprable) {
		return false;
	}

	@Override
	public boolean visitEfect(Efecto efecto) {
		System.out.println("Inicio visitor enemigo");
		// efecto.aplicar(enemigo);
		// System.out.println("Fin visitor enemigo");
		return true;
	}
}