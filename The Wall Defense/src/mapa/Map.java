package mapa;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Random;
import java.io.InputStream;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import Controladores.ControladorAtaque;
import Controladores.ControladorMovimiento;
import enemigo.Enemigo;
import enemigo.WhiteWalker;

import java.io.IOException;

import main.GameObject;
import interfaz.Escenario;
import jugador.Arquero;
import jugador.Caballero;
import jugador.Espadachin;
import jugador.Jugador;

public class Map implements Runnable{
	private Celda[][] celdas;
	private Escenario escenario;
	private ControladorMovimiento cMovimiento;
	private ControladorAtaque cAtacar;
	private JLabel celdaLabel;
	
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
	    			terreno.addMouseListener(
		    				new MouseAdapter() {		    					
		    					
		    					public void mouseClicked(MouseEvent e){
		    						if(celdaLabel==null) {
		    							terreno.setBorder(new LineBorder(new Color(0, 0, 0)));
		    							celdaLabel=terreno;
		    							System.out.println("("+terreno.getX()/32+","+terreno.getY()/32+")");
		    						}
		    						else{
		    							celdaLabel.setBorder(null);
		    							terreno.setBorder(new LineBorder(new Color(0, 0, 0)));
		    							celdaLabel=terreno;
		    							System.out.println("("+terreno.getX()/32+","+terreno.getY()/32+")");
		    							
		    						}
		    					}
		    					
		    					public void mouseEntered(MouseEvent e) {
		    						if(terreno!=celdaLabel) {
		    							terreno.setBorder(new LineBorder(new Color(0, 255, 0)));
		    						}
		    					}
		    					
		    					public void mouseExited(MouseEvent e) {
		    						if(terreno!=celdaLabel) {
		    							terreno.setBorder(null);
		    						}
		    					}
							}
		    					
						);
	    			
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
	   
	}
	
	
	
	public void agregarPersonajeEnMapa(){
		WhiteWalker white_walker2 = new WhiteWalker();
		Enemigo enemigo2 = new Enemigo(celdas[18][2],2,white_walker2);
		white_walker2.setEnemigo(enemigo2);
		celdas[18][2].getObjects()[1]= enemigo2;
		enemigo2.setCelda(celdas[18][2]);
		JLabel graf4 = enemigo2.getGrafico();
		graf4.setBounds(32*18,32*2,32,32);
		escenario.agregar(graf4,new Integer(2));
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

	public void crearPersonaje(String personaje) {
		int x_cel= Math.round(celdaLabel.getX()/32);
		int y_cel= Math.round(celdaLabel.getY()/32);
		
		switch (personaje) {
		case "arquero":
			if(celdaLabel!=null) {
				añadirArquero(x_cel,y_cel);
			}
			break;
			
		case "caballero":
			if(celdaLabel!=null) {
				añadirCaballero(x_cel,y_cel);
			}			
			break;
			
		case "caminante":
			if(celdaLabel!=null) {
				añadirCaminante(x_cel,y_cel);
			}
			break;
			
		case "espadachin":
			if(celdaLabel!=null) {
				añadirEspadachin(x_cel, y_cel);
			}
			break;
			
		case "whitewalker":
			if(celdaLabel!=null) {
				añadirCaminanteEstatico(x_cel,y_cel);
			}
			break;
			
		default:
			System.out.println("No existe la unidad --> "+personaje);
			break;
		}
		
	}
	
	public void añadirArquero(int x,int y) {
		Arquero arquero = new Arquero();
		Jugador jugador1 = new Jugador(celdas[x][y],2,arquero);
		arquero.setJugador(jugador1);
		celdas[x][y].getObjects()[2]= jugador1;
		jugador1.setCelda(celdas[x][y]);
		JLabel graf1 = jugador1.getGrafico();
		graf1.setBounds(32*x,32*y,32,32);
		escenario.agregar(graf1,new Integer(2));
	}
	
	public void añadirCaballero(int x,int y) {
		Caballero caballero = new Caballero();
		Jugador jugador2 = new Jugador(celdas[x][y],2,caballero);
		caballero.setJugador(jugador2);
		celdas[x][y].getObjects()[2]= jugador2;
		jugador2.setCelda(celdas[x][y]);
		JLabel graf2 = jugador2.getGrafico();
		graf2.setBounds(32*x,32*y,32,32);
		escenario.agregar(graf2,new Integer(2));
	}
	
	public void añadirCaminante(int x, int y) {
		WhiteWalker white_walker = new WhiteWalker();
		Enemigo enemigo1 = new Enemigo(celdas[x][y],1,white_walker);
		white_walker.setEnemigo(enemigo1);
		celdas[x][y].getObjects()[1]= enemigo1;
		enemigo1.setCelda(celdas[x][y]);
		JLabel graf3 = enemigo1.getGrafico();
		graf3.setBounds(32*x,32*y,32,32);
		escenario.agregar(graf3,new Integer(2));
	}
	
	public void añadirEspadachin(int x,int y) {
		Espadachin espadachin=new Espadachin();
		Jugador jugador3=new Jugador(celdas[x][y],2,espadachin);
		espadachin.setJugador(jugador3);
		celdas[x][y].getObjects()[2]=jugador3;
		JLabel graf3=jugador3.getGrafico();
		graf3.setBounds(32*x, 32*y, 32, 32);
		escenario.agregar(graf3, new Integer(2));
	}
	
	public void añadirCaminanteEstatico(int x, int y) {
		WhiteWalker white_walker = new WhiteWalker();
		Enemigo enemigo1 = new Enemigo(celdas[x][y],1,white_walker);
		white_walker.setEnemigo(enemigo1);
		enemigo1.getCelda().getCM().desactivar(enemigo1);
		celdas[x][y].getObjects()[1]= enemigo1;
		enemigo1.setCelda(celdas[x][y]);
		JLabel graf3 = enemigo1.getGrafico();
		graf3.setBounds(32*x,32*y,32,32);
		escenario.agregar(graf3,new Integer(2));
	}


	public void hacerDaño() {
		int x_cel= Math.round(celdaLabel.getX()/32);
		int y_cel= Math.round(celdaLabel.getY()/32);
		Celda celda= getCelda(x_cel, y_cel);
		GameObject personaje = celda.getObjects()[1];
		if(personaje!=null) {
			Enemigo e = (Enemigo) personaje;
			e.restarResistencia();
		}
	}	
	
}
