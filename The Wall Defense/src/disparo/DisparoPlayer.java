package disparo;
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
	protected int timer;
    public DisparoPlayer(Celda C, Unidad j, int prof,int speed){
       super(C,j,prof,speed);
       System.out.println("Disparo");
       cronometro = new Timer();
       V=new VisitorDisparoPlayer(this);
 	   grafico=new JLabel();
  	   grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/disparo/flecha.png")));
  	   grafico.setBounds(32*celda.getPosX(), 32*celda.getPosY(), 32, 32);
	   celda.getEscenario().agregar(grafico,new Integer(2));
	   timer=1000;
	   celda.getCM().activar(this);
    }
    
    public void run() {
    	if (grafico.getX()>640) {
    		grafico.setBounds(j.getCelda().getPosX()*32, grafico.getY(), getAncho(), getAlto());
    	}
    	else
    		grafico.setBounds(grafico.getX()+1, grafico.getY(), getAncho(), getAlto());
    }

    public void destruir(){
    	super.destruir();
    	Arquero archer=(Arquero)j;
		archer.restarDisparosEnEjecucion();		
	   
	}
    public boolean Accept(Visitor V){
    	return V.visitDisparoPlayer(this);
    }

	@Override
	public void mover() {
		Celda siguiente;
		int x=celda.getPosX();
		int y=celda.getPosY();
		if(x==19) {
			x=j.getCelda().getPosX();
		}
		siguiente=celda.getCelda(x+1,y);
		intercambiar_celdas(siguiente);
		if (timer==0) {
			run();
			timer=10000;
		}
		timer--;		
	}
	
	@Override
	public void atacar() {
		// TODO Auto-generated method stub
	}
    
}
