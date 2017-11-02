package powerUp;

import javax.swing.JLabel;

import jugador.Jugador;
import main.GameObject;
import main.Visitor;
import mapa.Celda;

public abstract class PowerUp extends GameObject {
	
	protected JLabel graficoToken;

	protected PowerUp(Celda c,int prof){
		celda[0] = c;
		profundidad = prof;
	}
	
	public abstract JLabel getGraficoToken();
	
	public boolean accept(Visitor V){
		return false;
	}
	
	public abstract void aplicar(Jugador j);

}
