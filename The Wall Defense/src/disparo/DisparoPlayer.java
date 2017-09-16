package disparo;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//import interfaz.GUI;
import jugador.Jugador;
import main.Unidad;
import main.Visitor;
import mapa.Celda;

public class DisparoPlayer extends Disparo{
    public DisparoPlayer(Celda C, Unidad j, int prof,int speed){
       super(C,j,prof,speed);
	   V=new VisitorDisparoPlayer(this);
 	   grafico=new JLabel();
  	   grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/disparo.png")));
  	   grafico.setBounds(32+16*celda.getPosX(), 128+16*celda.getPosY(), 16, 16);
	   celda.getGui().add(grafico,new Integer(2));
  	   graficos=new Icon[4];
	   graficos[0]=new ImageIcon(this.getClass().getResource("/resources/disparo.png"));
	   graficos[1]=new ImageIcon(this.getClass().getResource("/resources/disparo.png"));
	   graficos[2]=new ImageIcon(this.getClass().getResource("/resources/disparo.png"));
	   graficos[3]=new ImageIcon(this.getClass().getResource("/resources/disparo.png"));
  	   new DisparoRun(this,dirActual);
    }

    	 public void destruir(){
      	   super.destruir();
      	   
      	   Jugador jug=(Jugador)j;
      	   jug.restarDisparosEnEjecucion();
      	 //GUI.playSound("disparoColision.wav");
      	   
         }
    	 public boolean Accept(Visitor V){
    		 return V.visitDisparoPlayer(this);
    	 }
    
}
