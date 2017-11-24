package comprables;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Controladores.Director;
import main.CONFIG;
import main.Visitor;
import mapa.Celda;
import objetos.Comprable;
import objetos.ObjetoVida;

/*
 * Clase Rock
 * Clase que determina como esta compuesta y como se comporta una roca.
 */

public class Trampa extends ObjetoVida implements Comprable {

	protected int costo;

	// Constructor.
	public Trampa(Celda c) {
		super(c);
		graficos = new Icon[3];
		graficos[0] = new ImageIcon(this.getClass().getResource("/resources/static/trampa/trampa1.png"));
		graficos[1] = new ImageIcon(this.getClass().getResource("/resources/static/trampa/trampa2.png"));
		graficos[2] = new ImageIcon(this.getClass().getResource("/resources/static/trampa/trampa3.png"));
		setGrafico(2);
		costo = 5;
		vida = 1;
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
		return V.visitObjeto(this);
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
}