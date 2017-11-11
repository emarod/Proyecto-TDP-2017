package obstaculos;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

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

public class Water extends ObstaculoTemporal implements Runnable {

	// Atributos locales.
	protected int penalizacion;
	protected JLabel[] labels;

	// Constructor.
	public Water(Celda[] c) {
		super(c);
		celda = c;
		penalizacion = 100;
		labels = new JLabel[4];
		graficos = new Icon[4];
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
			labels[i] = new JLabel();
			labels[i].setIcon(graficos[i]);
			labels[i].setBounds(celda[i].getPosX() * 64, celda[i].getPosY() * 64, 64, 64);
			celda[0].getEscenario().agregar(labels[i], 3);
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
	public Obstaculo clone(Celda[] c) {
		Obstaculo clon = new Water(c);
		return clon;
	}

	@Override
	public boolean accept(Visitor V) {
		return V.visitObstaculo(this);
	}

	@Override
	public void aplicarEfecto(Enemigo e) {
		ScheduledFuture<?> taskEnemigo = e.getTask();
		taskEnemigo.cancel(true);
		ScheduledFuture<?> newTask = Director.ejecutarUna(this, penalizacion);
		e.setTask(newTask);
		e.activar(newTask.getDelay(TimeUnit.MILLISECONDS));

	}

	@Override
	public void destruir() {
		super.destruir();
		int i = 0;
		while (i < 4) {
			labels[i].setIcon(null);
			graficos[i] = null;
			celda[0].getEscenario().remove(labels[i]);
			labels[i] = null;
			i++;
			celda[i].getObjects()[CONFIG.PROFUNDIDAD_PRECIOSO] = null;
			celda[i] = null;
		}

	}

	@Override
	public void run() {
		destruir();
	}
}
