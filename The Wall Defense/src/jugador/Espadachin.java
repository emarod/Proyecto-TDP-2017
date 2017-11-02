package jugador;
import java.util.concurrent.Future;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Espadachin extends StateJugador{
	
	public Espadachin() {
		resistencia=2;
	}
	
	public void setJugador(Jugador jugador){
		this.jugador = jugador;
	}
	
    public Future<?> atacar(){
		return null;
    	
    }
    
    public void setGrafico(JLabel grafico){
    	ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/dinamic/personajes/jon_snow.gif"));
		grafico.setIcon(imagen);
    }

	@Override
	public StateJugador clone() {
		return new Espadachin();
	}
	
	public void playSound() {
	}
}