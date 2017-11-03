package disparo;
import main.Unidad;

/*
 * Clase abstracta Disparo.
 * clase que generaliza la idea de un proyectil.
 */

public abstract class Disparo extends Unidad  {
	
	//Constructor.
	public Disparo(int prof){
		profundidad=prof;
		ancho=64;
		alto=64;
	}
	
	//Metodos locales.
	public int getAlto(){
		return alto;
	}
	
	public int getAncho(){
		return ancho;
	}
	
	public void destruir(){
		super.destruir();
	}
	
	//Metodos abstractos.
	public abstract void restarDisparosEnEjecucion();
}