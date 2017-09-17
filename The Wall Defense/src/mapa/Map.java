package mapa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.GameObject;

public class Map implements Runnable{
	private Celda[][] celdas;
	
	public Map(int width,int height,int sprites) {		
		inicializarCeldas(sprites);
	}
	
	private void inicializarCeldas(int t) {
	    String sCurrentLine="";
	    Random rnd=new Random();
	    int r=rnd.nextInt(2);
	    InputStream is = getClass().getResourceAsStream("/resources/mapa_"+r+".txt");
        InputStreamReader isr = new InputStreamReader(is);

	    BufferedReader b = new BufferedReader(isr);
	  
	    int j=0;
	    while ((sCurrentLine = b.readLine()) != null) {
	    	
	    	for (int x=0;x<sCurrentLine.length();x++){
	    		char letra_actual=sCurrentLine.charAt(x);
	    		celdas[x][j]=new Celda(letra_actual,this,x,j,t);
	    		GameObject[] objetos=celdas[x][j].getObjects();
	    		if(objetos[0]!=null){
	    			JLabel graf=objetos[0].getGrafico();
	    			graf.setBounds(32+16*x,128+16*j,16,16);
	    		    gui.add(graf,new Integer(1));
	    			
	    		}else
	    			if(objetos[2]!=null){
	    				JLabel graf=objetos[2].getGrafico();
	    				graf.setBounds(32+16*x,128+16*j,16,16);
	    				gui.add(graf,new Integer(3));
	    			}	    		
	    	}
	    	 j++;
	    }
	   b.close();	   
	}
	
	
	
	public void run() {	
		
	}
	
}
