package enemigo;

import java.util.Random;
import java.util.concurrent.ScheduledFuture;

import javax.swing.JLabel;

import Controladores.Director;
import interfaz.Escenario;
import main.CONFIG;
import mapa.Celda;
import mapa.Mapa;

/*
 * Clase Horda.
 * Clase encargada de crear las hordas de forma random.
 */

public class Horda implements Runnable {

	// Atributos locales.
	protected Celda celda;
	protected Mapa mapa;
	protected Escenario stage;
<<<<<<< HEAD
	protected JLabel graf;
	protected int enemigos = 10;
	protected final int x = 15;
	protected ScheduledFuture<?> activeTask;

	// Constructor.
	public Horda(Escenario s) {
		stage = s;
		mapa = Director.getMapa();
		activeTask = Director.ejecutar(this, 10);
	}

	// Metodos locales.
	public boolean terminoHorda() {
		return enemigos == 0;
	}

	public void actualizarEnemigos() {
		if (enemigos > 0) {
			enemigos--;
			System.out.println("Numero de enemigos en la horda: " + enemigos);
		}
	}

	@Override
	public void run() {
		Random rnd = new Random();
		int r = rnd.nextInt(2);
		int y;
		Enemigo e;
		y = rnd.nextInt(6);
		while (mapa.getCelda(x, y).getObjects()[CONFIG.PROFUNDIDAD_ENEMIGO] != null) {
			y = rnd.nextInt(6);
		}
		Celda c = mapa.getCelda(x, y);
		Celda[] celdas = new Celda[4];
		celdas[0] = c;
		switch (r) {
			case 0: {
				System.out.println("case 0");
				e = new WhiteWalker(celdas, 1);
				mapa.crearEnemigo(e, x, y);
				break;
			}
			case 1: {
				System.out.println("case 1");
				e = new NightKing(celdas, 1);
				mapa.crearEnemigo(e, x, y);
				break;
			}

		}
		enemigos--;
		if (enemigos == 0) {
			activeTask.cancel(true);
			System.out.println("fin horda");
		}
		else {
			System.out.println("quedan " + enemigos + " enemigos");
		}

	}

}
=======
	protected JLabel graf; 
	protected int enemigos=0;
	
	//Constructor.
	public Horda(Escenario s){	
		stage=s;
		mapa=stage.getMapa();
		horda=new Enemigo[1];
		try {
			inicializarHorda();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Metodos locales.
	private void inicializarHorda() throws FileNotFoundException, IOException {
	    String sCurrentLine="";
	    Random rnd=new Random();
	    int r=rnd.nextInt(1);
	    //Este es un random limitado entre 1 y 3, para establecer un rango nuevo Random[n,m]: (Math.random()*m)+n
    	r = (int) (Math.random()*2);
	    InputStream fileHorda = getClass().getResourceAsStream("/resources/horda_"+r+".txt");
        InputStreamReader entradaHorda = new InputStreamReader(fileHorda);
        
	    BufferedReader bufferHorda = new BufferedReader(entradaHorda);
	    
	    int y,x;
	    while ((sCurrentLine = bufferHorda.readLine()) != null) {
	    	for (int i=0;i<sCurrentLine.length();i++){
	    		y= (int) (Math.random()*6);
	    		x = 15;
	    		while(mapa.getCelda(x,y).getObjects()[2]!=null){
	    			y= (int) (Math.random()*6);
	    		}
	    		char tipo =sCurrentLine.charAt(i);
	    		Celda c = mapa.getCelda(x,y);
	    		Celda[] celdas = new Celda[4];
	    		celdas [0]= c;
	    		Enemigo e;
	    		switch(tipo){
		  	   		case 'a':
		    		case 'b':
		    		case 'c':
		    		case 'd':
		    		case 'e':
		    			e = new Enemigo(celdas,1, new WhiteWalker());
		    			System.out.println("x:"+x+" y:"+y);
		    			mapa.crearEnemigo(e, x, y);
		    			enemigos++;
		    			break;
		    		case 'f':
		    		case 'g':
		    		case 'h':
		    		case 'i':
		    		case 'j':
		    		case 'k':
		    		case 'l':
		    		case 'm':
		    		case 'n':
		    			e = new Enemigo(celdas,1, new NightKing());
		    			System.out.println("x:"+x+" y:"+y);
		    			mapa.crearEnemigo(e, x, y);
		    			enemigos++;
		    			break;
		    		case 'o':
		    		case 'p':
		    		case 'q':
		    		case 'r':
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
		    		case '6':
		    		case '7':
	    		}
    		}
	    }
	    
	    System.out.println("Numero de enemigos en la horda: "+enemigos);
	    
	    bufferHorda.close();
    }
	
	public boolean terminoHorda(){
		return enemigos==0;
	}
	
	public void reiniciarHorda(){
		try{
			inicializarHorda();
		}
		catch(Exception e){
			System.out.println("Error al reiniciar la horda.");
		}
	}
	
	public void actualizarEnemigos(){
		if(enemigos>0){
			enemigos--;
			System.out.println("Numero de enemigos en la horda: "+enemigos);
		}
	}
	
}
>>>>>>> master
