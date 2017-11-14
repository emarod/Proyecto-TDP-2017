package jugador;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import enemigo.Enemigo;
import main.Visitor;
import objetoMapa.ObjetoMapa;
import objetoMapa.ObjetoMapaTemporal;
import objetoMapa.ObjetoMapaVida;
import premios.Premio;

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

	/*
	 * public boolean VisitRock(Rock r){ return false; }
	 *
	 * public boolean VisitBarricada(Barricada b){ return false; }
	 */

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
	public boolean visitObstaculo(ObjetoMapaVida o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitObstaculo(ObjetoMapaTemporal o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitObjetoPrecioso(Premio op) {
		// TODO Auto-generated method stub
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
}
