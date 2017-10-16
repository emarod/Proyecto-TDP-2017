package disparo;
import jugador.State;
import main.Unidad;
import main.Visitor;
public abstract class Disparo extends Unidad  {
	protected int ancho;
	protected int alto;
	protected State tipo;

	protected Disparo(State t, int prof,int speed){
		profundidad=prof;
		ancho=32;
		alto=32;
		tipo = t;
		celda=tipo.getJugador().getCelda();
		celda.getObjects()[profundidad]=this;
		this.velocidad=speed;
		mover=false;
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