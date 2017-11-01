package main;

import disparo.Disparo;
import enemigo.Enemigo;
import jugador.Jugador;
import obstaculo.*;

public abstract  class Visitor {
	   
	   public abstract boolean VisitRock(Rock r);
	   public abstract boolean VisitWater(Water w);
	   public abstract boolean visitPlayer(Jugador j);
	   public abstract boolean visitDisparoPlayer(Disparo d);
	   public abstract boolean visitEnemigo(Enemigo e);
}
