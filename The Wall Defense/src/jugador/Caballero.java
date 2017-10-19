package jugador;

import java.util.concurrent.Future;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Caballero extends State{
	public Caballero() {
		resistencia=10;
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

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public State clone() {
		return new Caballero();
	}
}
