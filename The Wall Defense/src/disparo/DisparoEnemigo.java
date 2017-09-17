package disparo;
import mapa.Celda;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import main.Unidad;
import main.Visitor;
public class DisparoEnemigo extends Disparo{
   public DisparoEnemigo(Celda c,Unidad e, int prof,int speed,int tipo){
	   super(c,e,prof,speed);
	   V=new VisitorDisparoEnemigo(this);
	   grafico=new JLabel();
  	   grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/DisparoEnemigo"+tipo+".png")));
  	   grafico.setBounds(32+16*celda.getPosX(), 128+16*celda.getPosY(), 16, 16);
	   //celda.getGui().add(grafico,new Integer(2));
  	   graficos=new Icon[4];
	   graficos[0]=new ImageIcon(this.getClass().getResource("/resources/DisparoEnemigo"+tipo+".png"));
	   graficos[1]=new ImageIcon(this.getClass().getResource("/resources/DisparoEnemigo"+tipo+".png"));
	   graficos[2]=new ImageIcon(this.getClass().getResource("/resources/DisparoEnemigo"+tipo+".png"));
	   graficos[3]=new ImageIcon(this.getClass().getResource("/resources/DisparoEnemigo"+tipo+".png"));
	  
  	   new DisparoRun(this,dirActual);
	   
   }
   public boolean Accept(Visitor V){
	   return V.visitDisparoEnemigo(this);
   }
}
