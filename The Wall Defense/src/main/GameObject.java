package main;
import javax.swing.*;

import mapa.Celda;
public abstract class GameObject {
	protected JLabel grafico;
    protected Celda celda;
    protected int profundidad;
    protected boolean isRunning=true;
    
    public JLabel getGrafico(){
    	return grafico;
 	}
    public void setGrafico(JLabel graf){
    	grafico=graf;
    }
    public void destruir(){
    	isRunning=false;
//    	GameObject objeto = celda.getObjects()[profundidad];
    	GameObject objeto = celda.getObjects()[1];
    	System.out.println("profundidad "+profundidad);
    	for (GameObject obj : celda.getObjects()) {
    		System.out.println("objeto "+obj);
		}
    	objeto.getGrafico().setIcon(null);
    	System.out.println("grafico "+grafico);
//    	celda.getObjects()[profundidad]=null;
    	celda.getObjects()[1]=null;
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