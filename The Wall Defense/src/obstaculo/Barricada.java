package obstaculo;

import javax.swing.*;
import main.Visitor;
import mapa.Celda;

/*
 * Clase Rock
 * Clase que determina como esta compuesta y como se comporta una roca.
 */

public class Barricada extends Obstaculo implements Runnable{
	
	//Atributos locales.
	protected int resistencia;
	
	//Constructor.
    public Barricada(Celda c,int prof){
    	profundidad=prof;
    	celda[0]=c;
    	resistencia=3;
    	grafico=new JLabel();
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/terrenos/barricada_momentanea.png")));  	
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
    
    public void destruir(){
    	super.destruir();
    }
    
    //Metodos heredados.
    public void run(){
    	
    }
    
    public boolean accept(Visitor V){
    	return V.VisitBarricada(this);
    }

}
