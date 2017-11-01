package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import jugador.Arquero;
import main.GameObject;
import main.Visitor;
import mapa.Celda;

public class DisparoArquero extends Disparo{	
	
	protected Arquero arquero;
	
    public DisparoArquero(Arquero archer, int prof){
       super(prof);
       arquero = archer;
		celda=arquero.getJugador().getCelda();
		celda.addDisparo(this);
       V=new VisitorDisparoPlayer(this);
 	   grafico=new JLabel();
  	   grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/disparo/flecha.png")));
  	   grafico.setBounds(64*celda.getPosX(), 64*celda.getPosY(), 64, 64);
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
		arquero.animarDisparo();
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
