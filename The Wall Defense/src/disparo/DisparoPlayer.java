package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import jugador.Arquero;
import jugador.State;
import main.GameObject;
import main.Visitor;
import mapa.Celda;

public class DisparoPlayer extends Disparo{	
	
    public DisparoPlayer(Arquero archer, int prof){
       super(archer,prof);      
       V=new VisitorDisparoPlayer(this);
 	   grafico=new JLabel();
  	   grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/disparo/flecha.png")));
  	   grafico.setBounds(32*celda.getPosX(), 32*celda.getPosY(), 32, 32);
	   celda.getEscenario().agregar(grafico,new Integer(2));
	   celda.getDirector().ejecutar(this,arquero.getVelocidadDisparo());	   
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
		int xCelda=celda.getPosX();
		int yCelda=celda.getPosY();
		int xGrafico= grafico.getX();
		int yGrafico= grafico.getY();
		if(xCelda!=19) {
			siguiente=celda.getCelda(xCelda+1,yCelda);
		}
		else
			siguiente=celda.getCelda(xCelda,yCelda);
			
		GameObject objeto =siguiente.getObjects()[1];					
		if (objeto!=null && !objeto.Accept(V)){
			celda.getDirector().desactivar(this);
		}		

		if(xCelda==19 || xGrafico>=640) {
			destruir();	
		}
		else {
			grafico.setBounds(xGrafico+32, yGrafico, getAncho(), getAlto());
			intercambiar_celdas(siguiente);
		}
		
	}
	
	@Override
	public void atacar() {
		// TODO Auto-generated method stub
	}

	@Override
	public void restarDisparosEnEjecucion() {
		arquero.restarDisparosEnEjecucion();
	}

	@Override
	public void run() {
		mover();
		
	}

	@Override
	public int getVelocidad() {
		return arquero.getVelocidadDisparo();
	}

	@Override
	public void setVelocidad(int speed) {
		arquero.setVelocidad(speed);		
	}
    
}
