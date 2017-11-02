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
    	r = (int) (Math.random()*2) ;
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
	   //Codido a prueba de token invulnerable
	   GameObject[] objetos22=celdas[8][4].getObjects();
	   PowerUp p = new Invulnerable(celdas[8][4],4);
	   JLabel grafico22=p.getGraficoToken();
	   objetos22[4]= p;
	   grafico22.setBounds(8*64,4*64,64, 64);
	   escenario.agregar(grafico22,new Integer(2));
	   grafico22.addMouseListener(
		   new MouseAdapter() {
			   public void mouseClicked(MouseEvent e) {
				   if(celdaLabel!=null) {
					   setPowerUp(p);				
				   }
				   
			   }
		   }
	   );
	   //Fin de codigo prueba
	   director.ejecutar(this);
	   
	}
	
	
    public Celda getCelda(int x, int y){
    	return celdas[x][y];
    }
    
    public Escenario getEscenario() {
    	return escenario;
    }
    
    
	public void run() {	
		escenario.repaint();
		agregarPowerUp();
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
						GameObject[] objetosCelda1 =celdas[x_celd][y_celd].getObjects();
						GameObject[] objetosCelda2 =celdas[x_celd+1][y_celd].getObjects();
						objetosCelda1[2]= player;
						objetosCelda2[2]= player;
						player.getCeldas()[0].getObjects()[2]=null;
						player.getCeldas()[1].getObjects()[2]=null;
						player.setCelda(celdas[x_celd][y_celd],0);
						player.setCelda(celdas[x_celd+1][y_celd],1);
						int x_terreno = objetosCelda1[0].getGrafico().getX();
						int y_terreno = objetosCelda1[0].getGrafico().getY();
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

	
	public void crearEnemigo(Enemigo e,int x, int y) {
		System.out.println("Enemigo creado - x:"+x+" y:"+y);
		if(celdas[x][y].getObjects()[2]==null) {
			Celda[] c = new Celda[4];
			c[0] = celdas[x][y];
			Enemigo enemy = e.clone(c);
			celdas[x][y].getObjects()[2]= enemy;
			JLabel icono = enemy.getGrafico();
			enemy.setBancoRecursos(banco);
			icono.setBounds(x*64,y*64,64,64);
			escenario.agregar(icono,new Integer(2));
		}
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
			   grafico2.setBounds(x*64,y*64,64, 64);
	 		   grafico2.addMouseListener(
	 				   new MouseAdapter() {
	 					   public void mouseClicked(MouseEvent e) {
	 						   if(celdaLabel!=null) {
	 							   setPowerUp(p);				
	 						   }
	 						   
	 					   }
	 				   }
	 			);
			   escenario.agregar(grafico2,new Integer(4));
 		  	   break;
 		   case 2:
 			   p = new Bomba(celdas[x][y],4);
 			  grafico2=p.getGraficoToken();
			   objetos2[4]= p;
			   grafico2.setBounds(x*64,y*64,64, 64);
	 		   grafico2.addMouseListener(
	 				   new MouseAdapter() {
	 					   public void mouseClicked(MouseEvent e) {
	 						   if(celdaLabel!=null) {
	 							   setPowerUp(p);				
	 						   }
	 						   
	 					   }
	 				   }
	 			);
			   escenario.agregar(grafico2,new Integer(4));
 		  	   break;
 		   case 3:
 			   p = new Invulnerable(celdas[x][y],4);
 			   grafico2=p.getGraficoToken();
 			   objetos2[4]= p;
 			   grafico2.setBounds(x*64,y*64,64, 64);
 	 		   grafico2.addMouseListener(
 	 				   new MouseAdapter() {
 	 					   public void mouseClicked(MouseEvent e) {
 	 						   if(celdaLabel!=null) {
 	 							   setPowerUp(p);				
 	 						   }
 	 						   
 	 					   }
 	 				   }
 	 			);
 			   escenario.agregar(grafico2,new Integer(4));
 		   		break;
 			}

 		  }
 		else
 		{
 			x=r.nextInt(16);
 			y=r.nextInt(6);
 			
 		}
 	}
	
	public void setPowerUp(PowerUp p){
		int x_cel= Math.round(celdaLabel.getX()/64);
		int y_cel= Math.round(celdaLabel.getY()/64);
		Jugador player = (Jugador) celdas[x_cel][y_cel].getObjects()[2];
		if(	celdas[x_cel][y_cel].getObjects()[2]!=null) {
			p.aplicar(player);
			escenario.remove(p.getGraficoToken());
			p.getGraficoToken().setIcon(null);
			celdas[x_cel][y_cel].getObjects()[4]=p.getCeldas()[0].getObjects()[4];
			p.getGrafico().setBounds(x_cel*64, y_cel*64, 64, 64);
			escenario.agregar(p.getGrafico(), new Integer(4));
		}
	}
}
