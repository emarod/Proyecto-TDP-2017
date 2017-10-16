package jugador;
import javax.swing.*;
public abstract class State {
	protected int velocidad_jugador;
	protected int resistencia;
	protected int velocidad_disparo;
	protected int disparos_simultaneos;
	protected int disparos_en_ejecucion;
	protected Jugador jugador;	
	
    public boolean impact(){
    	if(resistencia==1)
    		return true;
    	else{
    		resistencia--;
    		return false;
    	}
    }
    
    public int getVelocidad(){
    	return velocidad_jugador;
    }
    public abstract void atacar();
    public abstract void mover();
    public abstract void setJugador(Jugador jugador);
    
    public void restarDisparosEnEjecucion(){
    	disparos_en_ejecucion--;
    }
    public abstract void setGraficos(Icon[] graficos, JLabel grafico);

    public int getDisparosEnEjecucion(){
    	return disparos_en_ejecucion;
    }
	public abstract void setGrafico(JLabel grafico);
	public void destruir() {
		// TODO Auto-generated method stub
		
	}
	
	public abstract State clone();
	public Jugador getJugador() {
		// TODO Auto-generated method stub
		return jugador;
	}

}
