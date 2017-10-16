package mapa;

import Controladores.ControladorAtaque;
import Controladores.ControladorMovimiento;
import Controladores.Director;
import enemigo.Enemigo;
import interfaz.Escenario;
//import enemigo.Enemigo;
import main.GameObject;
import obstaculo.*;
import terreno.*;

public class Celda {
	   private GameObject[] listaObjetosLogicos;
	   private Map Map;
	   private int posX;
	   private int posY;
//	   public Celda(){}
	   public Celda(char tipo, Map Mapa,int posX, int posY,int sprite){
		   this.posX=posX;
		   this.posY=posY;
		   Map=Mapa;
	  	   listaObjetosLogicos=new GameObject[5];
	  	   switch(tipo){
	  	   		case  'a' : 
	    			listaObjetosLogicos[0]=null;
	    			break;
	    		case 'b':
	    			//listaObjetosLogicos[0]=new Rock(this,0,sprite);
	    			
	    			break;
	    		case 'c':
	    		case 'd':
	    		case 'e':
	    		case 'f':
	    		case 'g':
	    		case 'h':
	    		case 'i':
	    		case 'j':
	    		case 'k':
	    		case 'l':
	    		case 'm':
	    			listaObjetosLogicos[0]=new Muro(this);
	    			break;
	    		case 'n':
	    			//No necesita el 'sprite' por parametros porque crea un suelo ramdom.
	    			listaObjetosLogicos[0]=new Nieve(this);
	    			break;
	    		case 'o':
	    			//listaObjetosLogicos[0]=new Water(this,tipo,0,sprite);
	    			break;
	    		case 'p':
	    		case 'q':
	    		case 'r':
	    			//Piedra.
	    			listaObjetosLogicos[0]=new Rock(this,1,1);
	    			break;
	    		case 's':
	    		case 't':
	    		case 'u':
	    			//Lateral derecho.
	    			listaObjetosLogicos[0]=new Water(this,'u',0,1);
	    			break;
	    		case 'v':
	    			//Lateral izquierda.
	    			listaObjetosLogicos[0]=new Water(this,'v',0,1);
	    			break;
	    		case 'w':
	    			//Esquina superior izquierda.
	    			listaObjetosLogicos[0]=new Water(this,'w',0,1);
	    			break;
	    		case 'x':
	    			//Esquina inferior izquierda.
	    			listaObjetosLogicos[0]=new Water(this,'x',0,1);
	    			break;
	    		case 'y':
	    			//Esquina superior derecha.
	    			listaObjetosLogicos[0]=new Water(this,'y',0,1);
	    			break;
	    		case 'z':
	    			//Esquina inferior derecha.
	    			listaObjetosLogicos[0]=new Water(this,'z',0,1);
	    			break;
	    		case '1':
	    		case '2':
	    		case '3':
	    		case '4':
	    		case '5':
	    			//listaObjetosLogicos[2]=new Grass(this,tipo,2,sprite);
	    			break;
	    		case '6':
	    			//listaObjetosLogicos[0]=new Pared(this);
	    		break;
	    		case '7':
	    			//listaObjetosLogicos[0]=new Acero(this,0);
	    			
		    			
	   }
	   
	}
	
	public GameObject[] getObjects(){
		return listaObjetosLogicos;
	}
	public int getPosX(){
		return posX;
	}
	public int getPosY(){
		return posY;
	}
	public Celda getCelda(int x, int y){
		return Map.getCelda(x, y);
	}
	public Escenario getEscenario(){
		return Map.getEscenario();
	}
	    
    public Director getDirector() {
    	return Map.getDirector();
    }
    
    public void destruirEnemigo(Enemigo e){
 	   Map.destruirEnemigo(e);
    }
}
