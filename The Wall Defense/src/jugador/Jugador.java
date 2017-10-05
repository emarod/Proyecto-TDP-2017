package jugador;
import mapa.Celda;
//import obstaculos.Acero;
import javax.swing.*;

//import interfaz.GUI;
import main.Unidad;
import main.Visitor;
public class Jugador extends Unidad{
	
	protected JLabel imagen;
	protected int vidas;
	private int alto;
    private int ancho;
    private State tipo;
     
    public Jugador(Celda c,int prof, State t){	 
    	 alto=30;
    	 ancho=30;
    	 profundidad=prof;
    	 V=new VisitorJugador(this);
    	 celda=c;    	 
    	 grafico=new JLabel();
    	 tipo = t;
    	 setGrafico();
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

    public State getState(){
    	return tipo;
    }

    public void setV(){
    	setVisitor(new VisitorJugador(this));
 		 
    }
    
    public void setGrafico(){
    	tipo.setGrafico(grafico);
    }
    
    public JLabel getGrafico() {
    	return grafico;
    }

	@Override
	public void atacar() {
		tipo.atacar();
		
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

	public Visitor getVisitor() {
		return V;
	}
}
