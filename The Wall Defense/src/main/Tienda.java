package main;

import Controladores.Director;
import objetos.Comprable;

public class Tienda {

	public void vender(Comprable c) {
		c.destruir();
		Director.getPartida().añadirDinero(Math.round(c.getCosto() / 2));
		Director.getGui().getDinero().actualizar();
	}

}
