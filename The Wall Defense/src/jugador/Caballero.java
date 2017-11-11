package jugador;

import java.util.concurrent.Future;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * Clase Caballero.
 * Clase que especifica las caracteristicas y comportamiento del jugador caballero.
 */

public class Caballero extends PerfilJugador{
	
	//Constructor.
	public Caballero() {
		resistencia=10;
		costo=30;
	}
	
	//Metodos heredados.
	public void setJugador(Jugador jugador){
		this.jugador = jugador;
	}
	
    public Future<?> atacar(){
		return null;
    	
    }
    
    public void setGrafico(JLabel grafico){
    	ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/dinamic/personajes/lannister_atacando.gif"));
		grafico.setIcon(imagen);
    }

	@Override
	public PerfilJugador clone() {
		return new Caballero();
	}
	
	public void playSound() {
		
	}
	
	public void destruir(){
		jugador.getCeldas()[0].getEscenario().remove(jugador.getGrafico());
		jugador.getCeldas()[0].getDirector().desactivar(this.getJugador());
	}
	
	public int getDaño(){
		return daño;
	}
}