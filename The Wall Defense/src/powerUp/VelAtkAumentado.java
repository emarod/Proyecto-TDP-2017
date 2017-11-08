package powerUp;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import jugador.Jugador;
import mapa.Celda;

/*
 * Clase VelAtkAumentado.
 * Clase que especifica el comportamiento del poder que aumenta la velocidad de ataque.
 */

public class VelAtkAumentado extends PowerUp {

	// Constructor.
	public VelAtkAumentado(Celda c, int prof) {
		super(c, prof);
		grafico = new JLabel();
		graficoToken = new JLabel();
		graficoToken
				.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/token_vel_atk_aumentado.gif")));
		// graficoToken.setIcon(new
		// ImageIcon(this.getClass().getResource("/resources/dinamic/daño_atk_aumentado.gif")));
	}

	// Metodos heredados.
	@Override
	public JLabel getGraficoToken() {
		return graficoToken;
	}

	@Override
	public void aplicar(Jugador j) {
		// Duplicar la vel de ataque.
	}

	@Override
	public void run() {
		super.run();
	}
}
