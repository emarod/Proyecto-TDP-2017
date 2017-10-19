package jugador;
import java.util.concurrent.Future;

import javax.swing.*;
public abstract class StateJugador {
	protected int velocidad_jugador;
	protected int resistencia;
	protected Jugador jugador;
	protected Icon[] graficos;
	protected int graph;
	
    public boolean impact(){
    	if(resistencia==1)
    		return true;
    	else{
    		resistencia--;
    		return false;
    	}
    }
    
    public abstract Future<?> atacar();
    public abstract void mover();
    public abstract void setJugador(Jugador jugador);    
	public abstract void setGrafico(JLabel grafico);
	public void destruir() {
		// TODO Auto-generated method stub
		
	}
	
	public abstract StateJugador clone();
	
	public Jugador getJugador() {
		return jugador;
	}

	public void setVelocidad(int speed) {
		velocidad_jugador=speed;
	}
	
	public int getVelocidad() {
		return velocidad_jugador;
	}

}
