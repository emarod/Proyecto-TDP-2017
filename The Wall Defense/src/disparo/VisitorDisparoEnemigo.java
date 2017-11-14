package disparo;

import enemigo.Enemigo;
import jugador.Jugador;
import main.Visitor;
import objetoMapa.ObjetoMapaTemporal;
import objetoMapa.ObjetoMapaVida;
import premios.Premio;

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
	public boolean visitObstaculo(ObjetoMapaVida o) {
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
		// El disparo mas fuerte sobrevive
		disparo.colision(d);
		return true;
	}

	@Override
	public boolean visitDisparo(DisparoEnemigo d) {
		return true;
	}

}
