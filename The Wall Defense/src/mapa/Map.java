package mapa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Map implements Runnable{
	private Celda[][] celdas;
	
	public Map(int width,int height,int sprites) {		
		incializarCeldas(sprites);
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
	    		celdas[x][j]=new celda(letra_actual,this,x,j,t);
	    		gameObject[] objetos=celdas[x][j].getObjects();
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
	   JLabel graf2=new JLabel();
	   graf2.setIcon(new ImageIcon(this.getClass().getResource("/resources/Aguila_"+t+".gif")));
	   graf2.setBounds(32+16*10, 128+16*24, 32, 32);
	   gui.add(graf2,new Integer(2));
	   gameObject[] objetos=celdas[10][24].getObjects();
	   objetos[1]=new Aguila(celdas[10][24],1);
	   objetos=celdas[11][24].getObjects();
	   objetos[1]=new Aguila(celdas[10][24],1);
	   objetos=celdas[10][25].getObjects();
	   objetos[1]=new Aguila(celdas[11][24],1);
	   objetos=celdas[11][25].getObjects();
	   objetos[1]=new Aguila(celdas[10][25],1);
	   
	}
	
	
	
	public void run() {	
		
	}
	
}
