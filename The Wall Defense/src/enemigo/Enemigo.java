package enemigo;

import javax.swing.JLabel;

//import interfaz.GUI;
import main.Unidad;
import main.Visitor;
import mapa.Celda;
public class Enemigo extends Unidad{
	 private int alto;
	 private int ancho;
	 private State tipo;
	 
	 public Enemigo(Celda c, int profundidad, State t){
    	//GUI.playSound("EnemigoAparece.wav");
    	V=new VisitorEnemigo(this);
    	tipo=t;
    	alto=30;
    	ancho=30;
    	celda=c;
    	isRunning=true;
    	this.profundidad=profundidad;
    	grafico=new JLabel();
    	setGrafico();
	}

	public boolean Accept(Visitor V){
		return V.visitEnemigo((Enemigo)this);
	}
	
    public int getAlto(){
    	return alto;
    }
    
    public int getAncho(){
    	return ancho;
    }
    
    public Visitor getVisitor() {
    	return V;
    }
    	
    
	public boolean restarResistencia(){ 
		boolean destruir= tipo.impact();
		if (destruir) {
			destruir();
			tipo.destruir();
		}
		return destruir;
		
	}
	
    public void setGrafico(){
    	tipo.setGrafico(grafico);
    }
    
    public JLabel getGrafico() {
    	return grafico;
    }
    
    public State getState(){
    	return tipo;
    }
	
	public void destruir(){
		//GUI.playSound("EnemigoMuere.wav");
		super.destruir();
		//celda.destruirEnemigo(this);
	}

	@Override
	public void atacar() {
		tipo.atacar();
	}

	@Override
	public void mover() {
		tipo.mover();
		
	}
}
