package jugador;

import java.util.concurrent.Future;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import disparo.DisparoArquero;

/*
 * Clase Arquero.
 * Clase que especifica las caracteristicas y comportamiento del jugador arquero.
 */

public class Arquero extends PerfilJugador{
	
	//Atributos locales.
	protected Future<?> shot;
	protected int velocidad_disparo;
	protected int disparos_simultaneos;
	protected int disparos_en_ejecucion;
	
	//Constructor.
	public Arquero() {
		velocidad_jugador=15;
		resistencia=2;
		daño = 1;
		disparos_simultaneos=1;
		disparos_en_ejecucion=0;
		velocidad_disparo=75;
		graficos= new Icon[5];
		//Areglo que divide el sprite en capas para poder simular el movimiento.
		graficos[0]=new ImageIcon(this.getClass().getResource("/resources/static/ygritte_atacando/ygritte_atacando_0.png"));
		graficos[1]=new ImageIcon(this.getClass().getResource("/resources/static/ygritte_atacando/ygritte_atacando_1.png"));
		graficos[2]=new ImageIcon(this.getClass().getResource("/resources/static/ygritte_atacando/ygritte_atacando_2.png"));
		graficos[3]=new ImageIcon(this.getClass().getResource("/resources/static/ygritte_atacando/ygritte_atacando_3.png"));
		graficos[4]=new ImageIcon(this.getClass().getResource("/resources/static/ygritte_atacando/ygritte_atacando_4.png"));
	}
	
	//Metodos locales.
	public void animarDisparo() {
		if(graph<4) {
			graph++;
		}
		setGrafico(graph);
		if(graph == 4){
			setGrafico(0);
		}
	}
    
    public void restarDisparosEnEjecucion(){
    	disparos_en_ejecucion--;
    }
    
    public int getDisparosEnEjecucion(){
    	return disparos_en_ejecucion;
    }
    
    public void setGrafico(int i) {
		jugador.getGrafico().setIcon(graficos[i]);
	}

	public int getVelocidadDisparo() {
		return velocidad_disparo;
	}

	//Metodos heredados.
	public PerfilJugador clone() {
		return new Arquero();
	}
	
	public void playSound() {
		jugador.getBancoRecursos().playFlecha();
	}
	
	public void destruir(){
		
	}
	
	public Future<?> atacar(){
//		int xCelda=jugador.getCelda().getPosX();
//		int yCelda=jugador.getCelda().getPosY();
//		for(int x =0;jugador.getCelda().getPosX()<19 && atacar;x++) {
//			Celda siguiente = jugador.getCelda().getCelda(xCelda+1,yCelda);
//			GameObject objeto =siguiente.getObjects()[2];					
//			if (objeto!=null && !objeto.Accept(jugador.getVisitor())){
//				atacar=false;
//			}
//		}		
		if(disparos_en_ejecucion<disparos_simultaneos){
			jugador.playSound();
			shot =new DisparoArquero(this,6).getTask();			
			disparos_en_ejecucion++;
    	}
		graph=0;
		return shot;
    }
	
	public void setJugador(Jugador jugador){
		this.jugador = jugador;
		this.jugador.getCeldas()[0].getDirector().ejecutar(this.jugador,velocidad_jugador);
	}
	
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/static/ygritte_atacando/ygritte_atacando_0.png"));
		graph=0;
		grafico.setIcon(imagen);		
	}
    
	public int getDaño(){
		return daño;
	}
}