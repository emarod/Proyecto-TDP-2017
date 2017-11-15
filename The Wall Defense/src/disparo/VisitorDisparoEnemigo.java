package disparo;

import comprables.ComprableTemporal;
import comprables.ComprableVida;
import efectos.Efecto;
import enemigo.Enemigo;
import jugador.Jugador;
import main.Visitor;
import objetoMapa.ObjetoMapaTemporal;
import objetoMapa.ObjetoMapaVida;
import premios.PremioTemporal;
import premios.PremioVida;

/*
 * Clase VisitorDisparoEnemigo.
 * Clase encargada de implementar correctamente las colisiones de los proyectiles de los enemigos.
 * Especifica sus comportamientos mediante un patron de diseño visitor.
 */

public class VisitorDisparoEnemigo extends Visitor {

	// Atributos locales.
	protected Disparo disparo;

	public VisitorDisparoEnemigo(Disparo dp) {
		disparo = dp;
	}

	// Metodos heredados.
	@Override
	public boolean visitObjetoMapa(ObjetoMapaVida o) {
		o.recibirDaño(disparo.getDaño());
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
		return false;
	}

	@Override
	public boolean visitObjetoMapa(ObjetoMapaTemporal o) {
		return false;
	}

	@Override
	public boolean visitPremio(PremioVida op) {
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
	public boolean visitPremio(PremioTemporal op) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitComprable(ComprableVida comprable) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitComprable(ComprableTemporal comprable) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitEfect(Efecto efecto) {
		return true;
	}

}
