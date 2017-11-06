package objetos;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import main.Visitor;
import mapa.Celda;

/*
 * Clase Water
 * Clase que determina como esta compuesta y como se comporta el agua.
 */

public class Water extends ObstaculoTemporal {

	// Atributos locales.
	protected int penalizacion;

	// Constructor.
	public Water(Celda[] c, int prof) {
		super(c, prof);
		profundidad = prof;
		celda = c;
		grafico = new JLabel();
		penalizacion = 100;

		/**
		 * switch (tipo) { case 'c': // Centro. grafico.setIcon( new
		 * ImageIcon(this.getClass().getResource("/resources/static/terrenos/lago_centro.png")));
		 * break;
		 *
		 * case 's': // Lateral vertical sup. grafico.setIcon(new
		 * ImageIcon(this.getClass()
		 * .getResource("/resources/dinamic/lago/lago_lateral_vertical_sup_" + sprite +
		 * ".gif"))); break; case 't': // Lateral vertical inf. grafico.setIcon(new
		 * ImageIcon(this.getClass()
		 * .getResource("/resources/dinamic/lago/lago_lateral_vertical_inf_" + sprite +
		 * ".gif"))); break; case 'u': // Lateral derecho. grafico.setIcon(new
		 * ImageIcon(
		 * this.getClass().getResource("/resources/dinamic/lago/lago_lateral_der_" +
		 * sprite + ".gif"))); break; case 'v': // Lateral izquierda.
		 * grafico.setIcon(new ImageIcon(
		 * this.getClass().getResource("/resources/dinamic/lago/lago_lateral_izq_" +
		 * sprite + ".gif"))); break; case 'w': // Esquina superior izquierda.
		 * grafico.setIcon(new ImageIcon(this.getClass()
		 * .getResource("/resources/dinamic/lago/lago_esquina_sup_izq_" + sprite +
		 * ".gif"))); break; case 'x': // Esquina inferior izquierda.
		 * grafico.setIcon(new ImageIcon(this.getClass()
		 * .getResource("/resources/dinamic/lago/lago_esquina_inf_izq_" + sprite +
		 * ".gif"))); break; case 'y': // Esquina superior derecha. grafico.setIcon(new
		 * ImageIcon(this.getClass()
		 * .getResource("/resources/dinamic/lago/lago_esquina_sup_der_" + sprite +
		 * ".gif"))); break; case 'z': // Esquina inferior derecha. grafico.setIcon(new
		 * ImageIcon(this.getClass()
		 * .getResource("/resources/dinamic/lago/lago_esquina_inf_der_" + sprite +
		 * ".gif"))); break; }
		 **/
		grafico.setLayout(new FlowLayout(0, 0, 0));
	}

	// Metodos locales.
	public int getPenalizacion() {
		return penalizacion;
	}

	// Metodos heredados.
	@Override
	public Obstaculo clone(Celda[] c) {
		Obstaculo clon = new Water(c, 3);
		return clon;
	}

	@Override
	public boolean accept(Visitor V) {
		return V.visitObstaculo(this);
	}
}
