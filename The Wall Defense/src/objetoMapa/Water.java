package objetoMapa;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Controladores.Director;
import enemigo.Enemigo;
import main.CONFIG;
import main.Visitor;
import mapa.Celda;

/*
 * Clase Water
 * Clase que determina como esta compuesta y como se comporta el agua.
 */

public class Water extends ObjetoMapaTemporal implements Runnable {

	// Atributos locales.
	protected int penalizacion;
	protected JLabel[] labels;

	// Constructor.
	public Water(Celda c) {
		super(c);

		penalizacion = 100;
		labels = new JLabel[4];
		graficos = new Icon[4];
		// Esquina superior izquierda.
		graficos[0] = new ImageIcon(this.getClass().getResource("/resources/dinamic/lago/lago_esquina_sup_izq_1.gif"));
		// Esquina superior derecha.
		graficos[1] = new ImageIcon(this.getClass().getResource("/resources/dinamic/lago/lago_esquina_sup_der_1.gif"));
		// Esquina inferior izquierda.
		graficos[2] = new ImageIcon(this.getClass().getResource("/resources/dinamic/lago/lago_esquina_inf_izq_1.gif"));
		// Esquina inferior derecha.
		graficos[3] = new ImageIcon(this.getClass().getResource("/resources/dinamic/lago/lago_esquina_inf_der_1.gif"));

		// grafico.setLayout(new FlowLayout(0, 0, 0));
		Celda ce = celda;
		int i = 0;
		while (ce != null) {
			labels[i] = new JLabel();
			labels[i].setIcon(graficos[i]);
			labels[i].setBounds(ce.getPosX() * 64, ce.getPosY() * 64, 64, 64);
			Director.getMapa().getEscenario().agregar(labels[i], profundidad);
			ce.getObjects()[CONFIG.PROFUNDIDAD_OBSTACULO] = this;
			ce = ce.getChild();
			i++;
		}
		Director.ejecutarUna(this, 7);
	}

	// Metodos locales.
	public int getPenalizacion() {
		return penalizacion;
	}

	// Metodos heredados.
	@Override
	public ObjetoMapa clone(Celda c) {
		ObjetoMapa clon = new Water(c);
		return clon;
	}

	@Override
	public boolean accept(Visitor V) {
		return V.visitObjetoMapa(this);
	}

	@Override
	public void aplicarEfecto(Enemigo e) {
		e.setVelocidad(penalizacion);
	}

	@Override
	public void destruir() {
		super.destruir();
		int i = 0;
		while (i < labels.length) {
			labels[i].setIcon(null);
			Director.getMapa().getEscenario().remove(labels[i]);
			graficos[i] = null;
			labels[i] = null;
			i++;
		}

	}

	@Override
	public void run() {
		destruir();
	}
}
