package disparo;

import enemigo.Enemigo;
import jugador.Jugador;
import main.Visitor;
import obstaculo.Rock;
import obstaculo.Water;

public class VisitorDisparoEnemigo extends Visitor {
	
	protected Disparo disparo;
	
	@Override
	public boolean VisitRock(Rock r) {
		r.restarResistencia();
		return false;
	}

	@Override
	public boolean VisitWater(Water w) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitPlayer(Jugador j) {
		j.restarResistencia();
		disparo.destruir();
		return false;
	}

	@Override
	public boolean visitDisparoPlayer(Disparo d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitEnemigo(Enemigo e) {
		// TODO Auto-generated method stub
		return false;
	}

}
