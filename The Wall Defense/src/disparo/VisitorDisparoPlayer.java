package disparo;

import comprables.ComprableTemporal;
import comprables.ComprableVida;
import enemigo.Enemigo;
import jugador.Jugador;
import main.Visitor;
import objetoMapa.ObjetoMapaTemporal;
import objetoMapa.ObjetoMapaVida;
import premios.PremioTemporal;
import premios.PremioVida;

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
	public boolean visitPlayer(Jugador j) {
		return true;
	}

	@Override
	public boolean visitEnemigo(Enemigo e) {
		e.recibirDaño(disparo.getDaño());
		disparo.destruir();
		return false;
	}

	@Override
	public boolean visitObjetoMapa(ObjetoMapaVida o) {
		return true;
	}

	@Override
	public boolean visitObjetoMapa(ObjetoMapaTemporal o) {
		return true;
	}

	@Override
	public boolean visitPremio(PremioVida op) {
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
	public boolean visitPremio(PremioTemporal op) {
		return false;
	}

	@Override
	public boolean visitComprable(ComprableVida comprable) {
		return false;
	}

	@Override
	public boolean visitComprable(ComprableTemporal comprable) {
		return false;
	}

}
