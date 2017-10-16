package main;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import mapa.Celda;

public abstract class Unidad extends GameObject implements Runnable{
    
	protected Visitor V;

	//Parametros de conducta
    protected boolean esperar;
	protected boolean atacar;
	protected int velocidad;
	protected int retrasar;
	protected boolean congelar;
	protected ScheduledFuture<?> activeTask;

    public abstract int getAncho();
	public abstract int getAlto(); 
	public abstract void atacar();
	public abstract void mover();
	
	public void intercambiar_celdas(Celda C){
		mover=true;
	    C.getObjects()[profundidad]=this;	    
		celda.getObjects()[profundidad]=null;
		celda=C;
	}
	
    public void destruir(){
    	super.destruir();
    	
    }
	
	public boolean getMoviendo(){
		return mover;
	}
	
	public void setMoviendo(boolean b){
		mover=b;
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
	
	public void setCongelar(boolean b) {
		congelar=b;
	}
	
	public void setRetraso(int i) {
		retrasar=i;		
	}
	
	public void setEsperar(boolean b) {
		esperar=b;
	}
	
	public void setVelocidad(int i) {
		velocidad=i;		
	}
	
	public void hacerDaño() {
		
	}
}