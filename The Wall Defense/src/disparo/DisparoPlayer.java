package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import jugador.Jugador;
import main.GameObject;
import main.Unidad;
import main.Visitor;
import mapa.Celda;

public class DisparoPlayer extends Disparo{	
	protected int puntosCelda = 32;
	protected int puntosVelocidad = velocidad;
    public DisparoPlayer(Celda C, Unidad j, int prof,int speed){
       super(C,j,prof,speed);
//       System.out.println("Disparo");       
       V=new VisitorDisparoPlayer(this);
 	   grafico=new JLabel();
  	   grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/disparo/flecha.png")));
  	   grafico.setBounds(32*celda.getPosX(), 32*celda.getPosY(), 32, 32);
	   celda.getEscenario().agregar(grafico,new Integer(2));	   
	   celda.getCM().activar(this);
	   isRunning=true;
    }

    public void destruir(){
    	super.destruir();
    	Jugador archer=(Jugador)j;
		archer.getState().restarDisparosEnEjecucion();
//		celda.getEscenario().remove(grafico);
		celda.getCM().desactivar(this);
	   
	}
    public boolean Accept(Visitor V){
    	return V.visitDisparoPlayer(this);
    }

	@Override
	public void mover() {
		Celda siguiente;
//		int xCelda=(celda.getPosX()==19) ? celda.getPosX():j.getCelda().getPosX();
		int xCelda=celda.getPosX();
		int yCelda=celda.getPosY();
		int xGrafico= grafico.getX();
		int yGrafico= grafico.getY();
		if(xCelda!=19) {
			siguiente=celda.getCelda(xCelda+1,yCelda);
		}
		else
			siguiente=celda.getCelda(xCelda,yCelda);
			
		for(int i=0;i<3 && isRunning;i++) {
			GameObject objeto =siguiente.getObjects()[i];					
			if (objeto!=null && !objeto.Accept(V)){
				celda.getCM().desactivar(this);
				isRunning=false;
			}
		}
		

		if(!isRunning || xCelda==19 || xGrafico>=640) {
//			System.out.println("Destruccion xgraf"+xGrafico+" xcelda"+xCelda);
			celda.getCM().desactivar(this);
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
	}
	
	@Override
	public void atacar() {
		// TODO Auto-generated method stub
	}
    
}
