package main;
import javax.swing.*;

import mapa.Celda;
public abstract class GameObject {
	protected JLabel grafico;
    protected Celda [] celda = new Celda[4];
    protected int profundidad;
    
    public JLabel getGrafico(){
    	return grafico;
 	}
    public void setGrafico(JLabel graf){
    	grafico=graf;
    }
    public void destruir(){
    	//GameObject objeto = celda.getObjects()[profundidad];
    	grafico.setIcon(null);
    	celda[0].getObjects()[profundidad]=null;
    }
     
    public abstract boolean accept(Visitor V);
    public int getProfundidad(){
    	return profundidad;
    }
    
    public Celda[] getCeldas(){
    	return celda;
    }    
    
    public void setCelda(Celda c,int pos){
    	celda[pos]=c;
    }
}