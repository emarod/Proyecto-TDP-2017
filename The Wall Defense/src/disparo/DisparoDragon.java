package disparo;

import javax.swing.ImageIcon;

import Controladores.Director;
import jugador.Dragon;
import main.CONFIG;

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
		celda.addDisparo(this);
		grafico.setBounds(64 * celda.getPosX(), 64 * celda.getPosY(), 64, 64);
		Director.getMapa().getEscenario().agregar(grafico, new Integer(CONFIG.PROFUNDIDAD_DISPARO));
	}

	// Metodos locales.

	// Metodos heredados.

}
