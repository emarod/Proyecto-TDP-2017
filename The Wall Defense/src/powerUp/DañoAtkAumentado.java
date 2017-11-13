package powerUp;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import jugador.Jugador;
import mapa.Celda;

/*
 * Clase DañoAtkAumentado.
 * Clase que especifica el comportamiento del poder que aumenta el daño de ataque.
 */

public class DañoAtkAumentado extends PowerUp {

	// Constructor.
	public DañoAtkAumentado(Celda c) {
		super(c);
		grafico = new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/daño_atk_aumentado.gif")));
	}

	// Metodos heredados.

	@Override
	public void aplicar(Jugador j) {
		jugador = j;
		jugador.setAtaque(jugador.getDaño() * 2);
	}

	@Override
	public void run() {
		super.run();
	}

}
