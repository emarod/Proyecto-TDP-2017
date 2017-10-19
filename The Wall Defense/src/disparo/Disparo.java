package disparo;
import jugador.Arquero;
import main.Unidad;
import main.Visitor;
public abstract class Disparo extends Unidad  {
	protected Arquero arquero;

	protected Disparo(Arquero archer, int prof,int speed){
		profundidad=prof;
		ancho=32;
		alto=32;
		arquero= archer;
		celda=arquero.getJugador().getCelda();
		celda.getObjects()[profundidad]=this;
	}
	
	   
	public abstract boolean Accept(Visitor V);

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