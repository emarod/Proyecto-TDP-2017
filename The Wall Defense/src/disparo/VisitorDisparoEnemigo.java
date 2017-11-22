package disparo;

import comprables.ComprableTemporal;
import comprables.ComprableVida;
import efectos.Efecto;
import enemigo.Enemigo;
import jugador.Jugador;
import main.Visitor;
import objetoMapa.ObjetoMapaTemporal;
import objetoMapa.ObjetoMapaVida;
import premios.PremioVida;

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
	public boolean visitObjetoMapa(ObjetoMapaVida o) {
		o.recibirDaño(disparo.getDaño());
		disparo.destruir();
		return false;
	}

	@Override
	public boolean visitPlayer(Jugador j) {
		j.recibirDaño(disparo.getDaño());
		disparo.destruir();
		return false;
	}

	@Override
	public boolean visitEnemigo(Enemigo e) {
		return true;
	}

	@Override
	public boolean visitObjetoMapa(ObjetoMapaTemporal o) {
		return true;
	}

	@Override
	public boolean visitPremio(PremioVida op) {
		disparo.destruir();
		return false;
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
	public boolean visitComprable(ComprableVida comprable) {
		disparo.destruir();
		return false;
	}

	@Override
	public boolean visitComprable(ComprableTemporal comprable) {
		return true;
	}

	@Override
	public boolean visitEfect(Efecto efecto) {
		return true;
	}

}
