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

public class Jugador extends Unidad{
	
	//Atributos locales.
	protected JLabel imagen;
	protected int vidas;
	protected PerfilJugador tipo;
    protected Future<?> activeAttack;
	protected BancoRecursos bancoRecursos;
    
	//Constructor.
    public Jugador(Celda[] c,int prof, PerfilJugador t){	 
    	 alto=30;
    	 ancho=30;
    	 profundidad=prof;
    	 V=new VisitorJugador(this);
    	 celda=c;    	 
    	 grafico=new JLabel();
    	 tipo = t;
    	 setGrafico(); 
    }
    
    //Metodos locales.
	public boolean restarResistencia(int d){ 
		boolean destruir= (tipo.impact(d));
		if (destruir) {
			System.out.println("antes de restar resistencia de jugador");
			destruir();
			tipo.destruir();
		}
		return destruir;		
	}

    public void setVisitor(Visitor v){
    	V=v;
    }

    public PerfilJugador getState(){
    	return tipo;
    }

    public void setV(){
    	setVisitor(new VisitorJugador(this));
 		 
    }
    
    public void setGrafico(){
    	tipo.setGrafico(grafico);
    }
    
    public JLabel getGrafico() {
    	return grafico;
    }

	public Visitor getVisitor() {
		return V;
	}
	
	public Jugador clone(Celda[] c) {
		//Profundidad 2 predeterminada. Retorna una unidad de mismo tipo.
		PerfilJugador tipo = this.tipo.clone();
		Jugador clon = new Jugador(c, 2, tipo);
		tipo.setJugador(clon);
		return clon;
	}
	
	public int getDaño() {
		return tipo.getDaño	();		
	}

	public void setAtaque(int a) {
		tipo.setAtaque(a);	
	}
	
	public void setBancoRecursos(BancoRecursos banco) {
		bancoRecursos=banco;
	}
	
	public BancoRecursos getBancoRecursos() {
		return bancoRecursos;
	}
	
	public void playSound(){
		tipo.playSound();
	}
	
	//Metodos heredados.
	public void run() {
		if(activeAttack==null || activeAttack.isCancelled() || activeAttack.isDone()) {
			atacar();
		}
	}
	
	public int getVelocidad() {
		return tipo.getVelocidad();		
	}

	public void setVelocidad(int speed) {
		tipo.setVelocidad(speed);	
	}
	
	public void atacar() {
		activeAttack=tipo.atacar();		
	}

	public void mover() {
		
	}

    public boolean accept(Visitor V){
    	return V.visitPlayer(this);
    }
}