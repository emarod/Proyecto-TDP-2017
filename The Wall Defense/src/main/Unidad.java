package main;

import java.util.concurrent.ScheduledFuture;
import mapa.Celda;

/*
 * Clase abstracta Unidad.
 * Clase que generaliza la nocion de personaje, tanto aliado como enemigo.
 */

public abstract class Unidad extends GameObject implements Runnable{
    
	//Atributos locales.
	protected Visitor V;
	//Parametros de conducta
    protected int alto;
	protected int ancho;
	protected ScheduledFuture<?> activeTask;
	
	//Metodos locales.
	public void intercambiar_celdas(Celda C){
		C.getObjects()[profundidad]=this;	    
		celda[0].getObjects()[profundidad]=null;
		celda[0]=C;
	}
	
    public void destruir(){
    	super.destruir();    	
    }
		
	public ScheduledFuture<?> getTask(){
		return activeTask;
	}
	
	public void hacerDaño() {
		
	}
	
	public void setTask(ScheduledFuture<?> ejecutar) {
		activeTask = ejecutar;
		
	}
	
	//Metodos abstractos.
	public abstract void atacar();
	public abstract void mover();
	public abstract int getVelocidad();
	public abstract void setVelocidad(int speed);
	
}