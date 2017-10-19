package terreno;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.Visitor;
import mapa.Celda;

public class Muro extends Terreno {
	
	protected int sprite;
	
	
    public Muro(Celda c){    	
    	celda=c;  
    	//Este es un random limitado entre 1 y 2, para establecer un rango nuevo Random[n,m]: (Math.random()*m)+n
    	this.sprite = (int) (Math.random() * 2) +1; 
    	grafico=new JLabel();
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/terrenos/muro/muro"+sprite+".png")));
    	
    	
    }

	@Override
	public boolean Accept(Visitor V) {
		// TODO Auto-generated method stub
		return false;
	}

}