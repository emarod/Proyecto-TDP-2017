package obstaculo;
import mapa.Celda;
import main.Visitor;
import javax.swing.*;
public class Water extends obstaculo {
   public Water(Celda c,char tipo,int prof,int sprite){
	   profundidad=prof;
	   celda=c;
	   grafico=new JLabel();
	   grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/"+tipo+"_"+sprite+".png")));
   }
   
   public boolean Accept(Visitor V){
	   return V.VisitWater(this);
   }
}
