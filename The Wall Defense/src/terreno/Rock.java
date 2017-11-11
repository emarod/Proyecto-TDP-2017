package terreno;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import main.Visitor;
import mapa.Celda;
import Controladores.BancoRecursos;

public class Rock extends Terreno {
	
	//Atributos locales.
	protected int resistencia;
	protected Icon[] graficos;
	protected BancoRecursos banco;
	
	//Constructor.
    public Rock(Celda c, BancoRecursos b){    	
    	celda[0]=c; 
    	banco=b;
    	grafico=new JLabel();
    	resistencia=4;
    	graficos= new Icon[4];
    	graficos[0]=new ImageIcon(this.getClass().getResource("/resources/static/terrenos/roca/roca_0.png"));
    	graficos[1]=new ImageIcon(this.getClass().getResource("/resources/static/terrenos/roca/roca_1.png"));
		graficos[2]=new ImageIcon(this.getClass().getResource("/resources/static/terrenos/roca/roca_2.png"));
		graficos[3]=new ImageIcon(this.getClass().getResource("/resources/static/terrenos/roca/roca_3.png"));
    	grafico.setIcon(graficos[resistencia-1]);
    }
	
    
    
    public void setGrafico(int i) {
		grafico.setIcon(graficos[i]);
	}
    
    public void restarResistencia(int ataque){
    	if(resistencia>0){
    		playSound();
	    	if(resistencia<=ataque){
	    		resistencia = 0;
	    		grafico.setIcon(null);
	        	celda[0].getObjects()[profundidad]=null;
	        	setGrafico(0);
	    	}
	    	else{
	    		resistencia = resistencia - ataque;
	    		setGrafico(resistencia-1);
	    	}
    	}
    }
    
    public void playSound() {
		banco.playRoca();
	}
    
    public boolean accept(Visitor V){
    	return V.VisitRock(this);
    }

}
