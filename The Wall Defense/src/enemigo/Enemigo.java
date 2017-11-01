
package enemigo;

import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;

//import interfaz.GUI;
import main.Unidad;
import main.Visitor;
import mapa.Celda;
public class Enemigo extends Unidad{
	 protected StateEnemigo tipo;
	 
	 public Enemigo(Celda c, int profundidad, StateEnemigo t){
		V=new VisitorEnemigo(this);
    	tipo=t;
    	alto=30;
    	ancho=30;
    	celda[0]=c;    	
    	this.profundidad=profundidad;
    	grafico=new JLabel();
    	setGrafico();    	
	}
	 
	public void activar() {
		activeTask=getCeldas()[0].getDirector().ejecutar(this,tipo.getVelocidad());
	}
	
	public void activar(long l) {
		activeTask=getCeldas()[0].getDirector().ejecutar(this,l,tipo.getVelocidad());
	}

	public boolean Accept(Visitor V){
		return V.visitEnemigo(this);
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
    
    public StateEnemigo getState(){
    	return tipo;
    }
	
	public void destruir(){
		super.destruir();
		celda[0].destruirEnemigo(this);
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

	@Override
	public int getVelocidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setVelocidad(int speed) {
		// TODO Auto-generated method stub
		
	}

	public void relentizar(int penalizacion) {
		activeTask.cancel(true);
		activeTask= celda[0].getDirector().ejecutarUna(this,penalizacion);
		activar(activeTask.getDelay(TimeUnit.MILLISECONDS));
		
		
		
	}
}
