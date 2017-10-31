package powerUp;

import javax.swing.JLabel;

import main.GameObject;
import main.Visitor;
import mapa.Celda;

public abstract class PowerUp extends GameObject {
	
	protected JLabel graficoToken;

	protected PowerUp(Celda c,int prof){
		celda = c;
		profundidad = prof;
	}
	
	public abstract JLabel getGraficoToken();
	
	public boolean Accept(Visitor V){
		return false;
	}

}
