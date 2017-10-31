package jugador;
import mapa.Celda;

import java.util.concurrent.Future;

//import obstaculos.Acero;
import javax.swing.*;

import Controladores.BancoRecursos;
//import interfaz.GUI;
import main.Unidad;
import main.Visitor;
public class Jugador extends Unidad{
	
	protected JLabel imagen;
	protected int vidas;
	protected StateJugador tipo;
    protected Future<?> activeAttack;
	protected BancoRecursos bancoRecursos;
	protected boolean invulnerable;
     
    public Jugador(Celda c,int prof, StateJugador t){	 
    	 alto=30;
    	 ancho=30;
    	 profundidad=prof;
    	 V=new VisitorJugador(this);
    	 celda=c;    	 
    	 grafico=new JLabel();
    	 tipo = t;
    	 setGrafico();    	 
    }
    
	public boolean restarResistencia(){ 
		boolean destruir= (!invulnerable && tipo.impact());
		if (destruir) {
			destruir();
			tipo.destruir();
		}
		return destruir;		
	}
     
    public boolean Accept(Visitor V){
    	return V.visitPlayer(this);
    }

    public void setVisitor(Visitor v){
    	V=v;
    }

    public StateJugador getState(){
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

	@Override
	public void atacar() {
		activeAttack=tipo.atacar();		
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

	public Visitor getVisitor() {
		return V;
	}
	
	public Jugador clone(Celda c) {
//		Profundidad 2 predeterminada. Retorna una unidad de mismo tipo.
		StateJugador tipo = this.getState().clone();
		Jugador clon = new Jugador(c, 2, tipo);
		tipo.setJugador(clon);
		return clon;
	}

	@Override
	public void run() {
		if(activeAttack==null || activeAttack.isCancelled() || activeAttack.isDone()) {
			atacar();
		}
		
	}

	@Override
	public int getVelocidad() {
		return tipo.getVelocidad();		
	}

	@Override
	public void setVelocidad(int speed) {
		tipo.setVelocidad(speed);	
	}
	
	public int getAtaque() {
		return tipo.getAtaque();		
	}

	public void setAtaque(int a) {
		tipo.setAtaque(a);	
	}
	
	public void setBancoRecursos(BancoRecursos banco) {
		bancoRecursos=banco;
		
	}
	
	public void playSound() {
		bancoRecursos.playShot();
	}
	
	public void setInvulnerable(){
		invulnerable = true;
	}
}