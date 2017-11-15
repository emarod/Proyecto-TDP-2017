package efectos;

import javax.swing.ImageIcon;

import main.Unidad;
import mapa.Celda;

/*
 * Clase Invulnerable.
 * Clase que especifica el comportamiento del poder que vuelve invulnerable a un personaje.
 */

public class Invulnerable extends PowerUpTemporal {

	// Constructor.
	public Invulnerable(Celda c) {
		super(c);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/campo_fuerza.gif")));
	}

	// Metodos heredados.

	@Override
	public void aplicar(Unidad u) {
		unidad = u;
		unidad.setVida(9999);
	}

	@Override
	public void run() {
		super.run();
	}
}
