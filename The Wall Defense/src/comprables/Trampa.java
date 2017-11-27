package comprables;

import java.util.concurrent.TimeUnit;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Controladores.Director;
import main.CONFIG;
import main.Unidad;
import main.Visitor;
import mapa.Celda;
import objetos.Comprable;
import objetos.ObjetoTemporal;

/*
 * Clase Rock
 * Clase que determina como esta compuesta y como se comporta una roca.
 */

public class Trampa extends ObjetoTemporal implements Comprable {

	protected int costo, daño;
	private Unidad unidad;

	// Constructor.
	public Trampa(Celda c) {
		super(c);
		graficos = new Icon[3];
		graficos[0] = new ImageIcon(this.getClass().getResource("/resources/static/trampa/trampa1.png"));
		graficos[1] = new ImageIcon(this.getClass().getResource("/resources/static/trampa/trampa2.png"));
		graficos[2] = new ImageIcon(this.getClass().getResource("/resources/static/trampa/trampa3.png"));
		setGrafico(2);
		costo = 5;
		daño = 8;
		tiempo = 1;
		profundidad = CONFIG.PROFUNDIDAD_COMPRABLE;
	}

	// Metodos locales.

	// Metodos heredados.

	public void playSound() {
		Director.getBancoRecursos().playBarricada();
	}

	@Override
	public Comprable clone(Celda c) {
		Comprable clon = new Trampa(c);
		return clon;
	}

	@Override
	public boolean accept(Visitor V) {
		V.visitObjeto(this);
		return true;
	}

	@Override
	public void guardar() {
		Director.getPartida().aumentarObjeto(this);

	}

	@Override
	public int getCosto() {
		return costo;
	}

	@Override
	public void setCosto(int c) {
		costo = c;
	}

	@Override
	public void aplicarEfecto(Unidad u) {
		Director.ejecutarUna(this, 1);
		unidad = u;

	}

	@Override
	public void terminar() {
		destruir();

	}

	@Override
	public void run() {
		Director.ejecutarUna(this, 300, TimeUnit.MILLISECONDS);
		graph++;
		if (graph == 2) {
			setGrafico(graph);
			unidad.recibirDaño(daño);
			unidad = null;
			terminar();
		}
		else {
			setGrafico(graph);
		}

	}
}