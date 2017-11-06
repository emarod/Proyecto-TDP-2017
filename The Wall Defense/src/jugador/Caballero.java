package jugador;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Celda;

/*
 * Clase Caballero.
 * Clase que especifica las caracteristicas y comportamiento del jugador caballero.
 */

public class Caballero extends Jugador{
	
	//Constructor.
	public Caballero(Celda[] c, int prof) {
		super(c,prof);
		vida=10;
	}
	
	//Metodos heredados.
	
    public void atacar(){
    	
    }
    
    public void setGrafico(JLabel grafico){
    	ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/dinamic/personajes/lannister_atacando.gif"));
		grafico.setIcon(imagen);
    }

	@Override
	public Jugador clone(Celda[] c) {
		//Profundidad 2 predeterminada. Retorna una unidad de mismo tipo.
		Jugador clon = new Caballero(c, 2);
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