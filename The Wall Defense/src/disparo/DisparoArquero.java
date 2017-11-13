package disparo;

import javax.swing.ImageIcon;

import jugador.Arquero;

/*
 * Clase DisparoArquero
 * Clase que especifica el comportamiento de los proyectiles generados por el arquero.
 */

public class DisparoArquero extends DisparoJugador {

	// Atributos locales.

	// Constructor.
	public DisparoArquero(Arquero archer) {
		super(archer);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/disparo/flecha.png")));
		// setCelda();
		// activar();
	}

	// Metodos Locales.

	// Metodos heredados.

}
