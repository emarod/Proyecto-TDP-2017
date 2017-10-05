package main;

import javax.swing.JLabel;

import mapa.Celda;

public abstract class Unidad extends GameObject{
    
	protected Visitor V;

    
    public int profundidad;
    protected JLabel grafico;
    
    //Parametros de conducta
    protected boolean esperar;
	protected boolean movimiento;
	protected boolean atacar;
	protected int velocidad;
	protected int retrasar;
	protected boolean congelar;
    protected volatile boolean moviendo=false;

    public abstract int getAncho();
	public abstract int getAlto(); 
	public abstract void atacar();
	public abstract void mover();
	
	public void intercambiar_celdas(Celda C){
		moviendo=true;
	    C.getObjects()[profundidad]=this;	    
		celda.getObjects()[profundidad]=null;
		celda=C;
	}
	
	public boolean getMoviendo(){
		return moviendo;
	}
	
	public void setMovimiento(boolean b) {
		movimiento=b;
	}
	
	public void setAtacar(boolean b) {
		atacar=b;
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