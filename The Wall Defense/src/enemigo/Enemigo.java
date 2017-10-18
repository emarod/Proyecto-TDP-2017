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
		V=new VisitorEnemigo(this);
    	tipo=t;
    	alto=30;
    	ancho=30;
    	celda=c;    	
    	this.profundidad=profundidad;
    	grafico=new JLabel();
    	setGrafico();    	
	}
	 
	public void activar() {
		activeTask=getCelda().getDirector().ejecutar(this,tipo.getVelocidad());
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
			System.out.println("Destruyendo");
			System.out.println("Antes de restar profundidad "+profundidad);
			this.destruir();
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
		super.destruir();
		celda.destruirEnemigo(this);

	}

	public void atacar() {
		tipo.atacar();
	}

	public void mover() {
		tipo.mover();
	}
	
	public int getPuntaje() {
		return tipo.getPuntaje();
	}

	public void run() {		
		mover();		
	}
}
