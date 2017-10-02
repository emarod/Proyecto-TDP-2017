package main;
import javax.swing.*;

import mapa.Celda;
public abstract class GameObject {
	protected JLabel grafico;
    protected Celda celda;
    protected int profundidad;
    protected boolean isRunning=true;
    protected java.util.Timer cronometro;
    
    public JLabel getGrafico(){
    	return grafico;
 	}
    public void setGrafico(JLabel graf){
    	grafico=graf;
    }
    public void destruir(){
    	isRunning=false;
    	System.out.println("Grafico"+grafico);
//    	grafico.setIcon(null);
    	celda.getObjects()[profundidad]=null;    	
    }
     
    public abstract boolean Accept(Visitor V);
    public int getProfundidad(){
    	return profundidad;
    }
    public Celda getCelda(){
    	return celda;
    }
    public boolean getIsRunning(){
    	return isRunning;
    }
    public void setIsRunning(boolean is){
    	isRunning=is;
    }
    public void setCelda(Celda c){
    	celda=c;
    }	 
}