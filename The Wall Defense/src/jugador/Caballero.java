package jugador;

import java.util.concurrent.Future;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Caballero extends StateJugador{
	public Caballero() {
		resistencia=10;
		disparos_simultaneos=1;
		disparos_en_ejecucion=0;
		velocidad_disparo=10;
	}
	
	public void setJugador(Jugador jugador){
		this.jugador = jugador;
	}
	
    public Future<?> atacar(){
		return null;
    	
    }
    
    public void setGrafico(JLabel grafico){
    	ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/dinamic/lannister_atacando_8fps.gif"));
		grafico.setIcon(imagen);
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
		return new Caballero();
	}
}
