package terreno;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import main.Visitor;
import mapa.Celda;

/*
 * Clase Nieve.
 * Clase encargada de establecer el comportamiento del terreno nieve.
 */

public class Nieve extends Terreno {
	
	//Constructor.
    public Nieve(Celda c){    	
    	celda[0]=c;  
    	//Este es un random limitado entre 1 y 3, para establecer un rango nuevo Random[n,m]: (Math.random()*m)+n
    	this.sprite = (int) (Math.random() * 3) + 1; 
    	grafico=new JLabel();    	
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/terrenos/nieve/nieve"+sprite+".png")));
    }

	//Metodos heredados.
	public boolean accept(Visitor V) {
		return true;
	}

}
