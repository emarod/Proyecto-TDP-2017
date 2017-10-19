package terreno;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.Visitor;
import mapa.Celda;

public class Nieve extends Terreno {
	
	protected int sprite;
	
	
    public Nieve(Celda c){    	
    	celda=c;  
    	//Este es un random limitado entre 1 y 3, para establecer un rango nuevo Random[n,m]: (Math.random()*m)+n
    	this.sprite = (int) (Math.random() * 3) + 1; 
    	grafico=new JLabel();    	
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/terrenos/nieve/nieve"+sprite+".png")));
    	//grafico.setLayout(new FlowLayout(0, 0, 0));
    	
    	
    }

	@Override
	public boolean Accept(Visitor V) {
		return true;
	}

}
