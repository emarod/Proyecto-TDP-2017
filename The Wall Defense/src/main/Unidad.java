package main;

import java.util.concurrent.ScheduledFuture;

import mapa.Celda;

public abstract class Unidad extends GameObject implements Runnable{
    
	protected Visitor V;

	//Parametros de conducta
    protected boolean atacar;
	protected int velocidad;
	protected ScheduledFuture<?> activeTask;

    public abstract int getAncho();
	public abstract int getAlto(); 
	public abstract void atacar();
	public abstract void mover();
	
	public void intercambiar_celdas(Celda C){
		C.getObjects()[profundidad]=this;	    
		celda.getObjects()[profundidad]=null;
		celda=C;
	}
	
    public void destruir(){
    	super.destruir();    	
    }
		
	public ScheduledFuture<?> getTask(){
		return activeTask;
	}
	
	public int getVelociad() {
		return velocidad;
	}
	
	public void setAtacar(boolean b) {
		atacar=b;
	}
	
	public boolean getAtacar() {
		return atacar;
	}
	
	public void setVelocidad(int i) {
		velocidad=i;		
	}
	
	public void hacerDaño() {		
	}
	public void setTask(ScheduledFuture<?> ejecutar) {
		activeTask = ejecutar;
		
	}
}