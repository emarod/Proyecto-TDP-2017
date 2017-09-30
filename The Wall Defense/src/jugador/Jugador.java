package jugador;
import mapa.Celda;
//import obstaculos.Acero;
import javax.swing.*;

//import interfaz.GUI;
import main.Unidad;
import main.Visitor;
public class Jugador extends Unidad{
	
     private int alto;
     private int ancho;
     
     public Jugador(Celda c,int prof){	 
    	 alto=30;
    	 ancho=30;
    	 profundidad=prof;
    	 V=new VisitorJugador(this);
    	 celda=c;    	 
    	 grafico=new JLabel(); 
    }
     
    public boolean Accept(Visitor V){
    	return V.visitPlayer(this);
    }
    public int getAlto(){
    	return alto;
    }
    public int getAncho(){
    	return ancho;
    }
    public void setVisitor(Visitor v){
    	V=v;
    }

//    public int getVidas(){
//    	return vidas;
//    }
    public void setV(){
    	setVisitor(new VisitorJugador(this));
 		 
    }

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}
}
