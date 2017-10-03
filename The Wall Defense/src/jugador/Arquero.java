package jugador;

import mapa.Celda;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparo.DisparoPlayer;

public class Arquero extends Jugador{
	
	protected JLabel imagen;
	protected int disparos_simultaneos;
	protected int disparos_en_ejecucion;
	protected int velocidad_disparo;
	
	public Arquero(Celda c, int prof) {
		super(c, prof);
		imagen = new JLabel(new ImageIcon(this.getClass().getResource("/resources/dinamic/Ygritte.gif")));
		setGrafico(imagen);
		disparos_simultaneos=1;
		disparos_en_ejecucion=0;
		velocidad_disparo=10000;
		c.getCA().activar(this);
		System.out.println("Arquero");
	}
	
	public void atacar(){
		if(disparos_en_ejecucion<disparos_simultaneos){
			new DisparoPlayer(this.getCelda(),this,3,velocidad_disparo);
    		disparos_en_ejecucion++;
    	}
    }
    
    public void restarDisparosEnEjecucion(){
    	disparos_en_ejecucion--;
    }
    
    public int getDisparosEnEjecucion(){
    	return disparos_en_ejecucion;
    }
    
    
}
