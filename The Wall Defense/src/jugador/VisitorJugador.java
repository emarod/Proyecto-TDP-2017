package jugador;

import comprables.ComprableTemporal;
import comprables.ComprableVida;
import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import efectos.Efecto;
import enemigo.Enemigo;
import main.Visitor;
import objetoMapa.ObjetoMapa;
import objetoMapa.ObjetoMapaTemporal;
import objetoMapa.ObjetoMapaVida;
import premios.PremioVida;

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

	// Metodos locales.
	public boolean visitObstaculo(ObjetoMapa o) {
		return false;
	}

	@Override
	public boolean visitPlayer(Jugador j) {
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
	public boolean visitComprable(ComprableVida comprable) {
		return false;
	}

	@Override
	public boolean visitComprable(ComprableTemporal comprable) {
		return false;
	}

	@Override
	public boolean visitPremio(PremioVida op) {
		return false;
	}

	@Override
	public boolean visitObjetoMapa(ObjetoMapaVida o) {
		return false;
	}

	@Override
	public boolean visitObjetoMapa(ObjetoMapaTemporal o) {
		return false;
	}

	@Override
	public boolean visitEfect(Efecto efecto) {
		efecto.aplicar(jugador);
		return true;
	}
}
