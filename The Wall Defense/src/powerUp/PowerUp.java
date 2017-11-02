package powerUp;

import javax.swing.JLabel;

import jugador.Jugador;
import main.GameObject;
import main.Visitor;
import mapa.Celda;

public abstract class PowerUp extends GameObject implements Runnable{
	
	protected JLabel graficoToken;
	protected Jugador player;

	protected PowerUp(Celda c,int prof){
		celda[0] = c;
		profundidad = prof;
		celda[0].getDirector().ejecutarUna(this, 10);		
	}
	
	public abstract JLabel getGraficoToken();
	
	public boolean accept(Visitor V){
		return true;
	}
	
	public abstract void aplicar(Jugador j);
	
	public void run() {	
		if(graficoToken.getIcon()!=null) {
			graficoToken.setIcon(null);
			celda[0].getEscenario().remove(graficoToken);
		}
		else {
			player.getCeldas()[0].getObjects()[4]=null;
		}		
		this.destruir();
		
		
	}
	
	public void setJugador(Jugador j) {
		player = j;
	}

}
