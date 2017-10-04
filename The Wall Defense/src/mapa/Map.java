package mapa;

import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Random;
import java.io.InputStream;
import javax.swing.JLabel;

import Controladores.ControladorAtaque;
import Controladores.ControladorMovimiento;
import java.io.IOException;

import main.GameObject;
import interfaz.Escenario;
import jugador.Arquero;
import jugador.Caballero;
import jugador.Jugador;

public class Map implements Runnable{
	private Celda[][] celdas;
	private Escenario escenario;
	private ControladorMovimiento cMovimiento;
	private ControladorAtaque cAtacar;
	private MouseEvent oyente;
	
	public Map(Escenario stage,int width,int height,int sprites) {
		celdas= new Celda[width][height];
		escenario = stage;
//		Inicialización de controladores de acciones
		cAtacar=new ControladorAtaque();
		cMovimiento= new ControladorMovimiento();
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
	    			
	    			terreno.setBounds(32*x,32*y,32,32);
	    		    escenario.agregar(terreno,new Integer(1));
	    			
	    		}else
	    			if(objetos[2]!=null){
	    				JLabel terreno= objetos[2].getGrafico();
	    				terreno.setBounds(32*x,32*y,32,32);
	    				escenario.agregar(terreno,new Integer(3));
	    			}	    		
	    	}
	    	y++;
	   }
	   bufferMapa.close();
	   
	   agregarPersonajeEnMapa();
	}
	
	public void agregarPersonajeEnMapa(){
		Arquero arquero = new Arquero();
		Jugador jugador1 = new Jugador(celdas[2][2],2,arquero);
		arquero.setJugador(jugador1);
		celdas[2][2].getObjects()[1]= jugador1;
		jugador1.setCelda(celdas[2][2]);
		JLabel graf1 = jugador1.getGrafico();
		graf1.setBounds(32*2,32*2,32,32);
		escenario.agregar(graf1,new Integer(2));
		  	   
		Caballero caballero = new Caballero();
		Jugador jugador2 = new Jugador(celdas[4][4],2,caballero);
		caballero.setJugador(jugador2);
		celdas[4][4].getObjects()[1]= jugador2;
		jugador2.setCelda(celdas[4][4]);
		JLabel graf2 = jugador2.getGrafico();
		graf2.setBounds(32*4,32*4,32,32);
		escenario.agregar(graf2,new Integer(2));
	}
	
	
    public Celda getCelda(int x, int y){
    	return celdas[x][y];
    }
    
    public Escenario getEscenario() {
    	return escenario;
    }
    
    public ControladorMovimiento getCM() {
    	return cMovimiento;
    }
    
    public ControladorAtaque getCA() {
    	return cAtacar;
    }
    
	public void run() {	
		
	}
	
}
