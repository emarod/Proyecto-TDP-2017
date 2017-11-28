package comprables;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Controladores.Director;
import main.CONFIG;
import main.Tienda;
import main.Visitor;
import mapa.Celda;
import objetos.Comprable;
import objetos.ObjetoVida;

/*
 * Clase Rock
 * Clase que determina como esta compuesta y como se comporta una roca.
 */

public class Barricada extends ObjetoVida implements Comprable {

	protected int costo;

	// Constructor.
	public Barricada(Celda c) {
		super(c);
		vida = 3;
		graficos = new Icon[3];
		graficos[0] = new ImageIcon(
				this.getClass().getResource("/resources/static/terrenos/barricada/barricada_1.png"));
		graficos[1] = new ImageIcon(
				this.getClass().getResource("/resources/static/terrenos/barricada/barricada_2.png"));
		graficos[2] = new ImageIcon(
				this.getClass().getResource("/resources/static/terrenos/barricada/barricada_3.png"));
		setGrafico(2);
		costo = 10;
		profundidad = CONFIG.PROFUNDIDAD_COMPRABLE;
	}

	// Metodos heredados.

	public void playSound() {
		Director.getBancoRecursos().playBarricada();
	}

	@Override
	public Comprable clone(Celda c) {
		Comprable clon = new Barricada(c);
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
	public void accept(Tienda t) {
		t.vender(this);
	}

	@Override
	public void setCosto(int c) {
		costo = c;
	}

}
