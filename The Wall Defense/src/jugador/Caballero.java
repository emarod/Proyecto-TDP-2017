package jugador;

import java.util.concurrent.Future;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

<<<<<<< HEAD
public class Caballero extends StateJugador{
=======
public class Caballero extends State{
>>>>>>> refs/remotes/origin/hilos
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
	public StateJugador clone() {
		return new Caballero();
	}
}
