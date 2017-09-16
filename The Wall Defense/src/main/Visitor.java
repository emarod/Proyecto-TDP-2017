package main;

import Obstaculo.*;

public abstract  class Visitor {
	protected GameObject objeto;
	   
	   public abstract boolean VisitRock(Rock r);
	   public abstract boolean VisitWater(Water w);
}
