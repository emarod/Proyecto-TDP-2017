package mapa;

import java.util.LinkedList;
<<<<<<< HEAD

=======
import Controladores.Director;
>>>>>>> master
import enemigo.Enemigo;
import interfaz.Escenario;
import main.CONFIG;
import main.GameObject;

/*
 * Clase Celda.
 * Clase encargada de la construccion logica de una posicion en el campo de batalla.
 */

public class Celda {
<<<<<<< HEAD

	// Atributos locales.
	protected GameObject[] listaObjetosLogicos;
	protected Mapa mapa;
	protected int posX;
	protected int posY;
	protected boolean hayDisparo;
	protected boolean estaOcupada;
	protected LinkedList<GameObject> disparos;

	// Constructor.
	public Celda(Mapa mapa, int posX, int posY) {
		hayDisparo = false;
		this.posX = posX;
		this.posY = posY;
		this.mapa = mapa;
		listaObjetosLogicos = new GameObject[CONFIG.PROFUNDIDAD_CELDA];
		disparos = new LinkedList<GameObject>();
=======
		
		//Atributos locales.
	   protected GameObject[] listaObjetosLogicos;
	   protected Map Map;
	   protected int posX;
	   protected int posY;
	   protected boolean hayDisparo;
	   protected boolean estaOcupada;
	   protected LinkedList<GameObject> disparos;
	   
	   //Constructor.
	   public Celda(char tipo, Map Mapa,int posX, int posY,int sprite){
		   hayDisparo=false;
		   this.posX=posX;
		   this.posY=posY;
		   Map=Mapa;
	  	   listaObjetosLogicos=new GameObject[7];
	  	   disparos = new LinkedList<GameObject>();
	  	   switch(tipo){
	  	   		case  'a' : 
	    			listaObjetosLogicos[0]=null;
	    			break;
	    		case 'b':
	    		case 'c':
	    			//Centro lago.
	    			listaObjetosLogicos[0]=new Water(this,'c',0,1);
	    			break;
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
	    			listaObjetosLogicos[0]=new Rock(this,Map.banco);		
	    			break;
	    		case 's':
	    			//Lateral vertical sup.
	    			listaObjetosLogicos[0]=new Water(this,'s',0,1);
	    			break;
	    		case 't':
	    			//Lateral vertical inf.
	    			listaObjetosLogicos[0]=new Water(this,'t',0,1);
	    			break;
	    		case 'u':
	    			//Lateral horizontal derecho.
	    			listaObjetosLogicos[0]=new Water(this,'u',0,1);
	    			break;
	    		case 'v':
	    			//Lateral horizontal izquierdo.
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
	   
>>>>>>> master
	}

	// Metodos locales.
	public GameObject[] getObjects() {
		refresh();
		return listaObjetosLogicos;
	}

	public void addDisparo(GameObject d) {
		if (hayDisparo) {
			disparos.addFirst(d);
			refresh();
		}
		else {
			listaObjetosLogicos[6] = d;
			hayDisparo = true;
		}
	}

	public void refresh() {
		if (listaObjetosLogicos[CONFIG.PROFUNDIDAD_DISPARO] == null) {
			if (hayDisparo) {
				GameObject recarga = disparos.pollLast();
				if (recarga != null) {
					listaObjetosLogicos[CONFIG.PROFUNDIDAD_DISPARO] = recarga;
				}
				else {
					hayDisparo = false;
				}
			}
		}
	}

	public GameObject hayDisparo() {
		return listaObjetosLogicos[CONFIG.PROFUNDIDAD_DISPARO];
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public Celda getCelda(int x, int y) {
		return mapa.getCelda(x, y);
	}

	public Escenario getEscenario() {
		return mapa.getEscenario();
	}

	public void destruirEnemigo(Enemigo e) {
		mapa.destruirEnemigo(e);
	}

	// Si la celda contiene un enemigo, aliado, o obstaculo lo retorna cc null
	public GameObject estaOcupada() {
		int i = 1;
		while (!estaOcupada && i < 3) {
			if (listaObjetosLogicos[i] != null) {
				estaOcupada = true;
			}
		}
		return listaObjetosLogicos[i];
	}

}
