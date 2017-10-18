package jugador;
import java.util.concurrent.Future;

import javax.swing.*;
public abstract class State {
	protected int velocidad_jugador;
	protected int resistencia;
	protected Jugador jugador;	
	
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
    public abstract void setGraficos(Icon[] graficos, JLabel grafico);
	public abstract void setGrafico(JLabel grafico);
	public void destruir() {
		// TODO Auto-generated method stub
		
	}	
	public abstract State clone();
	
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
