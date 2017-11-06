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
	protected int velocidad;
	protected ScheduledFuture<?> activeTask;
	
	//Metodos locales.
	public void intercambiar_celdas(Celda C){
		C.getObjects()[profundidad]=this;	    
		celda[0].getObjects()[profundidad]=null;
		celda[0]=C;
	}
	
    public void destruir(){
    	super.destruir();
    	activeTask.cancel(true);
    }
		
	public ScheduledFuture<?> getTask(){
		return activeTask;
	}
	
	public void hacerDaño() {
		
	}
	
	public void setTask(ScheduledFuture<?> ejecutar) {
		activeTask = ejecutar;
		
	}
	
	public void activar() {
		if(activeTask==null) {
			activeTask=getCeldas()[0].getDirector().ejecutar(this,velocidad);
		}
		else {
			System.out.println("ya está activado");
		}

	}
	
	public void activar(long l) {
		if(activeTask==null || activeTask.isCancelled() || activeTask.isDone()) {
			activeTask=getCeldas()[0].getDirector().ejecutar(this,l,velocidad);
		}
		else {
			System.out.println("ya está activado");
		}

	}
	
	//Metodos abstractos.
	public abstract void atacar();
	public abstract void mover();
	public abstract int getVelocidad();
	public abstract void setVelocidad(int speed);
	
}