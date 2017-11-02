package disparo;


import enemigo.Enemigo;
import jugador.Jugador;
import main.Visitor;
import obstaculo.Rock;
import obstaculo.Water;
public class VisitorDisparoPlayer extends Visitor {
	
	protected Disparo disparo;
	
	public VisitorDisparoPlayer(Disparo dp){
		disparo = dp;
	}

	@Override
	public boolean VisitRock(Rock r) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean VisitWater(Water w) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitPlayer(Jugador j) {
		return true;
	}

	@Override
	public boolean visitDisparoPlayer(Disparo d) {		
		return true;
	}

	public boolean visitEnemigo(Enemigo e){
		e.restarResistencia();
		disparo.destruir();
		return true;
	}


}

