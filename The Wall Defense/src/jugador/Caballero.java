package jugador;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Celda;

/*
 * Clase Caballero.
 * Clase que especifica las caracteristicas y comportamiento del jugador caballero.
 */

<<<<<<< HEAD
public class Caballero extends Jugador {

	// Constructor.
	public Caballero(Celda[] c) {
		super(c);
		vida = 10;
		velocidad = 10;
		setGrafico(grafico);
	}

	// Metodos heredados.

	@Override
	public void atacar() {

	}

	@Override
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(
				this.getClass().getResource("/resources/dinamic/personajes/lannister_atacando.gif"));
=======
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
>>>>>>> master
		grafico.setIcon(imagen);
	}

	@Override
	public Jugador clone(Celda[] c) {
		// Profundidad 2 predeterminada. Retorna una unidad de mismo tipo.
		Jugador clon = new Caballero(c);
		return clon;

	}

	@Override
	public void playSound() {

	}
<<<<<<< HEAD

	@Override
	public void destruir() {
		super.destruir();
=======
	
	public void destruir(){
		jugador.getCeldas()[0].getEscenario().remove(jugador.getGrafico());
		jugador.getCeldas()[0].getDirector().desactivar(this.getJugador());
>>>>>>> master
	}

	@Override
	public int getDaño() {
		return daño;
	}

	@Override
	public void mover() {
	}
}