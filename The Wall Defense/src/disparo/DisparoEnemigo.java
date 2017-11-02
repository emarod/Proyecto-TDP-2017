package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import enemigo.NightKing;
import main.GameObject;
import main.Visitor;
import mapa.Celda;

public class DisparoEnemigo extends Disparo {

protected NightKing nightking;
	
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

    public void destruir(){
    	super.destruir();
    	restarDisparosEnEjecucion();
		celda[0].getEscenario().remove(grafico);
		celda[0].getDirector().desactivar(this);		
	}    
    
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
	
	@Override
	public void atacar() {		
	}

	@Override
	public void restarDisparosEnEjecucion() {
		nightking.restarDisparosEnEjecucion();
	}

	@Override
	public void run() {
		mover();		
	}

	@Override
	public int getVelocidad() {
		return nightking.getVelocidadDisparo();
	}

	@Override
	public void setVelocidad(int speed) {
		nightking.setVelocidad(speed);		
	}
}
