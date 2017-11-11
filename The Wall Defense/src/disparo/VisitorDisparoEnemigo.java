package disparo;

import enemigo.Enemigo;
import jugador.Jugador;
import main.Visitor;
<<<<<<< HEAD
import obstaculos.ObstaculoTemporal;
import obstaculos.ObstaculoVida;
import preciosos.ObjetoPrecioso;
=======
import obstaculo.*;
import terreno.Rock;
>>>>>>> master

/*
 * Clase VisitorDisparoEnemigo.
 * Clase encargada de implementar correctamente las colisiones de los proyectiles de los enemigos.
 * Especifica sus comportamientos mediante un patron de diseño visitor.
 */

public class VisitorDisparoEnemigo extends Visitor {

	// Atributos locales.
	protected Disparo disparo;
<<<<<<< HEAD

	// Metodos heredados.
	@Override
	public boolean visitObstaculo(ObstaculoVida o) {
		o.recibirDaño(disparo.getDaño());
=======
	
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
>>>>>>> master
		return false;
	}

	@Override
	public boolean visitPlayer(Jugador j) {
<<<<<<< HEAD
		j.recibirDaño(disparo.getDaño());
=======
		j.restarResistencia(disparo.getDaño());
>>>>>>> master
		disparo.destruir();
		return false;
	}

	@Override
	public boolean visitDisparoPlayer(Disparo d) {
		return false;
	}

	@Override
	public boolean visitEnemigo(Enemigo e) {
		return false;
	}

	@Override
	public boolean visitObstaculo(ObstaculoTemporal o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitObjetoPrecioso(ObjetoPrecioso op) {
		// TODO Auto-generated method stub
		return false;
	}

}
