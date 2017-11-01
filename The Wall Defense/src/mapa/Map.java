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

import Controladores.BancoRecursos;
import Controladores.Director;
import enemigo.Enemigo;
import enemigo.WhiteWalker;

import java.io.IOException;

import main.GameObject;
import powerUp.Bomba;
import powerUp.DañoAtkAumentado;
import powerUp.VelAtkAumentado;
import powerUp.Invulnerable;
import powerUp.PowerUp;
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
	protected BancoRecursos banco;
	
	public Map(Escenario stage,int width,int height,int sprites) {
		celdas= new Celda[width][height];
		escenario = stage;
		director = new Director();
		banco = new BancoRecursos();
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
	    //Este es un random limitado entre 1 y 3, para establecer un rango nuevo Random[n,m]: (Math.random()*m)+n
    	r = (int) (Math.random()*2)+1 ;
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
	    						System.out.println("click ("+(terreno.getX()+e.getX())+","+(terreno.getY()+e.getY())+")");

	    						if(celdaLabel==null) {
	    							terreno.setBorder(new LineBorder(new Color(0, 0, 0)));
	    							celdaLabel=terreno;
	    							System.out.println("("+terreno.getX()/64+","+terreno.getY()/64+")");
	    						}
	    						else{
	    							celdaLabel.setBorder(null);
	    							terreno.setBorder(new LineBorder(new Color(0, 0, 0)));
	    							celdaLabel=terreno;
	    							System.out.println("("+terreno.getX()/64+","+terreno.getY()/64+")");
	    							
	    						}
	    					}
	    					
	    					public void mouseEntered(MouseEvent e) {
		    					x_mouse=terreno.getX();
	    						y_mouse=terreno.getY();
	    						if(terreno!=celdaLabel) {
	    							terreno.setBorder(new LineBorder(new Color(255, 0, 0)));
	    						}
	    					}
	    					
	    					public void mouseExited(MouseEvent e) {
		    					if(terreno!=celdaLabel) {
	    							terreno.setBorder(null);
	    						}
	    					}
						}
		    					
					);
	    			terreno.setBounds(64*x,64*y,64,64);
	    		    escenario.agregar(terreno,new Integer(0));
	    			
	    		}else {
	    			if(objetos[2]!=null){
	    				System.out.println("ghost code");
	    				JLabel terreno= objetos[2].getGrafico();
	    				terreno.setBounds(64*x,64*y,64,64);
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
		enemigo2.setCelda(celdas[18][2],0);
		JLabel graf4 = enemigo2.getGrafico();
		graf4.setBounds(64*18,64*2,64,64);
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
		int x_cel= Math.round(celdaLabel.getX()/64);
		int y_cel= Math.round(celdaLabel.getY()/64);
		
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
		int x_cel= Math.round(celdaLabel.getX()/64);
		int y_cel= Math.round(celdaLabel.getY()/64);			
		if(	celdas[x_cel][y_cel].getObjects()[2]==null) {
			Celda[] c = new Celda[1];
			c[0] = celdas[x_cel][y_cel];
			Jugador player = j.clone(c);
			celdas[x_cel][y_cel].getObjects()[2]= player;
			JLabel icono = player.getGrafico();
			player.setBancoRecursos(banco);
			icono.setBounds(x_cel*64,y_cel*64,64,64);
			icono.addMouseListener(
				new MouseAdapter() {
					public void mouseReleased(MouseEvent e) {
						int x_cel = Math.round(x_mouse/64); 
						int y_cel = Math.round(y_mouse/64);
						GameObject[] objetosCelda =celdas[x_cel][y_cel].getObjects();
						objetosCelda[2]= player;
						player.getCeldas()[0].getObjects()[2]=null;
						player.setCelda(celdas[x_cel][y_cel],0);
						int x_terreno = objetosCelda[0].getGrafico().getX();
						int y_terreno = objetosCelda[0].getGrafico().getY();
						player.getGrafico().setBounds(x_terreno, y_terreno, 64, 64);
					}
				}
			);
			icono.addMouseMotionListener(
				new MouseMotionAdapter() {
					public void mouseDragged(MouseEvent e) {
						player.getGrafico().setBounds(x_mouse,y_mouse,64,64);
					}
				}
			);
			escenario.agregar(icono,new Integer(2));
		}
	}
	
	public void crearJugadorLargo(Jugador j) {		
		int x_cel= Math.round(celdaLabel.getX()/64);
		int y_cel= Math.round(celdaLabel.getY()/64);			
		if(	celdas[x_cel][y_cel].getObjects()[2]==null && celdas[x_cel+1][y_cel].getObjects()[2]==null) {
			Celda[] c = new Celda[2];
			c[0] = celdas[x_cel][y_cel];
			c[1] = celdas[x_cel+1][y_cel];
			Jugador player = j.clone(c);
			celdas[x_cel][y_cel].getObjects()[2]= player;
			celdas[x_cel+1][y_cel].getObjects()[2]= player;
			JLabel icono = player.getGrafico();
			player.setBancoRecursos(banco);
			icono.setBounds(x_cel*64,y_cel*64,128,64);
			
			//Codigo de soltado de mouse.
			icono.addMouseListener(
				new MouseAdapter() {
					public void mouseReleased(MouseEvent e) {
						int x_celd = Math.round(x_mouse/64); 
						int y_celd = Math.round(y_mouse/64);
						GameObject[] objetosCelda =celdas[x_celd][y_celd].getObjects();
						objetosCelda[2]= player;
						player.getCeldas()[0].getObjects()[2]=null;
						player.setCelda(celdas[x_cel][y_cel],0);
						player.getCeldas()[1].getObjects()[2]=null;
						player.setCelda(celdas[x_cel][y_cel],1);
						int x_terreno = objetosCelda[0].getGrafico().getX();
						int y_terreno = objetosCelda[0].getGrafico().getY();
						player.getGrafico().setBounds(x_terreno, y_terreno,128, 64);
					}
				}
			);
			
			//Codigo del arrastrado en mapa.
			icono.addMouseMotionListener(
				new MouseMotionAdapter() {
					public void mouseDragged(MouseEvent e) {
						player.getGrafico().setBounds(x_mouse,y_mouse,128,64);
					}
				}
			);
			escenario.agregarLargo(icono,new Integer(2));
		}
	}
	
	public void añadirCaminante(int x, int y) {
		WhiteWalker white_walker = new WhiteWalker();
		Enemigo enemigo1 = new Enemigo(celdas[x][y],1,white_walker);
		white_walker.setEnemigo(enemigo1);
		celdas[x][y].getObjects()[1]= enemigo1;
		enemigo1.setCelda(celdas[x][y],0);
		JLabel graf3 = enemigo1.getGrafico();
		graf3.setBounds(64*x,64*y,64,64);
		escenario.agregar(graf3,new Integer(2));
		enemigo1.activar();
	}
	
	public void añadirCaminanteEstatico(int x, int y) {
		WhiteWalker white_walker = new WhiteWalker();
		Enemigo enemigo1 = new Enemigo(celdas[x][y],1,white_walker);
		white_walker.setEnemigo(enemigo1);		
		celdas[x][y].getObjects()[1]= enemigo1;
		enemigo1.setCelda(celdas[x][y],0);
		JLabel graf3 = enemigo1.getGrafico();
		graf3.setBounds(64*x,64*y,64,64);
		escenario.agregar(graf3,new Integer(2));
		enemigo1.activar();
	}


	public void hacerDaño() {
		int x_cel= Math.round(celdaLabel.getX()/64);
		int y_cel= Math.round(celdaLabel.getY()/64);
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
	
	private void agregarPowerUp(){
 		Random r=new Random();
 		int x=r.nextInt(16);
 		int y=r.nextInt(6);
 			
 		if(celdas[x][y].getObjects()[4]==null){
 		   GameObject[] objetos2=celdas[x][y].getObjects();
 		   int c=r.nextInt(3)+0;
 		   PowerUp p;
 		   JLabel grafico2;
 		   switch(c){
 		   case 0:
 			   p=new DañoAtkAumentado(celdas[x][y],4);
 		  	   break;
 		  case 1:
 			   p=new VelAtkAumentado(celdas[x][y],4);
 			   grafico2=p.getGraficoToken();
			   objetos2[4]= p;
			   grafico2.setBounds(x,y,64, 64);
			   escenario.agregar(grafico2,new Integer(2));
 		  	   break;
 		   case 2:
 			   p = new Bomba(celdas[x][y],4);
 			  grafico2=p.getGraficoToken();
			   objetos2[4]= p;
			   grafico2.setBounds(x,y,64, 64);
			   escenario.agregar(grafico2,new Integer(2));
 		  	   break;
 		   case 3:
 			   p = new Invulnerable(celdas[x][y],4);
 			   grafico2=p.getGraficoToken();
 			   objetos2[4]= p;
 			   grafico2.setBounds(x,y,64, 64);
 			   escenario.agregar(grafico2,new Integer(2));
 		   		break;
 			}
 		  }
 		else
 		{
 			x=r.nextInt(16);
 			y=r.nextInt(6);
 			
 		}
 	}
}
