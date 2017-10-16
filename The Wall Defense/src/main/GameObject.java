package main;
import javax.swing.*;

import mapa.Celda;
public abstract class GameObject {
	protected JLabel grafico;
    protected Celda celda;
    protected int profundidad;
    protected volatile boolean mover=false;
    
    public JLabel getGrafico(){
    	return grafico;
 	}
    public void setGrafico(JLabel graf){
    	grafico=graf;
    }
    public void destruir(){
    	GameObject objeto = celda.getObjects()[profundidad];
    	grafico.setIcon(null);
    	celda.getObjects()[profundidad]=null;
    }
     
    public abstract boolean Accept(Visitor V);
    public int getProfundidad(){
    	return profundidad;
    }
    
    public Celda getCelda(){
    	return celda;
    }    
    
    public void setCelda(Celda c){
    	celda=c;
    }	 
}