package obstaculo;

import javax.swing.*;
import main.Visitor;
import mapa.Celda;

/*
 * Clase Rock
 * Clase que determina como esta compuesta y como se comporta una roca.
 */

public class Rock extends Obstaculo implements Runnable{
	
	//Atributos locales.
	protected int resistencia;
	protected int sprite;
	
	//Constructor.
    public Rock(Celda c,int prof,int sprite){
    	profundidad=prof;
    	celda[0]=c;
    	this.sprite=sprite;
    	resistencia=3;
    	grafico=new JLabel();
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/terrenos/roca_"+sprite+".png")));  	
    }
    
    //Metodos locales.
    public int getResistencia(){
    	return resistencia;
    }
    
    public void restarResistencia(){
    	System.out.println("restar resitencia");
    	if(resistencia==1){
    		destruir();
    	}else{
    		resistencia--;
    	}
    }
    
    public int getSprite(){
    	return sprite;
    }
    
    public void destruir(){
    	super.destruir();
    }
    
    //Metodos heredados.
    public void run(){
    	
    }
    
    public boolean accept(Visitor V){
    	return V.VisitRock(this);
    }

}
