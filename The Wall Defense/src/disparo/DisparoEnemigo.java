package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import enemigo.NightKing;
import main.GameObject;
import main.Visitor;
import mapa.Celda;

/*
 * Clase DisparoEnemigo
 * Clase que especifica el comportamiento de los proyectiles generados por el nightking.
 */

public class DisparoEnemigo extends Disparo {
	
	//Atributos locales.
	protected NightKing nightking;
	
	//Constructor.
    public DisparoEnemigo(NightKing nk, int prof){
       super(prof);
       nightking = nk;
		celda[0]=nightking.getEnemigo().getCeldas()[0];
		celda[0].addDisparo(this);
       V=new VisitorDisparoPlayer(this);
 	   grafico=new JLabel();
  	   grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/disparo/flecha.png")));
  	   grafico.setBounds(64*celda[0].getPosX(), 64*celda[0].getPosY(), 64, 64);
	   celda[0].getEscenario().agregar(grafico,new Integer(2));
	   celda[0].getDirector().ejecutar(this,nightking.getVelocidadDisparo());	     
    }
    
    //Metodos locales.
    public void destruir(){
    	super.destruir();
    	restarDisparosEnEjecucion();
		celda[0].getEscenario().remove(grafico);
		celda[0].getDirector().desactivar(this);		
	}    
    
    //Metodos heredados.
    public boolean accept(Visitor V){
    	return V.visitDisparoPlayer(this);
    }
	
	public void mover() {
		Celda siguiente;
		nightking.animarDisparo();
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
		nightking.restarDisparosEnEjecucion();
	}

	public void run() {
		mover();		
	}

	public int getVelocidad() {
		return nightking.getVelocidadDisparo();
	}

	public void setVelocidad(int speed) {
		nightking.setVelocidad(speed);		
	}
	
	public int getDaño(){
		return nightking.getDaño();
	}
}
