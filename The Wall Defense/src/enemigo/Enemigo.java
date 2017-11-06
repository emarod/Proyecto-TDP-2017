package enemigo;

import java.util.concurrent.TimeUnit;

import javax.swing.Icon;
import javax.swing.JLabel;
import main.Unidad;
import main.Visitor;
import mapa.Celda;

/*
 * Clase Enemigo.
 * Clase que generaliza la idea de un enemigo y su comportamiento.
 */

public abstract class Enemigo extends Unidad{
	
	
	//Atributos locales.
	protected int vida;
	protected int daño;	
	protected int puntaje;
	protected boolean atacar;
	protected boolean mover;
	protected Icon[] graficos;
	protected int graph;
	
	//Constructor.
	public Enemigo(Celda [] c, int profundidad){
		V=new VisitorEnemigo(this);
    	alto=30;
    	ancho=30;
    	celda=c;    	
    	this.profundidad=profundidad;
    	grafico=new JLabel();
    	setGrafico();
	}
	
	//Metodos locales.
    
    public Visitor getVisitor() {
    	return V;
    }
    
    public boolean recibirDaño(int golpe){ 
		boolean destruir= false;
    	if(vida<=daño) {
    		System.out.println("Enemigo abatido en "+vida);
    		destruir=true;
    	}
    	else{
    		vida = vida - golpe;
    	}
		if (destruir) {
			System.out.println("antes de restar resistencia de jugador");
			destruir();
		}
		return destruir;		
	}
	
    public void setGrafico(){
    	setGrafico(grafico);
    }
    
    public JLabel getGrafico() {
    	return grafico;
    }
	
	public void destruir(){
		super.destruir();
		celda[0].destruirEnemigo(this);
		
	}
	
	public int getPuntaje() {
		return getPuntaje();
	}

	public void relentizar(int penalizacion) {
		activeTask.cancel(true);
		activeTask= celda[0].getDirector().ejecutarUna(this,penalizacion);
		activar(activeTask.getDelay(TimeUnit.MILLISECONDS));
	}
	
	//Metodos heredados.
	public void run() {
		mover();
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int speed) {
		velocidad=speed;
	}
		
	public boolean accept(Visitor V){
		return V.visitEnemigo(this);
	}
	
	public int getDaño() {
		return daño;		
	}
	
	public abstract Enemigo clone(Celda[] c);
	public abstract void mover();
	public abstract void atacar();
	public abstract void playSound();	
}
