package disparo;
import jugador.StateJugador;
import main.Unidad;

public abstract class Disparo extends Unidad  {
	protected StateJugador tipo;

	protected Disparo(StateJugador t, int prof,int speed){
		profundidad=prof;
		ancho=32;
		alto=32;
		tipo = t;
		celda=tipo.getJugador().getCelda();
		celda.getObjects()[profundidad]=this;
		this.velocidad=speed;
	}

	public int getAlto(){
		return alto;
	}
	
	public int getAncho(){
		return ancho;
	}
	
	public void destruir(){
		super.destruir();
	}
	
	public abstract void restarDisparosEnEjecucion();
}