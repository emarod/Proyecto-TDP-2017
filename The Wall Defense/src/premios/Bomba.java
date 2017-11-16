package premios;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Controladores.Director;
import efectos.Explosion;
import main.Visitor;
import mapa.Celda;

/*
 * Clase Bomba.
 * Clase que especifica el comportamiento del poder bomba.
 */

public class Bomba extends PremioTemporal {

	protected int costo;
	protected int daño;
	protected Icon[] explosion;

	// Constructor.
	public Bomba() {
		super();
		construir();
	}

	public Bomba(Celda c) {
		super(c);
		construir();

	}

	private void construir() {
		tiempo = 1;
		daño = 10;
		graficos = new Icon[5];
		explosion = new Icon[7];
		for (int i = 0; i < graficos.length; i++) {
			if (i < 5) {
				graficos[i] = new ImageIcon(this.getClass().getResource("/resources/static/bomba/00" + i + ".png"));
			}
		}
		for (int i = 0; i < explosion.length; i++) {
			int f = i + 5;
			if (f < 10) {
				explosion[i] = new ImageIcon(this.getClass().getResource("/resources/static/bomba/00" + f + ".png"));
			}
			else {
				explosion[i] = new ImageIcon(this.getClass().getResource("/resources/static/bomba/0" + f + ".png"));
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

			Celda celda2 = Director.getCelda(x - 1, y);
			nuevaExplosion(celda2);

			Celda celda3 = Director.getCelda(x, y + 1);
			nuevaExplosion(celda3);

			Celda celda4 = Director.getCelda(x, y - 1);
			nuevaExplosion(celda4);

			Director.getBancoRecursos().playExplosion();
			destruir();
		}
	}

	@Override
	public void destruir() {
		super.destruir();
	}

	private void nuevaExplosion(Celda c) {
		if (c != null) {
			new Explosion(c, explosion, daño);
		}
	}

	// Metodos heredados.

	public void setGrafico(int i) {
		grafico.setIcon(graficos[i]);
	}

	@Override
	public boolean accept(Visitor V) {
		return V.visitPremio(this);
	}

	@Override
	public Premio clone(Celda c) {
		Premio clon = new Bomba(c);
		return clon;
	}

	@Override
	public void run() {
		explotar();
	}

}
