package jugador;

import comprables.ComprableTemporal;
import comprables.ComprableVida;
import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import enemigo.Enemigo;
import main.Visitor;
import objetoMapa.ObjetoMapa;
import objetoMapa.ObjetoMapaTemporal;
import objetoMapa.ObjetoMapaVida;
import premios.PremioTemporal;
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
		System.out.println("el enemigo visita a jugador");
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
	public boolean visitPremio(PremioTemporal op) {
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
}
