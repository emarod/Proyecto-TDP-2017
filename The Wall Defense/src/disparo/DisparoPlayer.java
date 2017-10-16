package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import jugador.State;
import main.GameObject;
import main.Visitor;
import mapa.Celda;

public class DisparoPlayer extends Disparo{	
	protected int puntosCelda = 32;
	protected int puntosVelocidad = velocidad;
    public DisparoPlayer(State t, int prof,int speed){
       super(t,prof,speed);      
       V=new VisitorDisparoPlayer(this);
 	   grafico=new JLabel();
  	   grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/disparo/flecha.png")));
  	   grafico.setBounds(32*celda.getPosX(), 32*celda.getPosY(), 32, 32);
	   celda.getEscenario().agregar(grafico,new Integer(2));	   
	   celda.getDirector().activarMovimiento(this);
	   
    }

    public void destruir(){
    	super.destruir();
    	restarDisparosEnEjecucion();
		celda.getEscenario().remove(grafico);
		celda.getDirector().desactivarMovimiento(this);
	   
	}
    
    
    public boolean Accept(Visitor V){
    	return V.visitDisparoPlayer(this);
    }

	
	public void mover() {
		mover=true;
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
			
		for(int i=0;i<3 && mover;i++) {
			GameObject objeto =siguiente.getObjects()[i];					
			if (objeto!=null && !objeto.Accept(V)){
				mover=false;								
			}
		}
		

		if(!mover || xCelda==19 || xGrafico>=640) {
			destruir();
		}
		else {
			grafico.setBounds(xGrafico+64, yGrafico, getAncho(), getAlto());
			intercambiar_celdas(siguiente);
			puntosCelda=32;
		}		
		mover=false;
		
	}
	
	public void mover2() {
		mover=true;
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
			
		for(int i=0;i<3 && mover;i++) {
			GameObject objeto =siguiente.getObjects()[i];					
			if (objeto!=null && !objeto.Accept(V)){
				celda.getDirector().desactivarMovimiento(this);
				mover=false;
			}
		}
		

		if(!mover || xCelda==19 || xGrafico>=640) {
			destruir();	
		}
		else {
			if(puntosVelocidad>0) {
				puntosVelocidad--;
				if(puntosVelocidad==0) {
					puntosCelda--;
					grafico.setBounds(xGrafico+1, yGrafico, getAncho(), getAlto());
					puntosVelocidad=velocidad;
				}
				
				if(puntosCelda==0) {
					
					intercambiar_celdas(siguiente);
					puntosCelda=32;
				}
			}

		}
		mover=false;
		
	}
	
	@Override
	public void atacar() {
		// TODO Auto-generated method stub
	}

	@Override
	public void restarDisparosEnEjecucion() {
		tipo.restarDisparosEnEjecucion();
	}
    
}
