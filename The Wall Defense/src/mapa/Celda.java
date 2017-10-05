package mapa;

import Controladores.ControladorAtaque;
import Controladores.ControladorMovimiento;
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
	    			//listaObjetosLogicos[0]=new Bridge(this,tipo,0);
	    			break;
	    		case 's':
	    		case 't':
	    		case 'u':
	    		case 'v':
	    		case 'w':
	    		case 'x':
	    		case 'y':
	    		case 'z':
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
	
    public ControladorMovimiento getCM() {
    	return Map.getCM();
    }
    
    public ControladorAtaque getCA() {
    	return Map.getCA();
    }
    
    public void destruirEnemigo(Enemigo e){
 	   Map.destruirEnemigo(e);
    }
}
