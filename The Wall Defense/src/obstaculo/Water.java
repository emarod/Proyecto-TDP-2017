package obstaculo;
import mapa.Celda;
import main.Visitor;

import java.awt.FlowLayout;

import javax.swing.*;
public class Water extends Obstaculo {
   public Water(Celda c,char tipo,int prof,int sprite){
	   profundidad=prof;
	   celda=c;
	   grafico=new JLabel();
	   switch(tipo){
		case 'u':
			//Lateral derecho.
			grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/lago_lateral_der_"+sprite+".gif")));
			break;
		case 'v':
			//Lateral izquierda.
			grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/lago_lateral_izq_"+sprite+".gif")));
			break;
		case 'w':
			//Esquina superior izquierda.
			grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/lago_esquina_sup_izq_"+sprite+".gif")));
			break;
		case 'x':
			//Esquina inferior izquierda.
			grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/lago_esquina_inf_izq_"+sprite+".gif")));
			break;
		case 'y':
			//Esquina superior derecha.
			grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/lago_esquina_sup_der_"+sprite+".gif")));
			break;
		case 'z':
			//Esquina inferior derecha.
			grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/lago_esquina_inf_der_"+sprite+".gif")));
			break;	
   		}
	   grafico.setLayout(new FlowLayout(0, 0, 0));
   }
   
   public boolean Accept(Visitor V){
	   return V.VisitWater(this);
   }
}
