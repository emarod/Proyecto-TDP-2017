package efectos;

import comprables.ComprableTemporal;
import comprables.ComprableVida;
import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import enemigo.Enemigo;
import jugador.Jugador;
import main.Visitor;
import objetoMapa.ObjetoMapaTemporal;
import objetoMapa.ObjetoMapaVida;
import premios.PremioTemporal;
import premios.PremioVida;

public class VisitorEfecto extends Visitor {

	protected Efecto efecto;

	public VisitorEfecto(Efecto e) {
		efecto = e;
	}

	@Override
	public boolean visitPlayer(Jugador j) {
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
		System.out.println("Inicio visitor efecto");
		efecto.aplicar(e);
		System.out.println("Fin visitor efectoo");
		return true;
	}

	@Override
	public boolean visitPremio(PremioTemporal op) {
		return true;
	}

	@Override
	public boolean visitPremio(PremioVida op) {
		return true;
	}

	@Override
	public boolean visitComprable(ComprableVida comprable) {
		return true;
	}

	@Override
	public boolean visitComprable(ComprableTemporal comprable) {
		return true;
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
	public boolean visitEfect(Efecto efecto) {
		return true;
	}

}
