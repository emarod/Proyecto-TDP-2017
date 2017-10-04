package enemigo;
import javax.swing.*;
//import obstaculos.Acero;
import disparo.DisparoPlayer;
//import interfaz.GUI;
public abstract class State {
	protected int velocidad_enemigo;
	protected int resistencia;
	protected Enemigo enemigo;
	
    public boolean impact(){
    	if(resistencia==1)
    		return true;
    	else{
    		resistencia--;
    		return false;
    	}
    }
    
    public int getVelocidad(){
    	return velocidad_enemigo;
    }
    public abstract State lvlUp();
    public abstract void atacar();
    public abstract void mover();    

    public abstract void setGraficos(Icon[] graficos, JLabel grafico);

	public abstract void setGrafico(JLabel grafico);

	public void destruir() {
		// TODO Auto-generated method stub
		
	}

}
