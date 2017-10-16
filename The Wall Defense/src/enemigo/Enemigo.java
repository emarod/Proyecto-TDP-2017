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
    	System.out.println("Creando enemigo"+this.profundidad);
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
		System.out.println("In enemigo profundidad "+profundidad);
		super.destruir();
		System.out.println("Destruir enemigo");
		celda.destruirEnemigo(this);

	}

	@Override
	public void atacar() {
		tipo.atacar();
	}

	@Override
	public void mover() {
		tipo.mover();
		
	}
	
	public int getPuntaje() {
		return tipo.getPuntaje();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
