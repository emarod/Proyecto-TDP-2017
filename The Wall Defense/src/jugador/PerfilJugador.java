package jugador;

import java.util.concurrent.Future;
import javax.swing.*;

/*
 * Clase abstracta PerfilJugador.
 * Clase que generaliza la idea de las caracteristicas especificas para un jugador en especifico.
 */

public abstract class PerfilJugador {
	
	//Atributos locales.
	protected int velocidad_jugador;
	protected int daño;
	protected int resistencia;
	protected Jugador jugador;
	protected Icon[] graficos;
	protected int graph;
	
	//Metodos locales.
    public boolean impact(){
    	if(resistencia<=daño) {
    		System.out.println("Enemigo abatido en "+resistencia);
    		return true;
    	}
    	else{
    		resistencia = resistencia - daño;
    		return false;
    	}
    }
    
    public Jugador getJugador() {
		return jugador;
	}

	public void setVelocidad(int speed) {
		velocidad_jugador=speed;
	}
	
	public int getVelocidad() {
		return velocidad_jugador;
	}
	
	public void setAtaque(int a) {
		daño=a;
	}
    
	//Metodos abstractos.
    public abstract Future<?> atacar();
    public abstract void setJugador(Jugador jugador);    
	public abstract void setGrafico(JLabel grafico);
	public abstract void playSound();
	public abstract void destruir();
	public abstract PerfilJugador clone();
	public abstract int getDaño();
}
