package disparo;

import enemigo.Enemigo;
import jugador.Jugador;
import main.Visitor;
import obstaculo.*;
import terreno.Rock;

/*
 * Clase VisitorDisparoEnemigo.
 * Clase encargada de implementar correctamente las colisiones de los proyectiles de los enemigos.
 * Especifica sus comportamientos mediante un patron de diseño visitor.
 */

public class VisitorDisparoEnemigo extends Visitor {
	
	//Atributos locales.
	protected Disparo disparo;
	
	//Metodos heredados.
	public boolean visitObstaculo(Obstaculo o) {
		o.restarResistencia(disparo.getDaño());
		return false;
	}
	
	public boolean VisitRock(Rock r) {
		r.restarResistencia(disparo.getDaño());
		return false;
	}

	/*
	public boolean VisitBarricada(Barricada b) {
		b.restarResistencia();
		return false;
	}
	*/
	
	public boolean VisitWater(Water w) {
		return false;
	}

	public boolean visitPlayer(Jugador j) {
		j.restarResistencia();
		disparo.destruir();
		return false;
	}

	public boolean visitDisparoPlayer(Disparo d) {
		return false;
	}

	public boolean visitEnemigo(Enemigo e) {
		return false;
	}

}
