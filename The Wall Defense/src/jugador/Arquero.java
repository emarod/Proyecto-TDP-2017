package jugador;

import mapa.Celda;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparo.DisparoPlayer;

public class Arquero extends State{
	
	protected int disparos_simultaneos;
	protected int disparos_en_ejecucion;
	protected int velocidad_disparo;
	
	public Arquero() {
		disparos_simultaneos=1;
		disparos_en_ejecucion=0;
		velocidad_disparo=500;
		System.out.println("Arquero");
	}
	
	public void setJugador(Jugador jugador){
		this.jugador = jugador;
		this.jugador.getCelda().getCA().activar(this.jugador);
	}
	
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/dinamic/Ygritte.gif"));
		grafico.setIcon(imagen);
	}
	
	public void atacar(){
		if(disparos_en_ejecucion<disparos_simultaneos){
			new DisparoPlayer(this.jugador.getCelda(),this.jugador,3,velocidad_disparo);
    		disparos_en_ejecucion++;
    	}
    }
    
    public void restarDisparosEnEjecucion(){
    	disparos_en_ejecucion--;
    }
    
    public int getDisparosEnEjecucion(){
    	return disparos_en_ejecucion;
    }

	@Override
	public State lvlUp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGraficos(Icon[] graficos, JLabel grafico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}
    
}
