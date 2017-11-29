package comprables;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Controladores.Director;
import efectos.Explosion;
import main.CONFIG;
import main.Tienda;
import main.Unidad;
import main.Visitor;
import mapa.Celda;
import objetos.Comprable;
import objetos.ObjetoTemporal;

public class Barril extends ObjetoTemporal implements Comprable, Runnable {

	protected int daño;
	protected Icon[] explosion;
	protected int costo;

	// Constructor.
	public Barril(Celda c) {
		super(c);
		costo = 15;
		profundidad = CONFIG.PROFUNDIDAD_COMPRABLE;
	}

	@Override
	public void crear() {
		super.crear();
		construir();
	}

	private void construir() {
		tiempo = 1;
		daño = 10;
		graficos = new Icon[5];
		explosion = new Icon[7];

		// BARRIL
		for (int i = 0; i < graficos.length; i++) {
			if (i < 5) {
				graficos[i] = new ImageIcon(this.getClass().getResource("/resources/static/barril/00" + i + ".png"));
			}
		}

		// EXPLOSION
		for (int i = 0; i < explosion.length; i++) {
			int f = i + 5;
			if (f < 10) {
				explosion[i] = new ImageIcon(this.getClass().getResource("/resources/static/barril/00" + f + ".png"));
			}
			else {
				explosion[i] = new ImageIcon(this.getClass().getResource("/resources/static/barril/0" + f + ".png"));
			}
		}

		graph = 0;
		grafico.setIcon(graficos[graph]);
		Director.ejecutarUna(this, tiempo);

	}

	public void explotar() {
		if (graph < 4) {
			grafico.setIcon(graficos[graph++]);
			Director.ejecutarUna(this, tiempo);
		}
		else {
			grafico.setIcon(graficos[graph]);
			int x = celda.getPosX();
			int y = celda.getPosY();
			nuevaExplosion(celda);

			Celda celda1 = Director.getCelda(x + 1, y);
			nuevaExplosion(celda1);
			Celda celda2 = Director.getCelda(x + 2, y);
			nuevaExplosion(celda2);

			Director.getBancoRecursos().playExplosion();
			destruir();
		}
	}

	private void nuevaExplosion(Celda c) {
		if (c != null) {
			new Explosion(c, explosion, daño).crear();
		}
	}

	// Metodos heredados.

	@Override
	public void setGrafico(int i) {
		grafico.setIcon(graficos[i]);
	}

	@Override
	public void accept(Tienda t) {
		t.vender(this);
	}

	@Override
	public Comprable clone(Celda c) {
		Comprable clon = new Barril(c);
		return clon;
	}

	@Override
	public void run() {
		explotar();
	}

	@Override
	public void aplicarEfecto(Unidad u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void terminar() {
		explotar();
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
