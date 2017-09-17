package mapa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Random;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.io.IOException;

import main.GameObject;
import interfaz.Escenario;

public class Map implements Runnable{
	private Celda[][] celdas;
	private Escenario escenario;
	
	public Map(Escenario stage,int width,int height,int sprites) {
		celdas= new Celda[width][height];
		escenario = stage;
		try {
			inicializarCeldas(sprites);
		}
		catch(FileNotFoundException e){
			System.out.println("ERROR, ARCHIVO DE MAPA NO ENCONTRADO.");
		}
		catch(IOException e){
			System.out.println("ERROR INESPERADO LEYENDO EL ARCHIVO.");
		}
	}
	
	private void inicializarCeldas(int t) throws FileNotFoundException, IOException {
	    String sCurrentLine="";
	    Random rnd=new Random();
	    int r=rnd.nextInt(1);
	    InputStream fileMap = getClass().getResourceAsStream("/resources/mapa_"+r+".txt");
        InputStreamReader entradaMapa = new InputStreamReader(fileMap);

	    BufferedReader bufferMapa = new BufferedReader(entradaMapa);
	  
	    int y=0;
	    while ((sCurrentLine = bufferMapa.readLine()) != null) {
	    	
	    	for (int x=0;x<sCurrentLine.length();x++){
	    		char letra_actual=sCurrentLine.charAt(x);
	    		celdas[x][y]=new Celda(letra_actual,this,x,y,t);
	    		GameObject[] objetos=celdas[x][y].getObjects();
	    		if(objetos[0]!=null){
	    			JLabel terreno=objetos[0].getGrafico();
	    			terreno.setBounds(32+16*x,128+16*y,16,16);
	    		    escenario.add(terreno,new Integer(1));
	    			
	    		}else
	    			if(objetos[2]!=null){
	    				JLabel terreno= objetos[2].getGrafico();
	    				terreno.setBounds(32+16*x,128+16*y,16,16);
	    				escenario.add(terreno,new Integer(3));
	    			}	    		
	    	}
	    	y++;
	    }
	   bufferMapa.close();	   
	}
	
    public Celda getCelda(int x, int y){
    	return celdas[x][y];
    }
    
    public Escenario getEscenario() {
    	return escenario;
    }
    
	public void run() {	
		
	}
	
}
