package mapa;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Random;
import java.io.InputStream;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import Controladores.Director;
import enemigo.Enemigo;
import enemigo.WhiteWalker;

import java.io.IOException;

import main.GameObject;
import interfaz.Escenario;
import jugador.Jugador;

public class Map implements Runnable{
	protected Celda[][] celdas;
	protected Escenario escenario;
	protected JLabel celdaLabel;
	protected int puntaje;
	protected int x_mouse;
	protected int y_mouse;
	protected Director director;
	
	public Map(Escenario stage,int width,int height,int sprites) {
		celdas= new Celda[width][height];
		escenario = stage;
		director = new Director();		
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
	    InputStream fileMap = getClass().getResourceAsStream("/resources/mapa_"+1+".txt");
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
	    						System.out.println("click ("+(terreno.getX()+e.getX())+","+(terreno.getY()+e.getY())+")");

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
		    					x_mouse=terreno.getX();
	    						y_mouse=terreno.getY();
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
	    		    escenario.agregar(terreno,new Integer(0));
	    			
	    		}else {
	    			if(objetos[2]!=null){
	    				System.out.println("ghost code");
	    				JLabel terreno= objetos[2].getGrafico();
	    				terreno.setBounds(32*x,32*y,32,32);
	    				escenario.agregar(terreno,new Integer(3));
	    			}
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
		escenario.repaint();
	}
	
	
    public Celda getCelda(int x, int y){
    	return celdas[x][y];
    }
    
    public Escenario getEscenario() {
    	return escenario;
    }
    
    
	public void run() {	
		escenario.repaint();
	}

	public void crearPersonaje(String personaje) {
		int x_cel= Math.round(celdaLabel.getX()/32);
		int y_cel= Math.round(celdaLabel.getY()/32);
		
		switch (personaje) {
		case "caminante":
			if(celdaLabel!=null) {
				añadirCaminante(x_cel,y_cel);
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
	
	public void crearJugador(Jugador j) {		
		int x_cel= Math.round(celdaLabel.getX()/32);
		int y_cel= Math.round(celdaLabel.getY()/32);				
		if(	celdas[x_cel][y_cel].getObjects()[2]==null) {
			Jugador player = j.clone(celdas[x_cel][y_cel]);
			celdas[x_cel][y_cel].getObjects()[2]= player;
			JLabel icono = player.getGrafico();
			icono.setBounds(x_cel*32,y_cel*32,32,32);
			icono.addMouseListener(
				new MouseAdapter() {
					public void mouseReleased(MouseEvent e) {
						int x_cel = Math.round(x_mouse/32); 
						int y_cel = Math.round(y_mouse/32);
						GameObject[] objetosCelda =celdas[x_cel][y_cel].getObjects();
						objetosCelda[2]= player;
						player.getCelda().getObjects()[2]=null;
						player.setCelda(celdas[x_cel][y_cel]);
						int x_terreno = objetosCelda[0].getGrafico().getX();
						int y_terreno = objetosCelda[0].getGrafico().getY();
						player.getGrafico().setBounds(x_terreno, y_terreno, 32, 32);
					}
				}
			);
			icono.addMouseMotionListener(
				new MouseMotionAdapter() {
					public void mouseDragged(MouseEvent e) {
						player.getGrafico().setBounds(x_mouse,y_mouse,32,32);
					}
				}
			);
			escenario.agregar(icono,new Integer(2));
		}
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
		enemigo1.activar();
	}
	
	public void añadirCaminanteEstatico(int x, int y) {
		WhiteWalker white_walker = new WhiteWalker();
		Enemigo enemigo1 = new Enemigo(celdas[x][y],1,white_walker);
		white_walker.setEnemigo(enemigo1);		
		celdas[x][y].getObjects()[1]= enemigo1;
		enemigo1.setCelda(celdas[x][y]);
		JLabel graf3 = enemigo1.getGrafico();
		graf3.setBounds(32*x,32*y,32,32);
		escenario.agregar(graf3,new Integer(2));
		enemigo1.activar();
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

    public void destruirEnemigo(Enemigo e){
    	System.out.println(puntaje);
   	 	puntaje =puntaje+e.getPuntaje();
   	 	System.out.println(puntaje);
   	 	actualizarPuntaje();
   	 	escenario.repaint();
   		 
    }


	private void actualizarPuntaje() {		
		escenario.setPuntaje("Puntaje: "+puntaje);
	}
	
	public Director getDirector() {
		return director;
	}
}
