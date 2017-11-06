package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import jugador.Dragon;
import main.GameObject;
import main.Visitor;
import mapa.Celda;

/*
 * Clase DisparoDragon
 * Clase que especifica el comportamiento de los proyectiles generados por el dragon.
 */

public class DisparoDragon extends Disparo {
	
	//Atributos locales.
	protected Dragon dragon;
	
	//Constructor.
	public DisparoDragon(Dragon drake, int prof){
	       super(prof);
	       dragon = drake;
	       celda[0]=dragon.getCeldas()[1];
	       celda[0].addDisparo(this);
	       V=new VisitorDisparoPlayer(this);
	 	   grafico=new JLabel();
	  	   grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/disparo/bola_fuego.png")));
	  	   grafico.setBounds(64*celda[0].getPosX(), 64*celda[0].getPosY(), 64, 64);
		   celda[0].getEscenario().agregar(grafico,new Integer(2));
		   activeTask=celda[0].getDirector().ejecutar(this,dragon.getVelocidadDisparo());	     
	    }
	
	//Metodos locales.
	public void destruir(){
    	super.destruir();
    	restarDisparosEnEjecucion();
    	dragon=null;
	}  
	
    //Metodos heredados.
    public boolean accept(Visitor V){
    	return V.visitDisparoPlayer(this);
    }
	
    public void mover() {
		Celda siguiente;
		dragon.animarDisparo();
		int xCelda=celda[0].getPosX();
		int yCelda=celda[0].getPosY();
		int xGrafico= grafico.getX();
		int yGrafico= grafico.getY();
		if(xCelda!=15) {
			siguiente=celda[0].getCelda(xCelda+1,yCelda);
		}
		else
			siguiente=celda[0].getCelda(xCelda,yCelda);
			
		GameObject objeto =siguiente.getObjects()[1];					
		if (objeto!=null && !objeto.accept(V)){
			celda[0].getDirector().desactivar(this);
		}		
		
		if(xCelda==16 || xGrafico>=1026) {
			destruir();	
		}
		else {
			grafico.setBounds(xGrafico+64, yGrafico, getAncho(), getAlto());
			intercambiar_celdas(siguiente);
		}
		
	}
    
	public void atacar() {		
	}

	public void restarDisparosEnEjecucion() {
		dragon.restarDisparosEnEjecucion();
	}

	public void run() {
		mover();		
	}

	public int getVelocidad() {
		return dragon.getVelocidadDisparo();
	}

	public void setVelocidad(int speed) {
		dragon.setVelocidad(speed);		
	}
	
	public int getDaño(){
		return dragon.getDaño();
	}
}
