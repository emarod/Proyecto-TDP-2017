package disparo;
import main.Unidad;
import main.Visitor;
public abstract class Disparo extends Unidad  {
	public Disparo(int prof){
		profundidad=prof;
		ancho=64;
		alto=64;
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