package disparo;

import javax.swing.ImageIcon;

import jugador.Dragon;

/*
 * Clase DisparoDragon
 * Clase que especifica el comportamiento de los proyectiles generados por el dragon.
 */

public class DisparoDragon extends DisparoJugador {

	// Atributos locales.

	// Constructor.
	public DisparoDragon(Dragon drake) {
		super(drake);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/disparo/bola_fuego.png")));
		celda = jugador.getCelda().getChild();
		setCelda();
	}

	// Metodos locales.

	// Metodos heredados.

}
