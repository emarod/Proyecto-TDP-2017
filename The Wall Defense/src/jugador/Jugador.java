package jugador;

import mapa.Celda;
import java.util.concurrent.Future;
import javax.swing.*;
import Controladores.BancoRecursos;
import main.Unidad;
import main.Visitor;

/*
 * Clase Jugador.
 * Clase que generaliza la idea de un jugador y su comportamiento.
 */

public abstract class Jugador extends Unidad{
	
	//Atributos locales.
	protected JLabel imagen;
	protected int daño;
	protected int vida;
	protected Icon[] graficos;
	protected int graph;
    
	//Constructor.
    public Jugador(Celda[] c,int prof){	 
    	 alto=30;
    	 ancho=30;
    	 profundidad=prof;
    	 V=new VisitorJugador(this);
    	 celda=c;    	 
    	 grafico=new JLabel();
    }
    
    //Metodos locales.
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

    public void setVisitor(Visitor v){
    	V=v;
    }
    
    public void destruir() {
    	super.destruir();
    }

    public void setV(){
    	setVisitor(new VisitorJugador(this));
 		 
    }    
    
    public JLabel getGrafico() {
    	return grafico;
    }

	public Visitor getVisitor() {
		return V;
	}
		
	public int getDaño() {
		return getDaño	();		
	}

	public void setAtaque(int a) {
		setAtaque(a);	
	}	
	
	//Metodos heredados.
	public void run() {
		atacar();		
	}
	
	public int getVelocidad() {
		return velocidad;		
	}

	public void setVelocidad(int speed) {
		velocidad=speed;	
	}	

    public boolean accept(Visitor V){
    	return V.visitPlayer(this);
    }    
    
	//abstract methods
	public abstract Jugador clone(Celda[] c);
	public abstract void mover();
	public abstract void atacar();
	public abstract void playSound();	
    
}