package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import jugador.Dragon;
import main.GameObject;
import main.Visitor;
import mapa.Celda;

public class DisparoDragon extends Disparo {

	protected Dragon dragon;
	
	public DisparoDragon(Dragon drake, int prof){
	       super(prof);
	       dragon = drake;
			celda=dragon.getJugador().getCelda();
			celda.addDisparo(this);
	       V=new VisitorDisparoPlayer(this);
	 	   grafico=new JLabel();
	  	   grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/disparo/bola_fuego.png")));
	  	   grafico.setBounds(64*celda.getPosX(), 64*celda.getPosY(), 64, 64);
		   celda.getEscenario().agregar(grafico,new Integer(2));
		   celda.getDirector().ejecutar(this,dragon.getVelocidadDisparo());	     
	    }
	
	public void destruir(){
    	super.destruir();
    	restarDisparosEnEjecucion();
		celda.getEscenario().remove(grafico);
		celda.getDirector().desactivar(this);		
	}    
    
    public boolean Accept(Visitor V){
    	return V.visitDisparoPlayer(this);
    }
	
    public void mover() {
		Celda siguiente;
		dragon.animarDisparo();
		int xCelda=celda.getPosX();
		int yCelda=celda.getPosY();
		int xGrafico= grafico.getX();
		int yGrafico= grafico.getY();
		if(xCelda!=15) {
			siguiente=celda.getCelda(xCelda+1,yCelda);
		}
		else
			siguiente=celda.getCelda(xCelda,yCelda);
			
		GameObject objeto =siguiente.getObjects()[1];					
		if (objeto!=null && !objeto.Accept(V)){
			celda.getDirector().desactivar(this);
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
		dragon.restarDisparosEnEjecucion();
	}

	@Override
	public void run() {
		mover();		
	}

	@Override
	public int getVelocidad() {
		return dragon.getVelocidadDisparo();
	}

	@Override
	public void setVelocidad(int speed) {
		dragon.setVelocidad(speed);		
	}

}
