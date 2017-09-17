package terreno;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.Visitor;
import mapa.Celda;

public class Nieve extends Terreno {
	
	private int sprite;
	
    public Nieve(Celda c,int sprite){    	
    	celda=c;
    	this.sprite=sprite;    	
    	grafico=new JLabel();
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/terrenos/nieve/nieve"+sprite+".png")));
    	
    	
    }

	@Override
	public boolean Accept(Visitor V) {
		// TODO Auto-generated method stub
		return false;
	}

}
