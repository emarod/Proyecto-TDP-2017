package jugador;

import java.util.concurrent.Future;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparo.DisparoDragon;

public class Dragon extends StateJugador {

	protected Future<?> shot;
	protected int velocidad_disparo;
	protected int disparos_simultaneos;
	protected int disparos_en_ejecucion;
	
	public Dragon() {
		velocidad_jugador=20;
		resistencia=5;
		disparos_simultaneos=1;
		disparos_en_ejecucion=0;
		velocidad_disparo=75;
		graficos= new Icon[8];
		graficos[0]=new ImageIcon(this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_0.png"));
		graficos[1]=new ImageIcon(this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_1.png"));
		graficos[2]=new ImageIcon(this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_2.png"));
		graficos[3]=new ImageIcon(this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_3.png"));
		graficos[4]=new ImageIcon(this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_4.png"));
		graficos[5]=new ImageIcon(this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_5.png"));
		graficos[6]=new ImageIcon(this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_6.png"));
		graficos[7]=new ImageIcon(this.getClass().getResource("/resources/static/dragon_atacando/dragon_atacando_7.png"));
	}
	
	public void setJugador(Jugador jugador){
		this.jugador = jugador;
		this.jugador.getCeldas()[0].getDirector().ejecutar(this.jugador,velocidad_jugador);
	}
	
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/dinamic/dragon_atacando.gif"));
		graph=0;
		grafico.setIcon(imagen);		
	}
	
	public void animarDisparo() {
		if(graph<4) {
			graph++;
		}
		setGrafico(graph);
		if(graph == 4){
			setGrafico(0);
		}		
	}
	
	public void setGrafico(int i) {
		jugador.getGrafico().setIcon(graficos[i]);
	}
	
	public StateJugador clone() {
		return new Dragon();
	}

	public int getVelocidadDisparo() {
		return velocidad_disparo;
	}
	
	public Future<?> atacar(){		
		if(disparos_en_ejecucion<disparos_simultaneos){
			jugador.playSound();
			shot = new DisparoDragon(this,6).getTask();			
			disparos_en_ejecucion++;
    	}
		graph=0;
		return shot;
    }
	
	public void restarDisparosEnEjecucion(){
    	disparos_en_ejecucion--;
    }
    
    public int getDisparosEnEjecucion(){
    	return disparos_en_ejecucion;
    }
	
	public void playSound() {
		jugador.getBancoRecursos().playBolaFuego();
	}
}
