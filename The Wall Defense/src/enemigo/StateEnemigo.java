package enemigo;

import java.util.concurrent.Future;
import javax.swing.*;

public abstract class StateEnemigo {
	
	protected int velocidad_enemigo;
	protected int resistencia;
	protected Enemigo enemigo;
	protected int puntaje;
	protected boolean atacar;
	protected boolean mover;
	protected Icon[] graficos;
	protected int graph;
	
	
    public boolean impact(){
    	if(resistencia==1) {
    		System.out.println("Enemigo abatido en "+resistencia);
    		return true;
    	}
    	else{
    		resistencia--;
    		return false;
    	}
    }
    
    public int getVelocidad(){
    	return velocidad_enemigo;
    }
    public void setVelocidad(int speed) {
		velocidad_enemigo=speed;
	}
    
    public abstract Future<?> atacar();
    public abstract void mover();    

    public abstract void setGraficos(Icon[] graficos, JLabel grafico);

	public abstract void setGrafico(JLabel grafico);

	public abstract void destruir();
	
	public abstract int getPuntaje();
	
	public abstract void setEnemigo(Enemigo e);
	
	public abstract StateEnemigo clone();
	
	public abstract void playSound();
}