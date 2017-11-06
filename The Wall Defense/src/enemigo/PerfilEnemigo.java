package enemigo;

import java.util.concurrent.Future;
import javax.swing.*;

/*
 * Clase abstracta PerfilEnemigo.
 * Clase que generaliza la idea de las caracteristicas especificas para un enemigo en especifico.
 */

public abstract class PerfilEnemigo {
	
	//Atributos locales.
	protected int velocidad_enemigo;
	protected int resistencia;
	protected int daño;
	protected Enemigo enemigo;
	protected int puntaje;
	protected boolean atacar;
	protected boolean mover;
	protected Icon[] graficos;
	protected int graph;
	
	//Metodos locales.
    public boolean impact(int d){
    	if(resistencia<=d) {
    		System.out.println("Enemigo abatido en "+resistencia);
    		return true;
    	}
    	else{
    		resistencia = resistencia -d;
    		return false;
    	}
    }
    
    public int getVelocidad(){
    	return velocidad_enemigo;
    }
    
    public void setVelocidad(int speed) {
		velocidad_enemigo=speed;
	}
    
    //Metodos abstractos.
    public abstract Future<?> atacar();
    public abstract void mover();    
    public abstract void setGraficos(Icon[] graficos, JLabel grafico);
	public abstract void setGrafico(JLabel grafico);
	public abstract void destruir();
	public abstract int getPuntaje();
	public abstract void setEnemigo(Enemigo e);
	public abstract PerfilEnemigo clone();
	public abstract void playSound();
	public abstract int getDaño();
}