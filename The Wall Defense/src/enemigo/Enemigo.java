
package enemigo;

import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;

import Controladores.BancoRecursos;
import main.Unidad;
import main.Visitor;
import mapa.Celda;

public class Enemigo extends Unidad{
	 protected StateEnemigo tipo;
	 protected BancoRecursos bancoRecursos;
	 
	 public Enemigo(Celda [] c, int profundidad, StateEnemigo t){
		V=new VisitorEnemigo(this);
    	tipo=t;
    	alto=30;
    	ancho=30;
    	celda=c;    	
    	this.profundidad=profundidad;
    	grafico=new JLabel();
    	setGrafico();
		getCeldas()[0].getDirector().ejecutar(this, 10);

	}
	 
	public void activar() {
		activeTask=getCeldas()[0].getDirector().ejecutar(this,tipo.getVelocidad());
	}
	
	public void activar(long l) {
		activeTask=getCeldas()[0].getDirector().ejecutar(this,l,tipo.getVelocidad());
	}

	public boolean accept(Visitor V){
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
	
	public void setBancoRecursos(BancoRecursos banco) {
		bancoRecursos=banco;
	}
	
	public BancoRecursos getBancoRecursos() {
		return bancoRecursos;
	}

	public void relentizar(int penalizacion) {
		activeTask.cancel(true);
		activeTask= celda[0].getDirector().ejecutarUna(this,penalizacion);
		activar(activeTask.getDelay(TimeUnit.MILLISECONDS));
	}
	
	public Enemigo clone(Celda[] c) {
//		Profundidad 1 predeterminada. Retorna una unidad de mismo tipo.
		StateEnemigo tipo = this.tipo.clone();
		Enemigo clon = new Enemigo(c, 1, tipo);
		tipo.setEnemigo(clon);
		return clon;
	}
	
	public void playSound(){
		tipo.playSound();
	}
}
