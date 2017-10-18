package jugador;

import java.util.concurrent.Future;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparo.DisparoPlayer;

public class Arquero extends StateJugador{
	
	protected Future<?> shot;
	public Arquero() {
		resistencia=5;
		disparos_simultaneos=1;
		disparos_en_ejecucion=0;
		velocidad_disparo=100;		
		
	}
	
	public void setJugador(Jugador jugador){
		this.jugador = jugador;
		this.jugador.getCelda().getDirector().ejecutar(this.jugador,velocidad_disparo);
	}
	
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/dinamic/Ygritte.gif"));
		grafico.setIcon(imagen);
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
			shot =new DisparoPlayer(this,3,1).getTask();
			disparos_en_ejecucion++;		
    	}		
		return shot;
    }
    
    public void restarDisparosEnEjecucion(){
    	disparos_en_ejecucion--;
    }
    
    public int getDisparosEnEjecucion(){
    	return disparos_en_ejecucion;
    }

	@Override
	public void setGraficos(Icon[] graficos, JLabel grafico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StateJugador clone() {
		return new Arquero();
	}
    
}
