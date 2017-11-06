package jugador;

import java.util.concurrent.Future;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Celda;

/*
 * Clase Espadachin.
 * Clase que especifica las caracteristicas y comportamiento del jugador espadachin.
 */

public class Espadachin extends Jugador{
	
	//Constructor.
	public Espadachin(Celda[] c, int prof) {
		super(c,prof);
		vida=2;
	}
	
	//Metodos heredados.
	
    public void atacar(){    	
    }
    
    public void setGrafico(JLabel grafico){
    	ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/dinamic/personajes/jon_snow.gif"));
		grafico.setIcon(imagen);
    }

	public Jugador clone(Celda[] c) {
		//Profundidad 2 predeterminada. Retorna una unidad de mismo tipo.
		Jugador clon = new Espadachin(c, 2);
		return clon;
		}
	
	public void playSound() {
		
	}
	
	public void destruir(){
		super.destruir();		
	}
	
	public int getDaño(){
		return daño;
	}

	@Override
	public void mover() {
	}
}