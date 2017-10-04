package disparo;


import enemigo.Enemigo;
import jugador.Jugador;
import main.GameObject;
import main.Visitor;
import obstaculo.Rock;
import obstaculo.Water;
public class VisitorDisparoPlayer extends Visitor {
	public VisitorDisparoPlayer(GameObject o){
		objeto=o;
	}

	@Override
	public boolean VisitRock(Rock r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean VisitWater(Water w) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitPlayer(Jugador j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitDisparoPlayer(DisparoPlayer d) {
			System.out.println("Visitor Enemigo");
		return false;
	}

	public boolean visitEnemigo(Enemigo e){
		e.restarResistencia();
		objeto.destruir();
		return false;
	}


}

