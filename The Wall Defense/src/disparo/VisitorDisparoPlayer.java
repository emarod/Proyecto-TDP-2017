package disparo;


import enemigo.Enemigo;
import jugador.Jugador;
import main.Visitor;
import obstaculo.Rock;
import obstaculo.Water;
public class VisitorDisparoPlayer extends Visitor {
	
	protected DisparoPlayer disparo;
	
	public VisitorDisparoPlayer(DisparoPlayer dp){
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
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitDisparoPlayer(DisparoPlayer d) {		
		return true;
	}

	public boolean visitEnemigo(Enemigo e){
		e.restarResistencia();
		disparo.destruir();
		return false;
	}


}

