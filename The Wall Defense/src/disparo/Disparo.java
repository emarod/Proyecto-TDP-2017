package disparo;
import main.Unidad;
import main.Visitor;
import mapa.Celda;
public abstract class Disparo extends Unidad  {
	protected Unidad j;
	protected int ancho;
	protected int alto;
	
       protected Disparo(Celda C, Unidad j, int prof,int speed){
    	   profundidad=prof;
    	   isRunning=true;
    	   this.j=j;
    	   ancho=16;
    	   alto=16;
    	   dirActual=j.getDireccion();
    	   celda=C;
    	   celda.getObjects()[profundidad]=this;
    	   this.speed=speed;

       }

       
       public abstract boolean Accept(Visitor V);
       public boolean getIsRunning(){
    	   
    	   return isRunning ;
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
       public void restarDisparosEnEjecucion(){}
}