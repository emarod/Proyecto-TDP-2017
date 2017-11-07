package objetos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import enemigo.Enemigo;
import main.Visitor;
import mapa.Celda;

/*
 * Clase Water
 * Clase que determina como esta compuesta y como se comporta el agua.
 */

public class Water extends ObstaculoTemporal {

	// Atributos locales.
	protected int penalizacion;
	protected JLabel[] labels;

	// Constructor.
	public Water(Celda[] c, int prof) {
		super(c, prof);
		profundidad = prof;
		celda = c;
		penalizacion = 100;
		labels = new JLabel[4];

		// Esquina superior izquierda.
		graficos[0] = new ImageIcon(this.getClass().getResource("/resources/dinamic/lago/lago_esquina_sup_izq_1.gif"));
		// Esquina superior derecha.
		graficos[1] = new ImageIcon(this.getClass().getResource("/resources/dinamic/lago/lago_esquina_sup_der_1.gif"));
		// Esquina inferior derecha.
		graficos[2] = new ImageIcon(this.getClass().getResource("/resources/dinamic/lago/lago_esquina_inf_der_1.gif"));
		// Esquina inferior izquierda.
		graficos[3] = new ImageIcon(this.getClass().getResource("/resources/dinamic/lago/lago_esquina_inf_izq_1.gif"));
		// grafico.setLayout(new FlowLayout(0, 0, 0));
		int i = 0;
		while (i < 4) {
			System.out.println("Y??" + i);
			labels[i] = new JLabel();
			labels[i].setIcon(graficos[i]);
			celda[0].getEscenario().agregar(labels[i], 3);
			i++;
		}

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

	@Override
	public void aplicarEfecto(Enemigo e) {
		// TODO Auto-generated method stub

	}
}
