package powerUp;

import javax.swing.ImageIcon;

import jugador.Jugador;
import mapa.Celda;

/*
 * Clase Invulnerable.
 * Clase que especifica el comportamiento del poder que vuelve invulnerable a un personaje.
 */

public class Invulnerable extends PowerUp {

	// Constructor.
	public Invulnerable(Celda c) {
		super(c);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/campo_fuerza.gif")));
	}

	// Metodos heredados.

	@Override
	public void aplicar(Jugador j) {
		jugador = j;
		jugador.setVida(9999);
	}

	@Override
	public void run() {
		super.run();
	}
}
