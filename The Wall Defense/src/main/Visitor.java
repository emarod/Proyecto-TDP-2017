package main;

import disparo.Disparo;
import enemigo.Enemigo;
import jugador.Jugador;
import obstaculo.*;

/*
 * Clase Visitor.
 * Clase que generaliza la noción del visitador.
 * Esta clase es parte de la aplicación del diseño visitor.
 */

public abstract  class Visitor {
	   
	//Metodos abstractos.
   public abstract boolean VisitRock(Rock r);
   public abstract boolean VisitWater(Water w);
   public abstract boolean visitPlayer(Jugador j);
   public abstract boolean visitDisparoPlayer(Disparo d);
   public abstract boolean visitEnemigo(Enemigo e);
}
