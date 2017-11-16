package disparo;

import javax.swing.ImageIcon;

import enemigo.NightKing;

/*
 * Clase DisparoNightKing
 * Clase que especifica el comportamiento de los proyectiles generados por el nightking.
 */

public class DisparoNightKing extends DisparoEnemigo {

	// Atributos locales.

	// Constructor.
	public DisparoNightKing(NightKing nk) {
		super(nk);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/disparo/lanza.png")));
		setCelda();
	}
}
