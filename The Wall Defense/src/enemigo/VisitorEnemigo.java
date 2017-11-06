package enemigo;

import obstaculo.*;
import disparo.Disparo;
import jugador.Jugador;
import main.Visitor;
import terreno.Rock;

/*
 * Clase VisitorEnemigo.
 * Clase encargada de implementar correctamente las colisiones de los enemigos.
 * Especifica sus comportamientos mediante un patron de diseño visitor.
 */

public class VisitorEnemigo extends Visitor{
	
	//Atributos locales.
	protected Enemigo enemigo;
	
	//Constructor.
	public VisitorEnemigo(Enemigo e){
    	enemigo = e;
    }
    
	//Metodos heredados.
	public boolean visitObstaculo(Obstaculo o) {
		o.restarResistencia(enemigo.getDaño());
		return false;
	}
	
   public  boolean VisitRock(Rock r){
	   r.restarResistencia(enemigo.getDaño());
	   return false;
   }
   
   /*
   public  boolean VisitBarricada(Barricada b){
	   b.restarResistencia();
	   return false;
   }
   */
	
   public  boolean VisitWater(Water w){
	   enemigo.relentizar(w.getPenalizacion());
	   return true;
   }
   
   public  boolean visitPlayer(Jugador j){
	   System.out.println("el juagador visita a enemigo");
	   j.restarResistencia(enemigo.getDaño());
	   return false;
   }
   
   public boolean visitDisparoPlayer(Disparo d){
	   d.destruir();
	   enemigo.restarResistencia(d.getDaño());
	   return true;
   }   
   
   public boolean visitEnemigo(Enemigo e){
	   return false;
   }
}