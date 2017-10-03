package disparo;
import java.sql.Time;
import java.util.Timer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import jugador.Arquero;
import jugador.Jugador;
import main.Unidad;
import main.Visitor;
import mapa.Celda;

public class DisparoPlayer extends Disparo{	
	protected int puntosCelda = 32;
	protected int puntosVelocidad = velocidad;
    public DisparoPlayer(Celda C, Unidad j, int prof,int speed){
       super(C,j,prof,speed);
//       System.out.println("Disparo");       
       cronometro = new Timer();
       V=new VisitorDisparoPlayer(this);
 	   grafico=new JLabel();
  	   grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/disparo/flecha.png")));
  	   grafico.setBounds(32*celda.getPosX(), 32*celda.getPosY(), 32, 32);
	   celda.getEscenario().agregar(grafico,new Integer(2));	   
	   celda.getCM().activar(this);
    }
    
    public void run() {
    	if (grafico.getX()>640) {
//    		grafico.setBounds(j.getCelda().getPosX()*32, grafico.getY(), getAncho(), getAlto());

    	}
    	else
    		grafico.setBounds(grafico.getX()+1, grafico.getY(), getAncho(), getAlto());
    }

    public void destruir(){
    	super.destruir();
    	Arquero archer=(Arquero)j;
		archer.restarDisparosEnEjecucion();
		celda.getCM().desactivar(this);
	   
	}
    public boolean Accept(Visitor V){
    	return V.visitDisparoPlayer(this);
    }

	@Override
	public void mover() {
		Celda siguiente;
		int xCelda=(celda.getPosX()==19) ? celda.getPosX():j.getCelda().getPosX();
		int yCelda=celda.getPosY();
		int xGrafico= grafico.getX();
		int yGrafico= grafico.getY();
		puntosVelocidad--;
		if(xGrafico>=640) {
//			System.out.println("Destruccion xgraf"+xGrafico+" xcelda"+xCelda);
			destruir();			
		}
		else {
			if(puntosVelocidad==0) {
				puntosCelda--;
				grafico.setBounds(xGrafico+1, yGrafico, getAncho(), getAlto());
				puntosVelocidad=velocidad;
			}
		}	
		if(puntosCelda==0) {
			siguiente=celda.getCelda(xCelda+1,yCelda);
			intercambiar_celdas(siguiente);
			puntosCelda=32;
		}
		
	}
	
	public void adelantar() {
		int x = grafico.getX();
		
	}
	
	@Override
	public void atacar() {
		// TODO Auto-generated method stub
	}
    
}
