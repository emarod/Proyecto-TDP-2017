package terreno;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import main.Visitor;
import mapa.Celda;

/*
 * Clase Muro.
 * Clase encargada de establecer el comportamiento del terreno muro.
 */

public class Muro extends Terreno {
	
	//Constructor
    public Muro(Celda c){    	
    	celda[0]=c;  
    	//Este es un random limitado entre 1 y 2, para establecer un rango nuevo Random[n,m]: (Math.random()*m)+n
    	this.sprite = (int) (Math.random() * 2) +1; 
    	grafico=new JLabel();
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/terrenos/muro/muro"+sprite+".png")));
    	
    	
    }

	//Metodos heredados.
	public boolean accept(Visitor V) {
		return false;
	}

}